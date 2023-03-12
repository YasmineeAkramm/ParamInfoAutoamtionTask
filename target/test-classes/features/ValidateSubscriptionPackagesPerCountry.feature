Feature: Validating Subscription Packages

  Scenario: Validate Subscription Packages
    Given I am at STC TV website
    When  I am navigating to Kuwait Country
    Then  I will find the following packages details
      | Lite    | 1.2 | KWD/month |
      | Classic | 2.5 | KWD/month |
      | Premium | 4.8 | KWD/month |
    When  I switch Country to Bahrain
    Then  I will find the following packages details
      | Lite    | 2 | BHD/month |
      | Classic | 3 | BHD/month |
      | Premium | 6 | BHD/month |
    When  I switch Country to KSA
    Then  I will find the following packages details
      | Lite    | 15 | SAR/month |
      | Classic | 25 | SAR/month |
      | Premium | 60 | SAR/month |