package com.niusm.cucumber.validation;

import org.junit.Assert;

public class CommonValidation {
    public static void validateStatusCode(int actualStatusCode, int expectedStatusCode) {
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }
}
