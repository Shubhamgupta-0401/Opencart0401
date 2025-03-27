package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	 public static WebDriver driver;
	 public Logger logger;	//log4j2
	 public Properties p;
	 	 
		@BeforeClass(groups= {"Sanity","Regression","Master"})
		@Parameters({"os", "browser"})
		public void setup(String os, String br) throws IOException
		{    
			//loading config.properties file
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
						
			logger=LogManager.getLogger(this.getClass()); //Log4j2
			
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				if(os.equalsIgnoreCase("window"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
			
				
				
				//browser
				switch(br.toLowerCase())
				{
				case "chrome" : capabilities.setBrowserName("chrome");break;
				case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
				default: System.out.println("No Matching browser"); return;
				}
				
				driver=new RemoteWebDriver(new URL(" http://192.168.16.163:4444/wd/hub"),capabilities);
				
			}
				
				
				
				if(p.getProperty("execution_env").equalsIgnoreCase("local"))
				{
					switch(br.toLowerCase())
					{
					case "chrome" : driver=new ChromeDriver(); break;
					case "edge" : driver=new EdgeDriver(); break;
					case "firefox" : driver=new FirefoxDriver(); break;
					default : System.out.println("Invalid browser name.."); return;
					}			
			}	
			
			
			
			
			
			
			
			/*switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}*/
			
			
			
			//driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appUrl")); //reading url from properties file
			driver.manage().window().maximize();
		}
		
		@AfterClass(groups= {"Sanity","Regression","Master"})
		public void teardown()
		{
			driver.quit();
		}
	

	     public String randomeString()
		{
		String generatedstring=	RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		}
		
	     public String randomeNumber()
	 	{
	 	String generatednumber=	RandomStringUtils.randomNumeric(10);
	 	return generatednumber;
	 	}
		
	     public String randomeAlphaNumeric()
	  	{
	    String generatedstring=	RandomStringUtils.randomAlphabetic(3);	 
	  	String generatednumber=	RandomStringUtils.randomNumeric(10);
	  	return (generatedstring+generatednumber);	  	  	
	  	}
	    
	     public String captureScreen(String tname)
		    {
		    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());	
		    	
		    TakesScreenshot takeScreenshot = (TakesScreenshot)	driver;	    
		    File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		    
		    String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +"_" + timeStamp + ".png"; 
		    File targetFile=new File(targetFilePath);
		    
		    sourceFile.renameTo(targetFile);
		    
		    return targetFilePath;
		    }		
	     
	     
	     
	     
	     
	     
	     
	     
}
