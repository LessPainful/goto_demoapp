  Feature: Login
  Scenario: Login to the app
  Given my app is running
  And I wait for "Hello!" to appear
  Then take picture
  
  Then I enter "jonas" as "username"
  And I enter "password" as "password"
  Then take picture
  
  Then I press "Login"
  
  And I wait for "Welcome" to appear	
  Then take picture