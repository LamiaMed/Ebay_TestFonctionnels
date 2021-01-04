import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Exo2 {
    @Test
    public void TestEbay() {
        int i = 0;
        /** Variable to test in while **/
        boolean cont = true;
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        /** find search Box **/
        WebElement element = driver.findElement(By.className("ui-autocomplete-input"));
        /** search for "shoes for men" **/
        element.sendKeys("shoes for men");
        element.submit();
        /** Get products list by ClassName **/
        List<WebElement> product = driver.findElements(By.className("s-item__title"));
        while (i < product.size() && cont) {
            /** find the right product **/
            if (product.get(i).getText().equals("Mens Womens Converse Shoes All Star Low High Tops Chuck Taylor Trainers Sneaker")) {
                product.get(i).click();
                cont = false;
            }
            i++;
        }
        /** Select size **/
        element = driver.findElement(By.xpath("//*[contains(text(), 'UK 4')]"));
        element.click();
        /** Select color **/
        element = driver.findElement(By.xpath("//*[contains(text(), 'Navy Hi')]"));
        element.click();
        /** Add product to cart**/
        element = driver.findElement(By.id("isCartBtn_btn"));
        element.click();
        /** Open cart page**/
        element = driver.findElement(By.className("gh-cart-icon"));
        element.click();
        /** Test prices**/
        assertEquals(driver.findElement(By.xpath("//div[@class='val-col total-row']")).getText(), "GBP 38.98");
        driver.close();
    }
}
