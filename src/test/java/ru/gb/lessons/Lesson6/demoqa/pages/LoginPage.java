package ru.gb.lessons.Lesson6.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Авторизация на сайте")
    public ProfilePage login(String username, String password) {

        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath("//*[@id=\"close-fixedban\"]/img")).click();
        return new ProfilePage(driver);

    }
}
