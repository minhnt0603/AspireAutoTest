package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,30);
    }

    /** Capture web elements in Dashboard Page */
    @FindBy(how = How.XPATH, using = "//div[text()='Home']")
    WebElement TAB_HOME;
    @FindBy(how = How.XPATH, using = "//div[text()='More']")
    WebElement TAB_MORE;

    /** Actions on Dashboard Page */
    public DashboardPage navigateTo(String page) {
        wait.until(ExpectedConditions.elementToBeClickable(TAB_HOME));
        if (page.equalsIgnoreCase("more")) {
            TAB_MORE.click();
        } else if (page.equalsIgnoreCase("home")) {
            TAB_HOME.click();
        }
        return this;
    }
}
