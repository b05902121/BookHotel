package databaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUser extends DatabaseConnect {
    public DatabaseUser(String configFile) {
        super(configFile);
    }

    public void InsertUser(String Id, String password){
        System.out.print("[dbUtil] DatabaseUser InsertUser().\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `Users`(`UID`,`password`) VALUES ( '");
        stringBuilder.append(Id);
        stringBuilder.append("' , '");
        stringBuilder.append(password);
        stringBuilder.append("' );");
        System.out.print("[dbUtil] " + stringBuilder.toString() + "\n");
        try {
            stmt.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUserById(String Id){
        System.out.print("[LOG] DatabaseUser getUserById().\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM `Users` WHERE  `UID` = '");
        stringBuilder.append(Id);
        stringBuilder.append("' ;");
        System.out.print("[dbUtil] " + stringBuilder.toString() + "\n");
        try {
            return stmt.executeQuery(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
