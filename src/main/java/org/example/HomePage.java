package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    private final Locator city = page.getByRole(AriaRole.SEARCHBOX).first();
    private final Locator firstOption = page.getByRole(AriaRole.OPTION).first();
    private final Locator temperature = page.locator(".temperature--font");

    public HomePage(Page page) {
        super(page);
    }

    public void chooseCity(String value) {
        city.fill(value);
        firstOption.click();
    }

    public String getCityTemperature() {
        return temperature.textContent();
    }

}
