package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().list().isEmpty()) {
            app.contact().create(new ContactDate("test1", "test2", "test3", "test4","test1"));
        }
    }
    @Test
    public void testContactModification() {
        List<ContactDate> before = app.contact().list();
        int index = before.size() -1;
        ContactDate contact = new ContactDate("test1", "test2", "test3", "test4", null);

        app.contact().modify(contact);
        List<ContactDate> after = app.contact().list();

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactDate> byName =
                (c1, c2) -> c1.lastname().compareToIgnoreCase(c2.lastname());
        before.sort(byName);
        after.sort(byName);
        Assert.assertEquals(before, after);



    }


}
