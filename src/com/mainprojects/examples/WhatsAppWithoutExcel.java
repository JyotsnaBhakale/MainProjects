package com.mainprojects.examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsAppWithoutExcel {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://web.whatsapp.com/");
		
		// Scan the QR code within 15 seconds
		Thread.sleep(30000);
		
		// Refreshing the web page to load all the web elements
		driver.navigate().refresh();
		Thread.sleep(20000);
		
		// To identify the search bar webelement
		WebElement search_bar = driver.findElement(By.xpath("//div[@class='x1hx0egp x6ikm8r x1odjw0f x6prxxf x1k6rcq7 x1whj5v']"));
		search_bar.sendKeys("8050806737");
		search_bar.sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement message_bar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='selectable-text copyable-text x15bjb6t x1n2onr6'])[2]")));
		message_bar.sendKeys("Selenium Logo");
		message_bar.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// + icon	//div[@class='x11xpdln x1d8287x x1h4ghdb']
		WebElement plus_icon = driver.findElement(By.xpath("//div[@class='x11xpdln x1d8287x x1h4ghdb']"));
		plus_icon.click();
		Thread.sleep(4000);
		
		try {
				WebElement photo = driver.findElement(By.xpath("//input[@accept='image/*,video/mp4,video/3gpp,video/quicktime']"));
				photo.sendKeys("D:\\Selenium\\SeleniumLogo.png");
				photo.click(); 
		}
		catch(Exception e)
		{
			
		}
		
		
		WebElement text = driver.findElement(By.xpath("(//p[@class='selectable-text copyable-text x15bjb6t x1n2onr6'])[1]"));
		text.sendKeys("Selenium Logo");
		
		// click on send button - //div[@aria-label="Send"] 
		
		
		WebElement send_button = driver.findElement(By.xpath("//div[@class='x78zum5 x6s0dn4 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1f6kntn xk50ysn x7o08j2 xtvhhri x1rluvsa x14yjl9h xudhj91 x18nykt9 xww2gxu xu306ak x12s1jxh xkdsq27 xwwtwea x1gfkgh9 x1247r65 xng8ra']"));
		send_button.sendKeys(Keys.ENTER);
		// To logout	- navbar (//span[@data-icon="menu"])[1]

		driver.findElement(By.xpath("(//span[@data-icon=\"menu\"])[1]")).click();
		
		// logout button //div[@aria-label="Log out"]
		
		driver.findElement(By.xpath("(//div[@aria-label=\"Log out\"]")).click();
	}
	
}
