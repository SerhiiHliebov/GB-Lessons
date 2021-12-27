package ru.gb.lessons.Lesson6.demoqa.Test;

import org.junit.jupiter.api.Test;
import ru.gb.lessons.Lesson5.demoqa.BasicTest;
import ru.gb.lessons.Lesson6.demoqa.pages.LoginPage;

public class DemoqaTest extends BasicTest {

    private final String username = "gleb";
    private final String password = "Deepmix1987@";

    @Test
    void AddBookTest() {

        driver.get(url);
        new LoginPage(driver).login(username, password)
                .clickGoToStoreButton()
                .searchBook()
                .clickAddToYourCollectionButton();
    }

    @Test
    void PracticeFormTest() {

        driver.get(url);
        new LoginPage(driver).login(username, password)
                .clickFormButton()
                .FillStudentRegistrationForm()
                .clickSubmitButton("Thanks for submitting the form");
    }
}