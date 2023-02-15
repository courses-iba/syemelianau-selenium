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
        excel.assertEqualFalse(0, excel.test_first_name);
        excel.changeColumnValue(0, excel.test_first_name);
        excel.assertEqualTrue(0, excel.test_first_name);
    }

    @Test
    public void updateMiddleName() throws IOException {
        excel.assertEqualFalse(1, excel.test_middle_name);
        excel.changeColumnValue(1, excel.test_middle_name);
        excel.assertEqualTrue(1, excel.test_middle_name);
    }

    @Test
    public void updateSurname() throws IOException {
        excel.assertEqualFalse(2, excel.test_surname);
        excel.changeColumnValue(2, excel.test_surname);
        excel.assertEqualTrue(2, excel.test_surname);
    }
}
