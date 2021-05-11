package com.niusm.cucumber.common;

public class Constants {

    /*HTTP */
    public static final String OPERATION_POST = "POST";
    public static final String OPERATION_GET = "GET";
    public static final String OPERATION_PUT = "PUT";
    public static final String OPERATION_DELETE = "DELETE";

    /*Headers*/
    public static final String HEADER_CLIENT_ID = "clientId";
    public static final String HEADER_CLIENT_ID_VALUE = "web";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json";

    /*URLs*/
    public static final String BASE_URI = "http://localhost:38600";
    public static final String BRAND_KEY = "brand";
    public static final String SKU_UTILITY_NEED_EXPORTER_ENDPOINT = "/export/spreadsheet/skuUtilityNeeds";
    public static final String WORKBOOK_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String EXCEPTION_MESSAGE = "IO Exception: {}";
    public static final String SUCCESS_MESSAGE = "Successful sku utility need export.";
    public static final String CHARSET_KEY = "_charset_";

    /*Brands*/
    public static final String BRAND = "brand";
    public static final String BRAND_WE = "we";

    /*User Details*/
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    /** Performance Testing Attributes */
    public static final String WCM_SERVER="WCM_SERVER";
    public static final String WCM_PORT = "WCM_PORT";
    public static final String WCM_UN = "WCM_UN";
    public static final String WCM_PW = "WCM_PW";
    public static final String WCM_BRAND = "WCM_BRAND";
    public static final String WCM_SEASON = "WCM_SEASON";
    public static final String WCM_SHOP_SUPER_CATEGORY = "WCM_SHOP_SUPER_CATEGORY";
    public static final String WCM_GROUP_ID_NAME = "WCM_GROUP_ID_NAME";
    public static final String WCM_SKU_ID = "WCM_SKU_ID";
    public static final String WCM_SUB_CATEGORY_NAME = "WCM_SUB_CATEGORY_NAME";
    public static final String WCM_SKU_NAME = "WCM_SKU_NAME";
    public static final String WCM_PERSISTENT_GROUP_NAME = "WCM_PERSISTENT_GROUP_NAME";
    public static final String WCM_REGULAR_GROUP_NAME = "WCM_REGULAR_GROUP_NAME";
    public static final String WCM_GUIDED_GROUP_NAME = "WCM_GUIDED_GROUP_NAME";
    public static final String WCM_SELLING_POINT_GROUP_NAME = "WCM_SELLING_POINT_GROUP_NAME";
    public static final String WCM_SEASON_SELLING_POINT_GROUP_NAME = "WCM_SEASON_SELLING_POINT_GROUP_NAME";
    public static final String WCM_OUTPUT_FOLDER = "WCM_OUTPUT_FOLDER";
    public static final String WCM_SUB_CATEGORY_TOP_LEVEL_CATEGORY = "WCM_SUB_CATEGORY_TOP_LEVEL_CATEGORY";



}
