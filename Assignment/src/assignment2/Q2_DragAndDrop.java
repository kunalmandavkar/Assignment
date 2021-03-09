package assignment2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q2_DragAndDrop {
  WebDriver driver;
  @Test
  public void T2() throws Exception {
	 driver.get("https://jqueryui.com/droppable/");
	 WebElement f=driver.findElement(By.className("demo-frame"));
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", f);
	 driver.switchTo().frame(f);
	 WebElement src= driver.findElement(By.xpath("/html/body/div[1]"));
	 WebElement dest=driver.findElement(By.xpath("/html/body/div[2]"));
	 Actions action=new Actions(driver);
	 action.dragAndDrop(src, dest).build().perform();
	 Thread.sleep(1000);
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
