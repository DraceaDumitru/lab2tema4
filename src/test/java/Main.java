import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        login();
        //WishListTest.addObjToWishList();
        //RegisterTest.registerWithoutConfirmationPasswordUser();
        //RegisterTest.registerWithoutPasswordUser();
        //RegisterTest.registerWithoutFirstnameUser();
        //RegisterTest.registerWithoutLastnameUser();
        //RegisterTest.registerWithoutEmailUser();
        // RegisterTest.alreadyRegisterUser();
        // RegisterTest.registerUser();
        // LoginTest.validLogin();
        // LoginTest.invalidEmailLogin();
        // LoginTest.invalidPasswordLogin();

    }

    //Ex 1
    public static void login() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://testfasttrackit.info/selenium-test/"); // intra pe site
        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click(); // apasa pe my account
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click(); //apasa pe login
        driver.findElement(By.cssSelector("#email")).sendKeys("denys_1997ddd@yahoo.com"); // pune mail=ul
        driver.findElement(By.cssSelector("#pass")).sendKeys("urage123"); // pune parola
        driver.findElement(By.cssSelector("#send2")).click(); //da click pe butonul de login
        driver.findElement(By.cssSelector("#header > div > a")).click(); // merge la home page
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a")).click(); // intra in categoria men
        driver.close();//inchide browser
        // ps am incercat sa intru la woman/sales dar nu a mers de pe link-ul asta
    }
    //Ex 2 am pus dependintele

}
