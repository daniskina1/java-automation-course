package addressbook.appmanager;

import addressbook.model.ContactDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactHelper extends HelperBase {
    public boolean acceptNextAlert = true;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void returnToContact() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.firstname());
        type(By.name("lastname"), contactDate.lastname());
        type(By.name("mobile"), contactDate.mobile());
        type(By.name("email"), contactDate.email());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.group());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContactCreation() {
        click(By.linkText("add new"));
        wd.get("http://localhost/addressbook/edit.php");
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact( ) {
        click(By.xpath("//table[@id='maintable']//tr[2]/td[1]/input"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void createContact(ContactDate contact) {
        selectContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContact();
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']//tr[2]/td[1]/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactDate> getContactList() {
        List<ContactDate> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[not(@class='header')]"));
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                continue;
            }
            String[] name = elements.get(i).getText().split("\\s");
            ContactDate contact = new ContactDate(
                    getByIndexOrNull(name, 1),
                    getByIndexOrNull(name, 0),
                    getByIndexOrNull(name, 3),
                    getByIndexOrNull(name, 2),
                    getByIndexOrNull(name, 4));
            contacts.add(contact);
        }
        return contacts;
    }

    private String getByIndexOrNull(String[] s, int index) {
        if (index > s.length - 1) {
            return null;
        }
        return s[index];
    }
    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void modifyContact(ContactDate contact) {
        selectContact();
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        returnToContact();
    }
}
