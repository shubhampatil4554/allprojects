Feature: Validating Order Placement in DemoBlaze

Scenario: Login to dempblaze application
Given user is on tricentis main page
When enter username <username> and password <password>
And click on DB Login Button
And click on mobile product link
And click on add to cart button and ok button
And click on place order button 
And fill the order details and click on purchase
Then verify msg <msg>
And click ok
Example:
|username|password|msg|
|pavanol |test@123|Thank you for your purchase!|