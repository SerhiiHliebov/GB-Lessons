package ru.gb.lessons.Lesson6.Listener;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static io.qameta.allure.Allure.step;

public class EventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        String stepName = "Нажать на элемент" + element.getText();
        step(stepName);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        String stepName = "Выполнено";
        step(stepName);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String stepName = "Ввести текст" + Arrays.toString(keysToSend) + "в поле с id = " + element.getAttribute("id");
        step(stepName);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String stepName = "Выполнено";
        step(stepName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        Allure.addAttachment("ScreenShot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}
