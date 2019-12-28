package test;

import java.sql.*;
import model.SignHandler;
import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseUser;

public class TestSignHandler {

    public TestSignHandler() throws SQLException {
        /*  Initialize databases and tables */
        DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("jdbc.properties");
        if(!databaseBuildAllTables.getConnection().isClosed()) {
            System.out.print("[LOG] databaseBuildAllTables start.\n");
        }
        databaseBuildAllTables.start();
        databaseBuildAllTables.closeConnection();

        /*  Set default user data to users table and select one data    */
        DatabaseUser databaseUser = new DatabaseUser("jdbc.properties");
        if(!databaseUser.getConnection().isClosed()) {
            System.out.print("[LOG] DatabaseUser start.\n");
        }
        databaseUser.insertDefaultData();

    }

    public static void main(String[] args) throws SQLException {
        SignHandler sh = new SignHandler();

        Boolean ret = sh.signUp("aaaa", "123123");
        if (ret) {System.out.println("Sign up successfully.");}
        else {System.out.println("User already exists.");}

        Boolean ret2 = sh.signUp("aaaa", "123123");
        if (ret2) {System.out.println("Sign up successfully.");}
        else {System.out.println("User already exists.");}

        Boolean ret3 = sh.signIn("aaaa", "123123");
        if (ret3) {System.out.println("Sign in successfully.");}
        else {System.out.println("username or password incorrect");}
    }

}
