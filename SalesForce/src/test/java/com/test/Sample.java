package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.generic.BaseClass;

public class Sample extends BaseClass {

	@Test
	public void test1() {
		driver.findElement(By.id("username")).sendKeys("myarc72448-zv04@force.com");
		driver.findElement(By.id("password")).sendKeys("Admin@5ty");
		driver.findElement(By.id("Login")).click();
		/*
		 * try { Robot ro = new Robot(); ro.keyPress(KeyEvent.VK_CONTROL);
		 * ro.keyPress(KeyEvent.VK_T); ro.keyRelease(KeyEvent.VK_T);
		 * ro.keyRelease(KeyEvent.VK_CONTROL);
		 * 
		 * } catch (AWTException e) {
		 * 
		 * e.printStackTrace(); } String parent = driver.getWindowHandle(); Set<String>
		 * all = driver.getWindowHandles(); all.remove(parent);
		 * System.out.println(parent); for (String string : all) {
		 * driver.switchTo().window(string); }
		 */
		 driver.findElement(By.id("identifierId")).sendKeys("myarc72448@gmail.com", Keys.CONTROL + "t");
		/*
		 * driver.get(
		 * "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
		 * ); driver.findElement(By.id("identifierId")).sendKeys("myarc72448@gmail.com",
		 * Keys.ENTER);
		 */
		 
		/*
		 * driver.findElement(By.
		 * xpath("//div[@class='hercules-header h-c-header h-c-header--product-marketing-one-tier header--desktop']/descendant::a[@ga-event-action='sign in'][1]"
		 * )).click(); String p1 = driver.getWindowHandle(); Set<String> ch =
		 * driver.getWindowHandles(); for (String string : ch) {
		 * driver.switchTo().window(string); }
		 * driver.findElement(By.id("identifierId")).sendKeys("myarc72448@gmail.com",
		 * Keys.ENTER); driver.findElement(By.id("")).sendKeys("",Keys.ENTER);
		 */
	}

	private void get(String string) {
		// TODO Auto-generated method stub
		
	}
}
