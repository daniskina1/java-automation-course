package addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class ContactDeletionTests extends TestBase {
    public boolean acceptNextAlert = true;


    @Test
    public void testContactDeletion() throws Exception {
        acceptNextAlert = true;
        app.getGroupHelper().wd.findElement(By.id("14")).click();
        app.getGroupHelper().wd.findElement(By.xpath("//input[@value='Delete']")).click();
        app.getGroupHelper().wd.switchTo().alert().accept();
    }


    }

