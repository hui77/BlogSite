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

insert  into `User` values
('1000000000','123456789','hui','male','Java程序员','2327502214@qq.com','我的剑，就是你的剑！'),
('1000000001','987654321','secret','secret','隐者','xxxxxxxxxx@xxx.com','哥只是传说！')
;

DROP TABLE IF EXISTS `Blog`;

CREATE TABLE `Blog` (
  `Id` int(9) PRIMARY KEY AUTO_INCREMENT,
  `AuthorId` varchar(10) NOT NULL,
  `PublishDate` DateTime NOT NULL,
  `Title` varchar(20) NOT NULL,
  `Content` text NOT NULL,
  `FavorNum` int(8) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `Blog` values
('1','1000000000',str_to_date('2019-1-17 9:5:55','%Y-%m-%d %H:%i:%S'),'编程世界','Java-网络后端；C/C++-桌面应用程序开发；python-人工智能',77),
('2','1000000001',str_to_date('1970-1-1 0:0:0','%Y-%m-%d %H:%i:%S'),'宇宙奥秘','死亦生，生亦死，一切皆虚无！',99999999)
;

DROP TABLE IF EXISTS `Relation`;

CREATE TABLE `Relation` (
  `id` int(3) PRIMARY KEY AUTO_INCREMENT,
  `NoticerId` varchar(10) NOT NULL,
  `NoticedId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `Relation` values
('1','1000000000','1000000001'),
('2','1000000001','1000000000')
;
