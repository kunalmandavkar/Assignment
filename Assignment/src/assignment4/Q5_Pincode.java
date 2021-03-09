package assignment4;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Q5_Pincode {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement table=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
	  List<WebElement> Rows=table.findElements(By.tagName("tr"));
	  int n=Rows.size();
	  System.out.println(n);
	  int f=1;
	  for(int i=3;i<n-5;i++) {
		  List<WebElement> Cols = Rows.get(i).findElements(By.tagName("td"));
		  System.out.println(Cols.get(2).getText());
		  for(int j=i+1;j<n-5;j++) {	  
			  List<WebElement> Cols2 = Rows.get(j).findElements(By.tagName("td"));	  
			  if(Cols.get(2).getText().equals(Cols2.get(2).getText())){
				  System.out.println("Pincode mathched "+ Cols.get(2).getText() +" At Number "+Cols2.get(0).getText());
				  f=0;
			  }
		  }
	  }
	  if(f==1) {
		  System.out.println("No matched pincode");
	  }  
  }
  @BeforeClass
  public void beforeClass() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\Documents\\Seleniun Java Jars\\chromedriver.exe");
  	driver=new ChromeDriver();
  	driver.manage().window().maximize();
  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	driver.get("https://chennaiiq.com/chennai/pincode-by-name.php");
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
