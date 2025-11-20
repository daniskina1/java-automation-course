package addressbook.tests;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;



import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    public static Stream<GroupDate> validGroups() {
        return Stream.of(
                new GroupDate().withName("test1").withHeader("header1").withFooter("footer1"),
                new GroupDate().withName("test2").withHeader("header2").withFooter("footer2"),
                new GroupDate().withName("test3").withHeader("header3").withFooter("footer3")
        );
    }


    @ParameterizedTest
    @MethodSource("validGroups")
    public void testGroupCreation( GroupDate group)  {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo (before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadGroupCreation()  {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        GroupDate group = new GroupDate().withName("test2'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo (before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));

    }
}

