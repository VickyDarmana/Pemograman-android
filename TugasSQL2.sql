CREATE DATABASE Rumah_Sakit_1;

USE Rumah_Sakit_1;

CREATE TABLE Pasien_1
(Id_Pasien VARCHAR(5) NOT NULL,
First_Name TEXT NOT NULL,
Last_Name TEXT NOT NULL,
Tempat_Tanggal_Lahir VARCHAR(50) NOT NULL,
Jenis_Kelamin VARCHAR(10) NOT NULL,
No_Telp VARCHAR(12) NOT NULL,
Golongan_Darah TINYTEXT NOT NULL,
Berat_Badan_Kg VARCHAR(10) NOT NULL,
Tinggi_Badan_Cm VARCHAR(10) NOT NULL);

DROP TABLE Pasien_1;

DESCRIBE Pasien_1;

INSERT INTO Pasien_1
(Id_Pasien,First_Name,Last_Name,Tempat_Tanggal_lahir,Jenis_Kelamin,No_Telp,Golongan_Darah,Berat_Badan_kg,Tinggi_Badan_Cm)
VALUES ('001','Andi','Winarto','Medan, 1 April 2000','Laki-laki','081234567894','A','60','165'),
('002','Clara','Wijaya','Jakarta, 10 September 1998','Perempuan','081236478964','B-','55','155'),
('003','Tono','Wido','Jakarta, 25 Juni 2001','Laki-laki','081278642318','O','70','170');
SELECT * FROM Pasien_1;

UPDATE Pasien_1
SET First_name = 'Anto' , Last_name = 'Purba' , Tinggi_Badan_Cm = '169'
WHERE Id_Pasien = '001';
SELECT * FROM Pasien_1;

DELETE FROM Pasien_1
WHERE Id_Pasien = '002';
SELECT * FROM Pasien_1;

TRUNCATE Pasien_1;

CREATE TABLE Dokter
(Id_Dokter VARCHAR(5) NOT NULL,
Nama TEXT NOT NULL,
Lulusan_Dokter VARCHAR(20) NOT NULL,
Alamat LONGTEXT NOT NULL,
No_Telp VARCHAR(12) NOT NULL,
Id_Spesialis VARCHAR(10) NOT NULL);

DROP TABLE Dokter;

DESCRIBE Dokter;

INSERT INTO Dokter
(Id_Dokter,Nama,Lulusan_dokter,Alamat,No_Telp,Id_Spesialis)
VALUES ('A001','Felix Kho','Dokter Spesialis Kandungan','Jln. Apel No.10','081234978615','A'),
('B005','Tanto Ang','Dokter Spesialis Jantung','Jln. Jeruk No.18,','081359746157','B'),
('C003','Burdan Kangti','Dokter Spesialis Penyakit Dalam','Jln. Anggur No.47,','081378946519','C');
SELECT * FROM Dokter;

UPDATE Dokter
SET Id_Dokter = 'A002' , Nama = 'Jackson Fung'
WHERE Id_Dokter = 'A001';
SELECT * FROM Dokter;

DELETE FROM Dokter
WHERE Id_Dokter = 'C003';
SELECT * FROM Dokter;

TRUNCATE Dokter;

CREATE TABLE Spesialis
(Id_Spesialis VARCHAR(5) NOT NULL,
Jenis_Spesialis VARCHAR(30) NOT NULL);

DROP TABLE Spesialis;

DESCRIBE Spesialis;

INSERT INTO Spesialis
(Id_Spesialis,Jenis_Spesialis)
VALUES ('A','Spesialis Kandungan'),
('B','Spesialis Jantung'),
('C','Spesialis Penyakit Dalam'),
('D','Spesialis Anak'),
('E','Spesialis Kulit'),
('F','Spesialis Saraf');
SELECT * FROM Spesialis;

UPDATE Spesialis
SET Jenis_Spesialis = 'Spesialis Mata'
WHERE Id_Spesialis = 'E';
SELECT * FROM Spesialis;

DELETE FROM Spesialis
WHERE Id_Spesialis = 'F';
SELECT * FROM Spesialis;

TRUNCATE Spesialis;

CREATE TABLE Konsultasi
(Id_Konsultasi VARCHAR(50) NOT NULL,
Keluhan LONGTEXT NOT NULL,
Id_Resep VARCHAR(50) NOT NULL,
Hasil_Diagnosa LONGTEXT NOT NULL,
Id_Pasien VARCHAR(50) NOT NULL,
Id_Dokter VARCHAR(50) NOT NULL,
Id_Spesialis VARCHAR(50) NOT NULL);

DROP TABLE Konsultasi;

DESCRIBE Konsultasi;

INSERT INTO Konsultasi
(Id_Konsultasi,Keluhan,Id_Resep,Hasil_Diagnosa,Id_Pasien,Id_Dokter,Id_Spesialis)
VALUES ('1A','Gangguan Kandungan','#1A','Tidak Perlu Rawat Inap,','001','A001','A'),
('1B','Keluhan di Jantung','#1B','Perlu Rawat Inap','002','B002','B');
SELECT * FROM Konsultasi;

UPDATE Konsultasi
SET Keluhan = 'Sering Mual' , Hasil_Diagnosa = 'Perlu Rawat Inap'
WHERE Id_Konsultasi = '1A';
SELECT * FROM Konsultasi;

DELETE FROM Konsultasi
WHERE Id_Konsultasi = '1B';
SELECT * FROM Konsultasi;

TRUNCATE Konsultasi;

CREATE TABLE Resep
(Id_Detail VARCHAR(5) NOT NULL,
Id_Resep VARCHAR(5) NOT NULL,
Id_Faskes VARCHAR(5) NOT NULL,
Faskes VARCHAR(50) NOT NULL);

DROP TABLE Resep;

DESCRIBE Resep;

INSERT INTO Resep
(Id_Detail,Id_Resep,Id_Faskes,Faskes)
VALUES ('#A100','#1A','GP','Global Prima'),
('#A110','#1B','BP','BPJS'),
('#B205','#3D','MT','Murni Teguh');
SELECT * FROM Resep;

UPDATE Resep
SET Id_Detail = '#A205' , Id_Resep = '2D'
WHERE Id_Detail = '#B205';
SELECT * FROM Resep;

DELETE FROM Resep
WHERE Id_Detail = '#A100';
SELECT * FROM Resep;

TRUNCATE Resep;

CREATE TABLE Faskes
(Id_Faskes VARCHAR(5) NOT NULL,
Id_Detail VARCHAR(5) NOT NULL,
Nama LONGTEXT NOT NULL,
Alamat LONGTEXT NOT NULL,
Laboratorium VARCHAR(20) NOT NULL,
Cek_Darah VARCHAR(20) NULL,
USG VARCHAR(20) NULL,
CT_Scan VARCHAR(20) NULL,
Apotek VARCHAR(20) NOT NULL,
Obat_Generik_atau_Racikan VARCHAR(10) NULL,
Vitamin VARCHAR(20) NULL,
Rumah_Sakit VARCHAR(50) NOT NULL,
RS_Rujukan_Dokter VARCHAR(50) NULL);

DROP TABLE Faskes;

DESCRIBE Faskes;

INSERT INTO Faskes
(Id_Faskes,Id_Detail,Nama,Alamat,Laboratorium,Cek_Darah,USG,CT_Scan,Apotek,Obat_Generik_atau_Racikan,Vitamin,Rumah_Sakit,RS_Rujukan_Dokter)
VALUES ('MT','#B205','Benny Tok','Jln. Pepaya No.32','-','-','-','-','Apotek Bisa Sehat','Generik','Vitamin C','-','-'),
('BP','#A156','Erik Stones','Jln. Mangga No.107','Laboratorium Thamrin','+','-','-','Apotek Yakin Jaya','Racikan','Vitamin A,B,D','-','-');
SELECT * FROM Faskes;

UPDATE Faskes
SET Apotek = 'Apotek Yakin Jaya' , Alamat = 'Jln. Pisang No.21'
WHERE Id_Faskes = 'MT';
SELECT * FROM Faskes;

DELETE FROM Faskes
WHERE Id_Faskes = 'BP';
SELECT * FROM Faskes;

TRUNCATE Faskes;























