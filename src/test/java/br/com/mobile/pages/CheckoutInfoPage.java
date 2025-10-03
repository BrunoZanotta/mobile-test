package br.com.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutInfoPage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Full Name* input field']")
    private WebElement fullNameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Address Line 1* input field']")
    private WebElement addressLine1Field;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Address Line 2 input field']")
    private WebElement addressLine2Field;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='City* input field']")
    private WebElement cityField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='State/Region input field']")
    private WebElement stateRegionField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Zip Code* input field']")
    private WebElement zipCodeField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Country* input field']")
    private WebElement countryField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To Payment']")
    private WebElement toPaymentButton;

    public CheckoutInfoPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fullNameField));
    }

    public void fillCheckoutForm(String fullName, String address1, String city, String zipCode, String country) {
        fullNameField.sendKeys(fullName);
        addressLine1Field.sendKeys(address1);
        cityField.sendKeys(city);
        zipCodeField.sendKeys(zipCode);
        countryField.sendKeys(country);
    }

    public void clickToPaymentButton() {
        toPaymentButton.click();
    }
}