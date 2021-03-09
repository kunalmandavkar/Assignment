package assignment3;

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

public class Q2_DataProvider {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String s) throws Exception {
	 WebElement dropD=driver.findElement(By.id("select-demo"));
	 Thread.sleep(1000);
	 Select select=new Select(dropD);
	 select.selectByValue(s);
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  @AfterMethod
  public void afterMethod() {
  }
  @DataProvider
  public Object[][] dp() {
	  return new Object[][]{{"Sunday"},{"Monday"},{"Tuesday"},{"Wednesday"},{"Thursday"},{"Friday"},{"Saturday"}};
  }
  @BeforeClass
  public void beforeClass() throws Exception {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\Documents\\Seleniun Java Jars\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 Thread.sleep(2000);
	 driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
  }

  @AfterClass
  public void afterClass() throws Exception {
	Thread.sleep(2000);
	driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
