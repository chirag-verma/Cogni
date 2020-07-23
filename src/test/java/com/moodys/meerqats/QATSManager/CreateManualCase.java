package com.moodys.meerqats.QATSManager;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.moodys.meerqats.pageclass.BaseClass;

public class CreateManualCase extends BaseClass{
	@Test
	public void ManualCase() throws InterruptedException{
	
	driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys(prop.getProperty("ManagerUserName"));

	driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(prop.getProperty("ManagerPassword"));

	driver.findElement(By.xpath("//*[@id='sub']")).click();
	
	driver.findElement(By.xpath("//span[text()='Create QA Review']")).click();
	
Thread.sleep(3000);

driver.switchTo().frame(1);
	
	System.out.println(driver.findElement(By.xpath("//*[@id='RULE_KEY']/div[1]/div[1]/div[1]/b")).getText());
	
	Actions act = new Actions(driver);
	
	act.sendKeys(Keys.END).build().perform();
	
	driver.findElement(By.xpath("//button[text()='Create Manual Case']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//label[text()='Lead Analyst Name']/following-sibling::div/input[@type='text']")).sendKeys("Andreas");
	
	Thread.sleep(3000);
	
	List<WebElement>  Names= driver.findElements(By.xpath("//tr[contains(@data-gargs,'Andreas')]"));
	
	
	System.out.println("Total number of names with Andreas are " + Names.size());
	
	for(WebElement Name: Names){
		
		System.out.println(Name.getText());
		
		if(Name.getText().contains("Olaf")){
			
			Name.click();
		}
	}
	
	Thread.sleep(2000);
	
	System.out.println(driver.findElement(By.xpath("//span[text()='Lead Analyst Email']//following-sibling::div/span")).getText());
	


}
	
@AfterClass
public void teardown(){
	

}



}
