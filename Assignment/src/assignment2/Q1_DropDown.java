package assignment2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q1_DropDown {
  WebDriver driver;
  @Test(dataProvider = "dp")
  public void T4(String n,String day) throws Exception {
	 driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
	 WebElement dropD=driver.findElement(By.id("select-demo"));
	 Thread.sleep(1000);
	 Select select=new Select(dropD);
	 select.selectByValue(day);
	 Thread.sleep(2000);
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "1", "Sunday" },
      new Object[] { "2", "Monday" },
      new Object[] { "3", "Tuesday" },
      new Object[] { "4", "Wednesday" },
      new Object[] { "5", "Thursday" },
      new Object[] { "6", "Friday" },
      new Object[] { "7", "Saturday" },
    };
  }
  @BeforeClass
  public void beforeClass() throws Exception {  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\Documents\\Seleniun Java Jars\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }
  
  @AfterClass
  public void afterClass() throws Exception { 
	  Thread.sleep(2000);
	  driver.quit();
  }
  @BeforeMethod
 public void beforeMethod() {  }

 @AfterMethod
 public void afterMethod() {  }
 
  
  @BeforeTest
  public void beforeTest() {  }
  
  @AfterTest
  public void afterTest() {  }
  
  @BeforeSuite
  public void beforeSuite() {  }
  
  @AfterSuite
  public void afterSuite() {  }
}
