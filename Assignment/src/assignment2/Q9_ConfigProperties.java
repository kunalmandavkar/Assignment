package assignment2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q9_ConfigProperties {
  WebDriver driver;
  @Test
  public void T9() {
	  File file = new File("C:\\Users\\Kunal\\git\\Assignments\\Assignment\\configs\\config.properties");
	  FileInputStream fileInput = null;
	  try {
		  fileInput = new FileInputStream(file);
	  } 
	  catch (FileNotFoundException e) {
		  e.printStackTrace();
	  }
	  Properties prop = new Properties();
	  try {
		  prop.load(fileInput);
	  }
	  catch (IOException e) {
		  e.printStackTrace();
	  }	
	  System.out.println(prop.getProperty("url"));
	  driver.get(prop.getProperty("url")); 
	  driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(prop.getProperty("search"));
  }
  
  @BeforeMethod
  public void beforeMethod() {  }
 
  @AfterMethod
  public void afterMethod() {  }
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() throws Exception {  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\Documents\\Seleniun Java Jars\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }
  
  @AfterClass
  public void afterClass() throws Exception { 
	  Thread.sleep(2000);
	  driver.quit();
  }
  
  @BeforeTest
  public void beforeTest() {  }
  
  @AfterTest
  public void afterTest() {  }
  
  @BeforeSuite
  public void beforeSuite() {  }
  
  @AfterSuite
  public void afterSuite() {  }
}
