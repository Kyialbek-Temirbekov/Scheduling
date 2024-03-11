-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: scheduling_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `habit_schedule`
--

DROP TABLE IF EXISTS `habit_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habit_schedule` (
  `habit_id` bigint NOT NULL,
  `schedule` date DEFAULT NULL,
  KEY `FK8hp327t5sfmte4ksfubsintpq` (`habit_id`),
  CONSTRAINT `FK8hp327t5sfmte4ksfubsintpq` FOREIGN KEY (`habit_id`) REFERENCES `reminder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habit_schedule`
--

LOCK TABLES `habit_schedule` WRITE;
/*!40000 ALTER TABLE `habit_schedule` DISABLE KEYS */;
INSERT INTO `habit_schedule` VALUES (2,'2023-05-15'),(2,'2023-05-25'),(2,'2023-05-18'),(6,'2023-05-15');
/*!40000 ALTER TABLE `habit_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder`
--

DROP TABLE IF EXISTS `reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` date DEFAULT NULL,
  `message` varchar(300) NOT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder`
--

LOCK TABLES `reminder` WRITE;
/*!40000 ALTER TABLE `reminder` DISABLE KEYS */;
INSERT INTO `reminder` VALUES (1,'2023-06-15','string','2023-05-15'),(2,NULL,'Reminder',NULL),(3,'2023-06-15','string','2023-05-15'),(4,'2023-06-15','string','2023-05-15'),(5,'2023-06-15','string','2023-05-15'),(6,NULL,'string',NULL);
/*!40000 ALTER TABLE `reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_days`
--

DROP TABLE IF EXISTS `reminder_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_days` (
  `reminder_id` bigint NOT NULL,
  `days` varchar(255) DEFAULT NULL,
  KEY `FK6yh4h1niv9ubnntxh9w3hj55h` (`reminder_id`),
  CONSTRAINT `FK6yh4h1niv9ubnntxh9w3hj55h` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_days`
--

LOCK TABLES `reminder_days` WRITE;
/*!40000 ALTER TABLE `reminder_days` DISABLE KEYS */;
INSERT INTO `reminder_days` VALUES (1,'MONDAY'),(1,'TUESDAY'),(1,'FRIDAY'),(3,'TUESDAY'),(3,'SUNDAY'),(4,'MONDAY'),(5,'MONDAY');
/*!40000 ALTER TABLE `reminder_days` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17  9:32:19
