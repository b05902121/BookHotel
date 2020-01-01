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

DROP TABLE IF EXISTS `Hotels`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `Hotels` (
  `HotelID` int(11) NOT NULL,
  `HotelStar` int(11) NOT NULL,
  `Locality` varchar(45) NOT NULL,
  `Street-Address` varchar(45) NOT NULL,
  PRIMARY KEY (`HotelID`),
  UNIQUE KEY `HotelID_UNIQUE` (`HotelID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Rooms`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `Rooms` (
  `RoomID` int(11) NOT NULL,
  `HotelID` int(11) NOT NULL,
  `RoomType` varchar(45) NOT NULL,
  `RoomPrice` int(11) NOT NULL,
  PRIMARY KEY (`RoomID`),
  UNIQUE KEY `RoomID_UNIQUE` (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*`DateAvailable` BOOLEAN ARRAY[1000] NOT NULL,*/;