package com.moodys.meerqats.QATSAdmin;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class LoginAsAdmin extends BaseClass {

	@Test
	public void AdminAccess() throws InterruptedException {
		

		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys(prop.getProperty("AdminUserName"));

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(prop.getProperty("AdminPassword"));

		driver.findElement(By.xpath("//*[@id='sub']")).click();
		Thread.sleep(2000);

		List<WebElement> AdminMenuItems = driver.findElements(By.xpath("//span[@class='menu-item-title']"));
		
		int Total= AdminMenuItems.size();

		System.out.println("-------------------------------------------------------------");

		System.out.println("Here are the list of Meny Items access with Admin");

		Iterator<WebElement> it = AdminMenuItems.iterator();

		while (it.hasNext()) {

			WebElement MenuItem = it.next();

			System.out.println(MenuItem.getText());

			if (MenuItem.getText().equals("Manage Questionnaire") || MenuItem.getText().equals("Admin Utils")) {

				MenuItem.click();
				
				Thread.sleep(2000);

				it.next();

				Total = Total - 1;

			}

		}

		System.out.println("-------------------------------------------------------------");

		System.out.println("Total number of Menu Items access with Admin are" + " " + Total);

		Assert.assertEquals(Total, Integer.parseInt(prop.getProperty("AdminMenuItemaccess")));
		
		Assert.assertEquals(true, false);

	}
	
	

	
}
