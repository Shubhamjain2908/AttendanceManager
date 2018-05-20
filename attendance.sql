/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.37-community-nt : Database - attendance
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`attendance` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `attendance`;

/*Table structure for table `addsubject` */

DROP TABLE IF EXISTS `addsubject`;

CREATE TABLE `addsubject` (
  `Subject_Code` varchar(10) NOT NULL,
  `Subject_name` varchar(50) default NULL,
  PRIMARY KEY  (`Subject_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `addsubject` */

insert  into `addsubject`(`Subject_Code`,`Subject_name`) values ('IT-5002','Principle of Programming Languages'),('IT-5003','Computer Networks'),('IT-5004','Digital Communication'),('IT-5005','Java Programming'),('IT-5005(A)','Microprocessor and Interfacing '),('IT-5005(B)','Software Testing'),('IT-5005(C)','Data Communication'),('JS','JAVA SCRIPT');

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` varchar(100) NOT NULL default '',
  `password` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`id`,`password`) values ('admin','827ccb0eea8a706c4c34a16891f84e7b');

/*Table structure for table `attendence` */

DROP TABLE IF EXISTS `attendence`;

CREATE TABLE `attendence` (
  `id` int(20) default NULL,
  `enrollment` varchar(50) default NULL,
  `lecture` varchar(50) default NULL,
  `date` date default NULL,
  `status` varchar(50) default NULL,
  `faculty` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `attendence` */

/*Table structure for table `compiled` */

DROP TABLE IF EXISTS `compiled`;

CREATE TABLE `compiled` (
  `id` int(20) NOT NULL,
  `enrollment` varchar(50) default NULL,
  `startingDate` date default NULL,
  `endingDate` date default NULL,
  `percentage` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `compiled` */

/*Table structure for table `faculty` */

DROP TABLE IF EXISTS `faculty`;

CREATE TABLE `faculty` (
  `facultyid` varchar(50) NOT NULL,
  `name` varchar(50) default NULL,
  `number` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `gender` varchar(50) default NULL,
  `dob` date default NULL,
  `address` varchar(500) default NULL,
  `password` varchar(100) default NULL,
  `flag` int(10) default NULL,
  `authcode` varchar(20) default NULL,
  PRIMARY KEY  (`facultyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `faculty` */

insert  into `faculty`(`facultyid`,`name`,`number`,`email`,`gender`,`dob`,`address`,`password`,`flag`,`authcode`) values ('0812IT151054','shubham jain','8871574375','sjain88715@gmail.com','Male','2018-01-04','31 Greater Vaishali','827ccb0eea8a706c4c34a16891f84e7b',1,'0'),('111111111111','as','9829812712','asljda@kjlsa.c0jmas','Male','2018-02-08','akalsksA','827ccb0eea8a706c4c34a16891f84e7b',1,'0'),('12345','shubham jain','8871574375','shubhamjain2908@gmail.com','Male','2018-01-01','31 Greater Vaishali','827ccb0eea8a706c4c34a16891f84e7b',1,'0');

/*Table structure for table `facultytt` */

DROP TABLE IF EXISTS `facultytt`;

CREATE TABLE `facultytt` (
  `id` int(11) default NULL,
  `facultyid` varchar(50) default NULL,
  `days` varchar(50) default NULL,
  `time` varchar(50) default NULL,
  `lecture` varchar(50) default NULL,
  `division` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `facultytt` */

insert  into `facultytt`(`id`,`facultyid`,`days`,`time`,`lecture`,`division`) values (1,'0812IT151054','Monday','08:30 - 09:25','IT-5005','IT'),(2,'0812IT151054','Monday','09:30 - 10:25','IT-5005','IT'),(3,'0812IT151054','Monday','10:30 - 11:20','IT-5005','IT'),(4,'0812IT151054','Monday','11:25 - 12:15','IT-5005','IT'),(5,'0812IT151054','Monday','01:15 - 02:05','IT-5005','IT'),(6,'0812IT151054','Monday','02:10 - 03:00','IT-5005','IT'),(7,'0812IT151054','Monday','03:05 - 04:00','IT-5005','IT'),(8,'0812IT151054','Monday','04:05 - 05:00','IT-5005','IT'),(9,'0812IT151054','Tuesday','08:30 - 09:25','IT-5005','IT'),(10,'0812IT151054','Tuesday','09:30 - 10:25','IT-5005','IT'),(11,'0812IT151054','Tuesday','10:30 - 11:20','IT-5005','IT'),(12,'0812IT151054','Tuesday','11:25 - 12:15','IT-5005','IT'),(13,'0812IT151054','Tuesday','01:15 - 02:05','IT-5005','IT'),(14,'0812IT151054','Tuesday','02:10 - 03:00','IT-5005','IT'),(15,'0812IT151054','Tuesday','03:05 - 04:00','IT-5005','IT'),(16,'0812IT151054','Tuesday','04:05 - 05:00','IT-5005','IT'),(17,'0812IT151054','Wednesday','08:30 - 09:25','IT-5005','IT'),(18,'0812IT151054','Wednesday','09:30 - 10:25','IT-5005','IT'),(19,'0812IT151054','Wednesday','10:30 - 11:20','IT-5005','IT'),(20,'0812IT151054','Wednesday','11:25 - 12:15','IT-5005','IT'),(21,'0812IT151054','Wednesday','01:15 - 02:05','IT-5005','IT'),(22,'0812IT151054','Wednesday','02:10 - 03:00','IT-5005','IT'),(23,'0812IT151054','Wednesday','03:05 - 04:00','IT-5005','IT'),(24,'0812IT151054','Wednesday','04:05 - 05:00','IT-5005','IT'),(25,'0812IT151054','Thrusday','08:30 - 09:25','IT-5005','IT'),(26,'0812IT151054','Thrusday','09:30 - 10:25','IT-5005','IT'),(27,'0812IT151054','Thrusday','10:30 - 11:20','IT-5005','IT'),(28,'0812IT151054','Thrusday','11:25 - 12:15','IT-5005','IT'),(29,'0812IT151054','Thrusday','01:15 - 02:05','IT-5005','IT'),(30,'0812IT151054','Thrusday','02:10 - 03:00','IT-5005','IT'),(31,'0812IT151054','Thrusday','03:05 - 04:00','IT-5005','IT'),(32,'0812IT151054','Thrusday','04:05 - 05:00','IT-5005','IT'),(33,'0812IT151054','Friday','08:30 - 09:25','IT-5005','IT'),(34,'0812IT151054','Friday','09:30 - 10:25','IT-5005','IT'),(35,'0812IT151054','Friday','10:30 - 11:20','IT-5005','IT'),(36,'0812IT151054','Friday','11:25 - 12:15','IT-5005','IT'),(37,'0812IT151054','Friday','01:15 - 02:05','IT-5005','IT'),(38,'0812IT151054','Friday','02:10 - 03:00','IT-5005','IT'),(39,'0812IT151054','Friday','03:05 - 04:00','IT-5005','IT'),(40,'0812IT151054','Friday','04:05 - 05:00','IT-5005','IT'),(41,'111111111111','Monday','08:30 - 09:25','IT-5003','CS'),(42,'111111111111','Monday','09:30 - 10:25','IT-5004','CS'),(43,'0812IT151054','Monday','10:30 - 11:20','free','null'),(44,'111111111111','Monday','11:25 - 12:15','JS','CS'),(45,'111111111111','Monday','01:15 - 02:05','JS','CS'),(46,'111111111111','Monday','02:10 - 03:00','IT-5002','CS'),(47,'111111111111','Monday','03:05 - 04:00','IT-5004','CS'),(48,'111111111111','Monday','04:05 - 05:00','IT-5005','CS'),(49,'111111111111','Tuesday','08:30 - 09:25','free','CS'),(50,'111111111111','Tuesday','09:30 - 10:25','IT-5002','CS'),(51,'111111111111','Tuesday','10:30 - 11:20','IT-5004','CS'),(52,'111111111111','Tuesday','11:25 - 12:15','IT-5002','CS'),(53,'111111111111','Tuesday','01:15 - 02:05','IT-5005','CS'),(54,'111111111111','Tuesday','02:10 - 03:00','IT-5005(B)','CS'),(55,'111111111111','Tuesday','03:05 - 04:00','IT-5005(B)','CS'),(56,'111111111111','Tuesday','04:05 - 05:00','IT-5005(B)','CS'),(57,'111111111111','Wednesday','08:30 - 09:25','IT-5005(C)','CS'),(58,'111111111111','Wednesday','09:30 - 10:25','IT-5005(C)','CS'),(59,'111111111111','Wednesday','10:30 - 11:20','IT-5004','CS'),(60,'111111111111','Wednesday','11:25 - 12:15','IT-5003','CS'),(61,'111111111111','Wednesday','01:15 - 02:05','IT-5005(C)','CS'),(62,'111111111111','Wednesday','02:10 - 03:00','IT-5004','CS'),(63,'111111111111','Wednesday','03:05 - 04:00','IT-5004','CS'),(64,'111111111111','Wednesday','04:05 - 05:00','IT-5005','CS'),(65,'111111111111','Thrusday','08:30 - 09:25','IT-5005(C)','CS'),(66,'111111111111','Thrusday','09:30 - 10:25','IT-5005','CS'),(67,'111111111111','Thrusday','10:30 - 11:20','IT-5005(C)','CS'),(68,'111111111111','Thrusday','11:25 - 12:15','IT-5005','CS'),(69,'111111111111','Thrusday','01:15 - 02:05','IT-5005(A)','CS'),(70,'111111111111','Thrusday','02:10 - 03:00','IT-5005(C)','CS'),(71,'111111111111','Thrusday','03:05 - 04:00','IT-5005','CS'),(72,'111111111111','Thrusday','04:05 - 05:00','IT-5005','CS'),(73,'111111111111','Friday','08:30 - 09:25','IT-5005(C)','CS'),(74,'111111111111','Friday','09:30 - 10:25','IT-5005(C)','CS'),(75,'111111111111','Friday','10:30 - 11:20','IT-5005(C)','CS'),(76,'111111111111','Friday','11:25 - 12:15','free','CS'),(77,'111111111111','Friday','01:15 - 02:05','IT-5005(A)','CS'),(78,'111111111111','Friday','02:10 - 03:00','IT-5005(A)','CS'),(79,'111111111111','Friday','03:05 - 04:00','JS','CS'),(80,'111111111111','Friday','04:05 - 05:00','IT-5005(C)','CS');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `enrollment` varchar(100) NOT NULL,
  `name` varchar(100) default NULL,
  `number` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `gender` varchar(100) default NULL,
  `dob` date default NULL,
  `address` varchar(500) default NULL,
  `branch` varchar(100) default NULL,
  `session` varchar(100) default NULL,
  `division` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  PRIMARY KEY  (`enrollment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`enrollment`,`name`,`number`,`email`,`gender`,`dob`,`address`,`branch`,`session`,`division`,`password`) values ('0192ec208912','aljs','9128912892','lak@lLAS.COM','Female','2018-02-15','ASKLAKS ;LQ 80291','EC','null','null','6f07efdd16999e894e5ade416d2b99a3'),('0812IT151001','Akash Tak','9829372823','','Male','2018-01-10','saksa','IT','null','null','94754d0abb89e4cf0a7f1c494dbb9d2c'),('0812IT151002','Abhansh Giri','9829372823','','Male','2018-01-10','saksa','IT','null','null','a95bc72cf82d4eaa0874de0175dc2091'),('0812IT151003','Abhishek Raj','9829372823','','Male','2018-01-10','saksa','IT','null','null','65a1223dae83b8092c4edba0823a793c'),('0812IT151054','shubham jain','shubham jain','sjain88715@gmail.com','Male','2018-01-04','31 Greater Vaishali','IT','null','null','827ccb0eea8a706c4c34a16891f84e7b');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
