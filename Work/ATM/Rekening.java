package ATM;

import java.util.Date;

public class Rekening {
    private String nomorRekening;
    private String namaPemilik;
    private String sandi;
    private double saldo;
    private Queue<History> history;

    public Rekening(String nomorRekening, String namaPemilik, String sandi, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.sandi = sandi;
        this.saldo = saldo;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getSandi() {
        return sandi;
    }

    public void setSandi(String sandi) {
        this.sandi = sandi;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void tambahHistory(String jenisOperasi, String keterangan, Date createdOn) {
        History history = new History(this.nomorRekening, jenisOperasi, keterangan, createdOn);
    }

    public Queue<History> getHistory() {
        return history;
    }

    

    @Override
    public String toString() {
        return "Rekening [nomorRekening=" + nomorRekening + ", namaPemilik=" + namaPemilik + ", sandi=" + sandi
                + ", saldo=" + (int) saldo + "]";
    }

}