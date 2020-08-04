package Alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.*;

public class ContextMenuTests extends BaseTests {

    private AlertsPage alertsPage;

    @Test
    public void testContextMenuDismissAlert(){
        var contextMenu = homePage.clickContextMenu();
        contextMenu.triggerContextMenuMessage();
        assertEquals(contextMenu.getAlertText(), "You selected a context menu", "Alert text is incorrect.");
        System.out.println(contextMenu.getAlertText());
        contextMenu.alert_clickToAccept();
    }
}
