package addressbook;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactCreationTests extends TestBase {

        @Test
        public void testUntitledTestCase() throws Exception {

            initContactCreation();
            fillContactForm(new ContactDate("test1", "test2", "test3", "test4"));
            submitContactCreation();
            returnToContact();
        }

    public void returnToContact() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactDate contactDate) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactDate.firstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactDate.middlename());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactDate.mobile());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactDate.email());
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
        wd.get("http://localhost/addressbook/edit.php");
    }
}

