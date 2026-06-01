package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @FindBy(id = "login_field")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement loginBtn;

    public void login(String user, String pass) {
        signInButton.click();
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();

    }
}