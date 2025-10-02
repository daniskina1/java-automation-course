package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test

    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactDate("test1", "test2", "test3", "test4"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContact();

    }
}
