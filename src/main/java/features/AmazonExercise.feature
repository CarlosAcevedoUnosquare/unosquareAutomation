@AmazonFeature
Feature: Example
	
Scenario: Exercise Example
Given User nagivates to amazonMX page
And User clicks on signin button
And User writes user email
And User clicks continuar button
And User wirtes password
And User clicks iniciar sesion
When User search for item "Samsung Galaxy S9 64GB"
And User scrolls to element at position 1
And User stores price at position 1
And User clicks element at position 1
And User gets price at cart level
And User compares prices in the cart
And User clicks add to cart button
And User checks for warranty modal and skips it
And User stores price at position 1
And User compares prices in the cart
And User validate items in cart are equal to 1
And User search for item "Alienware Aw3418DW"
And User scrolls to element at position 1
And User clicks element at position 1
And User clicks add to cart button
And User checks for warranty modal and skips it
Then User validate items in cart are equal to 2