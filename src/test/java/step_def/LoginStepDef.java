package step_def;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.BrowserUtils;

public class LoginStepDef {
    LoginPage login = new LoginPage();


    @Given("navigate and verify landing page")
    public void navigate_and_verify_landing_page() {
        login.navigateLandingPage();
        BrowserUtils.waitFor(2);
    }

    @When("click Sign in button")
    public void click_Sign_in_button() {
        login.clickSignIn();
        BrowserUtils.waitFor(2);
    }

    @When("Enter the valid credentials mobile {string} and password {string}")
    public void enter_the_valid_credentials_mobile_and_password(String mobile, String password) {
        login.enterCredentials(mobile,password);
        BrowserUtils.waitFor(2);
    }

    @When("click login")
    public void click_login() {
        login.login();
        BrowserUtils.waitFor(2);
    }

    @Then("verify successful login")
    public void verify_successful_login() {
        login.verifyLogin();
        BrowserUtils.waitFor(2);
    }

    @Then("verify {string} txt and detail {string}")
    public void verify_txt_and_detail(String error, String errorDetails) {
        login.verifyErrorLoginWithInvalidCred(error,errorDetails);
        BrowserUtils.waitFor(2);
    }

    @When("click account icon")
    public void click_account_icon() {
        login.clickAccountIconAndSelectMyAccount();
        BrowserUtils.waitFor(2);
    }

    @Then("verify account details page and click edit account")
    public void verify_account_details_page_and_click_edit_account() {
        login.verifyAccountDetailsAndClickEditButton();
        BrowserUtils.waitFor(2);
    }

    @Then("enter new email to email input and click save button")
    public void enter_new_email_to_email_input_and_click_save_button() {
        login.enterNewEmailAndClickSave();
        BrowserUtils.waitFor(2);
    }

    @Then("verify email is updated")
    public void verify_email_is_updated() {
        login.emailUpdateVerification();
        BrowserUtils.waitFor(2);
    }
}
