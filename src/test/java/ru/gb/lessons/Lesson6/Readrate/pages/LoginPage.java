package ru.gb.lessons.Lesson6.Readrate.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Авторизация на сайте")
    public Checks login(String Email, String Password) {

        driver.findElement(By.xpath("//*[@class=\"signin signin-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"readRateLoginEmail\"]")).sendKeys(Email);
        driver.findElement(By.xpath("//*[@id=\"readRateLoginPassword\"]")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"readRateLoginSubmit\"]")).click();
        return new Checks(driver);

    }
}
