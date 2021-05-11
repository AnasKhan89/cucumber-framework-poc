Feature: This file contains exporter api test scenarios based on Cucumber BDD style

  @regression, @smoke
  Scenario Outline: 1) As a user, I validate the following Exporters
    Given I make POST request to "<ExporterName>" API with "<URI>", "<WCM_BRAND>", "<WCM_SEASON>", "<WCM_SHOP_SUPER_CATEGORY>", "<WCM_GROUP_ID_NAME>", "<WCM_SKU_ID>", "<WCM_SUB_CATEGORY_NAME>", "<WCM_SKU_NAME>", "<WCM_PERSISTENT_GROUP_NAME>", "<WCM_REGULAR_GROUP_NAME>", "<WCM_GUIDED_GROUP_NAME>", "<WCM_SELLING_POINT_GROUP_NAME>", "<WCM_SEASON_SELLING_POINT_GROUP_NAME>", "<WCM_SUB_CATEGORY_TOP_LEVEL_CATEGORY>"
    Then I verify response status code as 200

    Examples:
      | ExporterName                         | URI       | WCM_BRAND | WCM_SEASON | WCM_SHOP_SUPER_CATEGORY | WCM_GROUP_ID_NAME | WCM_SKU_ID | WCM_SUB_CATEGORY_NAME | WCM_SKU_NAME | WCM_PERSISTENT_GROUP_NAME | WCM_REGULAR_GROUP_NAME | WCM_GUIDED_GROUP_NAME | WCM_SELLING_POINT_GROUP_NAME | WCM_SEASON_SELLING_POINT_GROUP_NAME | WCM_SUB_CATEGORY_TOP_LEVEL_CATEGORY |
      | Alt Image and In Line Video Exporter | /swatches | TRUE      |            |                         |                   |            |                       |              |                           |                        |                       |                              |                                     |                                     |

