package parcel;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Editing_GI
{
  WebDriver driver = new FirefoxDriver();
  String window1;
  Set <String> WindowHandle;
  Logger log = Logger.getLogger("devpinoyLogger");
  WebElement editBtn;
  
  @BeforeClass
  public void Login() throws InterruptedException
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
		log.debug("Logged into Stage Server Successfully");
		
		System.out.println("********************");	

		//Entering Site ID
		WebElement newSiteID1 = driver.findElement(By.xpath("//input[@class='search-query search-query-site']"));
		HighLightElement(driver,newSiteID1);
		newSiteID1.sendKeys("1182788");
		newSiteID1.sendKeys(Keys.ENTER);
		System.out.println("Report opened Successfully");
		log.debug("Report opened Successfully");
	 	System.out.println("********************");	  
        //Site IDs 1182788, 1222937
		//Validated that General Information link is displayed in Write Tab	  
		Thread.sleep(4000);
		
		
		//Finding General Information is displayed or not in ToC
		WebElement gilabel = driver.findElement(By.xpath("//a[@class='general-info-link']"));
		HighLightElement(driver,gilabel);
		gilabel.isDisplayed();

		System.out.println("General Information is displayed in the Write Tab: " +gilabel.isDisplayed());

		System.out.println("********************");	  

		window1=driver.getWindowHandle();//main window
		
		//Clicking on General Information link	  
		gilabel.click();

  }
  
  @Test(priority=1)
  public void TC_15() throws InterruptedException 
  {
	  
	  System.out.println("*********Test Case 15 start***********");	
	  System.out.println("Switching to General Information Window");
	  log.debug("Switched to GI window successfully");
	  WindowHandle = driver.getWindowHandles();
	  for(String handle: WindowHandle)
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.manage().window().maximize();
	  
	  //I am on General Information Window - window 2
	  System.out.println("Title of the current window is: " +driver.getTitle());
	  log.debug("Current window is GI");
	  
	  //Verifying that "Edit" button is displayed and enabled on GI page
	  editBtn = driver.findElement(By.xpath("//a[@id='toggle-edit-button']"));
	  HighLightElement(driver,editBtn);
	  
	  //Verify that edit button is displayed
	  if(editBtn.isDisplayed()==true)
	  {
		  System.out.println("Edit button is displayed");
		  log.debug("Edit button is displayed");
	  }
	  else
	  {
		  System.out.println("Edit button is not displayed");
		  log.debug("Edit button is not displayed");
	  }
		 
	  //Verify that edit button is enabled
	  if(editBtn.isEnabled()==true)
	  {
		  System.out.println("Edit button is enabled");
		  log.debug("Edit button is enabled");
	  }
	  else
	  {
		  System.out.println("Edit button is not enabled");
		  log.debug("Edit button is not enabled");
	  }
	  
	  System.out.println("*********Test Case 15 End***********");	
  }

 @Test(priority=2)
 public void TC_16() throws InterruptedException
 {
	
	//Verifying that edit button is clickable 
	 
	 System.out.println("*********Test Case 16 Start***********");
	 HighLightElement(driver,editBtn);
	 editBtn.click();
	 System.out.println("Edit button is clicked");
	 log.debug("Edit button is clicked");
	 
	 WebElement scroll1 = driver.findElement(By.xpath("//div[@class='row-fluid']/div"));
	 scroll1.sendKeys(Keys.PAGE_DOWN);
	 System.out.println("*********Test Case 16 End***********");
 }
 
 @Test(priority=3)
 public void TC_17() throws InterruptedException
 {
	 //Verifying that Submit Changes button is displayed and clickable
	  WebElement scroll1 = driver.findElement(By.xpath("//div[@class='row-fluid']/div"));
	  scroll1.sendKeys(Keys.PAGE_DOWN); 
	 
	 System.out.println("*********Test Case 17 Start***********");
	 WebElement submitBtn = driver.findElement(By.xpath("//input[@class='btn btn-success']"));
	 HighLightElement(driver,submitBtn);
	 
	 //validating that submit changes button is displayed and enabled
	 if(submitBtn.isDisplayed()==true)
	 {
		 System.out.println("Submit Changes button is displayed");
		 log.debug("Submit Changes button is displayed");
	 }
	 else
	 {
		 System.out.println("Submit Changes button is not displayed");
		 log.debug("Submit Changes button is not displayed");
	 }
	 
	 
	 if(submitBtn.isEnabled()==true)
	 {
		 System.out.println("Submit Changes button is enabled");
		 log.debug("Submit Changes button is enabled");
	 }
	 else
	 {
		 System.out.println("Submit Changes button is not enabled");
		 log.debug("Submit Changes button is not enabled");
	 }
	 
	 submitBtn.click();
	 
	 System.out.println("Submit Changes button is clicked");
	 
	 scroll1.sendKeys(Keys.PAGE_DOWN); 
	 
	 WebElement message = driver.findElement(By.xpath("//td[@class='message alert alert-info']"));
	 HighLightElement(driver,message);
	 System.out.println("Message text:" +message.getText());
	 log.debug("Submit Changes button is clicked");
	 Thread.sleep(4000);
 }
 
   @Test(priority=4)
   public void TC_18() throws InterruptedException
   {
	   //Verifying that the edited changes are saved.
	   // Clicking on Edit button
	   
	   System.out.println("*********Test Case 18 Start***********");
	   editBtn = driver.findElement(By.xpath("//a[@id='toggle-edit-button']"));
	   HighLightElement(driver,editBtn);
	   editBtn.click();
	   System.out.println("Edit button is clicked");
	   log.debug("Edit button is clicked");
	   
	   WebElement scroll2 = driver.findElement(By.xpath("//div[@class='row-fluid']/div"));
	   scroll2.sendKeys(Keys.PAGE_DOWN); 
	   scroll2.sendKeys(Keys.PAGE_DOWN);
	   WebElement consultantFirmText = driver.findElement(By.xpath("//input[@name='ConsultantName']"));
	   HighLightElement(driver,consultantFirmText);
	   consultantFirmText.clear();
	   consultantFirmText.sendKeys("EDR EMG TEST");
	   log.debug("Firm name is entered");
	   
	   WebElement consultantAddress = driver.findElement(By.xpath("//input[@name='ConsultantAddress']"));
	   HighLightElement(driver,consultantAddress);
	   consultantAddress.clear();
	   consultantAddress.sendKeys("392 West Street,");
	   log.debug("Address is entered");
	   
	   WebElement consultantCity = driver.findElement(By.xpath("//input[@name='ConsultantCity']"));
	   HighLightElement(driver,consultantCity);
	   consultantCity.clear();
	   consultantCity.sendKeys("Greenville");
	   log.debug("City is entered");
	   
	   WebElement consultantState = driver.findElement(By.xpath("//input[@name='ConsultantState']"));
	   HighLightElement(driver,consultantState);
	   consultantState.clear();
	   consultantState.sendKeys("SC");
	   log.debug("State is entered");
	   
	   WebElement consultantZip = driver.findElement(By.xpath("//input[@name='ConsultantZip']"));
	   HighLightElement(driver,consultantZip);
	   consultantZip.clear();
	   consultantZip.sendKeys("29601");
	   log.debug("Zip code is entered");
	   
	   
	   WebElement submitBtn = driver.findElement(By.xpath("//input[@class='btn btn-success']"));
	   HighLightElement(driver,submitBtn);
	   log.debug("Submit button is clicked"); 
	   submitBtn.click();
	   
	 //  scroll2.sendKeys(Keys.PAGE_DOWN);
	   WebElement message = driver.findElement(By.xpath("//td[@class='message alert alert-info']"));
	   HighLightElement(driver,message);
	   System.out.println("Changes are saved: " +message.getText());
	   log.debug("Changes are saved");
	   	   
	   System.out.println("*********Test Case 18 End***********");
	   
   }   
   
   @Test(priority=5)
   public void TC_19() throws InterruptedException
   {
	   //Verifying that Cancel button is displayed
	   // Clicking on Edit button
	    WebElement scroll1 = driver.findElement(By.xpath("//div[@class='row-fluid']/div"));
	    scroll1.sendKeys(Keys.PAGE_DOWN); 
	    System.out.println("\n*********Test Case 19 Start***********");
	    editBtn=driver.findElement(By.xpath("//a[@id='toggle-edit-button']"));
	    HighLightElement(driver,editBtn);
		editBtn.click();
		System.out.println("Edit button is clicked");
		log.debug("Edit button is clicked");                                       
		
		
		scroll1.sendKeys(Keys.PAGE_DOWN);
		//Clicking on Cancel button
		WebElement cancelBtn = driver.findElement(By.xpath("//input[@value='Cancel']"));
		HighLightElement(driver,cancelBtn);
		
		if(cancelBtn.isDisplayed()==true)
		{
			System.out.println("Cancel button is displayed");
		}
		else
		{
			System.out.println("Cancel button is not displayed");
		}
		
		scroll1.sendKeys(Keys.PAGE_DOWN);
		//Editing Details of Consultant Address
		   WebElement consultantAddress = driver.findElement(By.xpath("//input[@name='ConsultantAddress']"));
		   HighLightElement(driver,consultantAddress);
		   consultantAddress.clear();
		   consultantAddress.sendKeys("392 West Street,");
		   log.debug("Address is entered");
		
		//Canceling the changes   
		 cancelBtn.click();
		 scroll1.sendKeys(Keys.PAGE_DOWN);
		 //Checking the changes
		 if(consultantAddress.getText().equals("392 West Street,"))
		   {
			   System.out.println("Entered changes is saved");
		   }
		   else
		   {
			   System.out.println("Entered changes is not saved");
		   }
		
		System.out.println("Cancel button is clicked");
		log.debug("cancel button is clicked");
		
		 System.out.println("\n*********Test Case 19 Start***********");
   }

  
  public static void HighLightElement (WebDriver driver, WebElement element) throws InterruptedException
  { 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"border: 5px solid red;");
	    Thread.sleep(2000);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",element,"");
  } 


}
