package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private String formAuthentication = "Form Authentication";
    private String dropdown = "Dropdown";
    private String hovers = "Hovers";
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        clickLink(formAuthentication);
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink(dropdown);
        return new DropdownPage(driver);
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public HoversPage clickHovers(){
        clickLink(hovers);
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public AlertsPage clickJaveScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDomPage(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
}
