package ru.gb.lessons.Lesson6.demoqa.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.Lesson5.demoqa.BasicTest;
import ru.gb.lessons.Lesson6.demoqa.pages.LoginPage;

@DisplayName("Demoqa Test")
public class DemoqaTest extends BasicTest {

    private final String username = "gleb";
    private final String password = "Deepmix1987@";

    @Test
    @DisplayName("Добавить книгу в коллекцию")
    @Description("В этом тесте находим книгу и добавляем ее в коллекцию, проверяем имя книги")
    @Severity(SeverityLevel.BLOCKER)
    void AddBookTest() {

        driver.get(url);
        new LoginPage(driver).login(username, password)
                .clickGoToStoreButton()
                .searchBook()
                .clickAddToYourCollectionButton();
    }

    @Test
    @DisplayName("Заполнить форму")
    @Description("В этом тесте заполняем форму и проверяем, что форма заполнена")
    @Severity(SeverityLevel.BLOCKER)
    void PracticeFormTest() {

        driver.get(url);
        new LoginPage(driver).login(username, password)
                .clickFormButton()
                .FillStudentRegistrationForm()
                .clickSubmitButton("Thanks for submitting the form");
    }
}