package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {

            app.initContactCreation();
            app.fillContactForm(new ContactDate("test1", "test2", "test3", "test4"));
            app.submitContactCreation();
            app.returnToContact();
        }

}

