package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.junit.jupiter.api.Test;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactCreationTests extends TestBase {

        @Test
        public void testContactCreation() throws Exception {
            Contacts before = app.contact().all();
            File photo = new File("src/test/resources/stru.png");
            ContactDate contact = new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1").withPhoto(photo);
            app.contact().create(contact);
            Contacts after = app.contact().all();
            assertThat(after.size(), equalTo(before.size() + 1));

            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
        }

}

