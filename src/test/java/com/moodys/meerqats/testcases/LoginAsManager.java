package com.moodys.meerqats.testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class LoginAsManager extends BaseClass {

	@Test
	public void ManagerAccess() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys(prop.getProperty("ManagerUserName"));

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(prop.getProperty("ManagerPassword"));

		driver.findElement(By.xpath("//*[@id='sub']")).click();

		List<WebElement> ManagerMenuItems = driver.findElements(By.xpath("//span[@class='menu-item-title']"));

		System.out.println("Total number of Menu Items access with Manager are" + " " + ManagerMenuItems.size());

		Assert.assertEquals(ManagerMenuItems.size(), Integer.parseInt(prop.getProperty("ManagerMenuItemsaccess")));

		System.out.println("Here are the list of Meny Items access with Manager");

		Iterator<WebElement> it = ManagerMenuItems.iterator();

		while (it.hasNext()) {

			System.out.println(it.next().getText());

		}
	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}

}
