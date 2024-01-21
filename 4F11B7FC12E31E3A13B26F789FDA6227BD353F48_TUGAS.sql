create database TUGAS;

use TUGAS;

CREATE TABLE Donatur
(Id_Donatur VARCHAR(12) NOT NULL,
Nama_Agen TEXT NOT NULL,
Nomor_Telepon_Donatur VARCHAR(13) NOT NULL,
Email_Donatur VARCHAR(50) NOT NULL);
drop table Donatur;
DESCRIBE Donatur;

CREATE TABLE Donate
(Id_Donate VARCHAR(12) NOT NULL,
Metode_Donate TINYTEXT NOT NULL,
Tanggal_Donate DATE DEFAULT NOW());
drop table Donasi_1;
DESCRIBE Donate;

CREATE TABLE Barang_Donate
(Id_Barang_Donate VARCHAR(12) NOT NULL,
Tipe_Barang_Donate TINYTEXT NOT NULL,
Jumlah_Barang INT NOT NULL);
drop table Barang_Donate;
DESCRIBE Barang_Donate;


