package addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class ContactDeletionTests extends TestBase {
    private boolean acceptNextAlert = true;


    @Test
    public void testContactDeletion() throws Exception {
        acceptNextAlert = true;
        app.wd.findElement(By.id("10")).click();
        app.wd.findElement(By.xpath("//input[@value='Delete']")).click();
        app.wd.switchTo().alert().accept();
    }


    }

