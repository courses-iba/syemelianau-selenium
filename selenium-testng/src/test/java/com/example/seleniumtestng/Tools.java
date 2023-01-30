package com.example.seleniumtestng;

import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class Tools {
    public static boolean checkboxIsActive(WebElement checkbox) {
        return Arrays.asList(checkbox.getAttribute("class").split(" ")).contains(Wildberries.cb_active_cls);
    }
}
