import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


import static org.junit.Assert.assertEquals;

public class Exo1 {
    @Test
    public void TestEbay() {
        WebDriver driver = new ChromeDriver();
        /** go to URL **/
        driver.get("https://www.ebay.com/");
        /** find element Shop By Category  then click**/
        WebElement element = driver.findElement(By.id("gh-shop-a"));
        element.click();
        /** find element Kids Toys then click **/
        element = driver.findElement(By.xpath("//a[@href='https://www.ebay.com/b/Diecast-Toy-Vehicles/222/bn_1850842']"));
        element.click();
        /** find element Action as Brand than click **/
        List<WebElement> tabBrand = driver.findElements(By.className("b-guidancecard__title"));
        tabBrand.get(2).click();
        /** find element CAR then click **/
        element = driver.findElement(By.id("s0-16-13_2-0-1[1]-0-6-0-0[0]-multiselect[]_12"));
        element.click();
        /** find TOYOTA then click **/
        List<WebElement> carMarque = driver.findElements(By.className("b-guidancecard__title"));
        carMarque.get(1).click();
        /** Do the test **/
        assertEquals(driver.findElement(By.className("srp-controls__count-heading")).getText(), "1-7 of 7 Results");
        driver.close();

    }
}
