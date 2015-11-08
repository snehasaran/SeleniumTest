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
	a) If it is found, "Successful" is displayed on the console.
	b) If not, "Unsuccessful" is displayed on the console.
5. 


