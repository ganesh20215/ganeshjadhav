package com.nisum.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.qa.baseTest.Base;
import com.nisum.qa.util.Util;

public class Cookware extends Base{
	
	Util util = new Util();
	
	
	public  Cookware()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * close Imagepopup:: Scroll Down of the page :: Clicking the the WebElement(Product we are clicking)
	 * <code>{@link # stovetop(String product, int no)}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	
	public Electrics stovetop(String product, int no)
	{
		util.imagepop();
		util.scrollmidle(no);
		WebElement element = driver.findElement(By.xpath("//*[@id='super-category']/main/div[2]/div[1]/ul[1]/li/a[contains(text(),'"+ product +"')]"));
		element.click();
		return new Electrics();
	}

}
