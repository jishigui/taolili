-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 121.37.216.114    Database: taolili
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `taolili_trande_flow`
--

DROP TABLE IF EXISTS `taolili_trande_flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taolili_trande_flow` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `wallet_id` bigint DEFAULT NULL COMMENT '钱包id',
  `trande_code` char(1) DEFAULT NULL COMMENT '0消费 1退款',
  `trade_amount` decimal(10,0) DEFAULT NULL COMMENT '交易金额',
  `wallet_balance` decimal(10,0) DEFAULT NULL COMMENT '钱包余额',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `taolili_trande_flow_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COMMENT='交易流水表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taolili_trande_flow`
--

LOCK TABLES `taolili_trande_flow` WRITE;
/*!40000 ALTER TABLE `taolili_trande_flow` DISABLE KEYS */;
INSERT INTO `taolili_trande_flow` VALUES (1,1,1,'0',1000,40000,'2023-03-25 14:39:59','2023-03-25 14:39:59',1),(2,1,1,'1',10000,50000,'2023-03-25 14:42:29','2023-03-25 14:42:29',1),(3,1,1,'1',10000,60000,'2023-03-26 04:14:07','2023-03-26 04:14:07',1),(4,1,1,'1',10000,70000,'2023-03-26 04:32:53','2023-03-26 04:32:53',1),(5,1,1,'0',10000,60000,'2023-03-26 04:52:04','2023-03-26 04:52:04',1),(6,1,1,'0',10000,50000,'2023-03-26 12:15:59','2023-03-26 12:15:59',1),(7,1,1,'1',10000,60000,'2023-03-26 12:16:05','2023-03-26 12:16:05',1),(8,1,1,'1',10000,70000,'2023-03-26 12:18:40','2023-03-26 12:18:40',1),(9,1,1,'1',10000,80000,'2023-03-26 12:18:43','2023-03-26 12:18:43',1),(10,1,1,'1',10000,90000,'2023-03-26 12:29:13','2023-03-26 12:29:13',2),(11,1,1,'1',10000,100000,'2023-03-26 12:29:18','2023-03-26 12:29:18',2),(12,1,1,'1',10000,110000,'2023-03-26 12:32:05','2023-03-26 12:32:05',1),(13,1,1,'1',10000,120000,'2023-03-26 12:32:08','2023-03-26 12:32:08',1);
/*!40000 ALTER TABLE `taolili_trande_flow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taolili_user`
--

DROP TABLE IF EXISTS `taolili_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taolili_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `sex` char(1) DEFAULT NULL COMMENT '0代表女 1代表男 2代表性别未确定',
  `age` int DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `taolili_user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taolili_user`
--

LOCK TABLES `taolili_user` WRITE;
/*!40000 ALTER TABLE `taolili_user` DISABLE KEYS */;
INSERT INTO `taolili_user` VALUES (1,'易星','yi\'x','1',21,'2023-03-25 13:48:34','2023-03-25 13:48:34',1);
/*!40000 ALTER TABLE `taolili_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taolili_wallet`
--

DROP TABLE IF EXISTS `taolili_wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taolili_wallet` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `wallet_balance` decimal(10,0) DEFAULT '0' COMMENT '余额',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `taolili_wallet_id_uindex` (`id`),
  UNIQUE KEY `id` (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='用户钱包表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taolili_wallet`
--

LOCK TABLES `taolili_wallet` WRITE;
/*!40000 ALTER TABLE `taolili_wallet` DISABLE KEYS */;
INSERT INTO `taolili_wallet` VALUES (1,1,120000,'2023-03-25 13:49:07','2023-03-25 13:49:07',3);
/*!40000 ALTER TABLE `taolili_wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-26 21:19:42
