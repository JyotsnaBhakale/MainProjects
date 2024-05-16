package com.mainprojects.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Gmail {
	public static void main(String[] args) throws InterruptedException, IOException  {
	
		ChromeOptions c = new ChromeOptions();
		c.addArguments("disable-blink-features=AutomationControlled");
		WebDriver driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=AaSxoQzKz--gmXChW0h-PFuUMiGTStmoP7RTkLWaHlYNj4uclquBMWaz8oMdZosVJJtzvqdbTDyxlg&ddm=0&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		//Establishing the connection from property file to Java file
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\MainProjects\\src\\com\\so\\utilities\\gmail.properties");
		
		// 	// Creation of Properties object to load the data
		Properties p = new Properties();
		p.load(fis);
		
		// Fetching the data from a Property File
		String username_data = p.getProperty("username");
		String password_data = p.getProperty("password");
		String to_address_data = p.getProperty("to_address");		
				
				// email --- //input[@name='identifier']
		WebElement email = driver.findElement(By.xpath("//input[@name='identifier']"));
		email.sendKeys(username_data);
		// next button	(//div[@class='VfPpkd-RLmnJb'])[2]
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Password //input[@name='Passwd']
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(password_data);
		
		try {
		// next button //span[text()='Next']
		 WebElement next = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		 next.click();
		}
		catch(Exception e)
		{
			
		}
		 WebElement next1 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		 next1.click();
		// to process 2 step verification
		Thread.sleep(20000);
		// Refreshing the web page to load all the web elements
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		// compose button	//div[@class='T-I T-I-KE L3'] //div[@class='z0']
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	
		// to maximize the compose window //img[@id=":mo"]
		driver.findElement(By.xpath("//img[@id=\":mo\"]")).click();
		
		// To address	//input[@id=":ta"]
		driver.findElement(By.xpath("//input[@id=\":ta\"]")).sendKeys(to_address_data);
		
		// Subject	//input[@name='subjectbox']
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Automation test");
		
		// Body to write	//div[@id=':qy']
		driver.findElement(By.xpath("//div[@id=':qy']")).sendKeys("Hi, This is an Automated Script.. Thank you");

		// send button	//div[@id=":pe"]
		driver.findElement(By.xpath("//div[@id=\":pe\"]")).click();
	}
}
