package ru.gb.lessons.Lesson6.demoqa.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseView {

    protected WebDriver driver;

    public BaseView(WebDriver driver) {
        this.driver = driver;
    }
}


