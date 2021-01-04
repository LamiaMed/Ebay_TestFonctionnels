package EXO3;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;

public class TestCases {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUpBeforeClass() {
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void testCases() {

        HomePage homePage = new HomePage(driver);
        /** search for "shoes for men" **/
        homePage.searchInEbay("shoes for men");
        homePage.submitSearch();
        ListProduct product = new ListProduct(driver);
        /** Select a product **/
        product.searchProduct("Mens Womens Converse Shoes All Star Low High Tops Chuck Taylor Trainers Sneaker");
        SelectedProduct selectedProd = new SelectedProduct(driver);
        /** Select properties  and add to cart**/
        selectedProd.selectProperties("UK 4", "Navy Hi");
        selectedProd.addToCart();
        CartPayment cart = new CartPayment(driver);
        cart.goToPayment();
        String price = cart.readTotalPrice();
        /** Test**/
        assertEquals(price, "GBP 38.98");
        driver.close();
    }

}
