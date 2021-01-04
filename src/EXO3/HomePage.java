package EXO3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    /** find checkbox to search things **/
    @FindBy(className = "ui-autocomplete-input")
    private WebElement searchBox;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /** Function to search a "text" **/
    public void searchInEbay(String text) {

        this.searchBox.sendKeys(text);

    }
    /** Function to submit search Box value **/
    public void submitSearch() {

        this.searchBox.submit();
    }
}
