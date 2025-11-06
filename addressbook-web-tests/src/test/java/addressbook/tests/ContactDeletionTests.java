package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        Contacts before = app.contact().all();
        ContactDate deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));

    }


}

