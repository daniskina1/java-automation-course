package addressbook.tests;

import addressbook.model.GroupDate;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation()  {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupDate("test1", "test2", "test3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}

