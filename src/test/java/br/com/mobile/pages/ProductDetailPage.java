package br.com.mobile.pages;

// 1. Adicionamos a importação do AppiumBy
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    private final AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    private WebElement productName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='product price']")
    private WebElement productPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add To Cart']")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")
    private WebElement cartButton;

    public ProductDetailPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']")
        ));
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void addItemToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartButton.click();
    }
}