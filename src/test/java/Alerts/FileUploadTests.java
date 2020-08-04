package Alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.*;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:/Users/DEVTOPIA/Desktop/testautomation/resources/chromedriver.exe");
        assertEquals(uploadPage.getUploadedFileText(), "chromedriver.exe", "Incorrect Upload message.");
    }

}
