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
    private final String current_dir = System.getProperty("user.dir");
    private final String file_path = current_dir + "\\users.xlsx";
    private final String template_path = current_dir + "\\users_template.xlsx";
    private final int firstRow = 1;
    private Workbook wb;

    public final String test_first_name = "Ivan", test_middle_name = "Ivanovich", test_surname = "Ivanov";

    public void setTemplateData() throws IOException {
        FileInputStream fs = new FileInputStream(template_path);
        Workbook wb = new XSSFWorkbook(fs);
        FileOutputStream fos = new FileOutputStream(file_path);
        wb.write(fos);
        fos.close();
    }

    private Workbook openFile() throws IOException {
        FileInputStream fs = new FileInputStream(file_path);
        return new XSSFWorkbook(fs);
    }

    public void changeColumnValue(int column, String value) throws IOException {
        wb = openFile();
        Sheet sheet = wb.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i <= lastRow; ++i) {
            Row row = sheet.getRow(i);
            System.out.println(row.getCell(column));
            Cell cell = row.createCell(column);

            cell.setCellValue(value);
            System.out.println(row.getCell(column));
        }

        FileOutputStream fos = new FileOutputStream(file_path);
        wb.write(fos);
        fos.close();
    }

    public void assertEqualFalse(int column, String test_data) throws IOException {
        wb = openFile();
        Sheet sheet = wb.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i <= lastRow; ++i) {
            Row row = sheet.getRow(i);
            assertNotEquals(test_data, row.getCell(column).toString());
        }
    }

    public void assertEqualTrue(int column, String test_data) throws IOException {
        wb = openFile();
        Sheet sheet = wb.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int i = firstRow; i <= lastRow; ++i) {
            Row row = sheet.getRow(i);
            assertEquals(test_data, row.getCell(column).toString());
        }
    }
}
