INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902002' , 'b05902002' );
INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902059' , 'b05902059' );
INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902109' , 'b05902109' );
INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902129' , 'b05902129' );

INSERT INTO `Hotels`(`HotelName`,`HotelID`,`SingleRoomNum`,`DoubleRoomNum`,`QuadRoomNum`,`Note`) VALUES ('Applee Hotel','0','1','1','1','An apple a day.');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('0','0','SingleRoom','A-1');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('1','0','DoubleRoom','A-2');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('2','0','QuadRoom','A-3');
INSERT INTO `Hotels`(`HotelName`,`HotelID`,`SingleRoomNum`,`DoubleRoomNum`,`QuadRoomNum`,`Note`) VALUES ('Banana Hotel','1','2','0','2','Two bananas 2 day.');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('3','1','SingleRoom','B-1');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('4','1','DoubleRoom','B-2');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('5','1','QuadRoom','B-3');
INSERT INTO `Hotels`(`HotelName`,`HotelID`,`SingleRoomNum`,`DoubleRoomNum`,`QuadRoomNum`,`Note`) VALUES ('Cookie Hotel','2','0','1','1','Three cookies and dead.');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('6','2','SingleRoom','C-1');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('7','2','DoubleRoom','C-2');
INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`Note`) VALUES ('8','2','QuadRoom','C-3');