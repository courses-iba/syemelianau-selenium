package com.example.seleniumframework;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.testng.Assert.*;

public class WriteIntoExcel {
    private final String CURRENT_DIR = System.getProperty("user.dir");
    private final String FILE_PATH = CURRENT_DIR + "\\users.xlsx";
    private final String TEMPLATE_PATH = CURRENT_DIR + "\\users_template.xlsx";
    private final int START_ROW = 1;

    private FileInputStream fs;
    private FileOutputStream fos;
    private Workbook wb;

    public final String FIRST_NAME = "Ivan", MIDDLE_NAME = "Ivanovich", LAST_NAME = "Ivanov";
    public final int FIRST_NAME_COLUMN = 0, MIDDLE_NAME_COLUMN = 1, LAST_NAME_COLUMN = 2;

    public void setTemplateData() throws IOException {
        fs = new FileInputStream(TEMPLATE_PATH);
        wb = new XSSFWorkbook(fs);

        fos = new FileOutputStream(FILE_PATH);
        wb.write(fos);
        fos.close();

        closeFile();
    }

    private void openFile() throws IOException {
        fs = new FileInputStream(FILE_PATH);
        wb = new XSSFWorkbook(fs);
    }

    private void closeFile() throws IOException {
        wb.close();
        fs.close();
    }

    public void changeColumnValue(int column, String value) throws IOException {
        openFile();

        Sheet sheet = wb.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int i = START_ROW; i <= lastRow; ++i) {
            Row row = sheet.getRow(i);
            System.out.println(row.getCell(column));
            Cell cell = row.createCell(column);

            cell.setCellValue(value);
            System.out.println(row.getCell(column));
        }

        fos = new FileOutputStream(FILE_PATH);
        wb.write(fos);
        fos.close();

        closeFile();
    }

    public void assertEqualFalse(int column, String test_data) throws IOException {
        openFile();

        Sheet sheet = wb.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int i = START_ROW; i <= lastRow; ++i) {
            Row row = sheet.getRow(i);
            assertNotEquals(test_data, row.getCell(column).toString());
        }

        closeFile();
    }

    public void assertEqualTrue(int column, String test_data) throws IOException {
        openFile();

        Sheet sheet = wb.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int i = START_ROW; i <= lastRow; ++i) {
            Row row = sheet.getRow(i);
            assertEquals(test_data, row.getCell(column).toString());
        }

        closeFile();
    }
}
