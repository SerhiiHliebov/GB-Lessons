package ru.gb.lessons.Lesson6.Readrate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Checks extends BaseView{

    public Checks(WebDriver driver) {
        super(driver);
    }

    public CollectionPage checkLogin(String name) {
        driver.findElement(By.xpath("//*[@class=\"user-link\"]"));
        assertThat(name).isEqualTo("Serhii Hliebov");
        return new CollectionPage(driver);
    }

    public CollectionPage checkCollectionName(String name) {
        driver.findElement(By.xpath("//h1[text()=\"covid\"]"));
        assertThat(name).isEqualTo("covid");
        return new CollectionPage(driver);
    }
}
