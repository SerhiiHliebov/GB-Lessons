package ru.gb.lessons.Lesson6.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage login(String username, String password) {

        driver.findElement(By.id("userName")).sendKeys("gleb");
        driver.findElement(By.id("password")).sendKeys("Deepmix1987@");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath("//*[@id=\"close-fixedban\"]/img")).click();
        return new ProfilePage(driver);

    }
}
