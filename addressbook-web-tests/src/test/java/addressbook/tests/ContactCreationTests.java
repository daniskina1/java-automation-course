package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.util.Set;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {
            Set<ContactDate> before = app.contact().all();
            ContactDate contact = new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
            app.contact().create(contact);
            Set<ContactDate> after = app.contact().all();
            Assert.assertEquals(after.size(), before.size() + 1);

            contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt());
            before.add(contact);
            Assert.assertEquals(before, after);
        }

}

