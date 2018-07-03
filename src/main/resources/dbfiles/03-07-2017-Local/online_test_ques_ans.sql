CREATE DATABASE  IF NOT EXISTS `online_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `online_test`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: online_test
-- ------------------------------------------------------
-- Server version	5.6.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ques_ans`
--

DROP TABLE IF EXISTS `ques_ans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ques_ans` (
  `que_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` longtext NOT NULL,
  `opt1` longtext,
  `opt2` longtext,
  `opt3` longtext,
  `opt4` longtext,
  `ans` varchar(45) DEFAULT NULL,
  `difficult_level` int(11) DEFAULT NULL,
  `attempts` int(11) DEFAULT NULL,
  `answered` int(11) DEFAULT NULL,
  `display` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`que_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ques_ans`
--

LOCK TABLES `ques_ans` WRITE;
/*!40000 ALTER TABLE `ques_ans` DISABLE KEYS */;
INSERT INTO `ques_ans` VALUES (1,'What is out national animal','Tiger','Elephant','Peocock','Pegion','Tiger',1,NULL,NULL,1),(2,'Grand Central Terminal, Park Avenue, New York is the world\'s','largest railway station','longest railway station','highest railway station','None of the above','largest railway station',1,NULL,NULL,0),(4,'For which of the following disciplines is Nobel Prize awarded?','Physics and Chemistry','Physiology or Medicine','Literature, Peace and Economics','All of the above','All of the above',1,NULL,NULL,0),(5,'What is our national anthem language?','Hindi','Tamil','Bengali','Sanskrit','Bengali',1,NULL,NULL,NULL),(6,'Which of the following is true between Overloading and overriding','Java','Different','Equalant','Most likely','Different',1,NULL,NULL,0);
/*!40000 ALTER TABLE `ques_ans` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-03 22:43:03
