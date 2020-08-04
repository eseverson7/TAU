package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By contextMenuBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerContextMenuMessage(){
        WebElement menuBox = driver.findElement(contextMenuBox);
        Actions actions = new Actions(driver);
        actions.contextClick(menuBox);
        actions.perform();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

}
