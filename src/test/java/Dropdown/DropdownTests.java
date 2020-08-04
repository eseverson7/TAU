package Dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

    @Test
    public void testSelectOptions(){
        var dropDownPage = homePage.clickDropDown();
        dropDownPage.selectMultipleValuesFromDropdown();
        String option1 = "Option 1";
        String option2 = "Option 2";
        dropDownPage.selectFromDropdown2("1");
        dropDownPage.selectFromDropdown2("2");
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 2, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), "Option not selected");
        assertTrue(selectedOptions.contains(option1), "Option not selected");
    }
}
