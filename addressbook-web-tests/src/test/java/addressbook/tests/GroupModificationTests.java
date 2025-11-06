package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeEach
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupDate> before = app.group().all();
        GroupDate modifiedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
