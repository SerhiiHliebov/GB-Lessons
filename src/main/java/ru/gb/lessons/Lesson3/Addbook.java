package ru.gb.lessons.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Addbook {

    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver  = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        driver.get("https://demoqa.com/login");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1024,820));
        driver.manage().window().maximize();

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


        driver.quit();
    }
}
