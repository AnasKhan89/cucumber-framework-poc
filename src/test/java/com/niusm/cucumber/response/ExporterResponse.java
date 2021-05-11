package com.niusm.cucumber.response;

import org.apache.poi.ss.usermodel.Workbook;

public final class ExporterResponse {
    private final Workbook workbook;
    private final String messages;
    private final boolean exportStatus;

    /**
     * Create an exporter response object.
     * @param exportStatus indicating exporter tool's success or failure
     * @param messages from the exporter tool
     * @param exportedWorkbook object representing an exported spreadsheet
     */
    public ExporterResponse(Boolean exportStatus, String messages, Workbook exportedWorkbook) {
        this.exportStatus = exportStatus;
        this.messages = messages;
        this.workbook = exportedWorkbook;
    }

    /**
     * Get returned workbook.
     * Please take care to not mutate this workbook.
     * @return workbook representing spreadsheet
     */
    public Workbook getWorkbook() {
        return workbook;
    }

    /**
     * Get returned messages included in response.
     * @return messages returned by the exporter tool
     */
    public String getMessages() {
        return messages;
    }

    /**
     * Get status of the request.
     * @return exportStatus of the exporter tool
     */
    public boolean isSuccessful() {
        return exportStatus;
    }
}
