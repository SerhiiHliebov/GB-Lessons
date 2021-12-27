package ru.gb.lessons.Lesson6.Readrate.pages;

import org.openqa.selenium.WebDriver;

public class BaseView {

    protected WebDriver driver;

    public BaseView(WebDriver driver) {
        this.driver = driver;
    }
}
