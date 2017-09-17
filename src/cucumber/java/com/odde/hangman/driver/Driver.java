package com.odde.hangman.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Driver {

    private static final String HOST_NAME_PREFIX = "http://localhost:";
    private static final int DEFAULT_TIME_OUT_IN_SECONDS = 10;
    private final WebDriver webDriver = new ChromeDriver();
    @Value("${cucumber.port}")
    private String port;
    @Value("${cucumber.context-path}")
    private String contextPath;

    public void close() {
        webDriver.close();
    }

    public void navigateTo(String url) {
        webDriver.get(urlWithHostAndPort(url));
        webDriver.switchTo().window(webDriver.getWindowHandle());
    }

    public void waitForTextPresent(String text) {
        try {
            new WebDriverWait(webDriver, DEFAULT_TIME_OUT_IN_SECONDS).until(
                    (ExpectedCondition<Boolean>) webDriver -> getAllTextInPage().contains(text));
        } catch (TimeoutException e) {
            throw new TimeoutException(textNotFoundMessage(text));
        }
    }

    private String textNotFoundMessage(String text) {
        return String.format("Timed out after %d seconds waiting for \"%s\"", DEFAULT_TIME_OUT_IN_SECONDS, text);
    }

    public void inputTextByName(String text, String name) {
        elementByName(name).sendKeys(text);
    }

    private WebElement elementByName(String name) {
        return webDriver.findElement(By.name(name));
    }

    public void clickByText(String text) {
        firstElementByText(text).click();
    }

    private WebElement firstElementByText(String text) {
        return elementsByText(text)
                .findFirst().<NoSuchElementException>orElseThrow(() -> {
                    throw new NoSuchElementException(String.format("no element can be found by text: %s", text));
                });
    }

    private Stream<WebElement> elementsByText(String text) {
        return Stream.of(
                elementsByXPath(String.format("//input[@value='%s']", text)),
                elementsByXPath(String.format("//button[text()='%s']", text)),
                elementsByLinkText(text))
                .flatMap(Collection::stream);
    }

    private List<WebElement> elementsByLinkText(String text) {
        return webDriver.findElements(By.linkText(text));
    }

    private List<WebElement> elementsByXPath(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }

    public String getAllTextInPage() {
        return elementByTag().getText();
    }

    private WebElement elementByTag() {
        return webDriver.findElement(By.tagName("body"));
    }

    private String urlWithHostAndPort(String url) {
        return HOST_NAME_PREFIX + port + contextPath + url;
    }
}
