package databaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUser extends DatabaseConnect {
    public DatabaseUser(String configFile) {
        super(configFile);
        try {
            stmt.executeUpdate("USE `hotelList`;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDefaultData(){
        System.out.print("[LOG] DatabaseUser insertDefaultData.\n");
        try{
            stmt.executeUpdate("INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902002' , 'b05902002' );");
            stmt.executeUpdate("INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902059' , 'b05902059' );");
            stmt.executeUpdate("INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902109' , 'b05902109' );");
            stmt.executeUpdate("INSERT INTO `Users`(`UID`,`password`) VALUES ( 'b05902129' , 'b05902129' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertUser(String Id, String password){
        System.out.print("[LOG] DatabaseUser InsertUser.\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `Users`(`UID`,`password`) VALUES ( '");
        stringBuilder.append(Id);
        stringBuilder.append("' , '");
        stringBuilder.append(password);
        stringBuilder.append("' );");
        System.out.print(stringBuilder.toString() + "\n");
        try {
            stmt.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUserById(String Id){
        System.out.print("[LOG] DatabaseUser getUserById.\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM `Users` WHERE  `UID` = '");
        stringBuilder.append(Id);
        stringBuilder.append("' ;");
        System.out.print(stringBuilder.toString() + "\n");
        try {
            return stmt.executeQuery(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
