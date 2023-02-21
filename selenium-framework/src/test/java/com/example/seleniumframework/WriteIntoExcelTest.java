package com.example.seleniumframework;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class WriteIntoExcelTest {
    WriteIntoExcel excel = new WriteIntoExcel();

    @BeforeMethod
    public void setUpFile() throws IOException {
        excel.setTemplateData();
    }

    @Test
    public void updateFirstName() throws IOException {
        excel.assertEqualFalse(excel.FIRST_NAME_COLUMN, excel.FIRST_NAME);
        excel.changeColumnValue(excel.FIRST_NAME_COLUMN, excel.FIRST_NAME);
        excel.assertEqualTrue(excel.FIRST_NAME_COLUMN, excel.FIRST_NAME);
    }

    @Test
    public void updateMiddleName() throws IOException {
        excel.assertEqualFalse(excel.MIDDLE_NAME_COLUMN, excel.MIDDLE_NAME);
        excel.changeColumnValue(excel.MIDDLE_NAME_COLUMN, excel.MIDDLE_NAME);
        excel.assertEqualTrue(excel.MIDDLE_NAME_COLUMN, excel.MIDDLE_NAME);
    }

    @Test
    public void updateSurname() throws IOException {
        excel.assertEqualFalse(excel.LAST_NAME_COLUMN, excel.LAST_NAME);
        excel.changeColumnValue(excel.LAST_NAME_COLUMN, excel.LAST_NAME);
        excel.assertEqualTrue(excel.LAST_NAME_COLUMN, excel.LAST_NAME);
    }
}
