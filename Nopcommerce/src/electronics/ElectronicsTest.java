package electronics;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void electronicsTab(){
        mouseHover(By.linkText("Electronics"));
       clickOnElement(By.linkText("Cell phones"));
       verifyText("Verify CellPhone Text","Cell phones",By.xpath("//div[@class='page-title']/h1"));
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHover(By.linkText("Electronics"));
        clickOnElement(By.linkText("Cell phones"));
        verifyText("Verify CellPhone Text","Cell phones",By.xpath("//div[@class='page-title']/h1"));
        mouseHoverToElement(By.xpath("//div[@class='product-viewmode']/a[2]"));
        Thread.sleep(3000);
        WebElement nokia=driver.findElement(By.xpath("//div[@class='item-grid']/div[3]/div[1]/div[2]/h2/a"));
        Thread.sleep(3000);
        nokia.click();
        verifyText("Verify Product text","Nokia Lumia 1020",By.xpath("//div[@class='product-name']/h1"));
        verifyText("Verify Amount","$349.00",By.id("price-value-20"));
        clickClearnSendKey(By.id("product_enteredQuantity_20"),"2");
        clickOnElement(By.id("add-to-cart-button-20"));
        verifyText("Verify Product Added","The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@class='close']"));
        mouseHover(By.xpath("//li[@id='topcartlink']/a"));
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@id='flyout-cart']/div/div[4]/button"));
        verifyText("Verify Shopping Cart Text","Shopping cart",By.xpath("//div[@class='page-title']/h1"));
//        WebElement qty=driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]"));
//        System.out.println(qty.getText());
//        verifyText("Verify Qty","2",By.xpath("//table[@class='cart']/tbody/tr/td[5]/input"));
        verifyText("Verify Total","$698.00",By.xpath("//span[@class='product-subtotal']"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyText("Verify Welcome Text","Welcome, Please Sign In!",By.xpath("//div[@class='page-title']/h1"));
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        verifyText("Verify Register Text","Register",By.xpath("//div[@class='page-title']/h1"));
        clickOnElement(By.id("gender-male"));
        clickNSendKey(By.id("FirstName"),"ap");
        clickNSendKey(By.id("LastName"),"pa");
        clickNSendKey(By.id("FirstName"),"ap");
        selectdropdownmenu(By.xpath("//div[@class='date-picker-wrapper']/select"),"25");
        selectdropdownmenu(By.xpath("//div[@class='date-picker-wrapper']/select[2]"),"October");
        selectdropdownmenu(By.xpath("//div[@class='date-picker-wrapper']/select[3]"),"1991");
        clickNSendKey(By.id("Email"),"abcs@gmail.com");
        clickNSendKey(By.id("Password"),"123456");
        clickNSendKey(By.id("ConfirmPassword"),"123456");
        clickOnElement(By.id("register-button"));

        verifyText("Verify registration Text","Your registration completed",By.xpath("//div[@class='result']"));
        clickOnElement(By.xpath("//div[@class='buttons']/a"));
        verifyText("Verify Shopping cart Text","Shopping cart",By.xpath("//div[@class='page-title']/h1"));
        
    }
}
