package com.tests.allrpg.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class SiteConnection {
    private static Logger logger = LoggerFactory.getLogger(SiteConnection.class);

    private String url;
    private String user;
    private String password;
    private String master;

    private static Properties loadProperties() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("conf/" + System.getProperty("conf", "dev") + ".properties"));
        } catch(Exception e){
            logger.error(e.toString());
        }
        return p;
    }

    public static SiteConnection load() {
        Properties props = loadProperties();
        SiteConnection conn = new SiteConnection();

        conn.url = props.getProperty("url");
        conn.user = props.getProperty("user");
        conn.master = props.getProperty("master");
        conn.password = props.getProperty("password");

        return conn;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getMaster() {
        return master;
    }

}