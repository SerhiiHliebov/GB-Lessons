package ru.gb.lessons.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Readrate
{


    public static void main(String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver  = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        driver.get("https://readrate.com/rus");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1024,820));
        driver.manage().window().maximize();

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

        Thread.sleep(7000);
        driver.quit();
    }
}
