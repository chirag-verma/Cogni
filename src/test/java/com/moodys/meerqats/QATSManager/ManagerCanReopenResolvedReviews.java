package com.moodys.meerqats.QATSManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class ManagerCanReopenResolvedReviews extends BaseClass {

	@Test
	public void OpenResolvedReviews() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys(prop.getProperty("ManagerUserName"));

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(prop.getProperty("ManagerPassword"));

		driver.findElement(By.xpath("//*[@id='sub']")).click();

		driver.findElement(By.xpath("//span[text()='Reports']")).click();

		Thread.sleep(2000);

		driver.switchTo().frame(1);

		driver.findElement(By.xpath("//div[@aria-label='All reports (61)']")).click();

		driver.findElement(
				By.xpath("//label[@class='field-caption dataLabelForWrite']/following::input[@data-template][3]"))
				.sendKeys("Case");

		driver.findElement(By.xpath("//li[contains(@data-for-row,'Case Metrics')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Review Case Stocks']")).click();

		Thread.sleep(7000);
		
		
		driver.switchTo()	
		
		System.out.println(driver.findElement(By.xpath("//h1[text()='Review Case Stocks']")).getText());
		
		

		List<WebElement> allresolvedcompletedreviews= driver.findElements(By.xpath("//td[@data-attribute-name='Case status']/div/span[contains(text(),'Resolved-Completed')]"));
				
		allresolvedcompletedreviews.get(0).click();
		
		
		List<WebElement> actionbuttons = driver.findElements(By.xpath("//img[@alt='Actions']"));

		actionbuttons.get(1).click();

	}

}
