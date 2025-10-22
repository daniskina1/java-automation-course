package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;


public class ContactDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions () {
        if (!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactDate("test1", "test2", "test3", "test4", "test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptAlert();
        app.getContactHelper().returnToContact();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }
}

