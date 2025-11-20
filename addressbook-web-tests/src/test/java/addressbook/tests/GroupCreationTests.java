package addressbook.tests;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    public static Stream<Arguments> validGroups() throws IOException {
        String xml;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"))) {
            xml = reader.lines().collect(Collectors.joining());
        }
        XStream xstream = new XStream();
        // Настройка безопасности для XStream
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{GroupDate.class});
        xstream.alias("group", GroupDate.class);

        List<GroupDate> groups = (List<GroupDate>) xstream.fromXML(xml);
        return groups.stream().map(Arguments::of);
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

    @Disabled
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

