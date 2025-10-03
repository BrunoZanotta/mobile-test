package br.com.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage {

    private final WebDriverWait wait;
    private final By pageTitle = AppiumBy.xpath("//android.widget.TextView[@text='Checkout Complete']");
    private final By successMessage = AppiumBy.xpath("//android.widget.TextView[@text='Thank you for your order']");

    public CheckoutCompletePage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}