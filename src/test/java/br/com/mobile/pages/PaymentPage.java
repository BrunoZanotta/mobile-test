package br.com.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final By fullNameField = AppiumBy.xpath("//android.widget.EditText[@content-desc='Full Name* input field']");
    private final By cardNumberField = AppiumBy.xpath("//android.widget.EditText[@content-desc='Card Number* input field']");
    private final By expirationDateField = AppiumBy.xpath("//android.widget.EditText[@content-desc='Expiration Date* input field']");
    private final By securityCodeField = AppiumBy.xpath("//android.widget.EditText[@content-desc='Security Code* input field']");
    private final By reviewOrderButton = AppiumBy.xpath("//android.widget.TextView[@text='Review Order']");

    public PaymentPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(fullNameField));
    }

    public void fillPaymentFormAndContinue(String fullName, String cardNumber, String expDate, String securityCode) {
        WebElement nameElement = wait.until(ExpectedConditions.elementToBeClickable(fullNameField));
        nameElement.sendKeys(fullName);

        WebElement cardElement = wait.until(ExpectedConditions.elementToBeClickable(cardNumberField));
        cardElement.sendKeys(cardNumber);

        WebElement expDateElement = wait.until(ExpectedConditions.elementToBeClickable(expirationDateField));
        expDateElement.sendKeys(expDate);

        WebElement securityCodeElement = wait.until(ExpectedConditions.elementToBeClickable(securityCodeField));
        securityCodeElement.sendKeys(securityCode);

        WebElement reviewButtonElement = wait.until(ExpectedConditions.elementToBeClickable(reviewOrderButton));
        reviewButtonElement.click();
        reviewButtonElement.click();
    }
}