package assignment2;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q8_BrokenLinks {
  WebDriver driver;
  @Test
  public void T8() {
	  String url;
	  int res=200;
	  String homePage = "https://www.zlti.com";
	  HttpsURLConnection h;
	  driver.get("https://www.zlti.com/");
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  Iterator<WebElement> i=links.iterator();
	  while(i.hasNext()) {
		  url=i.next().getAttribute("href");
          if(url == null || url.isEmpty()){
        	  System.out.println("URL is either not configured for anchor tag or it is empty");
              continue;
          }
          if(!url.startsWith(homePage)){
              System.out.println(url+" URL belongs to another domain, skipping it.");
              continue;
          }
		  try {
              h = (HttpsURLConnection) (new URL(url).openConnection());     
              h.setRequestMethod("HEAD");              
              h.connect();
              res = h.getResponseCode();             
              if(res>= 400){
                  System.out.println(url+" broken link");
              }
              else{
                  System.out.println(url+" working link");
              }
                  
          } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } 
	  }
	  
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
