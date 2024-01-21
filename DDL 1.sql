CREATE DATABASE DDL;

USE DDL;

CREATE TABLE Data_agen
(Id_agen VARCHAR(12) NOT NULL, 
Nama_agen TEXT NOT NULL,
Nomor_telepon_agen VARCHAR(12) NOT NULL,
Email_agen VARCHAR(30) NOT NULL,
Status_agen TINYTEXT NOT NULL);
drop table Data_agen;
DESCRIBE Data_agen;

INSERT INTO Data_agen
(Id_agen,Nama_agen,Nomor_telepon_agen,Email_agen,Status_agen)
Values ("#ACW112345","John","0812345678910","John@gmail.com","AKTIF"),
("#ACW112346","Michael","083457329512","Michael@gmail.com","AKTIF"),
("#ACW112347","Evan","082376519830","Evan@gmail.com","AKTIF");
SELECT * FROM Data_agen;
Truncate Data_agen;

ALTER TABLE Data_agen
ADD CONSTRAINT Id_agen_pk PRIMARY KEY (Id_agen);
DESCRIBE Data_agen;

CREATE TABLE Data_nasabah
(Id_nasabah VARCHAR(12) NOT NULL,
Nama_nasabah TEXT NOT NULL,
Tempat_tanggal_lahir VARCHAR(30) NOT NULL,
Alamat_tempat_tinggal LONGTEXT NOT NULL,
Nomor_telepon_nasabah VARCHAR(12) NOT NULL,
Email Varchar(30) NOT NULL,
Jenis_kelamin VARCHAR(10) NOT NULL,
Status_pekerjaan VARCHAR(15) NOT NULL,
Pendapatan BIGINT(6) UNSIGNED NOT NULL,
Sumber_penghasilan LONGTEXT NULL,
NPWP TINYTEXT NULL);
drop table Data_nasabah;
DESCRIBE Data_nasabah;

INSERT INTO Data_nasabah
(Id_nasabah,Nama_nasabah,Tempat_tanggal_lahir,Alamat_tempat_tinggal,Nomor_telepon_nasabah,Email,Jenis_kelamin,Status_pekerjaan,Pendapatan,Sumber_penghasilan,NPWP)
Values ("#NBS000215","Michael","Medan,12-Januari-1997","Jl.Jalan no.1","081234567893","Michael.global@gmail.com","Laki-Laki","Bekerja","RP.10.000.000-RP.20.000.000","Properti","01.234.456.7-987.000"),
("#NBS000216","Budi","Medan,23-Maret-1999","Jl.Super no.12","081234567890","Budi.keren@gmail.com","Laki-Laki","Bekerja","RP.5.000.000-RP.10.000.000","Gaji","01.432.645.9-124.000"),
("#NBS000217","Jesica","Jakarta,13-November-1998","Jl.Sakti no.15","082458178023","Jesica@gmail.com","Perempuan","Tidak Bekerja","RP.15.000.000-RP.25.000.000","Investasi","01.876.923.4-105.000");
SELECT * FROM Data_nasabah;
Truncate Data_nasabah;

ALTER TABLE Data_nasabah
ADD CONSTRAINT Id_nasabah_pk PRIMARY KEY (Id_nasabah);
DESCRIBE Data_nasabah;

SELECT a.Id_nasabah, Nama_nasabah, Id_polis, Nomor_polis
FROM Data_nasabah a CROSS JOIN Data_polis b
where a.Id_nasabah = b.Id_nasabah;

CREATE TABLE Data_polis
(Id_polis VARCHAR(12) NOT NULL,
Nomor_polis BIGINT(12) UNSIGNED NOT NULL,
Id_nasabah VARCHAR(12) NOT NULL,
Id_produk VARCHAR(12) NOT NULL,
Id_agen VARCHAR(12) NOT NULL);
drop table Data_polis;
DESCRIBE Data_polis;

INSERT INTO Data_polis
(Id_polis,Nomor_polis,Id_nasabah,Id_produk,Id_agen)
Values ("#IP98310","1037491203","#NBS000215","#IPD9831","#ACW112345"),
("#IP98231","1045275920","#NBS000216","#IPD9831","#ACW112346"),
("#IP98321","1285020395","#NBS000217","#IPD9823","#ACW112347");
SELECT * FROM Data_polis;
Truncate Data_polis;

ALTER TABLE Data_polis
ADD CONSTRAINT Id_polis_pk PRIMARY KEY (Id_polis);
DESCRIBE Data_polis;

ALTER TABLE Data_polis
ADD CONSTRAINT Id_nasabah_fk FOREIGN KEY (Id_nasabah)
REFERENCES Data_nasabah(id_nasabah); 
DESCRIBE Data_polis;

ALTER TABLE Data_polis
ADD CONSTRAINT Id_produk_fk FOREIGN KEY (Id_produk)
REFERENCES Data_produk(id_produk);
DESCRIBE Data_polis;

ALTER TABLE Data_polis
ADD CONSTRAINT Id_agen_fk FOREIGN KEY (Id_agen)
REFERENCES Data_agen(id_agen);
DESCRIBE Data_polis;

SELECT e.Id_polis, Nomor_polis, Id_pembayaran, tanggal_pembayaran
FROM Data_polis NATURAL JOIN Pembayaran
where e.Id_polis = j.Id_polis;

CREATE TABLE Data_produk
(Id_produk VARCHAR(12) NOT NULL,
Nama_produk TINYTEXT NOT NULL,
Jenis_produk TINYTEXT NOT NULL,
Nomor_produk INT(3) UNSIGNED NOT NULL);
drop table Data_produk;
DESCRIBE Data_produk;

INSERT INTO Data_produk
(Id_produk,Nama_produk,Jenis_produk,Nomor_produk)
Values ("#IPD9831","Asuransi Maxis","Asuransi Kesehatan","111"),
("#IPD9823","Asuransi Maxis","Asuransi Properti","114"),
("#IPD9832","Asuransi Maxis","Asuransi Kendaraan","116");
SELECT * FROM Data_produk;
Truncate Data_produk;

ALTER TABLE Data_produk
ADD CONSTRAINT Id_produk_pk PRIMARY KEY (Id_produk);
DESCRIBE Data_produk;

CREATE TABLE Pembayaran
(Id_pembayaran VARCHAR(15) NOT NULL,
Id_polis VARCHAR(12) NOT NULL,
Id_metode_pembayaran VARCHAR(12) NOT NULL,
Tanggal_pembayaran DATE DEFAULT NOW() NOT NULL,
Angsuran INT(3) UNSIGNED NOT NULL,
Keterangan TINYTEXT NULL);
drop table Pembayaran;
DESCRIBE Pembayaran;

INSERT INTO Pembayaran
(Id_pembayaran,Id_polis,Id_metode_pembayaran,Tanggal_pembayaran,Angsuran,Keterangan)
Values ("#SC63453","#IP98310","#MP00154","12-Agustus-2022","2",""),
("#SC63718","#IP98231","#MP00163","17-November-2022","1",""),
("#SC39487","#IP98321","#MP00172","16-September-2022","","");
SELECT * FROM Pembayaran;
Truncate Pembayaran;

ALTER TABLE Pembayaran
ADD CONSTRAINT Id_pembayaran_pk PRIMARY KEY (Id_pembayaran);
DESCRIBE Pembayaran;

ALTER TABLE Pembayaran
ADD CONSTRAINT Id_polis_fk FOREIGN KEY (Id_polis)
REFERENCES Data_polis(Id_polis);
DESCRIBE Pembayaran;

ALTER TABLE Pembayaran
ADD CONSTRAINT Id_metode_pembayaran_fk FOREIGN KEY (Id_metode_pembayaran)
REFERENCES Metode_pembayaran(Id_metode_pembayaran);
DESCRIBE Pembayaran;

CREATE TABLE Metode_pembayaran
(Id_metode_pembayaran VARCHAR(12) NOT NULL,
Metode_pembayaran VARCHAR(12) NOT NULL,
Nomor_produk TINYINT(4) UNSIGNED NOT NULL );
drop table Metode_pembayaran;
DESCRIBE Metode_pembayaran;

INSERT INTO Metode_pembayaran
(Id_metode_pembayaran,Metode_pembayaran,Nomor_produk)
Values ("#MP00154","Debit","#NBS000215"),
("#MP00163","Credit","#NBS000216"),
("#MP00172","Debit","#NBS000217");
SELECT * FROM Metode_pembayaran;

ALTER TABLE Metode_pembayaran
ADD CONSTRAINT Id_metode_pembayaran_pk PRIMARY KEY (Id_metode_pembayaran);
DESCRIBE Metode_pembayaran;
