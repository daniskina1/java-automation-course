package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupDate("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        GroupDate group = new GroupDate(before.get(index).getId(),"test1", "test2", "test3");
        app.getGroupHelper().modifyGroup(index, group);
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
