package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions () {
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1"));
        }
    }
    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate()
                .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }

}
