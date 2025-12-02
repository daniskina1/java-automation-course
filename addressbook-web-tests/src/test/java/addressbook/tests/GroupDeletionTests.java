package addressbook.tests;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {
    @BeforeEach
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {

        Groups before = app.db().groups();
        GroupDate deletedGroup = before.iterator().next();
        app.goTo().GroupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo (before.size() - 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletedGroup)));


    }



}
