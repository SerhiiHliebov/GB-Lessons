package ru.gb.lessons.Lesson6.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeFormPage extends BaseView{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    @Step("Заполнить форму")
    public PracticeFormPage FillStudentRegistrationForm() {

        driver.findElement(By.id("firstName")).sendKeys("Alexandr");
        driver.findElement(By.id("lastName")).sendKeys("Pushkin");
        driver.findElement(By.id("userEmail")).sendKeys("botvich08@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0501317788");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"hobbies-checkbox-2\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();

        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Home my Home");
        return new PracticeFormPage(driver);

    }
    @Step("Кликнуть на кнопку Submit")
    public void clickSubmitButton(String name) {

        driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
        WebElement text = driver.findElement(By.xpath("//*[text()=\"Thanks for submitting the form\"]"));
        assertThat(text.getText()).isEqualTo("Thanks for submitting the form");

    }
}
