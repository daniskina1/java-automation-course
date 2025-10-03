package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.Browser;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(Browser.CHROME.browserName());

    @BeforeEach
    public void setUp()  {
        app.init();
    }

    @AfterEach
    public void tearDown()  {
        app.stop();
    }

}
