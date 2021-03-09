package assignment2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q4_GoogleSearch {
  WebDriver driver;
  @Test
  public void T4() throws Exception {
	 driver.get("https://google.com");
	 driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Automation");
	 Thread.sleep(1000);
	 List<WebElement> list=driver.findElements(By.className("sbct"));
	 int n=list.size();
	 driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[2]/div[2]/ul/li[1]")).click();
	 Thread.sleep(1000);
	 System.out.println("Number of suggestions "+n);
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
