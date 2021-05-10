package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pom.GitHubPage;
import utils.WebDriverService;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GitHubSteps extends WebDriverService {

    private GitHubPage gitHubPage = PageFactory.initElements(driver, GitHubPage.class);

    @Given("^User is on the Home page$")
    public void User_is_on_the_Home_page() {
        assertTrue(gitHubPage.verifySignUpButtonText(), "Verify HomePage is Displayed");
    }

    @When("^User clicks on the SignUp button$")
    public void user_clicks_on_the_SignUp_button() {
        gitHubPage.clickSignUpButton();
    }

    @Then("^User should be navigated to the create account page$")
    public void user_should_be_navigated_to_the_create_account_page() {
        assertTrue(driver.getCurrentUrl().contains("/join"), "Verify Create account page is opened");
    }

    @And("^User enters username \"([^\"]*)\"$")
    public void user_enters_username(String name) {
        gitHubPage.enterText(name);
    }

    @Then("^User should see the \"([^\"]*)\" validation in the Create Account page$")
    public void user_should_see_the_validation_in_the_Create_Account_page(String message) {
        if (message.equalsIgnoreCase("Username is not available")) {
            assertTrue(gitHubPage.verifyUsernameValidationMessage(), "Verify Validation Message is displayed");
        }  else if (message.equalsIgnoreCase("Success")) {
            assertFalse(gitHubPage.verifyUsernameValidationMessage(), "Verify Validation Message is NOT displayed");
        }
    }
}
