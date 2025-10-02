package addressbook.appmanager;

import addressbook.model.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
    public WebDriver wd;

    public GroupHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"), groupDate.name());
        type(By.name("group_header"), groupDate.header());
        type(By.name("group_footer"), groupDate.footer());
    }

    private void type(By Locator, String text) {
        click(Locator);
        wd.findElement(Locator).clear();
        wd.findElement(Locator).sendKeys(text);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
}
