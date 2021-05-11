package com.niusm.cucumber.common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.niusm.cucumber.common.Constants.*;


public class CommonMethod {

    public static Map<String, List<String>> getExcelDataFromFileWithEmptyCells (String filePath) {
        InputStream inputStream;
        /*Integer is row number in the spreadsheet, List<String> is all values for this row and String is column value in the spreadsheet */
        Map<String, List<String>> excelContent = new LinkedHashMap<String, List<String>>();
        try {
            inputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            excelContent = getExcelDataFromWorkbookWithEmptyCells(workbook);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("IO Exception" + e.getMessage());
        }
        return excelContent;
    }

    public static Map<String, List<String>> getExcelDataFromWorkbookWithEmptyCells(Workbook workbook) {
        Map<String, List<String>> excelContent = new LinkedHashMap<String, List<String>>();
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        // Get spreadsheet level info from header row
        Row headerRow = sheet.getRow(0);
        int lastColumn = headerRow.getLastCellNum();
        for (int cn = 0; cn <= lastColumn; cn++) {
            Cell c = headerRow.getCell(cn, Row.RETURN_BLANK_AS_NULL);
            if (null == c) {
                // The spreadsheet is empty in this cell
                // Does this indicate improper spreadsheet format? throw error?
            } else {
                // Do something useful with the cell's contents
                excelContent.put(c.getStringCellValue(), new ArrayList<String>());
            }
        }
        Object[] headerArray = excelContent.keySet().toArray();
        for (int rowNum = 1; rowNum <= lastRow; rowNum++) {
            Row r = sheet.getRow(rowNum);
            if (r == null) {
                // This whole row is empty
                // Handle it as needed
                continue;
            }
            for (int cn = 0; cn < lastColumn; cn++) {
                Cell cell = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                if (cell == null) {
                    excelContent.get(headerArray[cn]).add("");
                } else {
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            excelContent.get(headerArray[cn]).add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            excelContent.get(headerArray[cn]).add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            excelContent.get(headerArray[cn]).add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        default:
                            excelContent.get(headerArray[cn]).add(cell.getStringCellValue());
                            break;
                    }
                }
            }
        }
        return excelContent;
    }

    public static long currentTime(){
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis;
    }

    public static String getFeatureFilePath(){
        return System.getProperty("user.dir") + "/src/test/resources/data/";
    }

    public static Map<String, String> getFormParams(String brand, String season, String shopSuperCategory, String groupIdName,
                                                    String skuId, String subCategoryName, String skuName, String persistentGroupName,
                                                    String regularGroupName, String guidedGroupName, String sellingPointGroupName,
                                                    String seasonSellingPointGroupName, String subCategoryTopLevelCategory) {

        Map<String, String> listofParams = new HashMap<>();
        listofParams.put("brand", brand);
        listofParams.put("season", season);
//        listofParams.put(WCM_SHOP_SUPER_CATEGORY, shopSuperCategory);
//        listofParams.put(WCM_GROUP_ID_NAME, groupIdName);
//        listofParams.put(WCM_SKU_ID, skuId);
//        listofParams.put(WCM_SUB_CATEGORY_NAME, subCategoryName);
//        listofParams.put(WCM_SKU_NAME, skuName);
//        listofParams.put(WCM_PERSISTENT_GROUP_NAME, persistentGroupName);
//        listofParams.put(WCM_REGULAR_GROUP_NAME, regularGroupName);
//        listofParams.put(WCM_GUIDED_GROUP_NAME, guidedGroupName);
//        listofParams.put(WCM_SELLING_POINT_GROUP_NAME, sellingPointGroupName);
//        listofParams.put(WCM_SEASON_SELLING_POINT_GROUP_NAME, seasonSellingPointGroupName);
//        listofParams.put(WCM_SUB_CATEGORY_TOP_LEVEL_CATEGORY, subCategoryTopLevelCategory);


//        for (Map.Entry<String, String> entry: listofParams.entrySet()) {
//
//            if (entry.getValue().equals("TRUE")){
//
//            }
//
//
//        }

        return null;







    }
}
