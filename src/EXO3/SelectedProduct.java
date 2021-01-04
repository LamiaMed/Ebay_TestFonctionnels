package EXO3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProduct {

    private WebElement size;
    private WebElement color;
    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCartButton;
    WebDriver driver;

    public SelectedProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /** Function to choose properties for a product: color and size **/
    public void selectProperties(String prop1, String prop2) {
        this.size = driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", prop1)));
        this.size.click();
        this.color = this.driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", prop2)));
        this.color.click();

    }
    /** Function to add selected product to cart **/
    public void addToCart() {
        this.addToCartButton.click();

    }
}
