package com.example.seleniumjunit;

import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class Tools {
    public static boolean containsClass(WebElement checkbox, String className) {
        return Arrays.asList(checkbox.getAttribute("class").split(" ")).contains(className);
    }
}
