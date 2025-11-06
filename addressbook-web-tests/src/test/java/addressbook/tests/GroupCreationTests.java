package addressbook.tests;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation()  {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        GroupDate group = new GroupDate().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo (before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
}

