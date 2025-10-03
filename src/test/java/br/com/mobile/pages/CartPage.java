package br.com.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='product label']")
    private WebElement productName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='counter amount']/android.widget.TextView")
    private WebElement productQuantity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='total price']")
    private WebElement totalPrice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Proceed To Checkout button']")
    private WebElement proceedToCheckoutButton;

    public CartPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductQuantity() {
        return productQuantity.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}