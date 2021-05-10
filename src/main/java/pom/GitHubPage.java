package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverService;

public class GitHubPage extends WebDriverService {

    @FindBy(linkText = "Sign up")
    public WebElement signUpButton;
    @FindBy(id = "user_login")
    public WebElement usernameTextField;
    @FindBy(className = "error")
    public WebElement usernameErrorMsg;

    private static String user = null;

    public boolean verifySignUpButtonText() {
        driver.get("https://github.com/");
        waitForElement(signUpButton, 10);
        return (signUpButton.getText().equalsIgnoreCase("Sign Up"));
    }

    public void clickSignUpButton() {
        clickOnElement(signUpButton, "Sign Up");
    }

    public void enterText(String username) {
        user = username;
        enterValueInTextField(usernameTextField, username);
    }

    public boolean verifyUsernameValidationMessage() {
        boolean check = false;
        if (driver.findElements(By.className("error")).size() > 0) {
            String text = usernameErrorMsg.getText();
            System.out.println(" Validation message :: \n" + text);
            if (text.contains("Username " + user + " is not available."))
                check = true;
        }
        return check;
    }
}


