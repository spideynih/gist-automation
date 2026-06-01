package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateGistPage extends BasePage {

    public CreateGistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "gist[description]")
    private WebElement descriptionField;

    @FindBy(name = "gist[contents][][name]")
    private WebElement filenameField;

    @FindBy(css = ".CodeMirror-code")
    private WebElement codeMirrorInput;

    @FindBy(css = "summary.select-menu-button")
    private WebElement gistTypeDropdown;

    @FindBy(id = "gist_public_1")
    private WebElement publicGistOption;

    @FindBy(xpath = "//button[normalize-space()='Create public gist']")
    private WebElement createPublicGistButton;

    public void enterDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void enterFilename(String filename) {
        wait.until(ExpectedConditions.visibilityOf(filenameField));
        filenameField.clear();
        filenameField.sendKeys(filename);
    }

    public void enterContent(String content) {

        wait.until(ExpectedConditions.elementToBeClickable(codeMirrorInput));

        codeMirrorInput.click();
        codeMirrorInput.sendKeys(Keys.CONTROL + "a");
        codeMirrorInput.sendKeys(Keys.DELETE);
        codeMirrorInput.sendKeys(content);
    }

    public void selectPublicGist() {
        gistTypeDropdown.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", publicGistOption);
    }

    public void clickCreatePublicGist() {
        createPublicGistButton.click();
    }

    public void createPublicGist(
            String description,
            String filename,
            String content) {

        enterDescription(description);
        enterFilename(filename);
        enterContent(content);
        selectPublicGist();
        clickCreatePublicGist();
    }
}