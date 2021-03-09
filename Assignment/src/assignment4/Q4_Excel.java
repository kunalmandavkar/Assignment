package assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Q4_Excel {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.get("https://accounts.lambdatest.com/register");
	  File file=new File("C:\\Users\\Kunal\\Documents\\Seleniun Java Jars\\Demo.xlsx");
	  FileInputStream fs=new FileInputStream(file);
	  XSSFWorkbook book=new XSSFWorkbook(fs);
	  XSSFSheet sheet=book.getSheet("Sheet1");
	  String user,email,pwd,num;
	  user=sheet.getRow(1).getCell(0).getStringCellValue();
	  email=sheet.getRow(1).getCell(1).getStringCellValue();
	  pwd=sheet.getRow(1).getCell(2).getStringCellValue();
	  num=sheet.getRow(1).getCell(3).getRawValue()+"";
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div[1]/input")).sendKeys(user);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div[2]/input")).sendKeys(email);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div[3]/div/input")).sendKeys(pwd);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div[4]/input")).sendKeys(num);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div[5]/label/samp")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/form/div[6]/button")).click();
	  book.close();
	  fs.close();  
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
  public void beforeTest()  {
	  
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
