package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl="https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        selectByVisibleTextFromDropdown(By.id("input-sort"),"Price (High > Low)");
        verifyText("Price (High > Low)",By.xpath("//select[@id='input-sort']/option[5]"),"Verify price high to low");
        List<WebElement> hightoLow=driver.findElements(By.xpath("//p[@class='price']"));
        for (WebElement pr:hightoLow) {
            System.out.println("Verify price High to Low :"+pr.getText());}
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        selectByVisibleTextFromDropdown(By.id("input-sort"),"Price (High > Low)");
        clickOnElement(By.linkText("MacBook"));
        verifyText("MacBook",By.xpath("//div[@id=\"content\"]/div/div[2]/h1"),"Verify MacBook Text");
        clickOnElement(By.id("button-cart"));
        verifyText("Success: You have added MacBook to your shopping cart!\n"+"×",By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Verify Success Text");
        clickOnElement(By.linkText("shopping cart"));
        verifyText("Shopping Cart  (0.00kg)",By.xpath("//div[@id='content']/h1"),"Verify shopping cart Text");
        verifyText("MacBook",By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"),"Verify Macbook Text");
        WebElement quantity=driver.findElement(By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input"));
        quantity.click();
        quantity.clear();
        quantity.sendKeys("2");
        clickOnElement(By.xpath("//button[@type='submit']"));
        verifyText("Success: You have modified your shopping cart!\n"+"×",By.xpath("//div[@id=\"checkout-cart\"]/div[1]"),"Verify Modified Text");
        clickOnElement(By.xpath("//form[@id=\"form-currency\"]/div/button/span"));
        clickOnElement(By.xpath("//form[@id=\"form-currency\"]/div/ul/li[2]/button"));
        verifyText("£737.45",By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[6]"),"Verify Total amt Text");
        clickOnElement(By.linkText("Checkout"));
        verifyText("Checkout",By.xpath("//div[@id=\"content\"]/h1"),"Verify Checkout Text");
        verifyText("New Customer",By.xpath("//div[@id=\"collapse-checkout-option\"]/div/div/div[1]/h2"),"Verify New Customer Text");
        clickOnElement(By.xpath("//input[@value='guest']"));
        clickOnElement(By.id("button-account"));
        clickNSendKey(By.id("input-payment-firstname"),"Anish");
        clickNSendKey(By.id("input-payment-lastname"),"Patel");
        clickNSendKey(By.id("input-payment-email"),"abc@gmail.com");
        clickNSendKey(By.id("input-payment-telephone"),"123456789");
        clickNSendKey(By.id("input-payment-address-1"),"123abc");
        clickNSendKey(By.id("input-payment-city"),"phx");
        clickNSendKey(By.id("input-payment-postcode"),"85035");
        selectByVisibleTextFromDropdown(By.id("input-payment-country"),"United States");
        selectByVisibleTextFromDropdown(By.id("input-payment-zone"),"Arizona");
        clickOnElement(By.id("button-guest"));
        clickNSendKey(By.xpath("//textarea[@ name='comment']"),"Please do Gift Wrap the item");
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.id("button-payment-method"));
        verifyText("Warning: Payment method required!\n"+"×",By.xpath("//div[@class='alert alert-danger alert-dismissible']"),"Verify payment required Text");
    }
    @After
    public void tearUp(){
         closeBrowser();
        }
}
