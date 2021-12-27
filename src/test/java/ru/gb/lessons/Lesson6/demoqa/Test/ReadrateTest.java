package ru.gb.lessons.Lesson6.demoqa.Test;

import org.junit.jupiter.api.Test;
import ru.gb.lessons.Lesson5.Readrate.BasicTest;
import ru.gb.lessons.Lesson6.Readrate.pages.LoginPage;

public class ReadrateTest extends BasicTest {

    private final String username = "botvich08@gmail.com";
    private final String password = "Deepmix";

    @Test
    void CreateCollectionTest() {

        driver.get(url);
        new LoginPage(driver).login(username, password)
                .checkLogin("Serhii Hliebov")
                .clickToCollectionButton()
                .clickToCreateCollectionButton()
                .CollectionCategoriesAndNameCollection()
                .createCollectionButton()
                .checkCollectionName("covid");
    }
}
