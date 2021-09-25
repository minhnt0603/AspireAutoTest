package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.GlobalVariables;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Initialize() {
        System.setProperty("webdriver.chrome.driver", "./src/main/java/drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.navigate().to(GlobalVariables.ASPIRE_URL);
    }

    @AfterClass
    public void CleanUp() {
        if (driver != null) {
            driver.close();
        }
    }
}
