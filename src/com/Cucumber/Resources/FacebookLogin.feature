Feature: Facebook Login Feature

  @Loginvalid
  Scenario: Facebook valid Login
    Given User navigates to facebook
    When User enters valid crdentials
      | UserName                      | Password    |
      | raghavendra.bhaskar@gmail.com | Bhadra@1236 |
    Then User validates for FaceBook homepage
 #   And user closes the browser

  # Examples:
  #| UserName                      | Password  |
  #| raghavendra.bhaskar@gmail.com | Krupa9876 |
  #| raghavendra.bhaskar@gmail.com | Krupa9877 |
  
  @Logininvalid
  Scenario: Facebook invalid Login
    Given User navigates to facebook
    When User enters valid crdentials
      | UserName                      | Password   |
      | raghavendra.bhaskar@gmail.com | Amaze@1236 |
    Then User validates for FaceBook homepage
#    And user closes the browser
