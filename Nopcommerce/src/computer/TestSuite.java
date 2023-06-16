package computer;

import homepage.TopMenuTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite extends TopMenuTest {
    @Before
    public void compTab(){
      selectMenu("Computers");
      clickOnElement(By.linkText("Desktops"));
      selectdropdownmenu(By.id("products-orderby"),"Name: Z to A");
      verifyText("Verify Order","Name: Z to A",By.xpath("//select[@id='products-orderby']/option[3]"));
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        selectdropdownmenu(By.id("products-orderby"),"Name: A to Z");
        Thread.sleep(200);
        mouseHoverToElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a"));
        verifyText("Verify product Text","Build your own computer",By.xpath("//div[@class='product-name']/h1"));
        selectdropdownmenu(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        selectdropdownmenu(By.id("product_attribute_2"),"8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        List<WebElement> software=driver.findElements(By.xpath("//dd[@id='product_attribute_input_5']/ul/li/label"));
        for (WebElement list :software) {
                if (list.getText().equalsIgnoreCase("Total Commander [+$5.00]")){
                    list.click();
                }
            }
        Thread.sleep(80);
        verifyText("Verify Total amount Text","$1,475.00",By.id("price-value-1"));
        clickOnElement(By.id("add-to-cart-button-1"));
        verifyText("Verify Product added Text","The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@class='close']"));
        mouseHoverToElement(By.linkText("Shopping cart"));
        //clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        verifyText("Verify Shooping Cart Text","Shopping cart",By.xpath("//div[@class='page-title']/h1"));
        WebElement qty=driver.findElement(By.xpath("//input[@class='qty-input']"));
        qty.click();
        qty.clear();
        qty.sendKeys("2");
        clickOnElement(By.id("updatecart"));
        verifyText("Verify total","$2,950.00",By.xpath("//span[@class='product-subtotal']"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyText("Verify Welcome text","Welcome, Please Sign In!",By.xpath("//div[@class='page-title']/h1"));
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        clickNSendKey(By.id("BillingNewAddress_FirstName"),"A");
        clickNSendKey(By.id("BillingNewAddress_LastName"),"P");
        clickNSendKey(By.id("BillingNewAddress_Email"),"abc@gmail.com");
        selectdropdownmenu(By.id("BillingNewAddress_CountryId"),"United States");
        selectdropdownmenu(By.id("BillingNewAddress_StateProvinceId"),"Arizona");
        clickNSendKey(By.id("BillingNewAddress_City"),"Phoenix");
        clickNSendKey(By.id("BillingNewAddress_Address1"),"7770 w alv");
        clickNSendKey(By.id("BillingNewAddress_ZipPostalCode"),"85035");
        clickNSendKey(By.id("BillingNewAddress_PhoneNumber"),"5756218568");
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        selectdropdownmenu(By.id("CreditCardType"),"Master card");
        clickNSendKey(By.id("CardholderName"),"ap");
        clickNSendKey(By.id("CardNumber"),"012345678995135789");
        selectdropdownmenu(By.id("ExpireYear"),"2024");
        clickNSendKey(By.id("CardCode"),"0123");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        verifyText("Verify Payment Text","Payment Method:",By.xpath("//li[@class='payment-method']/span"));
        verifyText("Verify Payment Text","Credit Card",By.xpath("//li[@class='payment-method']/span[2]"));
        verifyText("Verify Shipping Text","Shipping Method:",By.xpath("//li[@class='shipping-method']/span"));
        verifyText("Verify Shipping Text","Next Day Air",By.xpath("//li[@class='shipping-method']/span[2]"));
        verifyText("Verify Total Amount","$2,950.00",By.xpath("//span[@class='value-summary']/strong"));
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        verifyText("Verify Message","Your order has been successfully processed!",By.xpath("//div[@class='page-body checkout-data']/div/div/strong"));
        clickOnElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));
        verifyText("Verify Text","Welcome to our store",By.xpath("//div[@class='topic-block-title']/h2"));
    }


    }


