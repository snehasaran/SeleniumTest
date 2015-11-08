package automationTest;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginValidation {

	public static void main(String[] args) {
		
		System.out.println("Enter Walmart account's username: ");
		Scanner s1 = new Scanner(System.in);
		String uname = s1.nextLine();
		
		System.out.println("Enter Walmart account's password: ");
		Scanner s2 = new Scanner(System.in);
		String password = s2.nextLine();

		System.out.println("\n Please input a value from : tv, socks, dvd, toys, iPhone:");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		HashSet<String> validValues = new HashSet<String>();
		validValues.add("tv");
		validValues.add("socks");
		validValues.add("dvd");
		validValues.add("toys");
		validValues.add("iPhone");
		if(validValues.contains(input)){
			automateWebApp(input,uname,password);
		}else{
			System.out.println("Please enter a valid values i.e. from : tv, socks, dvd, toys, iPhone");
		}
		//tv, socks, dvd, toys, iPhone
	} // end of void main	

	public static void automateWebApp(String keyword,String uname,String password){ 
		System.setProperty("webdriver.chrome.driver", "/Users/Sneha/Desktop/chromedriver");

		//Initialize Webdriver
		WebDriver driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		//navigate to the website
		driver.get("https://www.walmart.com/account");

		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

		/*CASE- 1. Both User name and Password are entered correctly. 
		    Check whether Email field exists or not */
		try
		{
			WebElement enterUsername = driver.findElement(By.xpath("//*[@id='login-username']"));
			System.out.println("---------Email id exists --------------");
			enterUsername.sendKeys(uname);
		}
		catch(Throwable e)
		{
			System.out.println("Email Id not found: " + e.getMessage());
			System.exit(0);
		}

		//Check whether Password field exists or not
		try
		{
			WebElement enterPassword = driver.findElement(By.xpath("//*[@id='login-password']"));
			System.out.println("----------Password exists ------------");
			enterPassword.sendKeys(password);

		}
		catch(Throwable e)
		{
			System.out.println("Password not found: " + e.getMessage());
			System.exit(0);
		}

		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		//Asserting if Submit button exists or not
		try{
			// WAIT UNTIL THE Submit BUTTON IS NOT LOCATED
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[3]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[3]")));

			WebElement searchBox = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
			searchBox.click();
			System.out.println("Submit/Sign in button found");
		}
		catch(Throwable e){
			System.out.println("Submit/Sign in button not found");
			System.exit(0);
		}


		//find H1 text
		try{
			// WAIT UNTIL THE Welcome Text IS NOT LOCATED
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("recent-orders")));
			wait.until(ExpectedConditions.elementToBeClickable(By.className("recent-orders")));

			WebElement divElement = driver.findElement(By.className("recent-orders"));
			String str = divElement.getText();
			if(str.contains("Welcome to your Walmart account!")){
				System.out.println("Successful");
			}
		}
		catch(Throwable e){
			System.out.println("Welcome text not found");
			System.exit(0);
		}

		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);




		//Search bar
		try{
			// WAIT UNTIL THE Search Bar IS NOT LOCATED
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));		        	 

			WebElement searchbar = driver.findElement(By.xpath("//input[@id='search']"));

			searchbar.sendKeys(keyword);
			//searchbar.sendKeys("tv");
		}
		catch(Throwable e){
			System.out.println("Search bar not found");
			System.exit(0);
		}


		//Click Search button
		try{
			// WAIT UNTIL THE Search Button IS NOT LOCATED
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("searchbar-submit")));
			wait.until(ExpectedConditions.elementToBeClickable(By.className("searchbar-submit")));		        	 

			WebElement findSearchButton = driver.findElement(By.className("searchbar-submit"));
			findSearchButton.click();
			System.out.println("Search button clicked, Data displayed");
		}
		catch(Throwable e){
			System.out.println("Search button not found");
			System.exit(0);
		}


		//pick an element from grid
		try{
			// WAIT UNTIL an element IS NOT PICKED FROM THE GRID
			WebDriverWait wait = new WebDriverWait(driver, 150);
			String href ="";
			switch (keyword) {
			case "socks":
				href= "/ip/Fruit-of-the-Loom-Ladies-Low-Cut-Socks-6-pair-2-free-bonus-pack/37202066";
				break;
			case "tv":
				href= "/ip/SCEPTRE-X322BV-HDR-32-LED-Class-720P-HDTV-with-ultra-slim-metal-brush-bezel-60Hz/25059351";
				break;
			case "iPhone":				
				href= "/ip/Refurbished-Straight-Talk-Apple-Prepaid-iPhone-5C-8GB-LTE-Smartphone-with-30-day-45-Service-Plan/45599395";
				break;
			case "dvd":
				href= "/ip/Verbatim-95102-DVD-R-4.7GB-16X-100-Pack/8207324";
				break;
			case "toys":
				href ="/ip/Lincoln-Logs-Prairie-Town-Mine-Building-Set/22716922";
				break;
			default:
				break;
			}
			WebElement pickElem;
			if(!keyword.equals("iPhone")){
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='"+href+"']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='"+href+"']")));
				pickElem = driver.findElement(By.cssSelector("a[href='"+href+"']"));
			}else{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tile-container']/div[1]/div/div/h4/a")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tile-container']/div[1]/div/div/h4/a")));
				pickElem = driver.findElement(By.xpath("//*[@id='tile-container']/div[1]/div/div/h4/a"));
			}

			
			Actions action = new Actions(driver);
			action.moveToElement(pickElem).click().perform();
			
			System.out.println("Element selected");
		}
		catch(Throwable e){
			e.printStackTrace();
			System.out.println("Element not found"); 
			System.exit(0);
		}

		// Selecting mandatory conditions for socks
		if(keyword.equals("socks") || keyword.equals("iPhone")){
			//Select color
			try{
				// WAIT UNTIL appropriate color IS NOT selected
				System.out.println("Selecting mandatory conditions");
				WebDriverWait wait = new WebDriverWait(driver, 100);
				String xpath ="";
				switch (keyword) {
				case "socks":
					xpath = "//div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[2]/label/span";
					break;
				case "iPhone":
					xpath = "/html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/div/span[1]/label/span";
					break;
				default:
					break;
				}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));		        	 

				//tests black color
				WebElement getColor = driver.findElement(By.xpath(xpath));

				//tests white color, uncomment this statement and comment the above
				//WebElement getColor = driver.findElement(By.xpath("/html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[1]/label/span"));
				getColor.click();
				System.out.println("Appropriate color found");

				//black
				//  /html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[1]/label/span

				//to test for white, uncomment
				//    /html/body/div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/span[2]/label/span

			}
			catch(Throwable e){
				System.out.println("Color not found");
				System.exit(0);
			}
		}

		if(keyword.equals("socks")){
			//searches dropdown on page
			try{
				// WAIT UNTIL dropdown is not located
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div")));		        	 


				WebElement selectSize = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div"));
				selectSize.click();
				System.out.println("searching for dropdown");

			}
			catch(Throwable e){
				System.out.println("Error in finding dropdown");
				System.exit(0);
			}
		}
		
		if(keyword.equals("socks")){
			// select one option from dropdown
			try{
				// WAIT UNTIL one Option IS NOT selected from the dropdown
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/button[2]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/button[2]")));;		        	 


				WebElement selectSizeActual = driver.findElement(By.xpath("//div[2]/section/section[4]/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div/button[2]"));
				//selectSizeActual.sendKeys("4-10");
				selectSizeActual.click();
				/*if(selectSizeActual.isSelected()){

		        		 System.out.println("Value in stock");
		        	 }
		        	 else{
		        		 System.out.println("Out of stock");
		        	 }*/

				System.out.println("Option selected from dropdown"); 
			}
			catch(Throwable e){
				System.out.println("Can't select option from dropdown");
				System.exit(0);
			}
		}

		//Add element to cart
		try{
			// WAIT UNTIL THE ADD TO CART BUTTON IS NOT LOCATED
			WebDriverWait wait = new WebDriverWait(driver, 200);
			//*[@id="WMItemAddToCartBtn"]
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WMItemAddToCartBtn")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("WMItemAddToCartBtn")));
*/
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='WMItemAddToCartBtn']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='WMItemAddToCartBtn']")));

			Thread.sleep(1000);
			//checks if Add to cart button is displayed or not
			boolean submitbuttonPresence=driver.findElement(By.xpath("//*[@id='WMItemAddToCartBtn']")).isDisplayed();
			if(submitbuttonPresence){
				WebElement addToCart = driver.findElement(By.xpath("//*[@id='WMItemAddToCartBtn']"));
				//Actions action = new Actions(driver);
				//action.moveToElement(addToCart).click().perform();
				addToCart.click();
				System.out.println("Added successfully");
			}
		}catch(Throwable e){
			try{
				WebDriverWait wait = new WebDriverWait(driver, 10);
				//System.out.println("Stopped for 10 sec");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-out-of-stock")));
				wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-out-of-stock")));
				boolean getInStockAlertButton=driver.findElement(By.className("btn-out-of-stock")).isDisplayed();
				if(getInStockAlertButton){
					System.out.println("Item out of stock");
					System.exit(0);
				}
			}catch(Exception e1){
				e.printStackTrace();
				System.out.println("Something went wrong, item couldn't be added to cart."+e1.getMessage());
				System.exit(0);
			}
		}


		//View cart
		try{

			// WAIT UNTIL THE VIEW CART BUTTON IS NOT LOCATED
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PACViewCartBtn")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("PACViewCartBtn")));

			WebElement viewCart = driver.findElement(By.id("PACViewCartBtn"));
			Actions action = new Actions(driver);
			System.out.println("Clicking view cart button");
			action.moveToElement(viewCart).click().perform();
			// viewCart.click();
			System.out.println("Cart being reviewed");
		}
		catch(Throwable e){
			System.out.println("Cannot review cart");
			System.exit(0);
		}

		//Validate Cart
		try{
			// WAIT UNTIL Selected item IS NOT LOCATED IN CART.
			WebDriverWait wait = new WebDriverWait(driver, 150);
			String href ="";
			switch (keyword) {
			case "socks":
				href= "/ip/37202072";
				break;
			case "tv":
				href= "/ip/25059351";
				break;
			case "iPhone":
				href= "/ip/39665237";
				break;
			case "dvd":
				href= "/ip/8207324";
				break;
			case "toys":
				href ="/ip/22716922";
				break;
			default:
				break;
			}
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='"+href+"']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='"+href+"']")));

			//check if the Selected Item is present in cart
			List<WebElement> ifSelectedItemInCart = driver.findElements(By.cssSelector("a[href='"+href+"']"));
			int x = ifSelectedItemInCart.size();
			if(x !=0){
				System.out.println("Selected element present in cart");
			}
			else{
				System.out.println("Selected element NOT present in cart");
				System.exit(0);
			}


			//check if there are other elements in cart, other than the selected item
			List<WebElement> elementsRoot = driver.findElements(By.className("cart-item-row"));
			int count = elementsRoot.size() -1;
			if(count == 1){
				System.out.println("1 element found in cart");
			}
			else{
				System.out.println("More than 1 element found in cart : " + count);
			}

		}
		catch(Throwable e){
			System.out.println("Could not locate selected item in cart");
			System.exit(0);
		}


	}// end of function

}//end of class
