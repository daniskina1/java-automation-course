package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.util.Set;


public class ContactDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        Set<ContactDate> before = app.contact().all();
        ContactDate deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }


}

