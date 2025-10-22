package addressbook.tests;

import addressbook.model.ContactDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;


public class ContactDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions () {
        if (app.contact().list().isEmpty()) {
            app.contact().create(new ContactDate("test1", "test2", "test3", "test4", "test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        List<ContactDate> before = app.contact().list();
        int index = before.size() -1;
        app.contact().delete();
        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}

