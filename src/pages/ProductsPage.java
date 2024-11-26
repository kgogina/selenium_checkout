package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By addToCartButton = By.xpath("(//div[@class='inventory_item']//button)[3]");
    private By basketIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addThirdProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void continueToBasket() {
        driver.findElement(basketIcon).click();
    }
}
