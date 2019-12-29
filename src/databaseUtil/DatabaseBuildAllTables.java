package databaseUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuildAllTables extends DatabaseConnect{
    public DatabaseBuildAllTables(String configFile) {
        super(configFile);
    }

    public void start(){
        System.out.print("[LOG] DatabaseBuildAllTables start().\n");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config/buildAllTables.sql"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                if(!line.equals("")){
                    stringBuilder.append(line);
                }
            }
            reader.close();
            String[] commands = stringBuilder.toString().split(";");
            for(int i = 0; i < commands.length; i++){
                if(!commands[i].equals("")){
                    stmt.executeUpdate(commands[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDefaultData(){
        System.out.print("[LOG] DatabaseUser insertDefaultData().\n");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config/InsertDefaultData.sql"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                if(!line.equals("")){
                    stringBuilder.append(line);
                }
            }
            reader.close();
            String[] commands = stringBuilder.toString().split(";");
            for(int i = 0; i < commands.length; i++){
                if(!commands[i].equals("")){
                    stmt.executeUpdate(commands[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
