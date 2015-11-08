Given Problem Statement: 
Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome or Safari browser.

Scenario to automate:
1. Login using existing account
2. Perform a search on home page from a pool of key words given below
3. Identify an item from the result set that you can add to cart
4. Add the item to cart
5. Validate that item added is present in the cart and is the only item in the cart

Test Data:
• Account details: create your own account
• Search terms: tv, socks, dvd, toys, iPhone

Testing tools and Programming language to be utilized: 
Any open source testing tool such as Webdriver, Watir etc. would work. Programming language for the test can be of your choice.

<------------------------------------------------------------------------------------------------------------------------------>

Browser Used: Chrome
Programming language used for testing: Java
Java version used: java version "1.7.0_79"
Testing Tool used: Selenium Webdriver.
IDE tested on: Eclipse, Version: Luna Service Release 1 (4.4.1)

Program execution:
1. Navigate to the URL https://www.walmart.com/account
2. Log in to an existing account with the following credentials:
	username: snehasaran700@gmail.com
	password: sneha123
	a) In order to log into another existing account, you'll need to look for uname.sendKeys("snehasaran700@gmail.com") and 
password.sendKeys("sneha123"), and replace the values in the code with the username and password of that account. 
	b) In case of wrong username, Code returns "Email Id not found: " message on the console along with the error message.
	c) In case of wrong password, Code returns "Password not found: " message on the console along with the error message. 
3. The program looks for a sign in button. 
	a) On successfully finding it, "Submit/Sign in button found" message is printed on the console.
	b) If there's an error, "Submit/Sign in button not found" message is printed on the console.
4. The code validates successful login by looking for the welcome text on the webpage "Welcome to your Walmart account!".
	a) If it is found, "Successful" message is displayed on the console.
	b) If not, "Welcome text not found" message is displayed on the console.
5. Program looks for the search bar and types the keyword to search. In case of an error, "Search bar not found" message
is displayed on the console.
6. After a keyword has been entered on the search bar, the program looks for the search button to click. 
	a) If it is successfully identified on the webpage, "Search button clicked, Data displayed" message is displayed on the 
	console and data is rendered on the webpage. 
	b) In case of error, "Search button not found" message is displayed on the console.
7. If the keyword entered is "socks"
	a) The program is designed to pick an element from the grid with the anchor tag - /ip/Fruit-of-the-Loom-Ladies-Low-Cut-Socks-6-pair-2-free-bonus-pack/37202066.
		i) If the item is identified successfully, "Element selected" message is displayed on the console.
	   ii) In case of error,program returns the error message on console - "Element not found".
	b) After this step, the program selects a color for the selected item and clicks it. The program is designed to select black color. In order to choose another color from the available set of options, you'll need to look for the following statement and make changes specified in <> brackets:
	WebElement getColor = driver.findElement(<Substitute the xpath of the desired color>);
		i) If black color is found, "Appropriate color found" message is displayed on the console.
	   ii) If not/In case of error,"Color not found" error message is displayed on the console.
	c) The program now looks for the dropdown that selects a size for this item(This is a mandatory selection on the webpage) and clicks it.
		i) If size dropdown is successfully identified, "searching for dropdown" message is displayed on the console.
	   ii) In case of error/If size dropdown is not found, "Error in finding dropdown" message is displayed on the console.
	d) After making the dropdown active, the program selects an option from it and clicks it. The program is designed to select the option "4-10" from the dropdown.
		i) On successfully selecting the "4-10" option, "Option selected from dropdown" message is displayed on the console.
	   ii) In case of error, "Can't select option from dropdown" error message is displayed on the console.
	e) Now, all mandatory options have been selected to add an element in the cart. The program checks if the item is in stock, it'll add it to the cart. Else it'll say "Out of Stock" and exit out of the program. 
		i) If after selecting all mandatory options, "Add to Cart" button is displayed --- That implies the item is IN STOCK. The program will then click the Add to Cart button and "Added successfully" message will be displayed on the console. 
	   ii) If after selecting all mandatory options, "Get In-Stock Alert" button is displayed -- That implies the item is OUT OF STOCK. The program will then click the Get In-Stock Alert button and "Item out of stock" message will be displayed on the console and the program will exit. 
	  iii) If both the above cases fail, program returns the error message "Something went wrong, item couldn't be added to cart." and the program will exit. 
	f) Program now looks for the "View cart" button to review the items in cart.
		i) If button is identified successfully, "Cart being reviewed" message is displayed on the console.
	   ii) If not/in case of error, "Cannot review cart" error message is displayed on the console and the program terminates.
	g) At this point, items in the cart are validated. 
		i) To check if the Selected Item is present in cart :
			-- Program looks for the same element which it selected in the beginning(By checking the link to the anchor tag).
					> If successfully found, "Selected element present in cart" message is displayed on the console.
					> Otherwise, program displays "Selected element NOT present in cart" on the console and terminates.
	   ii) To check if there are other elements in cart, other than the selected item: 
	   		-- Program counts the number of elements in the cart. 
	   				> If it is 1, "1 element found in cart" message is displayed on the console.
	   				> Otherwise, "More than 1 element found in cart" message is displayed on the console.
	  iii) If the above cases fail, "Could not locate selected item in cart" message is displayed on the console and the program terminates. 
	  			


	   	

	   


	

