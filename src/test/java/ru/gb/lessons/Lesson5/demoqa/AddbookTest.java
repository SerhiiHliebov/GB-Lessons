package ru.gb.lessons.Lesson5.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;

public class AddbookTest extends BasicTest {


    @Test
    void addbookTest() {

        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).click();
        driver.findElement(By.id("userName")).sendKeys("gleb");
        driver.findElement(By.id("password")).sendKeys("Deepmix1987@");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath("//*[@id=\"close-fixedban\"]/img")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"gotoStore\"]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        driver.findElement(By.id("searchBox")).sendKeys("Eric Elliott");
        driver.findElement(By.xpath("//*[text()=\"Programming JavaScript Applications\"]")).click();

        WebElement element1 = driver.findElement(By.xpath("//*[text()=\"Add To Your Collection\"]"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", element1);
    }

    @Test
    void addBookToCollectionTest() {
        driver.get("https://demoqa.com/books");
        driver.findElement(By.id("searchBox")).sendKeys("Eric Elliott");

        WebElement book = driver.findElement(By.id("searchBox"));
        assertThat(book).descriptionText();
    }
}
