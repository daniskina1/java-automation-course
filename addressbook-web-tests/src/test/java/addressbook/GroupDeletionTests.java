package addressbook;

import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        gotoGroupPage();
        selectGroup();
        deleteSelectGroup();
        returnToGroupPage();
    }

}
