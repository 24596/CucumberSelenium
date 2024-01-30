Feature: Search and Place the order for Products
  Scenario: Search experience for product search in both home and offer page

    Given User is on GreenCart Landing page
    When User searched with short name "Tom" and extract the actual name of the product
    Then User searched for the same short name "Tom" in offers page
    And Validate product name in offers page matches with product name in home page

