package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test

    public void testContactModification() {
        List<ContactDate> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactDate("test1", "test2", "test3", "test4","test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactDate("test1", "test2", "test3", "test4", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContact();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after, before);




    }
}
