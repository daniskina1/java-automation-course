package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupDate("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupDate> before = app.group().list();
        int index = before.size() - 1;
        GroupDate group = new GroupDate(before.get(index).getId(),"test1", "test2", "test3");
        app.group().modify(index, group);
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
