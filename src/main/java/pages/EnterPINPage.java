package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class EnterPINPage {
    WebDriver driver;
    WebDriverWait wait;

    public EnterPINPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,30);
    }

    /** Capture web elements in Enter PIN Page */
    @FindBy(how = How.XPATH, using = "//div[@class='password-input__input-box flex items-start justify-center password-input__input-box--current']")
    WebElement FIELD_PIN;

    /** Actions on Enter PIN Page */
    public EnterPINPage enterPIN() {
        wait.until(ExpectedConditions.visibilityOf(FIELD_PIN));
        String[] pin_digit = GlobalVariables.PIN.split("");
        for (String digit : pin_digit) {
            Actions actions = new Actions(driver);
            Action key = actions.sendKeys(digit).build();
            key.perform();
        }
        return this;
    }
}
