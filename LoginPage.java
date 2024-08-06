import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;   
import java.util.concurrent.TimeUnit;

public class LoginPage {
	public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	System.out.println("*****Test Case 1*****");
	System.out.println("Verify Test Case Number 2 with valid UserName and Password");
	System.out.println("Enter an valid email and password");

		driver.get("https://demo.haroldwaste.com/");
		driver.manage().window().maximize();
		
		//Test Case 1 : Verify with valid username and password
		driver.findElement(By.name("email"))
        .sendKeys("qa@julesai.com");
		 driver.findElement(By.name("password"))
         .sendKeys("QaJULES2023!");

     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button/span[1]/span"))
         .click();
     Thread.sleep(6000);
     
     String actualURL = "https://demo.haroldwaste.com/purchases";
     String expectedURL = driver.getCurrentUrl();
     if(actualURL.equalsIgnoreCase(expectedURL)) 
     { System.out.println("Test Case 1 passed : Login Page is displayed Successfully") ;
     } 
     else { System.out.println("Test Case 1 failed");
     }
    driver.quit();
    
    
     //Test Case 2 : Verify with Invalid username 
     WebDriver driver1 = new ChromeDriver();
 	driver1.get("https://demo.haroldwaste.com/");
	driver1.manage().window().maximize();
	System.out.println("*****Test Case 2*****");
	System.out.println("Verify Test Case Number 2 with Invalid UserName and Check Email not valid is displayed or not");
	System.out.println("Enter an Invalid email: hwiom ");
	driver1.findElement(By.name("email"))
    .sendKeys("hwiom");
    driver1.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	WebElement getStarted=driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div/div/div[1]/div[3]"));
	 boolean flag=getStarted.isDisplayed();
	 
	 if(flag) {
	 
	System.out.println(" Test Case 2 Passed : Email not Valid is displayed when enter invalid email id");
	}
	 else {
		 System.out.println(" Test Case 2 Failed ");}
	 driver1.quit();
	 
	 //Test Case 3 : Verify Invalid Password to verify 'Your email and/or password are incorrects'
     WebDriver driver2 = new ChromeDriver();
 	driver2.get("https://demo.haroldwaste.com/");
	driver2.manage().window().maximize();
	System.out.println("*****Test Case 3*****");
	
	System.out.println("Verify Test Case Number 3 with Invalid Password and Check PopUP is displayed or not");
	System.out.println("Enter an valid email ");
	driver2.findElement(By.name("email"))
    .sendKeys("qa@julesai.com");
	driver2.findElement(By.name("password"))
    .sendKeys("JULES2023!");
	driver2.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button/span[1]/span"))
    .click();
Thread.sleep(5000);
WebElement getStarted2 = driver2.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]"));
boolean flag1=getStarted2.isDisplayed();
System.out.println("Bug Identified : (Your email and/or password are incorrects)----> Statement Error");

	 driver2.quit();
}
	
}
