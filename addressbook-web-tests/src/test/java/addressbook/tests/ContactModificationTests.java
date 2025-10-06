package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test

    public void testContactModification() {
        if (! app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactDate("test1", "test2", "test3", "test4","test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactDate("test1", "test2", "test3", "test4", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContact();

    }
}
