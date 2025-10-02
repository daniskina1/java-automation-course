package addressbook.appmanager;

import addressbook.model.ContactDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public boolean acceptNextAlert = true;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void returnToContact() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactDate contactDate) {
        type(By.name("firstname"),contactDate.firstname());
        type(By.name("middlename"),contactDate.middlename());
        type(By.name("mobile"),contactDate.mobile());
        type(By.name("email"),contactDate.email());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
        wd.get("http://localhost/addressbook/edit.php");
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact(String id) {
        click(By.id(id));
    }
}
