package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorFrameId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditoriFrame();
        driver.findElement(textArea).clear();
        exitEditorFrame();
    }

    public void setTextArea(String text){
        switchToEditoriFrame();
        driver.findElement(textArea).sendKeys(text);
        exitEditorFrame();
    }

    public String getTextFromEditor(){
        switchToEditoriFrame();
        String text = driver.findElement(textArea).getText();
        exitEditorFrame();
        return text;
    }

    private void switchToEditoriFrame() {
        driver.switchTo().frame(editorFrameId);
    }

    private void exitEditorFrame(){
        driver.switchTo().parentFrame();
    }

    public void decreaseIndentation(){
        driver.findElement(decreaseIndentButton);
    }

}
