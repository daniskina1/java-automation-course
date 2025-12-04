package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import addressbook.model.GroupDate;
import addressbook.model.Groups;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME.browserName());

    @BeforeAll
    public static void setUp() throws Exception {
        app.init();
    }

    @AfterAll
    public static void tearDown() throws Exception {
        app.stop();
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupDate().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }
}
