package ru.gb.lessons.Lesson5.Readrate;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.Lesson6.Listener.EventListener;

import java.util.concurrent.TimeUnit;
@ExtendWith(AllureJunit5.class)
public class BasicTest {

    public EventFiringWebDriver driver;
    public WebDriverWait webDriverWait;
    public String url = "https://readrate.com/rus";

    @BeforeEach
    void setUp() {
        driver = new EventFiringWebDriver(WebDriverManager.chromedriver().create());
        driver.register(new EventListener());
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 7);
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown() {

        for (LogEntry logEntry : driver.manage().logs().get(LogType.BROWSER))
            Allure.addAttachment("Console logs", logEntry.getMessage());
        driver.quit();
    }
}

