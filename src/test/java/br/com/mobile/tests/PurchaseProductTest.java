package br.com.mobile.tests;

import br.com.mobile.setup.TestRule;
import br.com.mobile.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseProductTest extends TestRule {

    @Test(description = "Executa e valida o fluxo completo de compra de um produto")
    public void testCompleteSingleProductPurchaseAndValidationFlow() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectSauceLabsBackpack();

        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        Assert.assertEquals(productDetailPage.getProductName(), "Sauce Labs Backpack");
        productDetailPage.addItemToCart();
        productDetailPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
        cartPage.proceedToCheckout();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("bob@example.com", "10203040");

        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.fillCheckoutForm("Bruno Zanotta", "Rua dos Testes, 123", "Porto Alegre", "90000-000", "Brazil");
        checkoutInfoPage.clickToPaymentButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentFormAndContinue("Bruno Zanotta", "1234567890123456", "03/25", "123");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        checkoutOverviewPage.placeOrder();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String mensagemEsperada = "Thank you for your order";
        String mensagemAtual = checkoutCompletePage.getSuccessMessage();
        Assert.assertEquals(mensagemAtual, mensagemEsperada, "A mensagem de sucesso da compra não foi exibida corretamente.");
    }
}