package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GistEditPage extends BasePage {

    public GistEditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "gist[description]")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[contains(.,'Update')]")
    private WebElement updateGistButton;

    public void updateDescription(String newDescription) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField));

        descriptionField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        descriptionField.sendKeys(Keys.DELETE);
        descriptionField.sendKeys(newDescription);
    }

    public void clickUpdateGist() {
        wait.until(ExpectedConditions.elementToBeClickable(updateGistButton)).click();
    }

    public void editDescription(String newDescription) {
        updateDescription(newDescription);
        clickUpdateGist();
    }
}