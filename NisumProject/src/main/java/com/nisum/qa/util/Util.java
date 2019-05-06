package com.nisum.qa.util;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.nisum.qa.baseTest.Base;

public class Util extends Base{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITE_WAIT = 20;
	Actions action =  new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/**
	 * MouseHover on the WebElement So we are able to see the Option & click over there.
	 * <code>{@link # mouseoverAction()}</code>.
	 * @author GaneshJadhav
	 * @throws InterruptedException 
	 *
	 *
	 */
	public void mouseHoverAction(WebElement element) throws InterruptedException
	{
			action.moveToElement(driver.findElement(By.xpath("//a[@class='topnav-cookware ']"))).build().perform();
			Thread.sleep(3000);
	}
	
	/**
	 * close current browser window. If browser window open multiple windows this method will closed only current focused window..
	 * <code>{@link # closeCurrentBrowser()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	public void closeCurrentBrowser()
	{
		driver.close();
	}
	
	/**
	 * close all browser window. If browser window open multiple windows this method will closed all browser window..
	 * <code>{@link # closeBrowser()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	/**
	 * Handle browser popup. If browser window open multiple browser popup window. We can handle it using below method..
	 * <code>{@link # browserpopup()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	public void browserpopup()
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> window = driver.getWindowHandles();
		for(String s1 : window)
		{
			if(!s1.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(s1);
				driver.switchTo().window(parentWindow);
			}
		}
	}
	
	/**
	 * Scroll down on particular location you want. If you want to scroll down on particular location then we can handle using below method. We need to pass particular Number..
	 * <code>{@link # scrollmidle(int no)}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	
	public void scrollmidle(int no)
	{
		js.executeScript("window.scrollBy(0, "+ no +")");
	}
	
	
	/**
	 * Handle click on webElement using javascriptExecutor.
	 * <code>{@link # clickByJavascript(WebElement element)}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	
	public void clickByJavascript(WebElement element)
	{
		js.executeScript("document[0].click();", element);
	}
	

	/**
	 * Handle Dynamic Imagepopup.
	 * <code>{@link # imagepop()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	public void imagepop()
	{
		List<WebElement> dynamicelement = driver.findElements(By.xpath("//a[@class='stickyOverlayMinimizeButton']"));
		
			if(dynamicelement.size()!=0)
			{
				for(WebElement imageelement : dynamicelement)
				{
					imageelement.click();
					driver.switchTo().defaultContent();
				}
			}	
		}
	
	/**
	 * Checking for element is present on the UI.
	 * <code>{@link # isTextPresent()}</code>.
	 * @author GaneshJadhav
	 *
	 *
	 */
	
	public boolean isTextPresent(String name)
	{
		try
		{
			return driver.getPageSource().contains(name);
		}
		catch(Exception e)
		{
			return false;
		}
		

	}
}
