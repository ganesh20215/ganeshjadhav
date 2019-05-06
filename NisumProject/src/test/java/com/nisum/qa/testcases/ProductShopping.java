package com.nisum.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nisum.qa.baseTest.Base;
import com.nisum.qa.pages.AddToCart;
import com.nisum.qa.pages.Cookware;
import com.nisum.qa.pages.Electrics;
import com.nisum.qa.pages.HomePage;
import com.nisum.qa.util.Util;

public class ProductShopping extends Base{
	
	public static HomePage homepage;
	public static Util util;
	public static Cookware cookware;
	public static Electrics electricpro;
	public static AddToCart addtocart;
	
	@BeforeTest
	public void prerequsite()
	{
		initialization();
		homepage=new HomePage();
		cookware=new Cookware();
		util=new Util();
		electricpro=new Electrics();
		addtocart=new AddToCart();
		
		
	}
	
	@Parameters({"productName", "no", "no2", "product"})
	@Test
	public void verifyProductShopping(String product, int no, int no2, String productName )
	{
		homepage.cookwarepage();
		cookware.stovetop(product, no2);
		//util.scrollmidle(no);
		electricpro.selectproduct(productName);
		addtocart.addcart(no2);
		Assert.assertTrue(util.isTextPresent(product));
	}

	
	/*@AfterTest
	public void closebrowser()
	{
		util.closeBrowser();
	}*/
}
