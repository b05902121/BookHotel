package model;

import java.sql.*;
import databaseUtil.DatabaseUser;

public class SignUpModel {
    private DatabaseUser dbUser = null;

    public SignUpModel() {
        this.dbUser = new DatabaseUser("config/jdbc.properties");
    }
    
    public Boolean signUp(String username, String pwd) throws SQLException {
        /* 
         * First checks whether username exists in database.
         * If yes, return false.
         * If no, insert user and return true.
         */

        ResultSet resultSet = dbUser.getUserById(username);
        if(resultSet.next() == Boolean.TRUE) {
            // username exists
            return Boolean.FALSE;
        }
        dbUser.InsertUser(username, pwd);
        return Boolean.TRUE;
    }
}
