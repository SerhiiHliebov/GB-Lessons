package ru.gb.lessons.Lesson6.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BaseView{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @Step("Кликнуть на кнопку форма")
    public PracticeFormPage clickFormButton() {

        driver.findElement(By.xpath("//*[text()=\"Forms\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Practice Form\"]")).click();
        return new PracticeFormPage(driver);
    }
    @Step("Перейти в магазин")
    public StorePage clickGoToStoreButton() {

        WebElement element = driver.findElement(By.xpath("//*[@id=\"gotoStore\"]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return new StorePage(driver);
    }

}
