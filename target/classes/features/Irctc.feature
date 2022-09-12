Feature: Irctc Tatkal ticket booking


    Scenario: login to irctc
      Given I navigated to Irctc "https://www.irctc.co.in/"
      And I login to Irctc with valid credintion
      When I enter valid username "rizwanahmad1611" and password "Irctc123"
      And I click on Login button after entering the capcha manually
      Then I should land to the homepage
      And I enter the Origin "pryj" and Destination "Pune"
      And I enter date "15-09-2020" in datetime piker



