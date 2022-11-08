package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // 1- create the object of Properties class
    // we need Properties class to use methods coming from class like load(), getProperty(key)
    private static Properties properties = new Properties();
    // we made it "static" because we're using it in the static method in line 28
    // we made it "private" as I don't want any other classes to use it outside this class


    // to get rid of the error, this try/catch should be inside something else, it can be method or any block {}, but we will use static block to run it ONLY First and Once before reading
    static {
        try {
            // 2- Create the object of FileInputStream
            // we need this object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("config.properties");

            // 3- Load the properties object using FileInputStream object
            // load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);

            // close the file after loading to avoid memory usage in your computer
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is a purpose of creating this class, a bridge between classes
     * this method allows us to read file from the configuration.properties file
     *
     * @param keyword --> key name in configuration.properties file
     * @return --> value of the key and null if it's not found
     * driver.get(ConfigurationReader.getProperty("env"))
     */

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
