package com.niusm.cucumber.stepdef;

import com.niusm.cucumber.common.CommonMethod;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import java.util.Map;

public class ExporterStepDef {
    @Given("^I make POST request to \"([^\"]*)\" API with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iMakePOSTRequestToAPIWith(String exporterName, String uri, String brand, String season, String shopSuperCategory, String groupIdName, String skuId, String subCategoryName, String skuName, String persistentGroupName, String regularGroupName, String guidedGroupName, String sellingPointGroupName, String seasonSellingPointGroupName, String subCategoryTopLevelCategory) {

        Map<String, String> formParams = CommonMethod.getFormParams(brand, season, shopSuperCategory, groupIdName, skuId, subCategoryName, skuName, persistentGroupName, regularGroupName, guidedGroupName, sellingPointGroupName, seasonSellingPointGroupName, subCategoryTopLevelCategory);


        System.out.println("Hello");
    }
}
