package com.moodys.meerqats.QATSManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class CreateManualCase_PACR_AutoSuggestions extends BaseClass {

	@Test
	public void ManualCase_PACR_Suggestions() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys(prop.getProperty("ManagerUserName"));

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(prop.getProperty("ManagerPassword"));

		driver.findElement(By.xpath("//*[@id='sub']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Create QA Review']")).click();

		Thread.sleep(4000);

		driver.switchTo().frame(1);

		Actions act = new Actions(driver);

		act.sendKeys(Keys.END).build().perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Create Manual Case']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//label[text()='PACR']/following-sibling::div/input[@type='text']"))
				.sendKeys(prop.getProperty("FirstName"));

		Thread.sleep(4000);

		List<WebElement> Names = driver
				.findElements(By.xpath("//tr[contains(@data-gargs,'" + prop.getProperty("FirstName").trim() + "')]"));

		System.out.println("****************************************************************************************");

		System.out.println("Total number of names with first name " + prop.getProperty("FirstName").trim() + " are "
				+ Names.size());

		System.out.println("****************************************************************************************");

		System.out.println("Here are the name suggestions");
		for (WebElement Name : Names) {

			System.out.print(Name.getText());
			System.out.println();

		}

		for (WebElement Name : Names) {

			if (Name.getText().contains(prop.getProperty("LastName").trim())) {

				Name.click();
			}

		}

		Thread.sleep(4000);

	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}

}
