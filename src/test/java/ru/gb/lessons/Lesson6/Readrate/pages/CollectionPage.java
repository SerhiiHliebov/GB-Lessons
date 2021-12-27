package ru.gb.lessons.Lesson6.Readrate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionPage extends BaseView{

    public CollectionPage(WebDriver driver) {
        super(driver);
    }

    public CollectionPage clickToCollectionButton() {

        try {
            WebElement button = driver.findElement(By.xpath("//*[@class=\"d-none d-md-block w-100\"]/ul/li[5]/a"));
            button.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath("//*[@class=\"d-none d-md-block w-100\"]/ul/li[5]/a"));
            button.click();
        }
        return new CollectionPage(driver);

    }

    public CollectionPage clickToCreateCollectionButton() {

        driver.findElement(By.xpath("//*[@class=\"btn btn-block btn-pb btn-primary\"]")).click();
        return new CollectionPage(driver);
    }

    public CollectionPage CollectionCategoriesAndNameCollection() {

        driver.findElement(By.xpath("//*[text()=\"Найти или добавить категорию\"]")).click();

        new WebDriverWait(driver,5,500).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Карантин 2020\"]")))
                .click();

        driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("covid");
        driver.findElement(By.xpath("//*[@class=\"btn btn-pb btn-primary hide\"]")).click();
        return new CollectionPage(driver);
    }

    public Checks createCollectionButton() {

        new WebDriverWait(driver,5,500).
                until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@value=\"Создать коллекцию\"]"))))
                .click();
        return new Checks(driver);
    }
}
