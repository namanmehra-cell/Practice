package test;
import java.time.Duration; //for put some delay in time
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;//to select elements from webpage
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUp {
	@Test(dataProvider="kick") //anotations for testng
	public void signUp(String fname,String lname,String mailId,String password,String date,String num,String message) throws InterruptedException 
	{
        System.setProperty("webdriver.chrome.driver", "C:\\\\Automation Softs\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//to put time delay in every activity
        driver.manage().window().maximize();//to maximize window
        driver.get("https://mobileworld.banyanpro.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.btn-warning")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sign up")).click();
        Thread.sleep(1000);
        WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        WebElement emailID  = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
        WebElement pass  = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement shortBio  =  driver.findElement(By.xpath("//textarea[@placeholder='Short Bio']"));
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fname);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lname);
        driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(mailId);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys(date);
        driver.findElement(By.xpath("//input[@type='radio']")).click();
        driver.findElement(By.xpath("//input[@placeholder='91XXXXXXXXXX']")).sendKeys(num);
        driver.findElement(By.xpath("//textarea[@placeholder='Short Bio']")).sendKeys(message);
        driver.findElement(By.xpath("//button[.='Register']")).click();
        if(fname.equals("")) {
        	String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", firstname);
        	Assert.assertEquals("Please fill out this field.",validationMessage);
        	driver.quit();
        	
        }else if(lname.equals("")) {
        	String message2 = (String)js.executeScript("return arguments[0].validationMessage;",lastname);
        	Assert.assertEquals("Please fill out this field.",message2);
        	System.out.println(message2);
        	driver.quit();
        }
        else if(mailId.equals("")) {
        	String message3 = (String)js.executeScript("return arguments[0].validationMessage;",emailID);
        	//Assert.assertEquals("Please fill out this field.",message3);
        	System.out.println(message3);
        	driver.quit();
        }
        else if(password.equals("")) {
        	String message4 = (String)js.executeScript("return arguments[0].validationMessage;",pass);
        	Assert.assertEquals("Please fill out this field.",message4);
        	System.out.println(message4);
        	driver.quit();
        }
        else if(message.equals("")) {
        	String message5 = (String)js.executeScript("return arguments[0].validationMessage;",shortBio);
        	Assert.assertEquals("Please fill out this field.",message5);
        	System.out.println(message5);
        	driver.quit();
        }
        else{
            driver.switchTo().alert().accept();
            Thread.sleep(1000);
            driver.quit();
           
        }
		
		
		
	}
	
	@DataProvider(name="kick")
	public Object[][] dataInput(){
		Object[][] data = new Object[][] {
			{"pakkalocaltotalshaka","Cliche","namuna@outlook.com","Yas1234","12/02/1998","9909099012","I am tony stark"},
	         {"pakkalocaltotalshakalol","Cliche","namuna@outlook.com","Yas1234","12/02/1998","9909099012","I am tony stark"},
	         {"","Cliche","namuna@outlook.com","Yas1234","12/02/1998","9909099012","I am tony stark"},
	         {"pakkalocaltotal","Cli","namuna@outlook.com","Yas1234","12/02/1998","9909099012","I am tony stark"},
	         {"pakkalocaltotalshak","Cl","namuna@outlook.com","Yas1234","12/02/1998","9909099012","I am tony stark"},
	         {"pakkalocaltotalsa","ClicheToral","namuna@outlook.com","Yas1234","12/02/1998","9909099012","I am tony stark"}
	        
	};
		return data;
	}
	
}
