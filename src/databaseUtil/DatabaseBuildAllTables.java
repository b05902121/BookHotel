package databaseUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseBuildAllTables extends DatabaseConnect{
    private StringBuilder stringBuilder = new StringBuilder();

    public DatabaseBuildAllTables(String configFile) {
        super(configFile);
    }

    public void start(Boolean forceDropTable){
        System.out.print("[dbUtil] DatabaseBuildAllTables start().\n");
        if (forceDropTable) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("config/buildAllTables.sql"));
                stringBuilder.setLength(0);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (!line.equals("")) {
                        stringBuilder.append(line);
                    }
                }
                reader.close();
                String[] commands = stringBuilder.toString().split(";");
                for (int i = 0; i < commands.length; i++) {
                    if (!commands[i].equals("")) {
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

    public void insertDefaultData(String defaultDataFilePath){
        System.out.print("[dbUtil] DatabaseUser insertDefaultData().\n");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(defaultDataFilePath));
            stringBuilder.setLength(0);
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
