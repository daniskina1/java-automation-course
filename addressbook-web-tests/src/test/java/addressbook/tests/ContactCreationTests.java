package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.GroupDate;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {
            List<ContactDate> before = app.getContactHelper().getContactList();
            ContactDate contact = new ContactDate("test1", "test2", "test3", "test4","test1");
            app.getContactHelper().createContact(contact);
            List<ContactDate> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() + 1);

            before.add(contact);
            Comparator<? super ContactDate> byName =
                    (c1, c2) -> c1.lastname().compareToIgnoreCase(c2.lastname());
            before.sort(byName);
            after.sort(byName);
            Assert.assertEquals(before, after);
        }

}

