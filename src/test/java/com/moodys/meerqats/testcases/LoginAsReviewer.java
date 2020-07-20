package com.moodys.meerqats.testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class LoginAsReviewer extends BaseClass {

	@Test
	public void ReviewerAccess() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys("test@rqms");

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("rules");

		driver.findElement(By.xpath("//*[@id='sub']")).click();

		List<WebElement> ReviewerMenuItems = driver.findElements(By.xpath("//span[@class='menu-item-title']"));

		System.out.println("Total number of Menu Items access with Reviewer are" + " " + ReviewerMenuItems.size());

		Assert.assertEquals(ReviewerMenuItems.size(), 4);

		System.out.println("Here are the list of Meny Items access with Reviewer");

		Iterator<WebElement> it = ReviewerMenuItems.iterator();

		while (it.hasNext()) {

			System.out.println(it.next().getText());

		}
	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}

}
