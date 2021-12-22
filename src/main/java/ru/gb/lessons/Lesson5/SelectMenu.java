package ru.gb.lessons.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectMenu {

    public static void main(String[] args) throws InterruptedException{

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver  = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        driver.get("https://demoqa.com/select-menu");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//      driver.manage().window().setSize(new Dimension(1024,820));
        driver.manage().window().maximize();


        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@id=\"withOptGroup\"]"))))
                .click();
        driver.findElement(By.xpath("//div[text()=\"Group 2, option 1\"]")).click();

        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.presenceOfElementLocated((By.id("selectOne"))))
                .click();
        driver.findElement(By.xpath("//div[text()=\"Mr.\"]")).click();

       new Select(driver.findElement(By.id("oldSelectMenu"))).selectByVisibleText("Black");
       driver.findElement(By.id("close-fixedban")).click();

        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[text()=\"Select...\"]"))))
                .click();
        new WebDriverWait(driver,10,500).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()=\"Red\"]"))))
                .click();

       new Select(driver.findElement(By.id("cars"))).selectByVisibleText("Opel");

        Thread.sleep(7000);
        driver.quit();

    }
}
