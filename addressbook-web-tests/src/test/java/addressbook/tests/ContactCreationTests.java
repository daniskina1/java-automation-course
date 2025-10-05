package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {

            app.getContactHelper().initContactCreation();
            app.getContactHelper().fillContactForm(new ContactDate("test1", "test2", "test3", "test4","test1"), true);
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().returnToContact();
        }

}

