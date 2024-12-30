#Author: Parineeta
#Feature: List of scenarios related to DemoBlaze Application Automation Testing
Feature: Feature of Demo Blaze Application

  Background: 
    Given user open google browser 'https://www.google.com/'

  Scenario: To verify the URL for Demo_blaze on Google browser
    Given user navigated to DemoBlaze Application URL 'https://www.demoblaze.com/'
    Then User has the title of the page as 'STORE'
    And User closes the browser

  Scenario: To verify whether the site displays Greetings to the user
    Given user navigated to DemoBlaze Application URL 'https://www.demoblaze.com/'
    Then user receives welcome greetings 'Welcome to Demo_blaze'
    And User closes the browser

  Scenario: To verify that the user redirects to the sign up page
    Given user navigated to DemoBlaze Application URL 'https://www.demoblaze.com/'
    When user clicks on Sign up link and 'Sign up' modal is displayed
    And user input username as 'testsdYTREwetr123qwdemoblaze@gmail.com' and password as 'testdemo@120' and clicked on Sign up
    Then user is successfully signed up and 'Sign up successful.' alert is displayed
    And User closes the browser

  Scenario: To verify  that the user enters the valid user name
    Given user navigated to DemoBlaze Application URL 'https://www.demoblaze.com/'
    When user clicks on Login link and 'Log in' modal is displayed
    And user input username as 'testsdYTREwetr123qwdemoblaze@gmail.com' and password as 'testdemo@120' and clicked on Log in
    Then user is successfully logged in and 'Welcome testsdYTREwetr123qwdemoblaze@gmail.com' is displayed on loginpage
    And User closes the browser
