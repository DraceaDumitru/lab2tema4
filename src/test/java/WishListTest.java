import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//am avut o problema la metoda delete obj from wishlist , am scris acolo ce s-a intamplat
public class WishListTest {      //Ex 3
    private WebDriver driver;

    @Before
    public void commonElements() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://testfasttrackit.info/selenium-test/");
    }

    @Test
    //Ex 5
    public void addObjToWishList() {
//Am corectat ex asta

        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click();
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("denys_1997ddd@yahoo.com");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("urage123");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("div.page-title")); //confirma ca my dash apare pe pagina
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("MY DASHBOARD", message);
        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click(); // apasa pe sales
        driver.findElement(By.cssSelector("a.link-wishlist")).click();
        //comanda de sus apasa pe add to wishlist la un produs
        WebElement myWISHLIST = driver.findElement(By.cssSelector("div.page-title.title-buttons"));
        Assert.assertTrue(myWISHLIST.isDisplayed());
        String wishMessage = myWISHLIST.getText();
        Assert.assertEquals("MY WISHLIST", wishMessage);
    }

    @Test

    public void deleteObjFromWishList() {


        driver.findElement(By.cssSelector("#header>div>div.skip-links>div>a>span.label")).click();
        driver.findElement(By.cssSelector("#header-account>div>ul>li.last>a")).click();
        driver.findElement(By.cssSelector("input#email.input-text.required-entry.validate-email")).sendKeys("denys_1997ddd@yahoo.com");
        driver.findElement(By.cssSelector("input#pass.input-text.required-entry.validate-password")).sendKeys("urage123");
        driver.findElement(By.cssSelector("button#send2.button")).click();
        WebElement dashboard = driver.findElement(By.cssSelector("div.page-title")); //confirma ca my dash apare pe pagina
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("MY DASHBOARD", message);
        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click(); // apasa pe sales
        driver.findElement(By.cssSelector("a.link-wishlist")).click();
        //comanda de sus apasa pe add to wishlist la un produs
        WebElement myWISHLIST = driver.findElement(By.cssSelector("div.page-title.title-buttons"));
        Assert.assertTrue(myWISHLIST.isDisplayed());
        String wishMessage = myWISHLIST.getText();
        Assert.assertEquals("MY WISHLIST", wishMessage);
        driver.findElement(By.cssSelector("#item_873 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();//apasa pe cos si sterge produsul
        //Am avut o problema aici , apare o notificare la care trebuie sa apas pe ok ca sa sterg produsul , problema e ca nu pot sa dau inspect pe notificarea aia ca e de la chrome
        //asa ca nu am putut termina cu succes testul , teoretic e put tot cum trebuie dar din cauza notificarii nu pot sa continui sa sterg pana nu apas pe ok
        //N-a eu am incercat
        WebElement emptyWISHLIST = driver.findElement(By.cssSelector("#wishlist-view-form > div > p"));
        Assert.assertTrue(emptyWISHLIST.isDisplayed());
        String wishlistEmptyMessage = emptyWISHLIST.getText();
        Assert.assertEquals("You have no items in your wishlist.", wishlistEmptyMessage);
    }

    @After
    public void close() {
        driver.close();
    }
}
