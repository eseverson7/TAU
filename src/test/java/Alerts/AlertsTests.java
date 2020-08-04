package Alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertsTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJaveScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals( alertsPage.getResult(), "You successfuly clicked an alert", "Messages did not match");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJaveScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJaveScriptAlerts();
        alertsPage.triggerPrompt();

        String text = "TAU Rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Alert text incorrect");
    }



}
