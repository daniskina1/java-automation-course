package addressbook.appmanager;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectContactById(int id) {
        click(By.xpath("//input[@value='" + id + "']"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void create(ContactDate contact) {
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

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.xpath("//table[@id='maintable']//tr[not(@class='header')]"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // Пропускаем пустые строки или строки без данных
            if (cells.size() < 5) {
                continue;
            }
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();

            contacts.add(new ContactDate()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withMobile(cells.get(3).getText())
                    .withEmail(cells.get(4).getText()));
        }
        return contacts;
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void modify(ContactDate contact) {
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        returnToContact();
    }

    public void delete(ContactDate contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        acceptAlert();
        returnToContact();
    }
}
