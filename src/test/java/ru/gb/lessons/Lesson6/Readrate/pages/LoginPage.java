package ru.gb.lessons.Lesson6.Readrate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public Checks login(String Email, String Password) {

        driver.findElement(By.xpath("//*[@class=\"signin signin-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"readRateLoginEmail\"]")).sendKeys("botvich08@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginPassword\"]")).sendKeys("Deepmix");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginSubmit\"]")).click();
        return new Checks(driver);

    }
}
