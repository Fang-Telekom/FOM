-- MariaDB dump 10.19  Distrib 10.11.4-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: uni
-- ------------------------------------------------------
-- Server version	10.11.4-MariaDB-1~deb12u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `personen`
--

DROP TABLE IF EXISTS `personen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personen` (
  `name` varchar(30) DEFAULT NULL,
  `vorname` varchar(25) DEFAULT NULL,
  `personalnummer` int(11) NOT NULL AUTO_INCREMENT,
  `gehalt` double DEFAULT NULL,
  `geburtstag` date DEFAULT NULL,
  PRIMARY KEY (`personalnummer`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personen`
--

LOCK TABLES `personen` WRITE;
/*!40000 ALTER TABLE `personen` DISABLE KEYS */;
INSERT INTO `personen` VALUES
('Maier','Hans',4,3500,'1962-03-15'),
('Schmitz','Peter',5,3750,'1958-04-12'),
('Mertens','Julia',6,3621.5,'1959-12-30');
/*!40000 ALTER TABLE `personen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(32) DEFAULT NULL,
  `kapital` int(11) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(1,'Hans','3e45af4ca27ea2b03fc6183af40ea112',100000,'Hans.King@gmail.com',1),
(5,'Henry','d41d8cd98f00b204e9800998ecf8427e',5000,'Henry@gmail.com',0),
(6,'Henry','3e45af4ca27ea2b03fc6183af40ea112',50000,'Henry@gmail.com',0),
(7,'Zhi Yang Fang','3e45af4ca27ea2b03fc6183af40ea112',5000,'zhi-yang.fang@telekom.de',0),
(8,'Henrie','3e45af4ca27ea2b03fc6183af40ea112',5000,'Henrie@gmail.com',0),
(9,'Blob','3e45af4ca27ea2b03fc6183af40ea112',500,'blob@gmail.com',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-14 22:13:00
