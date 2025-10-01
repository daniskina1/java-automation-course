package addressbook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class GroupCreationTests {
    private WebDriver wb;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp()  {
        wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) wb;
        wb.get("http://localhost/addressbook/");
        wb.findElement(By.name("user")).click();
        wb.findElement(By.name("user")).clear();
        wb.findElement(By.name("user")).sendKeys("admin");
        wb.findElement(By.name("pass")).click();
        wb.findElement(By.name("pass")).clear();
        wb.findElement(By.name("pass")).sendKeys("secret");
        wb.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testGroupCreation()  {
        wb.findElement(By.linkText("groups")).click();
        wb.findElement(By.name("new")).click();
        wb.findElement(By.name("group_name")).click();
        wb.findElement(By.name("group_name")).clear();
        wb.findElement(By.name("group_name")).sendKeys("test1");
        wb.findElement(By.name("group_header")).click();
        wb.findElement(By.name("group_header")).clear();
        wb.findElement(By.name("group_header")).sendKeys("test2");
        wb.findElement(By.name("group_footer")).click();
        wb.findElement(By.name("group_footer")).clear();
        wb.findElement(By.name("group_footer")).sendKeys("test3");
        wb.findElement(By.name("submit")).click();
        wb.findElement(By.linkText("group page")).click();
        wb.findElement(By.linkText("Logout")).click();
    }

    @AfterEach
    public void tearDown()  {
        wb.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wb.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wb.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}

