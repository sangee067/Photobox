package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.GitHubApiPage;

import static org.testng.Assert.assertTrue;

public class GitHubApiSteps extends GitHubApiPage {

    @Given("^user sends \"([^\"]*)\" request to see a specific user \"([^\"]*)\" details$")
    public void user_sends_request_to_see_specific_user_details(String method, String username) {
         getRequestForUserDetailsList(username);
    }

    @Then("^user should see name property matches with user \"([^\"]*)\"$")
    public void user_should_see_name_property_matches_with_user(String username) {
        assertTrue(verifyNamePropertyMatchesWithUsername(username), "Check - Name matches with Username");
    }
}
