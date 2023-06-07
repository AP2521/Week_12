package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class RegisterTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void verifyThatSigningUpPageDisplay() {
        clickOnElement(By.linkText("Register"));
        verifyText("Verify Signing up Text", "Signing up is easy!", By.xpath("//div[@id='rightPanel']/h1"));
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        clickOnElement(By.linkText("Register"));
        clickNSendKey(By.id("customer.firstName"),"Anish");
        clickNSendKey(By.id("customer.lastName"),"patel");
        clickNSendKey(By.id("customer.address.street"),"123phx");
        clickNSendKey(By.id("customer.address.city"),"Phoenix");
        clickNSendKey(By.id("customer.address.state"),"AZ");
        clickNSendKey(By.id("customer.address.zipCode"),"85035");
        clickNSendKey(By.id("customer.phoneNumber"),"123456789");
        clickNSendKey(By.id("customer.ssn"),"12345678");
        clickNSendKey(By.id("customer.username"),"ab12345");
        clickNSendKey(By.id("customer.password"),"ab123");
        clickNSendKey(By.id("repeatedPassword"),"ab123");
        clickOnElement(By.xpath("//input[@value='Register']"));
        verifyText("Verify account created text","Your account was created successfully. You are now logged in.",By.xpath("//div[@id='rightPanel']/p"));

    }
    @After
    public void tearUP(){closeBrowser();}
}
