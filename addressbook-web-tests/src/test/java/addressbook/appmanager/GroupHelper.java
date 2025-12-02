package addressbook.appmanager;

import addressbook.model.GroupDate;
import addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class GroupHelper extends HelperBase {

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return  new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupDate().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"), groupDate.name());
        type(By.name("group_header"), groupDate.header());
        type(By.name("group_footer"), groupDate.footer());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectGroup() {
        click(By.name("delete"));
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void sudmitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify( GroupDate group) {

        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        sudmitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return  isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void delete(GroupDate group) {
        selectGroupById(group.getId());
        deleteSelectGroup();
        groupCache = null;
        returnToGroupPage();
    }
}
