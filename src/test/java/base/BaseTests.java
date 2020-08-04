package base;

import Utils.EventReporter;
import Utils.WindowManager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);
    }

//    private WebDriver driver;
//    protected HomePage homePage;
//
//    @BeforeClass
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        //    driver.manage().window().setSize(new Dimension(375, 675));
//        driver.get("https://the-internet.herokuapp.com/");
//
//        homePage = new HomePage(driver);
//    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        setCookie();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + "_" + timeStamp
                        + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobar");
      //  options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123").domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }

//    public static void main(String args[]){
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
}
