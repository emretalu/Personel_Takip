CREATE DATABASE person_db

CREATE TABLE `departman` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

insert  into `departman`(`Id`,`Ad`) values 
(1,'Insan Kaynaklari'),
(2,'Muhasebe'),
(3,'Bilgi Islem'),
(4,'Yazilim'),
(5,'Grafik Tasarim');

CREATE TABLE `personel` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DepartmanNo` int(10) unsigned NOT NULL,
  `Ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `Soyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `Yas` int(10) unsigned NOT NULL,
  `Cinsiyet` enum('Erkek','Kadýn') COLLATE utf8_turkish_ci NOT NULL,
  `Telefon` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL,
  `EPosta` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Parola` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `EPosta` (`EPosta`),
  KEY `DepNo` (`DepartmanNo`),
  CONSTRAINT `DepNo` FOREIGN KEY (`DepartmanNo`) REFERENCES `departman` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

insert  into `personel`(`Id`,`DepartmanNo`,`Ad`,`Soyad`,`Yas`,`Cinsiyet`,`Telefon`,`EPosta`,`Parola`) values 
(1,4,'Emre','Talu',24,'Erkek','0555 443 23 43','taluem@itu.edu.tr','emre'),
(2,4,'Onur','Güzel',22,'Erkek','0533 412 51 23','guzelmu@itu.edu.tr','onur'),
(3,1,'Admin','Admin',18,'Erkek','0554 354 77 13','admin@marmelat.net','admin');