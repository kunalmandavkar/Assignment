package assignment2;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q3_Popup {
  WebDriver driver;
  @Test
  public void T4() throws Exception {
	 driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/button")).click();
	 System.out.println(driver.switchTo().alert().getText());
	 Thread.sleep(2000);
	 driver.switchTo().alert().dismiss();
	 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/button")).click();
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept(); 
	 Thread.sleep(2000);
	 driver.get("https://webdriveruniversity.com/index.html");
	 Thread.sleep(2000);
	 driver.findElement(By.id("contact-us")).click();
     // To handle all new opened window.
	 String P=driver.getWindowHandle();
	 Thread.sleep(2000);
     Set<String> s1=driver.getWindowHandles();		
     Iterator<String> i1=s1.iterator();		
     while(i1.hasNext())			
     {		
    	 String ChildWindow=i1.next();			
    	 if(!P.equalsIgnoreCase(ChildWindow))			
    	 {    		 
             // Switching to Child window
             driver.switchTo().window(ChildWindow);	
             Thread.sleep(1000);
             driver.close();	
    	 }
     }	
     driver.switchTo().window(P);
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
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
