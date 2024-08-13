package DataProvider;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getProperty(String propertyName){
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(new File("ConfigFiles/config.properties") ));
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value =properties.getProperty(propertyName);
        return value;
    }
    public static String getProperty(String propertyFileName,String propertyName){
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(new File("ConfigFiles/"+propertyFileName+".properties") ));
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value =properties.getProperty(propertyName);
        return value;
    }
}
