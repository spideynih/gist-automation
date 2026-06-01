package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "svg[aria-label='Create new gist']")
    private WebElement createGistButton;

    @FindBy(css = "button[aria-label='View profile and more']")
    private WebElement profileAvatar;

    @FindBy(xpath = "//a[normalize-space()='Your gists']")
    private WebElement yourGistsMenu;

    @FindBy(xpath = "//h1[contains(.,'Discover gists')]")
    private WebElement discoverGistsTitle;

    public boolean isDashboardDisplayed() {
        return discoverGistsTitle.isDisplayed();
    }

    public boolean isLoggedIn() {
        return wait.until(
                ExpectedConditions.visibilityOf(createGistButton)
        ).isDisplayed();
    }

    public void clickCreateGist() {
        wait.until(
                ExpectedConditions.elementToBeClickable(createGistButton)
        );
        createGistButton.click();
    }

    public void openProfileMenu() {
        wait.until(
                ExpectedConditions.elementToBeClickable(profileAvatar)
        );
        profileAvatar.click();
    }

    // ===== FIXED METHOD UNTUK “YOUR GISTS” =====
    public void clickYourGists() {

        // 1. klik avatar dan tunggu menu muncul
        wait.until(ExpectedConditions.elementToBeClickable(profileAvatar)).click();

        wait.until(ExpectedConditions.visibilityOf(yourGistsMenu));
        wait.until(ExpectedConditions.elementToBeClickable(yourGistsMenu));

        // 2. klik aman pakai try-catch + fallback JS
        try {
            yourGistsMenu.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", yourGistsMenu);
        }
    }
}