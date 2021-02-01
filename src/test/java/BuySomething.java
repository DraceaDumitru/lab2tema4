import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuySomething {
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
    public void addObjToCart() {

        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click(); // apasa pe sales
        driver.findElement(By.cssSelector("a.button")).click(); //comanda de sus apasa pe view la un produs
        driver.findElement(By.cssSelector("span.swatch-label")).click(); // apasa pe culoarea neagra
        driver.findElement(By.cssSelector("a#swatch77.swatch-link.swatch-link-180")).click(); //apasa pe marimea XL
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();//adauga in cos
        WebElement dashboard = driver.findElement(By.cssSelector("li.success-msg"));
        Assert.assertTrue(dashboard.isDisplayed());
        String message = dashboard.getText();
        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.", message);
    }

    @Test
    public void addOneMoreObjToCart() {

        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click(); // apasa pe sales
        driver.findElement(By.cssSelector("a.button")).click();
        //comanda de sus apasa pe view la un produs
        driver.findElement(By.cssSelector("span.swatch-label")).click(); // apasa pe culoarea neagra
        driver.findElement(By.cssSelector("a#swatch77.swatch-link.swatch-link-180")).click(); //apasa pe marimea XL
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();//adauga in cos
        WebElement confirmationMessage = driver.findElement(By.cssSelector("li.success-msg")); // arata mesajul de succes
        Assert.assertTrue(confirmationMessage.isDisplayed());
        String message = confirmationMessage.getText();
        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.", message);
        WebElement continueButton = driver.findElement(By.cssSelector("button.button2.btn-continue"));//apasa pe continue shopping
        Assert.assertTrue(continueButton.isDisplayed());
        String button = continueButton.getText();
        Assert.assertEquals("CONTINUE SHOPPING", button);
        driver.findElement(By.cssSelector("button.button2.btn-continue")).click();//face click pe continue shopping
        driver.findElement(By.cssSelector("a.logo")).click();//face click pe homepage
        WebElement returnToMainPage = driver.findElement(By.cssSelector("div.widget-title"));
        Assert.assertTrue(returnToMainPage.isDisplayed());
        String continueShopping = returnToMainPage.getText();
        Assert.assertEquals("NEW PRODUCTS", continueShopping);
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(4)")).click();//apasa pe tipa in rochie
        driver.findElement(By.cssSelector("#swatch27")).click(); // apasa pe negru
        driver.findElement(By.cssSelector("#swatch72 > span.swatch-label")).click(); //apasa pe marimea 10
        driver.findElement(By.cssSelector("div.add-to-cart > div.add-to-cart-buttons")).click();
        WebElement confirmMessage = driver.findElement(By.cssSelector("li.success-msg"));
        Assert.assertTrue(confirmMessage.isDisplayed());
        String confirm = confirmMessage.getText();
        Assert.assertEquals("Lafayette Convertible Dress was added to your shopping cart.", confirm);
    }

    @Test
    public void deleteAnObjFromCart() {

        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click(); // apasa pe sales
        driver.findElement(By.cssSelector("a.button")).click();
        //comanda de sus apasa pe view la un produs
        driver.findElement(By.cssSelector("span.swatch-label")).click(); // apasa pe culoarea neagra
        driver.findElement(By.cssSelector("a#swatch77.swatch-link.swatch-link-180")).click(); //apasa pe marimea XL
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();//adauga in cos
        WebElement confirmationMessage = driver.findElement(By.cssSelector("li.success-msg")); // arata mesajul de succes
        Assert.assertTrue(confirmationMessage.isDisplayed());
        String message = confirmationMessage.getText();
        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.", message);
        WebElement continueButton = driver.findElement(By.cssSelector("button.button2.btn-continue"));//apasa pe continue shopping
        Assert.assertTrue(continueButton.isDisplayed());
        String button = continueButton.getText();
        Assert.assertEquals("CONTINUE SHOPPING", button);
        driver.findElement(By.cssSelector("button.button2.btn-continue")).click();//face click pe continue shopping
        driver.findElement(By.cssSelector("a.logo")).click();//face click pe homepage
        WebElement returnToMainPage = driver.findElement(By.cssSelector("div.widget-title"));
        Assert.assertTrue(returnToMainPage.isDisplayed());
        String continueShopping = returnToMainPage.getText();
        Assert.assertEquals("NEW PRODUCTS", continueShopping);
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(4)")).click();//apasa pe tipa in rochie
        driver.findElement(By.cssSelector("#swatch27")).click(); // apasa pe negru
        driver.findElement(By.cssSelector("#swatch72 > span.swatch-label")).click(); //apasa pe marimea 10
        driver.findElement(By.cssSelector("div.add-to-cart > div.add-to-cart-buttons")).click();
        WebElement confirmMessage = driver.findElement(By.cssSelector("li.success-msg"));
        Assert.assertTrue(confirmMessage.isDisplayed());
        String confirm = confirmMessage.getText();
        Assert.assertEquals("Lafayette Convertible Dress was added to your shopping cart.", confirm);
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr.last.even > td.a-center.product-cart-remove.last > a")).click();//face click pe stergere
        WebElement deleteMessage = driver.findElement(By.cssSelector("#shopping-cart-totals-table > tbody > tr > td:nth-child(2) > span"));
        Assert.assertTrue(deleteMessage.isDisplayed());
        String delete = deleteMessage.getText();
        Assert.assertEquals("140,00 RON", delete);
    }

    @Test
    public void emptyYourCart() {

        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click(); // apasa pe sales
        driver.findElement(By.cssSelector("a.button")).click();
        //comanda de sus apasa pe view la un produs
        driver.findElement(By.cssSelector("span.swatch-label")).click(); // apasa pe culoarea neagra
        driver.findElement(By.cssSelector("a#swatch77.swatch-link.swatch-link-180")).click(); //apasa pe marimea XL
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();//adauga in cos
        WebElement confirmationMessage = driver.findElement(By.cssSelector("li.success-msg")); // arata mesajul de succes
        Assert.assertTrue(confirmationMessage.isDisplayed());
        String message = confirmationMessage.getText();
        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.", message);
        WebElement continueButton = driver.findElement(By.cssSelector("button.button2.btn-continue"));//apasa pe continue shopping
        Assert.assertTrue(continueButton.isDisplayed());
        String button = continueButton.getText();
        Assert.assertEquals("CONTINUE SHOPPING", button);
        driver.findElement(By.cssSelector("button.button2.btn-continue")).click();//face click pe continue shopping
        driver.findElement(By.cssSelector("a.logo")).click();//face click pe homepage
        WebElement returnToMainPage = driver.findElement(By.cssSelector("div.widget-title"));
        Assert.assertTrue(returnToMainPage.isDisplayed());
        String continueShopping = returnToMainPage.getText();
        Assert.assertEquals("NEW PRODUCTS", continueShopping);
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(4)")).click();//apasa pe tipa in rochie
        driver.findElement(By.cssSelector("#swatch27")).click(); // apasa pe negru
        driver.findElement(By.cssSelector("#swatch72 > span.swatch-label")).click(); //apasa pe marimea 10
        driver.findElement(By.cssSelector("div.add-to-cart > div.add-to-cart-buttons")).click();
        WebElement confirmMessage = driver.findElement(By.cssSelector("li.success-msg"));
        Assert.assertTrue(confirmMessage.isDisplayed());
        String confirm = confirmMessage.getText();
        Assert.assertEquals("Lafayette Convertible Dress was added to your shopping cart.", confirm);
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr.last.even > td.a-center.product-cart-remove.last > a")).click();//face click pe stergere
        WebElement deleteMessage = driver.findElement(By.cssSelector("#shopping-cart-totals-table > tbody > tr > td:nth-child(2) > span"));
        Assert.assertTrue(deleteMessage.isDisplayed());
        String delete = deleteMessage.getText();
        Assert.assertEquals("140,00 RON", delete);
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.a-center.product-cart-remove.last > a")).click();
        WebElement emptyCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertTrue(emptyCart.isDisplayed());
        String deleteAll = emptyCart.getText();
        Assert.assertEquals("SHOPPING CART IS EMPTY", deleteAll);
    }

    @After
    public void close() {
        driver.close();
    }


}
