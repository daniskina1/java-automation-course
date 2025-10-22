package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;

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

}
