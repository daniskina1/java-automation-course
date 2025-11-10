package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase {
    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactDate().withFirstname("test1").withLastname("test2").withMobile("test3").withEmail("test4").withGroup("test1"));
        }
    }
    @Test
    public void testContactEmails() {
        app.goTo().gotoHomePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditFrom = app.contact().infoFromEditFrom(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditFrom)));
    }

    private String mergeEmails(ContactDate contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactEmailTest::cleanedEmail)
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedEmail(String email) {
        return email.trim();
    }
}
