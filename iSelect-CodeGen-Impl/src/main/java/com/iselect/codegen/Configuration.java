/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Hiep
 */
public class Configuration {

    private String conf = "config.properties";
    Properties prop = new Properties();
    InputStream input = null;

    public Configuration() {
    }

    public Configuration(String config) {
        this.conf = config;
    }

    public void loadConfig() throws IOException {
        try {
            input = getClass().getClassLoader().getResourceAsStream(conf);
            prop.load(input);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw ioe;
        }
    }

    public void closeConfig() {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getProperty(String value){
        return prop.getProperty(value);
    }
}
