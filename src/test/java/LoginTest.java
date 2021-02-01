import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void commonElements() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void validLogin() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("denys_1997ddd@yahoo.com");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("urage123");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("h1"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("MY DASHBOARD", message);
    }

    @Test
    public void invalidEmailLogin() {

        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click();
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("denys_1997@yahoo.com");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("urage123");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("Invalid login or password.", message);
    }

    @Test
    public void invalidPasswordLogin() {

        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click();
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("denys_1997ddd@yahoo.com");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("urage");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("div#advice-validate-password-pass.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", message);
    }

    @Test
    public void emptyEmailLogin() {

        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click();
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("urage123");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("#advice-required-entry-email.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.", message);
    }

    @Test
    public void emptyPasswordLogin() {

        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click();
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("denys_1997ddd@yahoo.com");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("#advice-required-entry-pass.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.", message);
    }

    @After
    public void close() {
        driver.close();
    }
}
