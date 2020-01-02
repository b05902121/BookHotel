package test;

import java.sql.*;

import controller.RoutingController;
import model.SignUpModel;
import model.SignInModel;
import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseUser;

public class TestSignInModel {

    public TestSignInModel() throws SQLException {
        DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
        Boolean forceDropTable = true;
        databaseBuildAllTables.start(forceDropTable);
        databaseBuildAllTables.insertDefaultData("config/InsertDefaultData.sql");
        try {
            databaseBuildAllTables.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            RoutingController router = new RoutingController();
            router.start();
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
