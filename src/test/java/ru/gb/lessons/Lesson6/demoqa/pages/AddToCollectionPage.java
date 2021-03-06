package ru.gb.lessons.Lesson6.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCollectionPage extends BaseView{

    public AddToCollectionPage(WebDriver driver) {
        super(driver);
    }
    @Step("Кликнуть на кнопку добавить в коллекцию")
    public void clickAddToYourCollectionButton() {

        WebElement element = driver.findElement(By.xpath("//*[text()=\"Add To Your Collection\"]"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", element);

    }
}
