package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By example1 = By.cssSelector(".example > a ");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickExample1(){
        driver.findElement(example1).click();
        System.out.println("Woot!");
    }

}
