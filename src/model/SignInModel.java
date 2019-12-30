package model;

import java.sql.*;
import main.UserSession;
import databaseUtil.DatabaseUser;

public class SignInModel {
    
    private DatabaseUser dbUser = null;

    public SignInModel() {
        this.dbUser = new DatabaseUser("config/jdbc.properties");
    }

    public Boolean signIn(String username, String pwd) throws SQLException {
        /*
         * First gets user by username.
         * If username does not exist, return false.
         * If username exists, check whether password is correct.
         * If password is correct, return true. Else, return false.
         */

        ResultSet resultSet = dbUser.getUserById(username);

        if(resultSet.next() == Boolean.FALSE) {
            // username does not exists
            return Boolean.FALSE;
        }
        else if (resultSet.getString("password").compareTo(pwd) == 0) {
        	UserSession.getInstance(true).signIn(username, pwd);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
