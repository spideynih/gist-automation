package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GistDetailPage extends BasePage {

    public GistDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'note') and contains(.,'Created')]")
    private WebElement createdLabel;

    @FindBy(xpath = "//span[text()='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//span[@class='Button-label'][text()='Delete']")
    private WebElement deleteButton;

    @FindBy(name = "gist[description]")
    private WebElement descriptionField;

    @FindBy(name = "gist[contents][][name]")
    private WebElement filenameField;

    @FindBy(id = "code-editor")
    private WebElement codeEditor;

    @FindBy(xpath = "//button[normalize-space()='Update public gist']")
    private WebElement updatePublicGistButton;

    public boolean isGistCreated() {
        return createdLabel.isDisplayed();
    }

    public void clickEdit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
    }

    public String getGistDescription() {
        return descriptionField.getAttribute("value");
    }

    public String getFilename() {
        return filenameField.getAttribute("value");
    }

    public void updateContent(String newContent) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(codeEditor));
        codeEditor.click();
        codeEditor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        codeEditor.sendKeys(Keys.DELETE);
        codeEditor.sendKeys(newContent);
    }

    public void clickUpdateGist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(updatePublicGistButton));
        updatePublicGistButton.click();
    }

    public void deleteGist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}