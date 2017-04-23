Feature: Facebook right click

  @RightClick
  Scenario: Right click on Facebook
    Given User Navigates to Facebook website
      | UserName                      | Password   |
      | raghavendra.bhaskar@gmail.com | Amaze@1236 |
    When User right clicks
    #And selects View Page Source option
    Then i check to verify respective window is opened
    And User Logsout

  @RightClick1
  Scenario: Right click on Facebook
    Given User Navigates to Facebook website
      | UserName                      | Password   |
      | raghavendra.bhaskar@gmail.com | Amaze@1237 |
    When User right clicks
    #And selects View Page Source option
    Then i check to verify respective window is opened
    And User Logsout
