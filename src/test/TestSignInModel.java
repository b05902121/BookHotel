package test;

import java.sql.*;
import model.SignUpModel;
import model.SignInModel;
import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseUser;

public class TestSignInModel {

    public TestSignInModel() throws SQLException {
        /*  Initialize databases and tables */
        DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
        if(!databaseBuildAllTables.getConnection().isClosed()) {
            System.out.print("[LOG] databaseBuildAllTables start.\n");
        }
        databaseBuildAllTables.start();
        databaseBuildAllTables.closeConnection();

        /*  Set default user data to users table and select one data    */
        DatabaseUser databaseUser = new DatabaseUser("config/jdbc.properties");
        if(!databaseUser.getConnection().isClosed()) {
            System.out.print("[LOG] DatabaseUser start.\n");
        }
    }

    public static void main(String[] args) throws SQLException {
        SignUpModel signUpModel = new SignUpModel();
        SignInModel signInModel = new SignInModel();
        
        Boolean ret = signInModel.signIn("uuuu", "123123");
        if (ret) {System.out.println("Sign in successfully.");}
        else {System.out.println("username or password incorrect");}
        
        Boolean ret2 = signUpModel.signUp("uuuu", "123123");
        if (ret2) {System.out.println("Sign up successfully.");}
        else {System.out.println("User already exists.");}
        
        Boolean ret3 = signInModel.signIn("uuuu", "123123");
        if (ret3) {System.out.println("Sign in successfully.");}
        else {System.out.println("username or password incorrect");}
        
        Boolean ret4 = signInModel.signIn("uuuu", "fkhglsrdl");
        if (ret4) {System.out.println("Sign in successfully.");}
        else {System.out.println("username or password incorrect");}

    }

}
