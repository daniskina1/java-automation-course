package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1"));
        }
    }
    @Test
    public void testContactModification() {
        Set<ContactDate> before = app.contact().all();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate()
                .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
        app.contact().modify(contact);
        Set<ContactDate> after = app.contact().all();

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);



    }


}
