package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {
            Contacts before = app.contact().all();
            ContactDate contact = new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1");
            app.contact().create(contact);
            Contacts after = app.contact().all();
            assertThat(after.size(), equalTo(before.size() + 1));

            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
        }

}

