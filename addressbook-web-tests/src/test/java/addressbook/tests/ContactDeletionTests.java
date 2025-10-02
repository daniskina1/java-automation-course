package addressbook.tests;

import org.junit.jupiter.api.Test;


public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.getContactHelper().selectContact("17");
        app.getContactHelper().deleteSelectedContact();
        app.acceptAlert();
    }
}

