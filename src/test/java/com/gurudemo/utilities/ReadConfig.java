package com.gurudemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fs = new FileInputStream(src);
			prop = new Properties();
			prop.load(fs);
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getchromepath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxpath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getiepath() {
		String iepath = prop.getProperty("iepath");
		return iepath;
	}

}
