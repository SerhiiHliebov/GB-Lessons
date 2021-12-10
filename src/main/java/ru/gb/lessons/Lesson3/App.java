package ru.gb.lessons.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.System.*;


public class App 
{


    public static void main(String[] args ) throws InterruptedException {

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
        driver.quit();
    }
}
