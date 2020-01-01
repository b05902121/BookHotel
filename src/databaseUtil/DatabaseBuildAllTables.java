package databaseUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import databaseUtil.Item.HotelForJson;
import databaseUtil.Item.RoomForJson;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseBuildAllTables extends DatabaseConnect{
    private StringBuilder stringBuilder = new StringBuilder();
    private PreparedStatement prstmtHotel = null;
    private PreparedStatement prstmtRoom = null;

    public DatabaseBuildAllTables(String configFile) {
        super(configFile);
    }

    public void start(Boolean forceDropTable){
        System.out.print("[dbUtil] DatabaseBuildAllTables start().\n");
        if (forceDropTable) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("config/buildAllTables.sql"));
                stringBuilder.setLength(0);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (!line.equals("")) {
                        stringBuilder.append(line);
                    }
                }
                reader.close();
                String[] commands = stringBuilder.toString().split(";");
                for (int i = 0; i < commands.length; i++) {
                    if (!commands[i].equals("")) {
                        stmt.executeUpdate(commands[i]);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertDefaultData(String defaultDataFilePath){
        System.out.print("[dbUtil] DatabaseUser insertDefaultData().\n");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(defaultDataFilePath));
            stringBuilder.setLength(0);
            String line = null;
            while ((line = reader.readLine()) != null){
                if(!line.equals("")){
                    stringBuilder.append(line);
                }
            }
            reader.close();
            String[] commands = stringBuilder.toString().split(";");
            for(int i = 0; i < commands.length; i++){
                if(!commands[i].equals("")){
                    stmt.executeUpdate(commands[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertJsonData(){
        System.out.print("[dbUtil] DatabaseHotel insertJsonData().\n");
        try{
            Gson gson = new GsonBuilder().create();
            Type REVIEW_TYPE = new TypeToken<ArrayList<HotelForJson>>(){}.getType();
            FileInputStream fis = new FileInputStream("config/HotelList.json" );
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "Big5"));
            JsonReader reader = new JsonReader(br);
            ArrayList<HotelForJson> hotelListFromJson = gson.fromJson(reader, REVIEW_TYPE);
            Integer roomIdStart = 0;
            prstmtHotel = conn.prepareStatement("INSERT INTO `Hotels`(`HotelID`,`HotelStar`,`Locality`,`Street-Address`,`SNum`,`DNum`,`QNum`,`SPrice`,`DPrice`,`QPrice`) VALUES (?,?,?,?,?,?,?,?,?,?);");
            prstmtRoom = conn.prepareStatement("INSERT INTO `Rooms`(`RoomID`,`HotelID`,`RoomType`,`RoomPrice`,`DateIsAvailable`) VALUES (?,?,?,?,?);");
            conn.setAutoCommit(false);
            for(HotelForJson hotel:hotelListFromJson){
                System.out.print("[dbUtil] insertJsonData " + hotel.getHotelId() + "/1500 \n");
                roomIdStart = insertOneJsonData(hotel, roomIdStart);
//                break;
            }
            int[] countHotel = prstmtHotel.executeBatch();
            int[] countRoom = prstmtRoom.executeBatch();
            conn.commit();
        } catch (FileNotFoundException | UnsupportedEncodingException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Integer insertOneJsonData(HotelForJson hotel, Integer roomIdStart) {
        Integer roomIdIndex = roomIdStart;
        RoomForJson[] rooms = hotel.getRooms();
        byte dateIsAvailableBytes[] = new byte[365];
        Arrays.fill(dateIsAvailableBytes,(byte)1);
//        System.out.print("[dbUtil] insertOneJsonData dateIsAvailableBytes " + new String(dateIsAvailableBytes, Charset.forName("UTF-8")) + "\n");
        try {
            prstmtHotel.setInt(1, hotel.getHotelId());
            prstmtHotel.setInt(2, hotel.getHotelStar());
            prstmtHotel.setString(3, hotel.getLocality());
            prstmtHotel.setString(4,hotel.getAddress());
            prstmtHotel.setInt(5, rooms[0].getNumber());
            prstmtHotel.setInt(6, rooms[1].getNumber());
            prstmtHotel.setInt(7, rooms[2].getNumber());
            prstmtHotel.setInt(8, rooms[0].getRoomPrice());
            prstmtHotel.setInt(9, rooms[1].getRoomPrice());
            prstmtHotel.setInt(10, rooms[2].getRoomPrice());
            prstmtHotel.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int roomTypeIdx = 0; roomTypeIdx < 3; roomTypeIdx++) {
            stringBuilder.setLength(0);
            RoomForJson room = rooms[roomTypeIdx];
            for (int i = 0; i < room.getNumber(); i++) {
                try {
                    prstmtRoom.setInt(1, roomIdIndex);
                    prstmtRoom.setInt(2, hotel.getHotelId());
                    prstmtRoom.setString(3, room.getRoomType());
                    prstmtRoom.setInt(4, room.getRoomPrice());
                    prstmtRoom.setBytes(5, dateIsAvailableBytes);
                    prstmtRoom.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                roomIdIndex++;
            }
        }
        return roomIdIndex;
    }
}
