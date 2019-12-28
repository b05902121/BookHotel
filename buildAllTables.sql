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

DROP TABLE IF EXISTS `Orders`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `Orders` (
  `OrderID` int(11) NOT NULL,
  `UID` varchar(45) NOT NULL,
  `HotelID` int(11) NOT NULL,
  `SingleRoom` int(5) NOT NULL,
  `DoubleRoom` int(5) NOT NULL,
  `QuadRoom` int(5) NOT NULL,
  `CheckIn` date NOT NULL,
  `CheckOut` date NOT NULL,
  PRIMARY KEY (`OrderID`),
  UNIQUE KEY `OrderID_UNIQUE` (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Hotels`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `Hotels` (
  `HotelName` varchar(45) NOT NULL,
  `HotelID` int(11) NOT NULL,
  `SingleRoomNum` int(5) NOT NULL,
  `DoubleRoomNum` int(5) NOT NULL,
  `QuadRoomNum` int(5) NOT NULL,
  `Note` varchar(100) NOT NULL,
  PRIMARY KEY (`HotelID`),
  UNIQUE KEY `HotelID_UNIQUE` (`HotelID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Rooms`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `Rooms` (
  `RoomID` int(11) NOT NULL,
  `HotelID` int(11) NOT NULL,
  `RoomType` varchar(45) NOT NULL,
  `Note` varchar(100) NOT NULL,
  PRIMARY KEY (`RoomID`),
  UNIQUE KEY `RoomID_UNIQUE` (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;