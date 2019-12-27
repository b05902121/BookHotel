CREATE DATABASE IF NOT EXISTS `hotelList`;
USE `hotelList`;

SET NAMES utf8 ;

DROP TABLE IF EXISTS `Users`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `UID` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `ID_UNIQUE` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;