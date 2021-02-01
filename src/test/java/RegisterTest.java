import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;
    @Before
    public void commonElements() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public  void registerUser() { // am testat si dupa am sters contul , acum merde doar o singura data dupa ce trece primul test , la al doilea test nu va mai merge

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("Slim");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("Shady");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys("slimshady@cocotier.com"); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("rapgod");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("rapgod");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("li.success-msg"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("Thank you for registering with Madison Island.",message);
    }
    @Test
    public  void alreadyRegisterUser() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("Slim");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("Shady");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys("slimshady@cocotier.com"); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("rapgod");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("rapgod");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("li.error-msg"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.",message);
    }
    @Test
    public  void registerWithoutFirstnameUser() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("Shady");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys("slimshady@cocotier.com"); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("rapgod");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("rapgod");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("div#advice-required-entry-firstname.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.",message);
    }
    @Test
    public  void registerWithoutLastnameUser() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("Slim");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys("slimshady@cocotier.com"); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("rapgod");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("rapgod");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("div#advice-required-entry-lastname.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.",message);
    }
    @Test
    public  void registerWithoutEmailUser() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("Slim");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("Shady");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys(""); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("rapgod");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("rapgod");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("div#advice-required-entry-email_address.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.",message);
    }
    @Test
    public  void registerWithoutPasswordUser() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("Slim");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("Shady");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys("slimshady@cocotier.com"); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("rapgod");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("div#advice-required-entry-password.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.",message);
    }
    @Test
    public  void registerWithoutConfirmationPasswordUser() {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();//apasa pe account
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click(); // apasa pe register
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).click();//apasa pe first name
        driver.findElement(By.cssSelector("input#firstname.input-text.required-entry")).sendKeys("Slim");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).click();//apasa pe last name
        driver.findElement(By.cssSelector("input#lastname.input-text.required-entry")).sendKeys("Shady");// seteaza un nume la first name
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).click();//apasa pe email
        driver.findElement(By.cssSelector("input#email_address.input-text.validate-email.required-entry")).sendKeys("slimshady@cocotier.com"); // seteaza email
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).click();//da click pe parola
        driver.findElement(By.cssSelector("input#password.input-text.required-entry.validate-password")).sendKeys("rapgod");//seteaza paraola
        driver.findElement(By.cssSelector("input#confirmation.input-text.required-entry.validate-cpassword")).click();//da click pe parola
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("");//seteaza paraola de confirmare
        driver.findElement(By.cssSelector("#is_subscribed")).click();//bifeaza optiunea cu news letter
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click(); // apasa pe register
        WebElement dashboard = driver.findElement(By.cssSelector("div#advice-required-entry-confirmation.validation-advice"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("This is a required field.",message);
    }
    @After
    public void close (){
        driver.close();
    }
}
