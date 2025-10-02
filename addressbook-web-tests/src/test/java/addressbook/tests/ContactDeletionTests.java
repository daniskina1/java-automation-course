package addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.selectContact();
        app.deleteSelectedContact();
        app.acceptAlert();
    }
}

