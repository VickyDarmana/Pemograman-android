create database TUGAS2SQL;

use TUGAS2SQL;

CREATE TABLE Donatur
(Id_Donatur VARCHAR(12) NOT NULL,
Nama_Donatur TEXT NOT NULL,
Nomor_Telepon_Donatur VARCHAR(13) NOT NULL,
Email_Donatur VARCHAR(50) NOT NULL);

drop table Donatur;

DESCRIBE Donatur;

INSERT INTO Donatur
(Id_Donatur,Nama_Donatur,Nomor_Telepon_Donatur,Email_Donatur)
VALUES ("#D12345678910","Aldi","0812345678910","Aldi.Taher@gmail.com"),
("#D23456789101","Bintang","081820902901","Bintang.Terangg@Yahoo.com"),
("#D34567891011","Cahyo","0853268896161","Cahyoo.Nagho@Hotmail.com");
SELECT*FROM Donatur;

UPDATE DONATUR
SET Nomor_Telepon_Donatur = "08125678910"
Where Id_Donatur = "#D12345678910";

DELETE FROM Donatur 
WHERE Id_Donatur = 
(SELECT Id_Donatur
From Donatur
Where Email_Donatur = "Cahyoo.Nagho@Hotmail.com");

TRUNCATE Donatur;


CREATE TABLE Donate
(Id_Donate VARCHAR(12) NOT NULL,
Metode_Donate TINYTEXT NOT NULL,
Tanggal_Donate TINYTEXT NOT NULL);
drop table Donate;
DESCRIBE Donate;

INSERT INTO Donate
(Id_Donate,Metode_Donate,Tanggal_Donate)
VALUES ("#D11223344556","UANG","23 MARET 2023"),
("#D11122233344","UANG","24 MARET 2023"),
("#D12323132121","BARANG","23 MARET 2023");
SELECT*FROM DONATE;

UPDATE Donate
SET Tanggal_Donate = "23 MARET 2023"
Where Id_Donate = "#D11122233344";

DELETE FROM Donate 
WHERE Id_Donate = 
(SELECT Id_Donate
From Donate
Where Metode_Donate = "BARANG");

TRUNCATE Donate;


CREATE TABLE Barang_donate
(Id_Barang_donate VARCHAR(8) NOT NULL,
Tipe_Barang_donate TINYTEXT NOT NULL,
Jumlah_Barang INT NOT NULL);
DESCRIBE Barang_donate;
DROP TABLE Barang_donate;

INSERT INTO Barang_donate
(Id_Barang_donate,Tipe_Barang_donate,Jumlah_Barang)
VALUES ("#B00001","BERAS 10 KG","2"),
("#B00002","MINYAK 2L","1"),
("#B00003","GULA 1 KG","2");
SELECT*FROM Barang_donate;

UPDATE Barang_donate
SET Tipe_Barang_donate = "TELUR 1 PAPAN"
Where Id_Barang_donate = "#B00003";

DELETE FROM Barang_donate 
WHERE Id_Barang_donate = 
(SELECT Id_Barang_donate
From Barang_donate
Where Tipe_Barang_donate = "GULA 1 KG");

TRUNCATE Tipe_Barang_donate;


CREATE TABLE Stok_barang
(Id_stok_barang VARCHAR(12) NOT NULL,
Nama_barang TINYTEXT NOT NULL,
Jumlah_stok INT NOT NULL);
DESCRIBE Stok_barang;

INSERT INTO Stok_barang
(Id_stok_barang,Nama_barang,Jumlah_Barang)
VALUES ("#B00001","BERAS 10 KG","2"),
("#B00002","MINYAK 2L","1"),
("#B00003","GULA 1 KG","2");
SELECT*FROM Barang_donate;

UPDATE Barang_donate
SET Jumlah_Barang = "2"
Where Id_Barang_donate = "#B00003";

DELETE FROM Barang_donate 
WHERE Id_Barang_donate = 
(SELECT Id_Barang_donate
From Barang_donate
Where Tipe_Barang_donate = "GULA 1 KG");

TRUNCATE Tipe_Barang_donate;


CREATE TABLE Anak_panti
(Id_anak_panti VARCHAR(12) NOT NULL,
nama_anak_panti TEXT NOT NULL,
Jenis_kelamin_anak_panti TINYTEXT NOT NULL,
Usia_anak_panti TEXT NOT NULL,
Tempat_lahir VARCHAR(15) NULL,
Tanggal_Lahir TEXT NULL);
DESCRIBE Anak_panti;

INSERT INTO Anak_panti
(Id_anak_panti,nama_anak_panti,Jenis_kelamin_anak_panti,Usia_anak_panti,Tempat_lahir,Tanggal_Lahir)
VALUES ("#A0000000001","CUACA","PRIA","10","MEDAN","22 JAN 2013"),
("#A0000000002","ANDI","WANITA","11","MEDAN","22 FEB 2012"),
("#A0000000003","TONO","PRIA","9","MEDAN","21 MAR 2014");
SELECT*FROM Anak_panti;

UPDATE Anak_panti
SET Jenis_kelamin_anak_panti = "PRIA"
Where Id_anak_panti = "#A0000000002";

DELETE FROM Anak_panti 
WHERE Id_anak_panti = 
(SELECT Id_anak_panti
From Anak_panti
Where nama_anak_panti = "TONO");

TRUNCATE Anak_panti;