package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.util.Set;

public class GroupDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {

        Set<GroupDate> before = app.group().all();
        GroupDate deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }



}
