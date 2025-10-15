package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.GroupDate;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {
            List<ContactDate> before = app.getContactHelper().getContactList();
            app.getContactHelper().selectContactCreation();
            app.getContactHelper().fillContactForm(new ContactDate("test1", "test2", "test3", "test4","test1"), true);
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().returnToContact();
            List<ContactDate> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() + 1);
        }

}

