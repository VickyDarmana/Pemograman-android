package ATM;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
   public static int appStatus = 1;
   public static LinkedList<RekeningNode> accountList = fetchAccountData();
   public static Queue<History> historyQueue = new Queue<>();

   public static void main(String[] args) {
      // Fetching account data from the csv files
      accountList = fetchAccountData();

      // Check if accountList is null before proceeding
      if (accountList == null) {
         System.out.println("Error fetching account data. Program will exit.");
         System.exit(0);
      }

      while (appStatus == 1) {
         welcomeView();
      }
   }

   // Views
   public static void welcomeView() {
      Rekening currentLoggedIn;

      System.out.println("***Selamat Datang***");
      System.out.println("1. Login");
      System.out.println("2. Keluar/Exit");

      Scanner sc = new Scanner(System.in);
      int input = sc.nextInt();

      if (input != 1 && input != 2) {
         System.out.println("Invalid Input!");
      } else {
         if (input == 2) {
            appStatus = 0;
            System.out.println("SHUTTING DOWN...");
         } else {
            currentLoggedIn = loginView(accountList);
            if (currentLoggedIn != null) {
               menuView(currentLoggedIn, accountList);
            }
         }
      }
   }

   public static Rekening loginView(LinkedList<RekeningNode> accountList) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Login");

      System.out.println("Nomor Rekening: ");
      String rekInput = sc.nextLine();

      System.out.println("Sandi: ");
      String sandiInput = sc.nextLine();

      Rekening currentRekening = login(rekInput, sandiInput, accountList);
      return currentRekening;
   }

   public static void menuView(Rekening rekening, LinkedList<RekeningNode> accountList) {
      System.out.println("\n***Main Menu***");
      System.out.println("1. Check Balance");
      System.out.println("2. Whitdraw");
      System.out.println("3. Deposit");
      System.out.println("4. Transfer");
      System.out.println("5. Transaction History");
      System.out.println("6. LogOut");

      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      JenisOperasi jenisOperasi;
      switch (choice) {
         case 1:
            jenisOperasi = JenisOperasi.CHECK_BALANCE;
            break;
         case 2:
            jenisOperasi = JenisOperasi.WITHDRAW;
            break;
         case 3:
            jenisOperasi = JenisOperasi.DEPOSIT;
            break;
         case 4:
            jenisOperasi = JenisOperasi.TRANSFER;
            break;
         case 5:
            jenisOperasi = JenisOperasi.TRANSACTION_HISTORY;
            break;
         case 6:
            jenisOperasi = JenisOperasi.LOGOUT;
            break;
         default:
            System.out.println("Invalid choice!");
            return;
      }
      // Call the method to handle the selected operation
      handleOperation(jenisOperasi, rekening, accountList);
   }

   /* Functional Methods */
   public static Rekening login(String rek, String sandi, LinkedList<RekeningNode> accountList) {
      if (accountList.isEmpty()) {
         System.out.println("No accounts found.");
         return null;
      }

      for (RekeningNode currentNode : accountList) {
         if (currentNode.getRekening().getNomorRekening().equals(rek)
               && currentNode.getRekening().getSandi().equals(sandi)) {
            System.out.println("Login successful!");
            return currentNode.getRekening();
         }
      }

      System.out.println("Login failed. Please check your account number and password.");
      return null;
   }

   public static LinkedList<RekeningNode> fetchAccountData() {
      // Create an empty linked list to store account details
      LinkedList<RekeningNode> accountList = new LinkedList<>();

      // Read the CSV file
      String csvFile = "D:/bankdetails.csv";
      String line;
      String csvDelimiter = ";";
      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
         // Skip the first line (header)
         br.readLine();

         // Read each line and create a RekeningNode object
         while ((line = br.readLine()) != null) {
            String[] data = line.split(csvDelimiter);
            String nomorRekening = data[0];
            String namaPemilik = data[1];
            String sandi = data[2];
            double saldo = Double.parseDouble(data[3]);

            // Create a RekeningNode object and add it to the linked list
            RekeningNode rekeningNode = new RekeningNode(new Rekening(nomorRekening, namaPemilik, sandi, saldo));
            accountList.addLast(rekeningNode);
         }
         return accountList;
      } catch (IOException e) {
         System.out.println("Error reading CSV file: " + e.getMessage());
         return null;
      }
   }

   public static void handleOperation(JenisOperasi jenisOperasi, Rekening rekening,
         LinkedList<RekeningNode> accountList) {
      switch (jenisOperasi) {
         case CHECK_BALANCE:
            checkBalance(rekening);
            break;
         case WITHDRAW:
            withdraw(rekening);
            break;
         case DEPOSIT:
            deposit(rekening);
            break;
         case TRANSFER:
            transfer(rekening, accountList);
            break;
         case TRANSACTION_HISTORY:
            transactionHistory(rekening);
            break;
         case LOGOUT:
            logout();
            break;
         default:
            System.out.println("Invalid operation");
            break;
      }
   }

   // Operation
   public static void checkBalance(Rekening rekening) {
      int viewStatus = 1;

      while (viewStatus == 1) {

         System.out.println("Your Balance");
         System.out.println("Nomor rekening: " + rekening.getNomorRekening());
         System.out.println("Nama Pemilik: " + rekening.getNamaPemilik());
         System.out.println("Rp. " + (int) rekening.getSaldo());
         System.out.println("Back? Y) Yes");

         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();

         if (input.equalsIgnoreCase("Y")) {
            viewStatus = 0;
            menuView(rekening, accountList);
         } else {
            System.out.println("Invalid Input!");
         }
      }
   }

   public static void withdraw(Rekening rekening) {
      int viewStatus = 1;

      while (viewStatus == 1) {

         double saldo = rekening.getSaldo();

         System.out.println("\n*** WITHDRAW ***");
         System.out.println("Withdraw Pecahan Rp.100.000");
         System.out.println("Saldo anda sekarang: Rp. " + (int) saldo);
         System.out.println("0) Keluar");
         System.out.print("Jumlah yang akan ditarik: Rp. ");

         Scanner sc = new Scanner(System.in);
         int amount = sc.nextInt();

         if (amount == 0) {
            viewStatus = 0;
            menuView(rekening, accountList);
         }

         if (amount % 100000 != 0 || amount > saldo) {
            System.out.println(
                  "Input salah, pastikan input merupakan angka, pecahan Rp.100.000 dan tidak melebihi saldo anda!");
         } else {
            rekening.setSaldo(saldo - amount);
            System.out.println("Saldo Baru: Rp. " + (int) rekening.getSaldo());

            // Create a new History object for the transaction
            String keterangan = "Penarikan tunai sebesar Rp. " + amount;
            History history = new History(rekening.getNomorRekening(), "Withdraw", keterangan, new Date());

            // Add the History object to the history queue
            historyQueue.enqueue(history);
            System.out.println("\n");
         }
      }
   }

   public static void deposit(Rekening rekening) {
      int viewStatus = 1;

      while (viewStatus == 1) {

         double saldo = rekening.getSaldo();

         System.out.println("\n*** DEPOSIT ***");
         System.out.println("Saldo anda sekarang: Rp. " + (int) saldo);
         System.out.println("Minimum deposit: Rp.100.000");
         System.out.println("Maximum deposit: Rp.10.000.000");
         System.out.println("0) Keluar");
         System.out.print("Jumlah yang akan di deposit: Rp. ");

         Scanner sc = new Scanner(System.in);
         if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount == 0) {
               viewStatus = 0;
               menuView(rekening, accountList);

               if (amount % 100000 != 0 || amount < 100000 || amount > 10000000) {
                  System.out.println("Pastikan input merupakan pecahan Rp.100.000");
               }
            } else {
               rekening.setSaldo(saldo + amount);
               System.out.println("Saldo Baru: Rp. " + (int) rekening.getSaldo());

               // Create a new History object for the transaction
               String keterangan = "Deposit tunai sebesar Rp. " + amount;
               History history = new History(rekening.getNomorRekening(), "Deposit", keterangan, new Date());

               // Add the History object to the history queue
               historyQueue.enqueue(history);
               System.out.println("\n");
            }
         } else {
            System.out.println("INVALID INPUT!");
         }
      }
   }

   public static void transfer(Rekening rekening, LinkedList<RekeningNode> accountList) {
      int viewStatus = 1;

      while (viewStatus == 1) {
         double saldo = rekening.getSaldo();
         int amount = 0;
         String rekTujuan = null;

         System.out.println("\n*** TRANSFER ***");
         System.out.println("0) Keluar");

         System.out.println("Nomor rekening tujuan: ");
         Scanner sc = new Scanner(System.in);

         if (sc.hasNextLine()) {
            rekTujuan = sc.nextLine();
         }

         if (rekTujuan.equals("0")) {
            viewStatus = 0;
            menuView(rekening, accountList);
            break;
         }

         System.out.print("Nominal Transfer: Rp. ");
         if (sc.hasNextInt()) {
            amount = sc.nextInt();
         }

         if (amount > rekening.getSaldo()) {
            System.out.println("Saldo Tidak Mencukupi!");
            continue;
         }

         if (amount == 0) {
            viewStatus = 0;
            menuView(rekening, accountList);
            break;
         } else {
            boolean rekValid = false;
            for (RekeningNode node : accountList) {
               if (node.getRekening().getNomorRekening().equals(rekTujuan)) {
                  System.out.println("Nomor Rekening Tujuan: " + node.getRekening().getNomorRekening());
                  System.out.println("Nama Pemilik: " + node.getRekening().getNamaPemilik());
                  System.out.println("Nominal Transfer: Rp. " + amount);
                  System.out.println("Apakah anda yakin ingin melanjutkan transfer? (yes/no)");
                  String confirmation = sc.next();
                  if (confirmation.equalsIgnoreCase("yes")) {
                     // Transfer the money
                     rekening.setSaldo(saldo - amount);
                     node.getRekening().setSaldo(node.getRekening().getSaldo() + amount);
                     System.out.println("Transfer Berhasil! Saldo Anda Sekarang: Rp. " + (int) rekening.getSaldo());
                     rekValid = true;

                     // Add the transfer transaction to the history queue
                     String keterangan = "Transfer ke rekening " + rekTujuan + " sebesar Rp. " + amount;
                     History history = new History(rekening.getNomorRekening(), "Transfer", keterangan, new Date());
                     historyQueue.enqueue(history);

                     break;
                  } else if (confirmation.equalsIgnoreCase("no")) {
                     System.out.println("Transfer dibatalkan!");
                     rekValid = true;
                     break;
                  } else {
                     System.out.println("Pilihan tidak valid. Transfer dibatalkan!");
                     rekValid = true;
                     break;
                  }
               }
            }

            if (!rekValid) {
               System.out.println("Nomor Rekening Tujuan tidak ditemukan!");
            }
         }
      }

   }

   public static void transactionHistory(Rekening rekening) {
      int viewStatus = 1;
      System.out.println("\n*** TRANSACTION HISTORY ***");
      if (historyQueue.isEmpty()) {
         System.out.println("No transaction history available.");
      } else {
         int count = 1;
         for (History history : historyQueue) {
            if (history.getNomorRekening().equals(rekening.getNomorRekening())) {
               System.out.println(count + ". " + history);
               count++;
            } else {
               continue;
            }
         }
      }

      System.out.println("0) Keluar");
      while (viewStatus == 1) {
         Scanner sc = new Scanner(System.in);
         int input = sc.nextInt();

         if (input == 0) {
            menuView(rekening, accountList);
         } else {
            System.out.println("INVALID INPUT!");
         }
      }
   }

   public static void logout() {
      welcomeView();
   }

}
