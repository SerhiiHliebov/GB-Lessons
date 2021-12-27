package ru.gb.lessons.Lesson6.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StorePage extends BaseView{

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public AddToCollectionPage searchBook() {

        driver.findElement(By.id("searchBox")).sendKeys("Eric Elliott");
        driver.findElement(By.xpath("//*[text()=\"Programming JavaScript Applications\"]")).click();
        return new AddToCollectionPage(driver);
    }


}
