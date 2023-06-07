package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
       clickNSendKey(By.xpath("//input[@name='username']"),"ab12345");
       clickNSendKey(By.xpath("//input[@name='password']"),"ab123");
       clickOnElement(By.xpath("//input[@value='Log In']"));
       verifyText("Verify account overview","Accounts Overview",By.xpath("//h1[@class='title']"));
    }
    @Test
    public void verifyTheErrorMessage(){
        clickNSendKey(By.xpath("//input[@name='username']"),"a12345");
        clickNSendKey(By.xpath("//input[@name='password']"),"ab123");
        clickOnElement(By.xpath("//input[@value='Log In']"));
        verifyText("Verify error text","The username and password could not be verified.",By.xpath("//p[@class='error']"));
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        clickNSendKey(By.xpath("//input[@name='username']"),"ab12345");
        clickNSendKey(By.xpath("//input[@name='password']"),"ab123");
        clickOnElement(By.xpath("//input[@value='Log In']"));
        clickOnElement(By.xpath("//div[@id='leftPanel']/ul/li[8]/a"));
        verifyText("Verify customer login text","Customer Login",By.xpath("//div[@id='leftPanel']/h2"));
    }
    @After
    public void teatUp(){closeBrowser();}
}
