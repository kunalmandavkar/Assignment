package assignment2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;


//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q5_ScrollWebPage {
  WebDriver driver;
  @Test
  public void T5() throws Exception {
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  
	  // Scroll Down using JavascriptExecutor
	  //JavascriptExecutor js= (JavascriptExecutor) driver;
	  //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  
      // Scroll Down using Actions class
	  Actions actions = new Actions(driver);
      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
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
