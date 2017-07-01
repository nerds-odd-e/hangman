package com.odde.hangman.driver;

public interface Driver {
    void close();

    void navigateTo(String url);

    void waitForTextPresent(String text);

    void inputTextByName(String text, String name);

    void clickByText(String text);

    String getAllTextInPage();
}
