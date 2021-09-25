package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UsersAndAccessPage {
    WebDriver driver;
    WebDriverWait wait;
    /**
     * Capture web elements on Users and Access Page
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Invite new user')]")
    WebElement BUTTON_INVITE_NEW_USER;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter user’s first and last name']")
    WebElement FIELD_NEW_USER_FULL_NAME;
    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    WebElement FIELD_NEW_USER_EMAIL;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Director (according to ACRA)')]/parent::div//*[@focusable='false']")
    WebElement RADIO_BUTTON_DIRECTOR;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Non-director')]/parent::div//*[@focusable='false']")
    WebElement RADIO_BUTTON_NON_DIRECTOR;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Choose their access role')]//ancestor::button")
    WebElement BUTTON_CHOOSE_ACCESS_ROLE;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Choose role')]")
    WebElement LABEL_CHOOSE_ROLE;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Only for legal company directors')]/parent::div")
    WebElement AREA_ROLE_ADMIN;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Suited for finance team, team leads')]/parent::div")
    WebElement AREA_ROLE_FINANCE;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Great for team members')]/parent::div")
    WebElement AREA_ROLE_CARD_ONLY;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign to send invite')]//ancestor::button")
    WebElement BUTTON_SIGN_TO_SEND_INVITE;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']//following-sibling::div")
    WebElement CHECKBOX_I_AGREE;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign contract')]//ancestor::button")
    WebElement BUTTON_SIGN_CONTRACT;
    @FindBy(how = How.XPATH, using = "//div[text()='Pending']")
    WebElement TAB_PENDING;
    @FindBy(how = How.XPATH, using = "//div[text()='Active']")
    WebElement TAB_ACTIVE;
    @FindBy(how = How.XPATH, using = "//div[@class='col ellipsis']//div[@class='invitations-list-item__name ellipsis text-bold text-h6 text-secondary']")
    WebElement INVITED_USER_NAME;
    @FindBy(how = How.XPATH, using = "//div[@class='col ellipsis']/div[@class='q-mt-xs text-secondary-light ellipsis']")
    WebElement INVITED_USER_EMAIL;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Verification pending')]")
    WebElement TEXT_VERIFICATION_PENDING;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Settings')]")
    WebElement TAB_SETTINGS;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Revoke access')]//parent::div[@class='q-item__label']")
    WebElement AREA_REVOKE_ACCESS;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Revoke')]//ancestor::button")
    WebElement BUTTON_REVOKE;
    @FindBy(how = How.XPATH, using = "//img[contains(@src,'empty-canvas')]")
    WebElement IMAGE_EMPTY_CANVAS;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Transfer without limits')]")
    WebElement AREA_TRANSFER_WITHOUT_LIMIT;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Submit only')]")
    WebElement AREA_SUBMIT_ONLY;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'No transfer rights')]")
    WebElement AREA_NO_TRANSFER_RIGHTS;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Yes, issue a debit card')]")
    WebElement AREA_ISSUE_DEBIT_CARD;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'No, debit card not needed')]")
    WebElement AREA_NO_ISSUE_DEBIT_CARD;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue')]//ancestor::button")
    WebElement BUTTON_CONTINUE;

    public UsersAndAccessPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    /**
     * Actions on Users and Access Page
     */
    public UsersAndAccessPage inviteNewMember(String fullName, String emailAddress, String roleInCom,
                                              String role, String bankTransferRights, String isIssueDebitCard) {
        wait.until((ExpectedConditions.elementToBeClickable(TAB_ACTIVE)));
        TAB_ACTIVE.click();

        // Click button Invite new user
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_INVITE_NEW_USER));
        BUTTON_INVITE_NEW_USER.click();

        // Enter user name, email and select role in company
        wait.until(ExpectedConditions.elementToBeClickable(FIELD_NEW_USER_FULL_NAME));
        FIELD_NEW_USER_FULL_NAME.sendKeys(fullName);
        FIELD_NEW_USER_EMAIL.sendKeys(emailAddress);
        if (roleInCom.equalsIgnoreCase("director")) {
            RADIO_BUTTON_DIRECTOR.click();
        } else {
            RADIO_BUTTON_NON_DIRECTOR.click();
        }

        // Click button Choose their access role
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_CHOOSE_ACCESS_ROLE));
        BUTTON_CHOOSE_ACCESS_ROLE.click();

        // Select role
        wait.until(ExpectedConditions.elementToBeClickable(LABEL_CHOOSE_ROLE));

        // Handle flow role = Admin
        if (role.equalsIgnoreCase("admin")) {
            AREA_ROLE_ADMIN.click();
        }
        // Handle flow role = Finance
        else if (role.equalsIgnoreCase("finance")) {
            AREA_ROLE_FINANCE.click();
            wait.until(ExpectedConditions.elementToBeClickable(AREA_TRANSFER_WITHOUT_LIMIT));
            if (bankTransferRights.equalsIgnoreCase("transfer without limit")){
                AREA_TRANSFER_WITHOUT_LIMIT.click();
            } else if (bankTransferRights.equalsIgnoreCase("submit only")){
                AREA_SUBMIT_ONLY.click();
            } else if (bankTransferRights.equalsIgnoreCase("no transfer rights")){
                AREA_NO_TRANSFER_RIGHTS.click();
            }

            wait.until(ExpectedConditions.elementToBeClickable(AREA_ISSUE_DEBIT_CARD));
            if (isIssueDebitCard.equalsIgnoreCase("yes")) {
                AREA_ISSUE_DEBIT_CARD.click();
                wait.until(ExpectedConditions.visibilityOf(BUTTON_CONTINUE));
                BUTTON_CONTINUE.click();
            } else {
                AREA_NO_ISSUE_DEBIT_CARD.click();
            }
        }
        // Handle flow role = Card-only
        else if (role.equalsIgnoreCase("card-only")) {
            AREA_ROLE_CARD_ONLY.click();
            wait.until(ExpectedConditions.visibilityOf(BUTTON_CONTINUE));
            BUTTON_CONTINUE.click();
        }

        // Click button Sign to send invite
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_SIGN_TO_SEND_INVITE));
        BUTTON_SIGN_TO_SEND_INVITE.click();

        // Check to Agreement checkbox then send the invitation
        wait.until(ExpectedConditions.visibilityOf(CHECKBOX_I_AGREE));
        CHECKBOX_I_AGREE.click();

        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_SIGN_CONTRACT));
        BUTTON_SIGN_CONTRACT.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException ie) {
        }
        return this;
    }

    public UsersAndAccessPage validateUserIsInvitedSuccessfully(String userName, String email) {
        // Switch Tab "Pending"
        wait.until(ExpectedConditions.elementToBeClickable(TAB_PENDING));
        TAB_PENDING.click();

        String invitedName = INVITED_USER_NAME.getText();
        String invitedEmail = INVITED_USER_EMAIL.getText();

        Assert.assertEquals(invitedName, userName);
        Assert.assertEquals(invitedEmail, email);
        return this;
    }

    public UsersAndAccessPage revokeTheInvitation() {
        wait.until(ExpectedConditions.elementToBeClickable(TEXT_VERIFICATION_PENDING));
        TEXT_VERIFICATION_PENDING.click();

        wait.until(ExpectedConditions.visibilityOf(TAB_SETTINGS));
        TAB_SETTINGS.click();

        wait.until(ExpectedConditions.visibilityOf(AREA_REVOKE_ACCESS));
        AREA_REVOKE_ACCESS.click();

        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_REVOKE));
        BUTTON_REVOKE.click();

        wait.until(ExpectedConditions.visibilityOf(IMAGE_EMPTY_CANVAS));
        return this;
    }
}
