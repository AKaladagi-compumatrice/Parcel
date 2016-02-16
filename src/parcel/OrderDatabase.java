package parcel;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class OrderDatabase
{
// Logger log = Logger.getLogger("devpinoyLogger");
  WebDriver driver = new FirefoxDriver();
  String window1,window2,window21,window3;
  Set <String> WindowHandle;
   
  
  @Test(priority=1)
 
  public void beforeTest() throws InterruptedException 
  {
	    
	  
		driver.get("https://stage.parcelplatform.com/reporting/login.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement UN = driver.findElement(By.xpath("//input[@id='uEmail']"));
		UN.sendKeys("mpatel1");
		
		WebElement PW = driver.findElement(By.xpath("//input[@type='password']"));
		PW.sendKeys("ManiParcel@123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='submit']"));
		loginBtn.click();
		
		System.out.println("Logged into Stage Server Successfully");
	//	log.debug("Logged into Stage Server Successfully");
		
		System.out.println("********************");	

		//Entering Site ID
		WebElement newSiteID1 = driver.findElement(By.xpath("//input[@class='search-query search-query-site']"));
		HighLightElement(driver,newSiteID1);
		newSiteID1.sendKeys("1182788");
		newSiteID1.sendKeys(Keys.ENTER);
		System.out.println("Report opened Successfully");
	//	log.debug("Report opened Successfully");
		System.out.println("********************");	  
        //Site IDs 1182788, 1222937
		
		
		//Validated that General Information link is displayed in Write Tab	  
		Thread.sleep(4000);
		
		//Finding General Information is displayed or not in ToC
		WebElement gilabel = driver.findElement(By.xpath("//a[@class='general-info-link']"));
		HighLightElement(driver,gilabel);
		gilabel.isDisplayed();

		System.out.println("\n General Information is displayed in the Write Tab: " +gilabel.isDisplayed());

		System.out.println("********************");	  

		window1=driver.getWindowHandle();//main window
		
		//Clicking on General Information link	  
		gilabel.click();
		
		//Switching to the new window
		WindowHandle = driver.getWindowHandles();
		
	    for(String handle:WindowHandle)
	    {
	    	driver.switchTo().window(handle);
	    }
		
	    driver.manage().window().maximize();
        // i am on second window
		
		System.out.println("Title of the window is " +driver.getTitle());
		String windowTitle = "PARCEL";
		if(driver.getTitle().equals(windowTitle))
		{
			System.out.println("Switched to child window");
			
		}
		
		else
		{
			System.out.println("Did not switch to child window");
			
		}	
		System.out.println("********************");
		
  }
  
  @Test(priority=2)
  public void TC_7() throws InterruptedException 
  {
	  
	  System.out.println("**********Test Case 7 Start**********");
	  // Validate that Order Database Report button is visible
	  WebElement orderBtn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	  HighLightElement(driver,orderBtn);
	  
	  if (orderBtn.isDisplayed()==true)
	  {
		  System.out.println("Order Database Button is displayed");
		 
		  		if(orderBtn.isEnabled()==true)
		  		{
		  			System.out.println("Order Database Button is Enabled and Clickable");
		  		}
	  }
	 else
	 {
		  System.out.println("Order Database Button is not displayed");
	 }
	 System.out.println("**********Test Case 7 End**********");
		
	 
  }

  @Test(priority=3)
  public void TC_8() throws InterruptedException
  {
	  
	  System.out.println("**********Test Case 8 Start**********");
		
	  //Clicking on order database button
	  WebElement orderBtn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	  
	  window2 = driver.getWindowHandle(); //second window
	  
	  orderBtn.click();
	  
	  WindowHandle = driver.getWindowHandles();
		
	  for(String handle:WindowHandle)
	  {
	    driver.switchTo().window(handle);
	  }
	  
	    // I am on third window
	  driver.manage().window().maximize();  
	  System.out.println("Window title after switching: " +driver.getTitle());
	  
	  WebElement orderTitle = driver.findElement(By.xpath("html/body/div[1]/div/form/h1"));
	  HighLightElement(driver,orderTitle);  
	  
	  WebElement propertyLbl = driver.findElement(By.xpath("//span[text()='Property Information:']"));
	  HighLightElement(driver,propertyLbl);
	  
	  String PIlbl = "Property Information:";
	  if(PIlbl.equals(propertyLbl.getText()))
	  {
		  System.out.println("Property Information section is displayed");
	  }
	  else
	  {
		  System.out.println("Property Information section is not displayed");
	  }
	  
	  WebElement notificationlbl = driver.findElement(By.xpath("//span[text()='Send email notification when reports are delivered to PARCEL?']"));
	  HighLightElement(driver,notificationlbl);
	  String notifyLbl = "Send email notification when reports are delivered to PARCEL?";
	  if(notifyLbl.equals(notificationlbl.getText()))
	  {
		  System.out.println("Send Notification section is displayed");
	  }
	  else
	  {
		  System.out.println("Send Notification section is not displayed");
	  }
	  
	  
	  WebElement emailLbl = driver.findElement(By.xpath("//span[text()='Send notifications to:']"));
	  HighLightElement(driver,emailLbl);
	  String email = "Send notifications to:";
	  if(email.equals(emailLbl.getText()))
	  {
		  System.out.println("Email Notification section is displayed");
	  }
	  else
	  {
		  System.out.println("Email Notification section is not displayed");
	  }
	  
	  WebElement providerLbl = driver.findElement(By.xpath("//span[text()='Data Provider:']"));
	  HighLightElement(driver,providerLbl);
	  String dataProvider = "Data Provider:";
	  if(dataProvider.equals(providerLbl.getText()))
	  {
		  System.out.println("Data Provider section is displayed");
	  }
	  else
	  {
		  System.out.println("Data Provider section is not displayed");
	  }
	  
	  WebElement singleOrder = driver.findElement(By.xpath("//input[@value='Continue with Single-Site Order']"));
	  HighLightElement(driver,singleOrder);
	  if(singleOrder.isDisplayed()==true)
	  {
		  System.out.println("Continue with Single-Site Order is displayed");
		  if(singleOrder.isEnabled()==true)
		  {
			  System.out.println("Continue with Single-Site Order is Enabled");
		  }
		  else
		  {
			  System.out.println("Continue with Single-Site Order is not Enabled");
		  }
	  }
	  else
	  {
		  System.out.println("Continue with Single-Site Order is not displayed");
	  }
	  
	  WebElement placeOrder = driver.findElement(By.xpath("//input[@value='Place Portfolio Order']"));
	  HighLightElement(driver,placeOrder);
	  if(placeOrder.isDisplayed()==true)
	  {
		  System.out.println("Place Portfolio Order is displayed");
		  if(placeOrder.isEnabled()==true)
		  {
			  System.out.println("Place Portfolio Order is enabled");
		  }
		  else
		  {
			  System.out.println("Place Portfolio Order is not enabled");
		  }
		  
	  }
	  else
	  {
		  System.out.println("Place Portfolio Order is not displayed");
	  }
	  
	  WebElement cancelBtn = driver.findElement(By.xpath("//input[@value='Cancel']"));
	  HighLightElement(driver,cancelBtn);
	  if(cancelBtn.isDisplayed()==true)
	  {
		  System.out.println("Cancel button is displayed");
		  if(cancelBtn.isEnabled()==true)
		  {
			  System.out.println("Cancel button is enabled");
		  }
		      else
			  System.out.println("Cancel button is not enabled");
	  }
	  else
	  {
		  System.out.println("Cancel button is not displayed");
	  }
	  
	  driver.close();
	  Thread.sleep(3000);
	  driver.switchTo().window(window2);
	  Thread.sleep(4000);
	  WebElement editBtn = driver.findElement(By.xpath("//a[@id='toggle-edit-button']"));
	  HighLightElement(driver,editBtn);
	  System.out.println("**********Test Case 8 End**********");
		 
  }
  
  @Test(priority=4)
    public void TC_9() throws InterruptedException
  {
	  
	  System.out.println("**********Test Case 9 Start**********");
		
	  // Finding the Order Database table
	  WebElement orderTable = driver.findElement(By.xpath("//div[@class='main clearfix']/div/div/div/div/div/table/tbody/tr[2]/td"));
	  HighLightElement(driver,orderTable);
	  orderTable.isDisplayed();
	  if(orderTable.isDisplayed()==true)
	  {
	  System.out.println("Order Database table is displayed ");
	  }
	  else
	  {
		  System.out.println("Order database table is not displayed");
	  }
	  System.out.println("**********Test Case 9 End**********");
		
	  
  }
  
  @Test(priority=5)
  public void TC_10() throws InterruptedException
  {
	  
	  System.out.println("**********Test Case 10 Start**********");
		
	  //Warning message if username and password is not entered on Order Database page
	  WebElement orderBtn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	  HighLightElement(driver,orderBtn);
	    	  
	  orderBtn.click();
	  
	  //Switching on the Order Database window
	   WindowHandle = driver.getWindowHandles();
		
	    for(String handle:WindowHandle)
	    {
	    	driver.switchTo().window(handle);
	    }
	    driver.manage().window().maximize();
	    // I am again on third window
	    
	    
	  //  String orderWindow = driver.getWindowHandle();
	    System.out.println("Window title after switching: " +driver.getTitle());
	    
	    //Clicking on Continue with Single-Site Order button without entering any details
	    WebElement singleSiteBtn = driver.findElement(By.xpath("//input[@value='Continue with Single-Site Order']"));
	    HighLightElement(driver,singleSiteBtn);
	    singleSiteBtn.click();
	    
	    // Viewing the text message displayed
	    WebElement msg = driver.findElement(By.xpath("/html/body/div[1]/div/form/span"));
	    HighLightElement(driver,msg);
	    System.out.println("Warning message displayed is : " +msg.getText());
	    System.out.println("**********Test Case 10 End**********");
		
	  
  }
  
  @Test(priority=6)
  public void TC_11() throws InterruptedException   
  {
	  
	  System.out.println("**********Test Case 11 Start**********");
		
	  //Verifying that user is navigated to  http://www.web.edrnet.com/ordering/webgeocoder url to complete the order.
	  //Username on Order Database page
	  WebElement accText = driver.findElement(By.xpath("//input[@name='account[1]']"));
	  HighLightElement(driver,accText);
	  accText.sendKeys("2013212"); 
	  
	  //Password
	  WebElement accPwd = driver.findElement(By.xpath("//input[@name='password[1]']"));
	  HighLightElement(driver,accPwd);
	  accPwd.sendKeys("edrtest1");
	  
	  //Clicking on button
	  WebElement singleSiteBtn = driver.findElement(By.xpath("//input[@value='Continue with Single-Site Order']"));
	  HighLightElement(driver,singleSiteBtn);
	  
	 window3 = driver.getWindowHandle();  //third window
	  
	 singleSiteBtn.click();
	 
	 Thread.sleep(6000);
	  
	  
	  System.out.println("Title of the window is:" +driver.getTitle());
	  System.out.println("URL of the current window is:" +driver.getCurrentUrl());
	  Thread.sleep(4000);
	  
	  //Highlighting Site name field to test switching of the window
	  WebElement sitename = driver.findElement(By.xpath("//input[@id='SiteName_TXT']"));
	  HighLightElement(driver,sitename);
	  Thread.sleep(5000);
	  
	  //Closing the current wed. edrnet window --- 3rd window
	  driver.close();   //closing third winodw
	  
	  Thread.sleep(4000);
	  
	  driver.switchTo().window(window2);
	  
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  System.out.println(driver.getTitle());
	 
	  System.out.println("**********Test Case 11 End**********");
		
  }
  
  @Test(priority=7)
  public void TC_12() throws InterruptedException
  {
	  
	  System.out.println("**********Test Case 12 STart**********");
	  
	  System.out.println("Current title of page is :" +driver.getTitle());
	  //Entering invalid credentials on order database page.
	  WebElement orderBtn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	  HighLightElement(driver,orderBtn);
	  
	   
	  window2 = driver.getWindowHandle();
	  System.out.println("window2");
	  orderBtn.click();
	  
	  
	//String currwin1=driver.getWindowHandle();
	  WindowHandle = driver.getWindowHandles();
		
	    for(String handle:WindowHandle)
	    {
	    	driver.switchTo().window(handle);
	    }
	    driver.manage().window().maximize();
	    
	    // I am on third window
	    
	  System.out.println(driver.getTitle());
	  
	  //Username on Order Database page
	  WebElement accText = driver.findElement(By.xpath("//input[@name='account[1]']"));
	  HighLightElement(driver,accText);
	  accText.sendKeys("345we45"); 
	  
	  //Password
	  WebElement accPwd = driver.findElement(By.xpath("//input[@name='password[1]']"));
	  HighLightElement(driver,accPwd);
	  accPwd.sendKeys("12edrtest1");
	  
	  //Clicking on button
	  WebElement singleSiteBtn = driver.findElement(By.xpath("//input[@value='Continue with Single-Site Order']"));
	  HighLightElement(driver,singleSiteBtn);
	  singleSiteBtn.click();
	  
	// Viewing the text message displayed
	    WebElement msg = driver.findElement(By.xpath("/html/body/div[1]/div/form/span"));
	    HighLightElement(driver,msg);
	    System.out.println("Warning message displayed is : " +msg.getText());
	    System.out.println("**********Test Case 12 End**********"); 
	  
  }
  
  @Test(priority=8)
  public void TC_13() throws InterruptedException
  {
	  //validating that user is redirected to EDR Portfolio order page
	  
	  System.out.println("**********Test Case 13 Start**********");
		
	  //Username on Order Database page
	  WebElement accText = driver.findElement(By.xpath("//input[@name='account[1]']"));
	  HighLightElement(driver,accText);
	  accText.sendKeys("2013212"); 
	  
	  //Password
	  WebElement accPwd = driver.findElement(By.xpath("//input[@name='password[1]']"));
	  HighLightElement(driver,accPwd);
	  accPwd.sendKeys("edrtest1");
	  
	  //Clicking  Place Portfolio Order button
	  WebElement placePortfolioBtn = driver.findElement(By.xpath("//input[@value='Place Portfolio Order']"));
	  HighLightElement(driver,placePortfolioBtn);
	  
	  placePortfolioBtn.click();
	  
	  System.out.println("**********Test Case 13 End**********");
		
  }
  
  @Test(priority=9)
  public void TC_14() throws InterruptedException
  {
	  
	  System.out.println("**********Test Case 14 Start**********");
	    
	  //Ordering portfolio
	  WebElement chkBoxOne = driver.findElement(By.xpath("//input[@id='chk[1182788]']"));
	  HighLightElement(driver,chkBoxOne);
	  chkBoxOne.click();
	  
	  //Entering data in PO# text
	  WebElement poText = driver.findElement(By.xpath("//input[@name='po[1182788]']"));
	  HighLightElement(driver,poText);
	  poText.clear();
	  poText.sendKeys("AO12345");
	  
	  //Entering data in proj# field
	  WebElement projText = driver.findElement(By.xpath("//input[@id='pn[1182788]']"));
	  HighLightElement(driver,projText);
	  projText.clear();
	  projText.sendKeys("Loan #45OB123");
	  
	  //Selecting value from drop down pkg
	  WebElement pkgLbl = driver.findElement(By.xpath("//select[@id='pack[1182788]']"));
	  HighLightElement(driver,pkgLbl);
	  Select pkgDD = new Select(pkgLbl);
	  pkgDD.selectByVisibleText("EDR Premium Package");
	  
	  //Checking Field chk check box
	  WebElement fieldChk = driver.findElement(By.xpath("//input[@id='fc[1182788]']"));
	  HighLightElement(driver,fieldChk);
	  fieldChk.click();
	  
	  //Selecting value from Srch Dist drop down
	  WebElement searchDist = driver.findElement(By.xpath("//select[@id='dist[1182788]']"));
	  HighLightElement(driver,searchDist);
	  Select srchDD = new Select(searchDist);
	  srchDD.selectByVisibleText("All DBs +1 mile");
	  
	  //Entering Email address for sending notifications
	  WebElement email = driver.findElement(By.xpath("//textarea[@id='eml[1182788]']"));
	  HighLightElement(driver,email);
	  email.sendKeys("snehal@compumatrice.com");
	  
	  //Clicking continue order button
	  WebElement continuBtn = driver.findElement(By.xpath("//input[@id='submitPortfolioOrder2']"));
	  HighLightElement(driver,continuBtn);
	  continuBtn.click();
	  Thread.sleep(10000);
	  System.out.println("Current window title is:" +driver.getTitle());
	  
	  //Highlighting the table after successful order
	  WebElement table = driver.findElement(By.xpath("//html/body/table[@class='edr']"));
	  HighLightElement(driver,table);
	  Thread.sleep(4000);
	  
	  window3 = driver.getWindowHandle();
	  driver.close();//3rd window close
	  Thread.sleep(3000);
	  
	  //I am on second window
	  driver.switchTo().window(window2);
	  driver.manage().window().maximize();
	  
	  Thread.sleep(3000);
	  System.out.println(driver.getTitle());
	   Thread.sleep(4000);  
	   
	  //Highlighting table
	  WebElement orderTable = driver.findElement(By.xpath("//div[@class='main clearfix']/div/div/div/div/div/table/tbody/tr[2]/td"));
	  HighLightElement(driver,orderTable);
	  
	  Thread.sleep(3000);

	  System.out.println("**********Test Case 14 End**********");
		
  }

  
 public static void HighLightElement (WebDriver driver, WebElement element) throws InterruptedException
  { 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"border: 5px solid red;");
	    Thread.sleep(2000);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",element,"");
  } 

}
