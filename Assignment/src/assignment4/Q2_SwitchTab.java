package assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Q2_SwitchTab {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/h2[1]/a")).sendKeys(selectLinkOpeninNewTab);
	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/h2[1]/a")).click();
	  WebElement name=driver.findElement(By.id("search_type"));
	  Select select=new Select(name);
	  select.selectByVisibleText("First Name");
	  Thread.sleep(1000);
	  driver.findElement(By.id("search_patient")).click();
	  Thread.sleep(2000);
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
