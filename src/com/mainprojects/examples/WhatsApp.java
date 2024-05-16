package com.mainprojects.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsApp {

		// Initialize all the static variables
		public static FileInputStream fis;
		public static XSSFWorkbook book;
		public static XSSFSheet sheet;
		public static int numofRows;
		public static String phoneNum;
		public static String message;
		public static String paths;
		public static XSSFRow row;
		
		public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://web.whatsapp.com/");
			
			// Scan the QR code within 15 seconds
			Thread.sleep(40000);
			
			//Refreshing the web page to load all the web elements
			driver.navigate().refresh();
			Thread.sleep(15000);
		
			// To build the connection from excel file to java file
			fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\MainProjects\\ExcelSheetsData\\WhatsApp.xlsx");
		
			// Fetch the excel book so create the object of book class
			book = new XSSFWorkbook(fis);
		 
		 	// To fetch the data from the sheet create object of that, indexing starts from 0
			sheet = book.getSheetAt(0);
			
			// To count the total number of rows present 
			numofRows = sheet.getPhysicalNumberOfRows();
			System.out.println(numofRows);
	
			// iterate to fetch the data, select 2nd row and index 1
			for(int i = 1; i < numofRows ; i++)
			{
				
				// to get the Row data
				XSSFRow row = sheet.getRow(i);
				// if there is no data present then break the loop
				if(row == null)
				{
					break;
				}
				// If some data is present then follow below steps - indexing of cells starts from 0
			
				DataFormatter df = new DataFormatter();									
				Cell cell = row.getCell(0);
				String phoneNum = df.formatCellValue(cell);
				
				// to get the message from 1st cell no and convert into string data
				String message = row.getCell(1).toString();
					
				String paths = row.getCell(2).toString();
				
				// To identify the search bar webelement
				WebElement search_bar = driver.findElement(By.xpath("//div[@class='x1hx0egp x6ikm8r x1odjw0f x6prxxf x1k6rcq7 x1whj5v']"));
				search_bar.sendKeys(phoneNum);
				search_bar.sendKeys(Keys.ENTER);
				
				// To identify the message bar webelement
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement message_bar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='selectable-text copyable-text x15bjb6t x1n2onr6'])[2]")));

				message_bar.sendKeys(message);
				message_bar.sendKeys(Keys.ENTER);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				// + icon	//div[@class='x11xpdln x1d8287x x1h4ghdb']
				WebElement plus_icon = driver.findElement(By.xpath("//div[@class='x11xpdln x1d8287x x1h4ghdb']"));
				plus_icon.click();
				Thread.sleep(4000);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				try {

					WebElement photo = driver.findElement(By.xpath("//input[@accept='image/*,video/mp4,video/3gpp,video/quicktime']"));
					photo.sendKeys(paths);
					photo.click();
				}
				catch(Exception e)
				{
				
				}
				finally
				{
					
				}
			
				WebElement send_button = driver.findElement(By.xpath("//div[@class='x78zum5 x6s0dn4 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1f6kntn xk50ysn x7o08j2 xtvhhri x1rluvsa x14yjl9h xudhj91 x18nykt9 xww2gxu xu306ak x12s1jxh xkdsq27 xwwtwea x1gfkgh9 x1247r65 xng8ra']"));
				send_button.sendKeys(Keys.ENTER);
			}
			
			// To logout	- navbar (//span[@data-icon="menu"])[1]

			driver.findElement(By.xpath("(//span[@data-icon=\"menu\"])[1]")).click();
			
			// logout button //div[@aria-label="Log out"]
			
			driver.findElement(By.xpath("(//div[@aria-label=\"Log out\"]")).click();
	}

}
