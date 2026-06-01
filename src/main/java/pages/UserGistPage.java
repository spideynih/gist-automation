package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserGistPage extends BasePage {

    public UserGistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.gist-snippet")
    private List<WebElement> gistList;

    @FindBy(css = "div.gist-snippet a[href*='/']")
    private List<WebElement> gistLinks;

    @FindBy(css = "strong.css-truncate-target")
    private List<WebElement> gistTitles;

    public boolean isGistListDisplayed() {
        return !gistList.isEmpty();
    }

    public void openLatestGist() {
        if (gistLinks.isEmpty()) {
            throw new RuntimeException("No gist found");
        }
        gistLinks.get(0).click();
    }

    public void openGistByFilename(String filename) {
        for (WebElement gist : gistTitles) {
            if (gist.getText().trim().equals(filename)) {
                gist.click();
                return;
            }
        }
        throw new RuntimeException("Gist not found: " + filename);
    }
}