-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: general_store
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB-1:10.5.8+maria~focal

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
-- Table structure for table `customer table`
--

DROP TABLE IF EXISTS `customer table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer table` (
  `Cust_id` varchar(25) NOT NULL,
  `Cust_name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Pin` int(11) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Bal_due` decimal(10,1) NOT NULL,
  PRIMARY KEY (`Cust_id`),
  UNIQUE KEY `unique_id` (`Cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer table`
--

LOCK TABLES `customer table` WRITE;
/*!40000 ALTER TABLE `customer table` DISABLE KEYS */;
INSERT INTO `customer table` VALUES ('cu01001','alak roy','b.d.para','Patna',800015,'Bihar',0.0),('cu01002','suman roy','puk para','patna',800132,'Bihar',2390.9),('cu01003','nidhi mishra','naini','allahabad',212079,'uttar pradesh',9990.9),('cu01004','priya das','chora para','Gaya',800010,'Bihar',1390.9),('cu01005','rina raj','kamal para','patna',800001,'Bihar',0.0),('cu01006','pulak roy','bircity','lucknow',226012,'uttar pradesh',110.9),('cu01007','priyanka das','nappam','lucknow',226005,'uttar pradesh',190.9),('cu01008','kusum roy','Jhalwa','allahabad',211012,'uttar pradesh',110.9),('cu01009','mina das','naini','allahabad',211078,'uttar pradesh',0.0),('cu01010','kamal yadav','naini','allahabad',211037,'uttar pradesh',2990.9),('cu01011','manali das','rajapur','allahabad',212098,'uttar pradesh',3990.9);
/*!40000 ALTER TABLE `customer table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item table`
--

DROP TABLE IF EXISTS `item table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item table` (
  `Item_id` varchar(15) NOT NULL,
  `Item_name` varchar(45) NOT NULL,
  `Manu_name` varchar(45) NOT NULL,
  `Item_rate` decimal(10,2) NOT NULL,
  `Sell_price` decimal(10,2) NOT NULL,
  `Item_description` varchar(45) NOT NULL,
  PRIMARY KEY (`Item_id`),
  UNIQUE KEY `unique_id` (`Item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item table`
--

LOCK TABLES `item table` WRITE;
/*!40000 ALTER TABLE `item table` DISABLE KEYS */;
INSERT INTO `item table` VALUES ('i001','lux_soap','lux_company',15.67,20.43,'soap'),('i002','copy','royal_notebook',14.80,16.40,'copy'),('i003','goodday_biscuit','britania_stores',2218.80,2220.40,'biscuit'),('i004','reynolds_pen','pen_parker',2015.67,2120.43,'pen'),('i005','sql_books','book_bpb',5104.80,5116.40,'book'),('i006','tata_steel','tata_sons',5118.80,5120.40,'tata'),('i007','seagate hdd','hp_world',5104.80,5116.40,'HDD1034'),('i008','dvd writer','moserbear_org',5118.80,5120.40,'DVDRW');
/*!40000 ALTER TABLE `item table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales order table`
--

DROP TABLE IF EXISTS `sales order table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales order table` (
  `Sales_order_no` varchar(25) NOT NULL,
  `Sales_order_date` varchar(15) NOT NULL,
  `Cust_id` varchar(25) NOT NULL,
  `Salesman_id` varchar(10) NOT NULL,
  `Bill_payby_party` varchar(3) NOT NULL,
  `Delivery_date` varchar(15) NOT NULL,
  `Item_rate` decimal(10,2) NOT NULL,
  `Tot_quantity_order` int(11) NOT NULL,
  `Cancel_date` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Sales_order_no`),
  UNIQUE KEY `unique_order_no` (`Sales_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales order table`
--

LOCK TABLES `sales order table` WRITE;
/*!40000 ALTER TABLE `sales order table` DISABLE KEYS */;
INSERT INTO `sales order table` VALUES ('son01001','01-aug-2008','cu01001','s001','yes','20-aug-2008',2220.40,50,'null'),('son01002','01-aug-2008','cu01002','s001','yes','20-aug-2008',2340.70,10,'null'),('son01003','01-aug-2008','cu01003','s002','yes','20-aug-2008',4789.80,20,'null'),('son01004','01-aug-2008','cu01004','s003','no','20-aug-2008',2340.60,70,'null'),('son01005','01-aug-2008','cu01005','s004','yes','20-aug-2008',4567.80,40,'28-march-2008'),('son01006','01-aug-2008','cu01006','s002','yes','20-aug-2008',3456.78,40,'null'),('son01007','01-aug-2008','cu01007','s003','yes','20-aug-2008',2390.70,20,'null'),('son01008','01-aug-2008','cu01008','s004','yes','20-aug-2008',8220.40,30,'null'),('son01009','01-aug-2008','cu01001','s001','yes','20-aug-2008',2220.80,10,'18-march-2008');
/*!40000 ALTER TABLE `sales order table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesman table`
--

DROP TABLE IF EXISTS `salesman table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesman table` (
  `Salesman_id` varchar(15) NOT NULL,
  `Salesman_name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Pin` int(11) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Salary` int(11) NOT NULL,
  PRIMARY KEY (`Salesman_id`),
  UNIQUE KEY `unique_id` (`Salesman_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesman table`
--

LOCK TABLES `salesman table` WRITE;
/*!40000 ALTER TABLE `salesman table` DISABLE KEYS */;
INSERT INTO `salesman table` VALUES ('s001','rohan singh','rajapur','allahabad',212098,'uttar pradesh',8000),('s002','rohan singh','naini','allahabad',212096,'uttar pradesh',9800),('s003','smita roy','indira nagar ','lucknow',226078,'uttar pradesh',3400),('s004','kabir bora','vikas nagar ','lucknow',226045,'uttar pradesh',6700),('s005','neha singh','gomti nagar','lucknow',226032,'uttar pradesh',9600),('s006','priya agrawal','gandhi road','32 distric',799750,'uttar pradesh',9900),('s007','ashok paul','filmcity','munnabari',799740,'delhi',8900);
/*!40000 ALTER TABLE `salesman table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-02 21:00:24
