package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    private Properties properties;
    private final String file;

    public Property(String file){
        this.file = file;
        loadPropertyFile(file);
    }
    private void loadPropertyFile(String file) {
        properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/data/"+file+".properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getDataProperty(String key) {
        if (properties == null)
            loadPropertyFile(file);
        return properties.getProperty(key);
    }
}
