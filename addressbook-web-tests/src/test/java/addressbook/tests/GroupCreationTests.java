package addressbook.tests;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

    public static Stream<Arguments> validGroupsFromXml() throws IOException {
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

    public static Stream<Arguments> validGroupsFromJson() throws IOException {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        Gson gson = new Gson();
        List<GroupDate> groups = gson.fromJson(json.toString(), new TypeToken<List<GroupDate>>(){}.getType());
        return groups.stream().map(Arguments::of);
    }


    @ParameterizedTest
    @MethodSource("validGroupsFromJson")
    public void testGroupCreation( GroupDate group)  {
        logger.info("Start test testGroupCreation");
        app.goTo().GroupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo (before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        logger.info("Stop test testGroupCreation");

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

