-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mobile_operator
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Current Database: `mobile_operator`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mobile_operator` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mobile_operator`;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(15) NOT NULL COMMENT 'Phone number in MSISDN format',
  `balance` bigint(20) NOT NULL COMMENT 'Balance on account in cents',
  `start_date` date NOT NULL COMMENT 'Date of contract''s conclusion',
  `end_date` date DEFAULT NULL COMMENT 'Date of contract''s closing',
  `is_active` bit(1) NOT NULL COMMENT 'True - conctact not blocked/closed',
  `customer_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `number_UNIQUE` (`phone_number`),
  KEY `contract_fk_0_idx` (`customer_id`),
  KEY `contract_fk_1_idx` (`employee_id`),
  CONSTRAINT `contract_fk_0` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contract_fk_1` FOREIGN KEY (`employee_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'79111590472',100,'2018-01-01',NULL,'',1,2);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_blocking`
--

DROP TABLE IF EXISTS `contract_blocking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_blocking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_id` bigint(20) NOT NULL,
  `start_date` date NOT NULL COMMENT 'When blocking started',
  `end_date` date DEFAULT NULL COMMENT 'When blocking is ended',
  `user_id` bigint(20) NOT NULL COMMENT 'Who established - contract''s customer or employee',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_contract_blocking_1_idx` (`contract_id`),
  KEY `fk_contract_blocking_2_idx` (`user_id`),
  CONSTRAINT `fk_contract_blocking_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_contract_blocking_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_blocking`
--

LOCK TABLES `contract_blocking` WRITE;
/*!40000 ALTER TABLE `contract_blocking` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_blocking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_option`
--

DROP TABLE IF EXISTS `contract_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_id` bigint(20) NOT NULL,
  `option_id` bigint(20) NOT NULL,
  `start_date` date NOT NULL COMMENT 'When option''s is added',
  `end_date` date DEFAULT NULL COMMENT 'When option is disabled',
  `is_active` bit(1) NOT NULL COMMENT 'True - option active',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_contract_option_1_idx` (`contract_id`),
  KEY `fk_contract_option_2_idx` (`option_id`),
  CONSTRAINT `fk_contract_option_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_contract_option_2` FOREIGN KEY (`option_id`) REFERENCES `option` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_option`
--

LOCK TABLES `contract_option` WRITE;
/*!40000 ALTER TABLE `contract_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_tariff`
--

DROP TABLE IF EXISTS `contract_tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_tariff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_id` bigint(20) NOT NULL,
  `tariff_id` bigint(20) NOT NULL,
  `start_date` date NOT NULL COMMENT 'When tariff was started',
  `end_date` date DEFAULT NULL COMMENT 'When tariff deactivated',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_contract_tariff_1_idx` (`contract_id`),
  KEY `fk_contract_tariff_2_idx` (`tariff_id`),
  CONSTRAINT `fk_contract_tariff_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_contract_tariff_2` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_tariff`
--

LOCK TABLES `contract_tariff` WRITE;
/*!40000 ALTER TABLE `contract_tariff` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_tariff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measure`
--

DROP TABLE IF EXISTS `measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `measure` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT 'Type of measure''s',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measure`
--

LOCK TABLES `measure` WRITE;
/*!40000 ALTER TABLE `measure` DISABLE KEYS */;
INSERT INTO `measure` VALUES (1,'sec'),(2,'min'),(3,'day'),(4,'month'),(5,'year'),(6,'pcs'),(7,'kB'),(8,'MB'),(9,'GB');
/*!40000 ALTER TABLE `measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option`
--

DROP TABLE IF EXISTS `option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price_conn` bigint(20) NOT NULL DEFAULT '0' COMMENT 'Price for connection',
  `cost` bigint(20) NOT NULL DEFAULT '0' COMMENT 'Price for 1 measured usage',
  `measure_id` bigint(20) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `id_measure_1_idx` (`measure_id`),
  CONSTRAINT `fk_option_1` FOREIGN KEY (`measure_id`) REFERENCES `measure` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Options in tariff - special service';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option`
--

LOCK TABLES `option` WRITE;
/*!40000 ALTER TABLE `option` DISABLE KEYS */;
/*!40000 ALTER TABLE `option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option_option`
--

DROP TABLE IF EXISTS `option_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `option_id_1` bigint(20) NOT NULL,
  `option_id_2` bigint(20) NOT NULL,
  `is_binded` bit(1) NOT NULL COMMENT 'True - options binded and its must be used together\nFalse - options binded and its must NOT be used together',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_option_option_1_idx` (`option_id_1`),
  KEY `fk_option_option_2_idx` (`option_id_2`),
  CONSTRAINT `fk_option_option_1` FOREIGN KEY (`option_id_1`) REFERENCES `option` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_option_option_2` FOREIGN KEY (`option_id_2`) REFERENCES `option` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option_option`
--

LOCK TABLES `option_option` WRITE;
/*!40000 ALTER TABLE `option_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `option_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT 'Name of service (SMS, incoming call, etc.)',
  `measure_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_idx` (`measure_id`),
  CONSTRAINT `fk_service_1` FOREIGN KEY (`measure_id`) REFERENCES `measure` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Incoming call',2),(2,'Outcoming call',2),(3,'SMS',6),(4,'LTE',9),(5,'Monthly pay',4);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff`
--

DROP TABLE IF EXISTS `tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tariff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT 'Name of tariff',
  `price_conn` bigint(20) NOT NULL DEFAULT '0' COMMENT 'Price for activation tariff in cents',
  `is_active` bit(1) NOT NULL COMMENT 'Can new users connect to this tariff now or not',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff`
--

LOCK TABLES `tariff` WRITE;
/*!40000 ALTER TABLE `tariff` DISABLE KEYS */;
INSERT INTO `tariff` VALUES (1,'Ultimate',20,''),(2,'Ultimate promo',0,'\0');
/*!40000 ALTER TABLE `tariff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff_option`
--

DROP TABLE IF EXISTS `tariff_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tariff_option` (
  `id` bigint(20) NOT NULL,
  `tariff_id` bigint(20) NOT NULL,
  `option_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_idx` (`tariff_id`),
  KEY `id_idx1` (`option_id`),
  CONSTRAINT `fk_tariff_option_1` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tariff_option_2` FOREIGN KEY (`option_id`) REFERENCES `option` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff_option`
--

LOCK TABLES `tariff_option` WRITE;
/*!40000 ALTER TABLE `tariff_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `tariff_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff_service`
--

DROP TABLE IF EXISTS `tariff_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tariff_service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tariff_id` bigint(20) NOT NULL,
  `service_id` bigint(20) NOT NULL,
  `price` bigint(20) unsigned NOT NULL COMMENT 'How many costs 1 pcs of service in measure',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_idx` (`tariff_id`),
  KEY `id_idx1` (`service_id`),
  CONSTRAINT `fk_tariff_service_1` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tariff_service_2` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff_service`
--

LOCK TABLES `tariff_service` WRITE;
/*!40000 ALTER TABLE `tariff_service` DISABLE KEYS */;
INSERT INTO `tariff_service` VALUES (1,1,1,0),(2,1,2,0),(3,1,3,0),(4,1,4,0),(5,1,5,10000);
/*!40000 ALTER TABLE `tariff_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_user`
--

DROP TABLE IF EXISTS `type_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT 'User''s types: customers, employeers',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_user`
--

LOCK TABLES `type_user` WRITE;
/*!40000 ALTER TABLE `type_user` DISABLE KEYS */;
INSERT INTO `type_user` VALUES (1,'customer'),(2,'employee');
/*!40000 ALTER TABLE `type_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `date_birth` date NOT NULL,
  `passport` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` bigint(20) NOT NULL COMMENT 'Hash of password',
  `type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `passport_UNIQUE` (`passport`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_1_idx` (`type_id`),
  CONSTRAINT `fk_user_1` FOREIGN KEY (`type_id`) REFERENCES `type_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ivan','Ivanov','1994-01-03','0000112233','Test street, Testsity','ivanov@test.ru',1,1),(2,'Sveta','Svetova','1960-12-25','0011001122','adress','sveta@mt.ru',2,2);
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

-- Dump completed on 2018-04-12 13:48:45
