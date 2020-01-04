package test;

import java.sql.*;

import controller.Router;
import model.SignUpModel;
import databaseUtil.DatabaseBuildAllTables;
import databaseUtil.DatabaseUser;

public class TestSignUpModel {

    public TestSignUpModel() throws SQLException {
        DatabaseBuildAllTables databaseBuildAllTables = new DatabaseBuildAllTables("config/jdbc.properties");
        Boolean forceDropTable = true;
        databaseBuildAllTables.start(forceDropTable);
        databaseBuildAllTables.insertDefaultData("config/InsertDefaultData.sql");
        try {
            databaseBuildAllTables.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Router.getInstance().start();
    }

    public static void main(String[] args) throws SQLException {
        SignUpModel signUpModel = new SignUpModel();

        Boolean ret = signUpModel.signUp("fdfa", "123123");
        if (ret) {System.out.println("Sign up successfully.");}
        else {System.out.println("User already exists.");}

        Boolean ret2 = signUpModel.signUp("gggg", "123123");
        if (ret2) {System.out.println("Sign up successfully.");}
        else {System.out.println("User already exists.");}

    }

}
