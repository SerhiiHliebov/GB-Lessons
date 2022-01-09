package ru.gb.lessons.Lesson6.demoqa.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.Lesson5.Readrate.BasicTest;
import ru.gb.lessons.Lesson6.Readrate.pages.LoginPage;

@DisplayName("Readrate Test")
public class ReadrateTest extends BasicTest {

    private final String username = "botvich08@gmail.com";
    private final String password = "Deepmix";

    @Test
    @DisplayName("Создать коллекцию")
    @Description("В этом тесте создаем коллекцию и проверяем, логин и имя коллекции")
    @Severity(SeverityLevel.BLOCKER)
    void CreateCollectionTest() {

        driver.get(url);
        new LoginPage(driver).login(username, password)
                .checkLogin("Serhii Hliebov")
                .clickToCollectionButton()
                .clickToCreateCollectionButton()
                .CollectionCategoriesAndNameCollection()
                .createCollectionButton()
                .checkCollectionName("covid");
    }
}

