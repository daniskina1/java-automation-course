package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void setUp()  {
        app.init();
    }

    @AfterEach
    public void tearDown()  {
        app.stop();
    }

}
