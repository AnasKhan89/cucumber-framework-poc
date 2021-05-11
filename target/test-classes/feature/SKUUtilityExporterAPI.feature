Feature: This file contains exporter api test scenarios based on Cucumber BDD style

  @regression, @smoke
  Scenario: 1) As a user, I validate the SKU Utility Need Exporter API
    Given Valid excel file that contains Utility Needs
      | Data_File                             |
      | Sku_Utility_Need_Expected_Output.xlsx |
    When I make POST request to SKU Utility Need Exporter API
    Then I verify response status code as 200
    Then I validate the number of records
    Then I validate the headers
    And I validate created actual data with expected data of excel file

