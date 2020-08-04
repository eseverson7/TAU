package WysiwygEditor;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WysiwygEditorTests extends BaseTests {

    @Test
    public void enterTextWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndentation();
        editorPage.setTextArea(text2);
        
        assertEquals( editorPage.getTextFromEditor(), "hello world", "Messages did not match");
    }
}
