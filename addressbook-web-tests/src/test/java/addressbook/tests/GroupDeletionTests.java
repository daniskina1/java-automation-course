package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;

public class GroupDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupDate("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {

        List<GroupDate> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }



}
