package com.nisum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.qa.baseTest.Base;
import com.nisum.qa.util.Util;

public class AddToCart extends Base{
	
	Util util = new Util();
	
	/**
	 * WebElement is defining in PageFactoty
	 * <code>{@link # PageFactory()}</code>.
	 * @author GaneshJadhav
	 */
	
	@FindBy(xpath="//button[@class='btn btn_addtobasket btn_addtobasket_add']")
	WebElement addtoCart;
	
	@FindBy(xpath="//a[@id='anchor-btn-checkout']")
	WebElement checkout;
	
	@FindBy(xpath="//a[@name='updates[0].moveToSFL']")
	WebElement saveforlater;
	
	
	public AddToCart()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Add Product in the cart.
	 * <code>{@link # addcart(int no2)}</code>.
	 * @author GaneshJadhav
	 */
	public void addcart(int no2)
	{
		util.imagepop();
		util.scrollmidle(no2);
		addtoCart.click();
		checkout.click();
		util.scrollmidle(no2);
		saveforlater.click();
	}

}
