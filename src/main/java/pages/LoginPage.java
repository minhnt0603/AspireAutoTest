package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,30);
    }

    /** Capture web elements on Login Page */
    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    WebElement FIELD_EMAIL_OR_PHONE;
    @FindBy(how = How.XPATH, using = "//span[text()='Next']")
    WebElement BUTTON_NEXT;

    /** Actions on Login Page */
    public LoginPage login(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(FIELD_EMAIL_OR_PHONE));
        FIELD_EMAIL_OR_PHONE.sendKeys(username);
        BUTTON_NEXT.click();
        return this;
    }
}
