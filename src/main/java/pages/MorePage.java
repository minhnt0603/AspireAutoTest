package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MorePage {
    WebDriver driver;
    WebDriverWait wait;

    public MorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,30);
    }

    /** Capture web elements on More Page */
    @FindBy(how = How.XPATH, using = "//div[@class='settings-page__user-name text-bold']")
    WebElement LABEL_USER_FULL_NAME;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Users and Access')]")
    WebElement LABEL_USERS_AND_ACCESS;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'My Accounts')]")
    WebElement LABEL_MY_ACCOUNTS;

    /** Actions on More Page */
    public MorePage openPage(String page) {
        wait.until(ExpectedConditions.elementToBeClickable(LABEL_USER_FULL_NAME));
        if (page.equalsIgnoreCase("users and access")) {
            LABEL_USERS_AND_ACCESS.click();
        } else if (page.equalsIgnoreCase("my accounts")) {
            LABEL_MY_ACCOUNTS.click();
        }
        return this;
    }
}
