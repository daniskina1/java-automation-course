package addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class ContactDeletionTests extends TestBase {
    public boolean acceptNextAlert = true;


    @Test
    public void testContactDeletion() throws Exception {
        selectContact();
        deleteSelectedContact();
        acceptAlert();
    }

    public void acceptAlert() {
        app.getGroupHelper().wd.switchTo().alert().accept();
    }

    public void deleteSelectedContact() {
        app.getGroupHelper().wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        acceptNextAlert = true;
        app.getGroupHelper().wd.findElement(By.id("14")).click();
    }


}

