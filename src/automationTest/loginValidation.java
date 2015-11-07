package automationTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/Sneha/Pictures/Quotes/chromedriver");

		
		
		//WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
		//driver.get("http://www.google.com");
		
		//Initialize Webdriver
		WebDriver driver = new ChromeDriver();
		
		 // Maximize Window
		   driver.manage().window().maximize();
		   
		   //navigate to the website
		    driver.get("https://www.walmart.com/account");
		   
		// Wait For Page To Load
		    //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		   
		   // Wait For Page To Load
	        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		   
		   
		    
		    /*//find the Sign in banner
		    try{
		    	WebElement findSignIn = driver.findElement(By.xpath("//*[@link='My Account']"));
		    	findSignIn.click();
		    }
		    catch(Throwable e) {
		    	
		    }*/
		    
		    
		    /*CASE- 1. Both User name and Password are entered correctly. 
		    Check whether Email field exists or not */
		        try
		            {
		              WebElement a1 = driver.findElement(By.xpath("//*[@id='login-username']"));
		              System.out.println("---------Email id exists --------------\n-----------------------");
		              a1.sendKeys("snehasaran700@gmail.com");
		              //a1.sendKeys("ENTER CORRECT MAIL ID");
		             }
		        catch(Throwable e)
		             {
		             System.out.println("Email Id not found: " + e.getMessage());
		             }

		        //Check whether Password field exists or not
		         try
		            {
		    	 WebElement password = driver.findElement(By.xpath("//*[@id='login-password']"));
		             System.out.println("----------Passwordd exists ------------\n-----------------------");
		             password.sendKeys("sneha123");
		             //password.sendKeys("ENTER CORRECT PASSWORD");
		            }
		        catch(Throwable e)
		            {
		    	 System.out.println("Passwordd not found: " + e.getMessage());
		            }
		        // ---- <Copy Paste here---->
		         
		      // Wait For Page To Load
				    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				    //System.out.println("Timeout executed");
		         
		         //Asserting if Submit button exists or not
		         try{
		        	 WebElement searchBox = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
		        	 searchBox.click();
		        	 System.out.println("Submit/Sign in button found");
		         }
		         catch(Throwable e){
		        	 System.out.println("Submit/Sign in button not found");
		         }
		         
		      // Wait For Page To Load
		        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		        
		        //find H1 text
		        try{
		        	WebElement divElement = driver.findElement(By.className("recent-orders"));
		        	String str = divElement.getText();
		        	//System.out.println(str);
		        	if(str.contains("Welcome to your Walmart account!")){
		        		System.out.println("Successful");
		        	}
		        	else{
		        		System.out.println("Unsuccessful");
		        	}
		        	
		        	
		        	//declare variables
		        	//String descriptionTextXPath = "//div[contains(@class, 'recent-orders')]/h1";
		        	
		        	//find element
		        	//WebElement h3Element = driver.findElement(By.xpath(descriptionTextXPath));
		        	
		        	/** Grab the text **/
		        	//String descriptionText = h3Element.getText();
			    
			           /*if(descriptionText.equals("Welcome to your Walmart account!")) {
			        	   System.out.println("Login successful");
			           }
			           else{
			        	   System.out.println("Unsuccessful login");
			           }*/
			           
			           //driver.FindElement(By.XPath("//h5[contains(@class, 'ban hot') and text() = 'us states']"));
		        }
		        catch(Throwable e){
		        	System.out.println("Welcome text not found");
		        }
		        
		        // Wait For Page To Load
		        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		         
		        //Search bar
		         try{
		        	 WebElement searchbar = driver.findElement(By.xpath("//input[@id='search']"));
		        	 searchbar.sendKeys("socks");
		         }
		         catch(Throwable e){
		        	 System.out.println("Search bar not found");
		         }
		         
		         
		         //Click Search button
		         try{
		        	 WebElement findSearchButton = driver.findElement(By.className("searchbar-submit"));
		        	findSearchButton.click();
		        	System.out.println("Search button clicked, Data displayed");
		         }
		         catch(Throwable e){
		        	 System.out.println("Search button not found");
		         }
		         
		         driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		         
		         //pick an element from grid
		         try{
		        	
		        	 WebElement pickElem = driver.findElement(By.cssSelector("a[href='/ip/Fruit-of-the-Loom-Ladies-Low-Cut-Socks-6-pair-2-free-bonus-pack/37202066']"));
		        	 pickElem.click();
		        	 System.out.println("Element selected, added to cart");
		         }
		         catch(Throwable e){
		        	 System.out.println("Element not found"); 
		         }
		         
		         //Select color
		         try{
		        	 //WebElement getColor = driver.findElement(By.className("variant-swatch"));
		        	 
		        	 WebElement getColor = driver.findElement(By.xpath("//div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[2]/label/span"));
		        	 getColor.click();
		        	 System.out.println("Appropriate color found");
		        	 
		        	 //black
		        	  //  /html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[1]/label/span
		        	 
		        	 //white
		        	//    /html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[2]/label/span
		        	 
		         }
		         catch(Throwable e){
		        	 System.out.println("Color class not found");
		         }
		         
		         
		         //searches dropdown on page
		         try{
		        	 WebElement selectSize = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div"));
		        	 selectSize.click();
		        	 System.out.println("searching for dropdown");
		        	 
		         }
		         catch(Throwable e){
		        	 System.out.println("Error in finding dropdown");
		         }
		         
		         
		         try{
		        	 WebElement selectSizeActual = driver.findElement(By.xpath("//div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/button[2]"));
		        	//selectSizeActual.sendKeys("4-10");
		        	 selectSizeActual.click();
		        	 /*if(selectSizeActual.isSelected()){
		        		
		        		 System.out.println("Value in stock");
		        	 }
		        	 else{
		        		 System.out.println("Out of stock");
		        	 }*/
		        	 
		        	 System.out.println("Select option from dropdown"); 
		         }
		         catch(Throwable e){
		        	 System.out.println("Can't select option from dropdown");
		         }
		         
		         //Adding timeout
		         driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	        
		         //Add element to cart
		         try{
		        	 // WAIT UNTIL THE VIEW CART BUTTON IS NOT LOCATED
		        	 WebDriverWait wait = new WebDriverWait(driver, 100);
		        	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WMItemAddToCartBtn")));
		        	 wait.until(ExpectedConditions.elementToBeClickable(By.id("WMItemAddToCartBtn")));
		        	 
		        	 
		        	 WebElement addToCart = driver.findElement(By.id("WMItemAddToCartBtn"));
		        	  addToCart.click();
		        	  System.out.println("Added successfully");
		         }
		         catch(Throwable e){
		        	System.out.println("Item could not be added to cart"); 
		         }
		         
		         
		         try{
		        	 
		        	// WAIT UNTIL THE VIEW CART BUTTON IS NOT LOCATED
		        	 WebDriverWait wait = new WebDriverWait(driver, 100);
		        	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PACViewCartBtn")));
		        	 wait.until(ExpectedConditions.elementToBeClickable(By.id("PACViewCartBtn")));
		        	 
		        	 WebElement viewCart = driver.findElement(By.id("PACViewCartBtn"));
		        	 viewCart.click();
		        	 System.out.println("Cart being reviewed");
		         }
		         catch(Throwable e){
		        	 System.out.println("Cannot review cart");
		         }
		         
		         
		         
		         
		        

	}

}
