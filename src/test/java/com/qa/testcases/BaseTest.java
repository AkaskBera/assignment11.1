package com.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.utilities.ReadConfig;

public class BaseTest {
	static ReadConfig readconfig = new ReadConfig();
	public static String baseURL = readconfig.getApplicationURL();
	public String email = readconfig.getEmail();
	public String password = readconfig.getPassword();
	public String excelPath = readconfig.getExcelPath();
	public String sheetName = readconfig.getSheetName();
	
	public static WebDriver driver;
	public static Logger logger;

	public static void initialization() {
		String br = readconfig.getBrowser();
		logger = Logger.getLogger("insuranceBrokerGuru99");
		PropertyConfigurator.configure("log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getGeckoPath());
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String name=tname+timeStamp;
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
