package model;

/**
 * @author gerber
 * This class implements the interface ServiceModel.
 * This class has two class methods, signIn() and signUp().
 * The class SignController should hold a reference of this class.
 */

import java.sql.*;
import databaseUtil.DatabaseUser;

public class SignHandler implements ServiceModel {

    private DatabaseUser dbUser = null;

    public SignHandler() {
        // TODO Auto-generated constructor stub
        this.dbUser = new DatabaseUser("jdbc.properties");
    }

    /*@Override
	public void notifyView() {
		// TODO Auto-generated method stub

	}*/

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
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
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
