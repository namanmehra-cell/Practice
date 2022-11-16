package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignIn {
@Test(dataProvider = "cr")
public void login(String username,String password) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://mobileworld.banyanpro.com/");
	driver.manage().window().maximize();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("button.btn-warning")).click();
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.cssSelector("label.custom-control-label")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("a.btn-block")).click();
	driver.quit();

}
@DataProvider(name="cr")
public Object[][] dp1(){
	Object[][] data = new Object[][] {
		{"An","ABCabc123@"},
		{"NamunaTim","ABCabc123@21"},
		{"Na","A2"},
		{"Nam","A1"},
		{"namuna12@12outlook.com","a1"},
		{"namuna12@outlook.com","a1"},
		{"namuna12@outlook.com","a1b2c3d4"},
		{"namuna12@12outlook.com","a1b"},
		{" "," "},
		{"!@#$","special12"}
	};
	return data;
}
}
