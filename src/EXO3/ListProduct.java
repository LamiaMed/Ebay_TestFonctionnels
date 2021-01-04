package EXO3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListProduct {
    /** find all products by className **/
    @FindBy(className = "s-item__title")
    private List<WebElement> productName;
    WebDriver driver;

    public ListProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /** Function to find a product by its name ex "text" **/
    public void searchProduct(String text) {
        int i = 0;
        boolean cont = true;
        while (i < this.productName.size() && cont) {
            if (this.productName.get(i).getText().equals(text)) {
                productName.get(i).click();
                cont = false;
            }
            i++;
        }
    }
}
