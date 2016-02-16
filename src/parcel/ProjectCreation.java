package parcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjectCreation {

	public static void main(String[] args) throws InterruptedException 
	
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://stage.parcelplatform.com/reporting/login.php");
		
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement UN = driver.findElement(By.xpath("//input[@id='uEmail']"));
		UN.sendKeys("mpatel1");
		
		WebElement PW = driver.findElement(By.xpath("//input[@type='password']"));
		PW.sendKeys("ManiParcel@123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='submit']"));
		loginBtn.click();
		

		// Creating New Single site project
		WebElement singleProjLink = driver.findElement(By.xpath("//a[@class='feature157']"));
		singleProjLink.click();
		
		Thread.sleep(10000);		
    	//Project name
	   WebElement projName = driver.findElement(By.xpath("//input[@name='project_name']"));
	   projName.sendKeys("St Steven Report");
		
	   //Draft date
	   WebElement draftDate = driver.findElement(By.xpath("//input[@id='draft_date']"));
	   draftDate.sendKeys("01/12/2016");
	
	   //Final Date
	   WebElement finalDate = driver.findElement(By.xpath("//input[@name='final_date']"));
	   finalDate.sendKeys("01/31/2016");
	
	   //Property Name
	   WebElement propName = driver.findElement(By.xpath("//input[@name='prop_name']"));
	   propName.sendKeys("St Steven School Report");
	
	   //Address
	   WebElement address1 = driver.findElement(By.xpath("//input[@name='prop_address1']"));
	   address1.sendKeys("1201 S Figueroa St");
	   
	   //City
	   WebElement city = driver.findElement(By.xpath("//input[@id='prop_city']"));
	   city.sendKeys("Los Angeles");
	
	   //State
	   WebElement stateDD = driver.findElement(By.xpath("//select[@id='prop_state']"));
	   Select stOptions = new Select(stateDD);
	   stOptions.selectByVisibleText("California");
	   
	   //Zip
	   WebElement zip = driver.findElement(By.xpath("//input[@id='prop_zip']"));
	   zip.sendKeys("90015");
	  
	
	   //Report Type
	   WebElement reportType = driver.findElement(By.xpath("//input[@value='PhaseI.2149']"));
	   reportType.click();
	
	   //Getting text of Property Name
	   String w =   projName.getAttribute("value");
	   System.out.println("Project Name Text: " +w);
	 
	   //Project # name
	   WebElement projName2 = driver.findElement(By.xpath("//input[@name='project_number[PhaseI.2149]']"));
	   projName2.sendKeys(w);
	   
	   //Creating Project
	   WebElement crtProjBtn = driver.findElement(By.xpath("//input[@value='Create Project']"));
	   crtProjBtn.click();
	   Thread.sleep(4000);
	   
	   //Getting Site ID
	   WebElement newSiteID = driver.findElement(By.xpath("//input[@class='search-query search-query-site']"));
	  String num = newSiteID.getAttribute("value");
	  System.out.println("Newly Created Site ID:" +num);
	  
	  //Finding the ToC section
//	  WebElement tocSection = driver.findElement(By.xpath("//ul[@id='simplifiedtoc']"));
//	  tocSection.isDisplayed();
		
	}

}
