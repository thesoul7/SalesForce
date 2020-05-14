package com.generic;

import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class FetchingOTP {
	public static  String ACCOUNT_SID="ACbba82eaa6c801de9dd7ccab1e0ded639";
	public static   String AUTH_TOKEN="f4770c1f964c2bf77465d43635899b53";
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		driver = new ChromeDriver(co);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("my_arc-c1dv@force.com");
		driver.findElement(By.id("password")).sendKeys("Admin@5ty");
		driver.findElement(By.id("Login")).click();
		
		

		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
		String removeString= getMsg();
		String otp =removeString.replaceAll("[^-?0-9]+", " "); 
		System.out.println("Verification code is "+otp.substring(0, 6));
		
		  driver.findElement(By.id("smc")).sendKeys(otp.substring(0, 6));
		  driver.findElement(By.id("save")).click();
		 
		 
	}
	
	private static java.util.stream.Stream<Message> getMessages() { 
		 ResourceSet<Message> messages =
				Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
	
		public static String getMsg() {
		return	getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND)==0)
			.filter(m -> m.getTo().equals("+12058437750")).map(Message::getBody).findFirst()
			.orElseThrow(IllegalStateException::new);
		}
		
}
