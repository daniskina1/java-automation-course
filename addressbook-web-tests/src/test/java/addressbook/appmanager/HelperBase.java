package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    public WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By Locator, String text) {
        click(Locator);
        wd.findElement(Locator).clear();
        wd.findElement(Locator).sendKeys(text);
    }
}
