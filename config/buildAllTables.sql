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
  `SNum` int(11) NOT NULL,
  `DNum` int(11) NOT NULL,
  `QNum` int(11) NOT NULL,
  `SPrice` int(11) NOT NULL,
  `DPrice` int(11) NOT NULL,
  `QPrice` int(11) NOT NULL,
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
  `DateIsAvailable` BLOB NOT NULL,
  PRIMARY KEY (`RoomID`),
  UNIQUE KEY `RoomID_UNIQUE` (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Orders`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `Orders` (
  `OrderID` int(11) NOT NULL,
  `UID` varchar(45) NOT NULL,
  `HotelID` int(11) NOT NULL,
  `StartDate` int(11) NOT NULL,
  `EndDate` int(11) NOT NULL,
  `SNum` int(11) NOT NULL,
  `DNum` int(11) NOT NULL,
  `QNum` int(11) NOT NULL,
  `TotalPrice` int(11) NOT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE KEY `OrderID_UNIQUE` (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*`DateAvailable` BOOLEAN ARRAY[1000] NOT NULL,*/;