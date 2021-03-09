package assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Q1_GoogleLogin {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	 driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
	 driver.findElement(By.id("firstName")).sendKeys("don");
	 Thread.sleep(1000);
	 driver.findElement(By.id("lastName")).sendKeys("here");
	 Thread.sleep(1000);
	 driver.findElement(By.id("username")).sendKeys("donhere72");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]"
	+ "/div/div[1]/div/form/span/section/div/div/div[3]/div[1]/div/div/div[1]/div/div[1]/div/div[1]/input")).sendKeys("don@1234");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]"
	+ "/div/div[1]/div/form/span/section/div/div/div[3]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys("don@1234");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]"
	+ "/div/div[1]/div/form/span/section/div/div/div[3]/div[3]/div/div[1]/div/div/div[1]/div/input")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]"
	 		+ "/div/div[2]/div/div[1]/div/div/button/div[2]")).click();
	 Thread.sleep(10000);	
  }
  @BeforeClass
  public void beforeClass() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\Documents\\Seleniun Java Jars\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Thread.sleep(2000);
  }

  @AfterClass
  public void afterClass() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
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
