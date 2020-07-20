package com.moodys.meerqats.testcases;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class LoginAsAdmin extends BaseClass {

	@Test
	public void ManagerAccess() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys("testadmin@qats");

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("rules123");

		driver.findElement(By.xpath("//*[@id='sub']")).click();
		Thread.sleep(2000);
		List<WebElement> AdminMenuItems = driver.findElements(By.xpath("//span[@class='menu-item-title']"));

		int Total = AdminMenuItems.size();

		

		System.out.println("-------------------------------------------------------------");

		System.out.println("Here are the list of Meny Items access with Admin");

		Iterator<WebElement> it = AdminMenuItems.iterator();

		while (it.hasNext()) {

			WebElement MenuItem = it.next();

			System.out.println(MenuItem.getText());

			if (MenuItem.getText().equals("Manage Questionnaire") || MenuItem.getText().equals("Admin Utils")) {

				MenuItem.click();

				it.next();

				Total = Total - 1;

			}

		}

		System.out.println("-------------------------------------------------------------");

		System.out.println("Total number of Menu Items access with Admin are" + " " + Total);
		
		Assert.assertEquals(Total, 14);
	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}
}
