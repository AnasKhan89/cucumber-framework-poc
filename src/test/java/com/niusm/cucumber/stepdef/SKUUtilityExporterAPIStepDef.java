package com.niusm.cucumber.stepdef;

import com.cucumber.listener.Reporter;
import com.niusm.cucumber.common.CommonMethod;
import com.niusm.cucumber.validation.CommonValidation;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.niusm.cucumber.common.CommonMethod.currentTime;
import static com.niusm.cucumber.common.CommonMethod.getFeatureFilePath;
import static com.niusm.cucumber.common.Constants.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class SKUUtilityExporterAPIStepDef {

    Response response;
    Workbook exportedWorkbook;

    Map<String, List<String>> exportedSkuUtilityNeedsMap;
    Map<String, List<String>> expectedSkuUtilityNeedsMap;
    String filePath;

    @Given("^Valid excel file that contains Utility Needs$")
    public void validExcelFileThatContainsUtilityNeeds(DataTable table) {
        List<String> dataList = table.asList(String.class);
        filePath = getFeatureFilePath() + dataList.get(1);
         System.out.println("*********************" + filePath);
//        expectedExcelData = getExcelDataFromFileWithEmptyCells(filePath);
    }

    @When("^I make POST request to SKU Utility Need Exporter API$")
    public void iMakePOSTRequestToSKUUtilityNeedExporterAPI() {

        Map<String, String> exportFormParams = new HashMap<>();
        exportFormParams.put(BRAND, BRAND_WE);

        long startTime = currentTime();


//        LOG.info("Downloading Sku utility need from {}", formData.get(Constants.PARAM_BRAND));
        response =
                given()
                        .auth().basic(USERNAME, PASSWORD)
                        .formParam(CHARSET_KEY, StandardCharsets.UTF_8.name())
                        .formParam(BRAND_KEY, BRAND_KEY)
                        .formParams(exportFormParams)
                        .when()
                        .post(BASE_URI + SKU_UTILITY_NEED_EXPORTER_ENDPOINT)
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .contentType(WORKBOOK_CONTENT_TYPE)
                        .extract().response();
        try {
            exportedWorkbook = new XSSFWorkbook(response.asInputStream());
        } catch (IOException ioException) {
            //Need to add Logger
        }
        long duration = System.currentTimeMillis() - startTime;
        Reporter.addStepLog("API Process Time in Secs: " + TimeUnit.MILLISECONDS.toSeconds(duration));

    }

    @Then("^I verify response status code as (\\d+)$")
    public void iVerifyResponseStatusCodeAs(int expectedResponseCode) {
        CommonValidation.validateStatusCode(response.statusCode(), expectedResponseCode);
    }

    @Then("^I validate the number of records$")
    public void iValidateTheNumberOfRecords() {

        exportedSkuUtilityNeedsMap = CommonMethod
                .getExcelDataFromWorkbookWithEmptyCells(exportedWorkbook);

        expectedSkuUtilityNeedsMap = CommonMethod
                .getExcelDataFromFileWithEmptyCells(filePath);
        System.out.println("************" + expectedSkuUtilityNeedsMap.size());
        System.out.println("************" + exportedSkuUtilityNeedsMap.size());

        assertEquals(exportedSkuUtilityNeedsMap.size(), expectedSkuUtilityNeedsMap.size());

    }

    @Then("^I validate the headers$")
    public void iValidateTheHeaders() {
        // Validate header row
        System.out.println("*******"+exportedSkuUtilityNeedsMap.keySet());
        assertEquals(expectedSkuUtilityNeedsMap.keySet(), exportedSkuUtilityNeedsMap.keySet());
    }

    @And("^I validate created actual data with expected data of excel file$")
    public void iValidateCreatedActualDataWithExpectedDataOfExcelFile() {
        // Validate each value row
        expectedSkuUtilityNeedsMap.entrySet().stream().allMatch(expectedResultEntry -> expectedResultEntry.getValue()
                .equals(expectedSkuUtilityNeedsMap.get(expectedResultEntry.getKey())));
    }
}
