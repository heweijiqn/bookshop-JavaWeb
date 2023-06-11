/*
SQLyog Professional v12.14 (64 bit)
MySQL - 5.7.19 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

LOCK TABLES `t_book` WRITE;

insert  into `t_book`(`id`,`name`,`price`,`author`,`sales`,`stock`,`img_path`) values 
(1,'java面对对象','81.00','何伟健',9999999,999,'static/img/default.jpg'),
(2,'Java经典示例','78.50','张磊',6,13,'static/img/java5.jpg'),
(3,'疯狂Java讲义','68.00','叶泽荣',99999,52,'static/img/java6.jpg'),
(4,'Javaweb项目案列导航','16.00','小胖',1000,50,'static/img/java7.jpg'),
(5,'Java语言程序设计','45.50','大胖',14,95,'static/img/java8.jpg'),
(6,'Java深入解析','9.90','吴总就',12,52,'static/img/java9.jpg'),
(7,'Java面试宝典','66.50','张三',125,535,'static/img/java10.jpg'),
(8,'Java编程思想','99.50','赵四',47,36,'static/img/javaweb2.jpg'),
(9,'深入分析Javaweb技术内幕','9.90','刘六',85,95,'static/img/javaweb3.jpg'),
(10,'学通Javaweb的24门课','49.00','牛二',52,62,'static/img/junit.jpg'),
(11,'osgi实战','28.00','谭七',52,74,'static/img/osgi1.jpg'),
(12,'深入了解osgi','51.50','雷八',48,82,'static/img/osgi2.jpg'),
(13,'java核心技术','12.00','罗九',19,9999,'static/img/java2.jpg'),
(14,'Java网络编程','33.05','刘德',22,88,'static/img/java3.jpg'),
(15,'spring企业应用开发实战','133.05','刘优',122,188,'static/img/spring1.jpg'),
(16,'spring攻略','173.15','封十',21,81,'static/img/spring2.jpg'),
(17,'tomcat Javaweb开发技术详解','99.15','乐十一',210,810,'static/img/tomcat.jpg'),
(18,'javaScript从入门到精通','69.15','国十二',210,810,'static/img/javascript.jpg'),
(19,'Javascript语言精粹','89.15','国十三',20,10,'static/img/javascript2.jpg'),
(20,'Java编程是想','88.15','莫刚',999,80,'static/img/java11.jpg'),
(21,'javaweb典型模块域项目实战开发','999.00','何加',9999999,111,'static/img/javaweb1.jpg'),
(22,'javaweb开发实战1200例','999.00','邓贺',9999999,111,'static/img/javaweb4.jpg'),
(23,'疯狂Ajax讲义','999.00','王宝',9999999,111,'static/img/ajax.jpg'),
(25,'flash全站互动设计','999.00','黎明',9999999,111,'static/img/flash1.jpg');

UNLOCK TABLES;

/*Table structure for table `t_cart` */

DROP TABLE IF EXISTS `t_cart`;

CREATE TABLE `t_cart` (
  `totalPrice` int(11) DEFAULT NULL,
  `totalCount` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_cart` */

LOCK TABLES `t_cart` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_cart_item` */

DROP TABLE IF EXISTS `t_cart_item`;

CREATE TABLE `t_cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `t_cart_item` */

LOCK TABLES `t_cart_item` WRITE;

UNLOCK TABLES;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `orderid` int(20) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

LOCK TABLES `t_order` WRITE;

insert  into `t_order`(`orderid`,`userid`) values 
(13261285,3);

UNLOCK TABLES;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

insert  into `user`(`id`,`username`,`password`,`email`) values 
(1,'admin','admin','admin@atguigu.com'),
(3,'hwj1218','123456','hwj@qq.com'),
(4,'hwj1217','123456','hwj@qq.com'),
(9,'hwj1219','123456','hwj@qq.com'),
(10,'hwj1216','123456','hwj@qq.com'),
(11,'hwj1210','123456','hwj@qq.com'),
(12,'hwj110','123456','hwj110@qq.com'),
(13,'hwj1104','123456','hwj@qq.com'),
(14,'hwj1234','123456','12345@qq.com'),
(15,'hwj12181128','123456','12345@qq.com'),
(16,'hwj1239','123456','12345@qq.com'),
(17,'hwj1238','123456','12345@qq.com'),
(18,'yzr1218','123456','123456@qq.com'),
(19,'yzr1219','123456','123456@qq.com'),
(20,'hhh1234','123456','123456@qq.com'),
(21,'wbl1218','123456','123456@qq.com'),
(22,'hjl1218','123456','123456@qq.com'),
(23,'hwj11111','123456','12345@qq.com'),
(24,'zl1234','123456','12345@qq.com');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
