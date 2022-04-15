	Feature: Application Login

Scenario: Home Page Default Login
Given User is on netbanking landing page
When user login into application with "jin" and "1234" 
Then Home page is populated
And Cards are displayed are "true"


Scenario: Home Page Default Login
Given User is on netbanking landing page
When user login into application with "ast" and "3456" 
Then Home page is populated
And Cards are displayed are "false"