package com.qa.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		try {
			FileInputStream src = new FileInputStream("./Configuration/config.properties");
			pro = new Properties();
			pro.load(src);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}

	public String getEmail() {
		String username = pro.getProperty("email");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

	public String getGeckoPath() {
		String geckopath = pro.getProperty("geckopath");
		return geckopath;
	}
	
	public String getExcelPath() {
		String geckopath = pro.getProperty("excelpath");
		return geckopath;
	}
	
	public String getSheetName() {
		String geckopath = pro.getProperty("sheetname");
		return geckopath;
	}
}
