package ru.gb.lessons.Lesson5.demoqa;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class AppTest extends BasicTest {


    @Test
    void appTest() throws InterruptedException {

        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).click();
        driver.findElement(By.id("userName")).sendKeys("gleb");
        driver.findElement(By.id("password")).sendKeys("Deepmix1987@");
        driver.findElement(By.id("login")).click();

        driver.findElement(By.cssSelector("div:nth-child(2) > span > div > div.header-text > span > svg")).click();
        driver.findElement(By.xpath("//span[text()=\"Practice Form\"]")).click();

        driver.findElement(By.id("firstName")).sendKeys("Alexandr");
        driver.findElement(By.id("lastName")).sendKeys("Pushkin");
        driver.findElement(By.id("userEmail")).sendKeys("botvich08@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0501317788");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"hobbies-checkbox-2\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();

        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Home my Home");

        driver.findElement(By.xpath("//*[@id=\"close-fixedban\"]/img")).click();
        driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();


        Thread.sleep(7000);
    }

    @Test
    void urlTest() {
        driver.get(url);
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://demoqa.com/login");
    }

    @Test
    void authTest() {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).click();
        driver.findElement(By.id("userName")).sendKeys("gleb");
        driver.findElement(By.id("password")).sendKeys("Deepmix1987@");
        driver.findElement(By.id("login")).click();

        WebElement name = driver.findElement(By.xpath("//*[text()=\"User Name : \"]"));
        assertThat(name).descriptionText();
    }

    @Test
    void formTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Alexandr");
        driver.findElement(By.id("lastName")).sendKeys("Pushkin");
        driver.findElement(By.id("userEmail")).sendKeys("botvich08@gmail.com");
        driver.findElement(By.id("userNumber")).sendKeys("0501317788");
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Home my Home");

        WebElement strings = driver.findElement(By.xpath("//*[@id=\"firstName\"]")).findElement(By.xpath("//*[@id=\"lastName\"]"))
                    .findElement(By.xpath("//*[@id=\"userEmail\"]")).findElement(By.xpath("//*[@id=\"userNumber\"]"))
                    .findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        assertThat(strings).as("firstName", "Alexandr").as("lastName", "Pushkin")
                .as("userEmail", "botvich08@gmail.com").as("userNumber", "0501317788")
                .as("Current Address", "Home my Home");
    }
}
