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
		{"An","ABCabc123@"},//invalid username(less than 3 characters) and valid password(10 characters)
		{"NamunaTim","ABCabc123@21"},////Valid username(between 3 and 20 characters ) and valid password(between 3 and 10 characters)
		{"Na","A2"},//invalid username(less than 3 characters) and invalid password(less than 3 characters).
		{"Nam","A1"},//valid username(3 characters) and invalid password(Less than 3 characters)
		{"namuna12@12outlook.com","a1"},//invalid email id and invalid password(less than 3 characters)
		{"namuna12@outlook.com","a1"},// valid email id and invalid password(less than 3 characters)
		{"namuna12@outlook.com","a1b2c3d4"},// valid email id and valid password(between 3 and 10 characters)
		{"namuna12@12outlook.com","a1b"},// invalid email id and valid password(3 characters password)
		{" "," "},//empty fields
		{"!@#$","special12"} // special characters in username/id and valid password
	};
	return data;
}
}
