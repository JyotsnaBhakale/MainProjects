package com.mainprojects.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstagramLike {
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		// TODO Auto-generated method stub
		
		// To tell the browser that automation is going on
		ChromeOptions c = new ChromeOptions();
		c.addArguments("disable-blink-features=AutomationControlled");
		WebDriver driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		
		String url = "https://www.instagram.com/";
		driver.get(url);
		
		//Establishing the connection from property file to Java file
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\MainProjects\\src\\com\\so\\utilities\\InstagramLike.properties");
		
		// Creation of Properties object to load the data
		Properties p = new Properties();
		p.load(fis);
		
		// Fetching the data from a Property File
		String username_data = p.getProperty("username");
		String password_data = p.getProperty("password");
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// username
		WebElement email = driver.findElement(By.xpath("(//input[@class = \"_aa4b _add6 _ac4d _ap35\"])[1]"));
		email.sendKeys(username_data);
		
		// password
		WebElement pass = driver.findElement(By.xpath("//input[@aria-label=\"Password\"]"));
		pass.sendKeys(password_data);
		
		// login button
		WebElement login = driver.findElement(By.xpath("//div[text() = \"Log in\"]"));
		login.click();
	
		 //"Not now" for popups to save the credentials
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement l1 = driver.findElement(By.xpath("//div[text() = \"Not now\"]"));
		l1.click();
		
		// window asking for save the signin data
		
		WebElement l2 = driver.findElement(By.xpath("//button[text() = \"Not Now\"]"));
		l2.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Search
		WebElement search = driver.findElement(By.xpath("//span[text()='Search']"));
		search.click();
		
		// To take account name from user 
		System.out.println("Enter the account name:");
		Scanner sc = new Scanner(System.in);
		String account = sc.next();
		
		Thread.sleep(7000);
		
		// Search bar
		WebElement account_name = driver.findElement(By.xpath("//input[@aria-label=\"Search input\"]"));
		//String account_name = "ankit_sajwan";
		//driver.get(url+account_name);
		
		account_name.sendKeys(account);
		Thread.sleep(5000);

		// to click on suggested account (//div[@class='x1ey2m1c xds687c x17qophe xg01cxk x47corl x10l6tqk x13vifvy x1ebt8du x19991ni x1dhq9h x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m'])[1]
		WebElement exact_match = driver.findElement(By.xpath("(//a[@class='x1i10hfl x1qjc9v5 xjbqb8w xjqpnuy xa49m3k xqeqjp1 x2hbi6w x13fuv20 xu3j5b3 x1q0q8m5 x26u7qi x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x1ypdohk xdl72j9 x2lah0s xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x2lwn1j xeuugli xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 x16tdsg8 x1hl2dhg xggy1nq x1ja2u2z x1t137rt x1q0g3np x87ps6o x1lku1pv x1a2a7pz x1dm5mii x16mil14 xiojian x1yutycm x1lliihq x193iq5w xh8yej3'])[1]"));
		exact_match.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// 1st post 
		WebElement post1 = driver.findElement(By.xpath("(//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s x1q0g3np xqjyukv x6s0dn4 x1oa3qoh x1nhvcw1'])[2]/../../../div[3]/div[1]/div[1]/div[1]"));
		post1.click();
		
		// like button	
		WebElement like = driver.findElement(By.xpath("//span[@class=\"x1rg5ohu xp7jhwk\"]"));
		// Mouse click
		Actions a = new Actions(driver);
		a.moveToElement(like).click().build().perform();
		
		// click on next button
		WebElement next_button = driver.findElement(By.xpath("(//button[@class='_abl-'])[1]"));		
		next_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//span[@class=\"x1rg5ohu xp7jhwk\"]")).click();
		
		// next button of post 2 as the xpath is same now keep them in a loop for liking all the posts
		for(int i = 2; i <50; i++)
		{
			WebElement next_button1 = driver.findElement(By.xpath("(//button[@class=\"_abl-\"])[2]"));		
			next_button1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			WebElement like1 = driver.findElement(By.xpath("//span[@class=\"x1rg5ohu xp7jhwk\"]"));		
			Actions a1 = new Actions(driver);
			a.moveToElement(like1).click().build().perform();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}
	
		// click on cancel button
		WebElement cancel = driver.findElement(By.xpath("//div[@class='x160vmok x10l6tqk x1eu8d0j x1vjfegm']"));
		a.moveToElement(cancel).click().build().perform();

		// click on more or three lines to logout
		WebElement l3 = driver.findElement(By.xpath("(//div[@class = \"x1n2onr6\"])[13]"));
		l3.click();
		
		// explicitwait signout button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = \"Log out\"]")));
		logout.click();
		
		// to logout
		WebElement l4 = driver.findElement(By.xpath("//span[text() = \"Log out\"]"));
		l4.click();
	
	}

}
