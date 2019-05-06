package com.nisum.qa.pages;

import org.openqa.selenium.By;


import com.nisum.qa.baseTest.Base;
import com.nisum.qa.util.Util;

public class Electrics extends Base{
	
	Util util = new Util();
	


	public AddToCart selectproduct(String product)
	{
		util.imagepop();
		driver.findElement(By.xpath("//img[@alt='"+product+"']")).click();
		return new AddToCart();
	}
}
