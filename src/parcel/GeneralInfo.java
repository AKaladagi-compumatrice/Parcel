package parcel;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GeneralInfo {
	
	WebDriver driver = new FirefoxDriver();
	WebElement gilabel;
	
  @Test(priority=1)
  public void TC_1() throws InterruptedException 
  
  { 
	  // Test case for logging into to the site
	  // Logging into Stage parcel site
			
		  driver.get("https://stage.parcelplatform.com/reporting/login.php");
		  driver.manage().window().maximize();
			
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			
		  WebElement UN = driver.findElement(By.xpath("//input[@id='uEmail']"));
		  UN.sendKeys("mpatel1");
			
		  WebElement PW = driver.findElement(By.xpath("//input[@type='password']"));
		  PW.sendKeys("ManiParcel@123");
			
		  WebElement loginBtn = driver.findElement(By.xpath("//button[@name='submit']"));
		  loginBtn.click();
			
		  System.out.println("Logged into Stage Server Successfully");
			
	      System.out.println("\n********************");	
	      
		 //Entering Site ID
		  WebElement newSiteID1 = driver.findElement(By.xpath("//input[@class='search-query search-query-site']"));
		  HighLightElement(driver,newSiteID1);
		  newSiteID1.sendKeys("1182788");
		  newSiteID1.sendKeys(Keys.ENTER);
		  System.out.println("Report opened Successfully");
		  System.out.println("\n********************");				
	 	  
  }
  
  @Test(priority=2)
  public void TC_3() throws InterruptedException
  {
	      //TC_3 Validated that General Information link is displayed in Write Tab	
	      System.out.println("\n**********Test Case 3 Start**********");	 
	      Thread.sleep(4000);
	      
	      //Finding General Information is displayed or not in ToC
	      gilabel = driver.findElement(By.xpath("//a[@class='general-info-link']"));
	      HighLightElement(driver,gilabel);
	      gilabel.isDisplayed();
	  
	      System.out.println("\n General Information is displayed in the Write Tab: " +gilabel.isDisplayed());
	  
	      System.out.println("\n**********Test Case 3 End**********");  
  }
  
  @Test(priority=3)
  public void TC_4()
  {
	  	//TC_4 and 5 - General information is clickable and opens new tab when clicked. 
	  	System.out.println("\n**********Test Case 4 and 5 Start**********");
	  	gilabel.click();
	  
	  	System.out.println("\nGeneral Information Window is open: " +driver.getTitle());
	  
	  	//Switching to new window
	  	Set <String> allWindows = driver.getWindowHandles();
	  
	  	Iterator<String> ite =  allWindows.iterator();
	  	String parentWindow = ite.next();
	  	System.out.println("Parent Window" +parentWindow);
	  
	  	String childWindow = ite.next();
	  	System.out.println("Child Window" +childWindow);
	  	driver.switchTo().window(childWindow);
	  	driver.manage().window().maximize();
	  
	  	System.out.println("Current child window title is: " +driver.getTitle());
	  
	  	System.out.println("\n**********Test Case 4 and 5 End**********");
	  
  }
  
  @Test(priority=4)
  public void TC_6() throws InterruptedException
  {
	  System.out.println("\n**********Test Case 6 Start**********");
	  //TC_6 Verify data fields available on the GI page
	  //Order Database Button
	  
	  WebElement orderBtn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	  HighLightElement(driver,orderBtn);
	  orderBtn.isDisplayed();
	  orderBtn.isEnabled();
	  System.out.println("Order Database Reports button is displayed" +orderBtn.getText());
	  
	  //Page Down
	  WebElement scroll1 = driver.findElement(By.xpath("//div[@class='row-fluid']/div"));
	  scroll1.sendKeys(Keys.PAGE_DOWN); 
	  
	  // Project Section
	  WebElement projectLbl = driver.findElement(By.xpath("//div[@id='viewGI']/table/tbody/tr[1]/td[1]/table[1]/tbody/tr[1]/td"));
	  HighLightElement(driver,projectLbl);
	  String one = projectLbl.getText();
	  String proj ="Project";
	 //System.out.println("" +one );
	  
	   if(one.equals(proj))
	  {
		   System.out.println("Project section is displayed");
	  }
	  else
	  {
		  System.out.println("Project section is not displayed");
	  }
	
	 // Site Section
	 WebElement siteLbl = driver.findElement(By.xpath("//div[@id='viewGI']/table/tbody/tr/td[2]/table/tbody/tr[1]/td"));
	 HighLightElement(driver,siteLbl);
	 String two = siteLbl.getText();
	 String site ="Site     View Map [MapQuest]";
	  
	  if(two.equals(site))
	  {
		  System.out.println("Site section is displayed");
	  }
	  else
	  {
		  System.out.println("Site section is not displayed");
	  }
	  	  
	  scroll1.sendKeys(Keys.PAGE_DOWN); 
	  // Consultant Section
	  WebElement consulLbl = driver.findElement(By.xpath("//div[@id='viewGI']/table/tbody/tr/td/table[2]/tbody/tr/td"));
	  HighLightElement(driver,consulLbl);
	  String three = "Consultant";
	  String consultant = consulLbl.getText();
	  
	  if(three.equals(consulLbl.getText()))
	  {
		  System.out.println("Consultant Section is Displayed");
	  }
	  else
	  {
		  System.out.println("Consultant section is not displayed");
	  }
      
	  
	  //Client Section
	  WebElement clientLbl = driver.findElement(By.xpath("//div[@id='viewGI']/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td"));
	  HighLightElement(driver,clientLbl);
	  String four = "Client Find a Contact";
	  
	  if(four.equals(clientLbl.getText()))
	  {
		  System.out.println("Client Section is Displayed");
	  }
	  else
	  {
		  System.out.println("Client section is not displayed");
	  }

	  
	//  WebElement scroll3 = driver.findElement(By.xpath("//div[@class='row-fluid']/div"));
	  scroll1.sendKeys(Keys.PAGE_DOWN); 
	  
	  //Signatures Section
	  WebElement signatureLbl = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[6]"));
	  HighLightElement(driver,signatureLbl);
	  String five = "Signatures";
	  
	  
	  if(five.equals(signatureLbl.getText()))
	  {
		  System.out.println("Signatures section is displayed");		  
	  }
	  else
	  {
		  System.out.println("Signatures section is not displayed");
	  } 
	  
	  //Certifications Section
	  WebElement certLbl = driver.findElement(By.xpath("//div[@id='viewCS']/table[2]/tbody/tr[1]/td"));
	  HighLightElement(driver,certLbl);
	  String six="Certifications";
	  
	  
	  if(six.equals(certLbl.getText()))
	  {
		  System.out.println("Certifications section is displayed");
	  }
	  else
	  {
		  System.out.println("Certifications section is not displayed");
	  }
	  
	  System.out.println("\n**********Test Case 6 End**********");	
	
  }
  
  public static void HighLightElement (WebDriver driver, WebElement element) throws InterruptedException
  { 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"border: 5px solid red;");
	    Thread.sleep(2000);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",element,"");
  } 
}
