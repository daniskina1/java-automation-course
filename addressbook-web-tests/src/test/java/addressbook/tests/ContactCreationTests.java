package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {
            int before = app.getContactHelper().getContactCount();
            app.getContactHelper().selectContactCreation();
            app.getContactHelper().fillContactForm(new ContactDate("test1", "test2", "test3", "test4","test1"), true);
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().returnToContact();
            int after = app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before + 1);
        }

}

