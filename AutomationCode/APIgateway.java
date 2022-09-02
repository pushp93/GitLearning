import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APILogin {
 WebDriver driver;

@BeforeTest
public void LaunchAPIPortal()
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\IT Division\\Downloads\\chromedriver_win32\\chromedriver.exe");
this.driver = new ChromeDriver();

driver.manage().window().maximize();
driver.get("http://test-apig.inroad.in/#/auth/login");
}




@Test(priority = 3 , description = "Test the URL")
public void currentUrlTest()
{
String actualURL = driver.getCurrentUrl();
String expectedURL = "http://test-apig.inroad.in/#/dashboard";
Assert.assertEquals(actualURL, expectedURL);
}





@Test(priority = 1 , description = "Test the Title")
public void titleTest()
{
String actualTitle = driver.getTitle();
String expectedTitle = "ShikshAPI";
Assert.assertEquals(actualTitle, expectedTitle);
}




@Test(priority = 2 , description = "User Login with valid credentials")
public void LoginUser1() throws InterruptedException
{

driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("7985030169");
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test@123");
          driver.findElement(By.cssSelector("button[type='submit']")).click();
          Thread.sleep(3000);
}


@Test(priority = 6 , description = "User Login with invalid credentials")
public void LoginUser2() throws InterruptedException
{

driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("7985130169");
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test0@123");
          driver.findElement(By.cssSelector("button[type='submit']")).click();
          Thread.sleep(3000);
}




@Test(priority = 4 , description = "Add User")
public void AddUser() throws InterruptedException
{

driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-layout[1]/app-navigation[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]")).click();
Thread.sleep(2000);
driver.findElement(By.className("btn-primary")).click();
driver.findElement(By.id("name")).sendKeys("suraj kumar");
driver.findElement(By.id("email")).sendKeys("suraj1.kumar@yopmail.com");
driver.findElement(By.id("mobile")).sendKeys("8081001025");
driver.findElement(By.xpath("/html/body/app-root/app-layout/section/app-users/app-add-user/div/div[2]/form/div[2]/button[1]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div/div/button[2]")).click();


}



@Test(priority = 5 , description = "User Logout")
public void LogOutUser() throws InterruptedException
{

driver.findElement(By.xpath("//a[@role='button']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/app-root/app-layout/app-navigation/div/div/ul/li/ul/li[3]/a/span")).click();
}

@AfterTest
public void closeBrowser()
{
//driver.close();


}

}