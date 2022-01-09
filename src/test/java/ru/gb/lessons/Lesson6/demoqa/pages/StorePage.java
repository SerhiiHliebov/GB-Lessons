package ru.gb.lessons.Lesson6.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;


public class StorePage extends BaseView{

    public StorePage(WebDriver driver) {
        super(driver);
    }
    @Step("Найти книгу")
    public AddToCollectionPage searchBook() {

        driver.findElement(By.id("searchBox")).sendKeys("Eric Elliott");
        driver.findElement(By.xpath("//*[text()=\"Programming JavaScript Applications\"]")).click();
        WebElement book = driver.findElement(By.xpath("//*[text()=\"Eric Elliott\"]"));
        assertThat(book.getText()).isEqualTo("Eric Elliott");
        return new AddToCollectionPage(driver);



    }


}
