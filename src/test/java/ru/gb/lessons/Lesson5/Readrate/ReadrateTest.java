package ru.gb.lessons.Lesson5.Readrate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


public class ReadrateTest extends BasicTest{

    @Test
    void readRateTest() {
        
        driver.get(url);
        driver.findElement(By.xpath("//*[@class=\"signin signin-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"readRateLoginEmail\"]")).sendKeys("botvich08@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginPassword\"]")).sendKeys("Deepmix");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginSubmit\"]")).click();

        try {
            WebElement button = driver.findElement(By.xpath("//*[@class=\"d-none d-md-block w-100\"]/ul/li[5]/a"));
            button.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath("//*[@class=\"d-none d-md-block w-100\"]/ul/li[5]/a"));
            button.click();
        }

        driver.findElement(By.xpath("//*[@class=\"btn btn-block btn-pb btn-primary\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Найти или добавить категорию\"]")).click();

        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Карантин 2020\"]")))
                .click();

        driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("covid");
        driver.findElement(By.xpath("//*[@class=\"btn btn-pb btn-primary hide\"]")).click();

        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@value=\"Создать коллекцию\"]"))))
                .click();
    }

    @Test
    void TitleTest() {

        driver.get(url);
        String Title = driver.getTitle();
        assertEquals(Title, "Лучшие книги и книжные новости, серии, авторы, коллекции на сайте ReadRate.");
    }

    @Test
    void createCollectionTest() {

        driver.get("https://readrate.com/rus/collections/create");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginEmail\"]")).sendKeys("botvich08@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginPassword\"]")).sendKeys("Deepmix");
        driver.findElement(By.xpath("//*[@id=\"readRateLoginSubmit\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Найти или добавить категорию\"]")).click();

        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Карантин 2020\"]")))
                .click();

        driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("covid");
        driver.findElement(By.xpath("//*[@class=\"btn btn-pb btn-primary hide\"]")).click();

        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@value=\"Создать коллекцию\"]"))))
                .click();

        WebElement collection = driver.findElement(By.xpath("//*[text()=\"Добавить книги в коллекцию\"]"));
        assertThat(collection.getText()).isEqualTo("Добавить книги в коллекцию");

    }
}
