package model;

import java.sql.*;
import databaseUtil.DatabaseUser;

public class SignUpModel extends SignModel{

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
