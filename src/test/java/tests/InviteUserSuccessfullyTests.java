package tests;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.*;
import utils.GlobalVariables;

public class InviteUserSuccessfullyTests extends TestBase {

    private String USER_NAME = "Testing";
    private String EMAIL = "aspiretest1@testing.com";

    @BeforeClass(alwaysRun = true)
    public void login() {
        // init web pages
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        EnterPINPage enterPINPage = PageFactory.initElements(driver, EnterPINPage.class);
        DashboardPage dashBoardPage= PageFactory.initElements(driver, DashboardPage.class);
        MorePage morePage = PageFactory.initElements(driver, MorePage.class);

        // Login
        loginPage.login(GlobalVariables.USERNAME);
        enterPINPage.enterPIN();

        // Navigate to Users and Access page
        dashBoardPage.navigateTo(GlobalVariables.TAB_MORE);
        morePage.openPage(GlobalVariables.TAB_USERS_AND_ACCESS);
    }

    @DataProvider(name="roleInCompany")
    public Object[][] roleInCompany(){
        return new Object[][]
                {
                        { "Director", "Admin", null, null},
                        { "Director", "Finance", "Transfer Without Limit", "Yes"},
                        { "Director", "Finance", "Submit Only", "No"},
                        { "Director", "Finance", "No Transfer Rights", "Yes"},
                        { "Director", "Card-only", "Transfer Without Limit", "No" },
                        { "Director", "Card-only", "Submit Only", "Yes" },
                        { "Director", "Card-only", "No Transfer Rights", "No"},
                        { "Non-director", "Finance", "Transfer Without Limit", "No" },
                        { "Non-director", "Finance", "Submit Only", "Yes" },
                        { "Non-director", "Finance", "No Transfer Rights", "No" },
                        { "Non-Director", "Card-only", "Transfer Without Limit", "Yes" },
                        { "Non-Director", "Card-only", "Submit Only", "No" },
                        { "Non-Director", "Card-only", "No Transfer Rights", "Yes"},
                };

    }

    @Test(dataProvider="roleInCompany", priority = 0)
    public void inviteUserSuccessfully(String roleInCom, String role,
                                       String bankTransferRights, String isIssueDebitCard ) {
        // init web pages
        UsersAndAccessPage usersAndAccessPage = PageFactory.initElements(driver, UsersAndAccessPage.class);

        // Invite new user
        usersAndAccessPage.inviteNewMember(USER_NAME,EMAIL,roleInCom,role,bankTransferRights,isIssueDebitCard);

        // Verify that user is invited successfully
        usersAndAccessPage.validateUserIsInvitedSuccessfully(USER_NAME,EMAIL);

        // Revoke invitation to clean up data
        usersAndAccessPage.revokeTheInvitation();
    }
}
