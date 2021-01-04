package EXO3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPayment {
    @FindBy(className = "gh-cart-icon")
    private WebElement cartIcon;
    @FindBy(xpath = "//div[@class='val-col total-row']")
    private WebElement price;
    WebDriver driver;

    public CartPayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /** Function to click on the cart icon and open list payments **/
    public void goToPayment() {
        this.cartIcon.click();

    }
    /** Function to get total payment in the cart page **/
    public String readTotalPrice() {
        return this.price.getText();
    }
}
