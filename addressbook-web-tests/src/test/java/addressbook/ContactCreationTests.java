package addressbook;

import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {

            initContactCreation();
            fillContactForm(new ContactDate("test1", "test2", "test3", "test4"));
            submitContactCreation();
            returnToContact();
        }

}

