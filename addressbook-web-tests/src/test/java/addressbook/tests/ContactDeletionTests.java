package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.GroupDate;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        int before = app.getContactHelper().getContactCount();
         if (! app.getContactHelper().isThereContact()) {
           app.getContactHelper().createContact(new ContactDate("test1", "test2", "test3", "test4","test1"));
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContact();
        app.acceptAlert();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}

