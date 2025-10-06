package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.GroupDate;
import org.junit.jupiter.api.Test;


public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
         if (! app.getContactHelper().isThereContact()) {
           app.getContactHelper().createContact(new ContactDate("test1", "test2", "test3", "test4","test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.acceptAlert();
    }
}

