SET NAMES utf8;

CREATE DATABASE if not exists `BlogSite` DEFAULT CHARACTER SET utf8;

USE `BlogSite`;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `Id` varchar(10) PRIMARY KEY,
  `Password` varchar(20) NOT NULL,
  `Nickname` varchar(20) NOT NULL,
  `Gender` varchar(6) NOT NULL DEFAULT 'secret',
  `Profession` varchar(20) NOT NULL DEFAULT '',
  `Email` varchar(30) NOT NULL DEFAULT '',
  `Introduction` varchar(80) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Blog`;

CREATE TABLE `Blog` (
  `Id` int(9) PRIMARY KEY AUTO_INCREMENT,
  `AuthorId` varchar(10) NOT NULL,
  `PublishDate` DateTime NOT NULL,
  `Title` varchar(20) NOT NULL,
  `Content` text NOT NULL,
  `FavorNum` int(8) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Relation`;

CREATE TABLE `Relation` (
  `id` int(3) PRIMARY KEY AUTO_INCREMENT,
  `NoticerId` varchar(10) NOT NULL,
  `NoticedId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
