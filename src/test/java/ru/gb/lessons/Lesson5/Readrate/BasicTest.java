package ru.gb.lessons.Lesson5.Readrate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public String url = "https://readrate.com/rus";

    @BeforeEach
    void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 7);
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

