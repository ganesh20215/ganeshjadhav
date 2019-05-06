package com.nisum.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.qa.baseTest.Base;
import com.nisum.qa.util.Util;

public class HomePage extends Base{
	
	Util util= new Util();
	
	/**
	 * WebElement is defining in PageFactoty
	 * <code>{@link # PageFactory()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	
	@FindBy(xpath="//a[@class='topnav-cookware ']")
	WebElement cookware;
		
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Cookware cookwarepage()
	{
		util.imagepop();
		cookware.click();
		return new Cookware();
	}

}
