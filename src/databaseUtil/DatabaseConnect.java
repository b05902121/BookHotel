package databaseUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnect{
    protected  Connection conn = null;
    protected  String url = null;
    protected  String user = null;
    protected  String password = null;
    protected  String classPath = null;
    protected  Statement stmt = null;

    public DatabaseConnect(String configFile){
        System.out.print("[dbUtil] Build DatabaseConnect connection.\n");
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(configFile));

            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            classPath = props.getProperty("driver");

            Class.forName(classPath);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate("USE `hotelList`;");
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException{
        System.out.print("[dbUtil] Mysql connection close.\n");
        conn.close();
    }

    public Connection getConnection() throws SQLException{
        return conn;
    }
}