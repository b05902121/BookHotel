INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902002' , 'b05902002' );
INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902059' , 'b05902059' );
INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902109' , 'b05902109' );
INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902129' , 'b05902129' );

INSERT INTO `Hotels`(`HotelID`,`HotelStar`,`Locality`,`Street-Address`) VALUES ('0','1','Taipei','East');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('0','0','SingleRoom','1');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('1','0','DoubleRoom','2');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('2','0','QuadRoom','3');
INSERT INTO `Hotels`(`HotelID`,`HotelStar`,`Locality`,`Street-Address`) VALUES ('1','1','Taipei','South');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('3','1','SingleRoom','1');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('4','1','DoubleRoom','2');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('5','1','QuadRoom','3');
INSERT INTO `Hotels`(`HotelID`,`HotelStar`,`Locality`,`Street-Address`) VALUES ('2','1','Taipei','West');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('6','2','SingleRoom','1');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('7','2','DoubleRoom','2');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`) VALUES ('8','2','QuadRoom','3');