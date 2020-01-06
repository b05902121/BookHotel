package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigPropertyValues {
    Boolean forceDropTable_bool;
    InputStream inputStream;
    
    public Boolean getPropValues() throws IOException {
 
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
 
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            // get the property value and print it out
            String forceDropTable = prop.getProperty("forceDropTable");
            System.out.println("Drop table: " + forceDropTable);
            
            forceDropTable_bool = Boolean.parseBoolean(forceDropTable);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return forceDropTable_bool;
    }
    
    public void updateConfigProperties(String bool) {
        FileOutputStream out = null;
        Properties prop = new Properties();
        try {
            out = new FileOutputStream("resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop.setProperty("forceDropTable", bool);
        try {
            prop.store(out, null);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*public void updateConfigProperties2(String bool) {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration("resources/config.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }*/
    
}
