//java version "1.8.0_271"

//open page https://www.saucedemo.com/
//enter username
//enter password
//click log in
//add the a third item to the cart
//click button Add to card
//navigate to the cart 
//check out the item
//enter first name
//enter last name
//enter Postal code
//click continue 
//click finish
//assert for your order confirmed



package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;

public class SaucedemoTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private Faker faker;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        // Initialize Faker
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void endToEndSaucedemoTest() {
        // Test Data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String postalCode = faker.address().zipCode();

        // Test Steps

        // Open home page and log in
        loginPage.openHomePage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.signInUser();

        // Add the third item to the cart and navigate to the basket
        productsPage.addThirdProductToCart();
        productsPage.continueToBasket();

        // proceed to checkout
        cartPage.proceedToCheckout();

        // Enter personal details and complete checkout
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
        checkoutPage.goToTheNextPage();
        checkoutPage.completeTransaction();

        // Assert order confirmation
        String confirmationMessage = checkoutPage.getCompleteHeader();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals(confirmationMessage, expectedMessage, "Order confirmation header does not match!");
        System.out.println("Test Passed: Order confirmed with message - " + confirmationMessage);
    }
}