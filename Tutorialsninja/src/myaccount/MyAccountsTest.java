package myaccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl="https://tutorialsninja.com/demo/index.php";
    public void selectMyAccountOptions(String option)  {
        /*This method should click on the options whatever name is passed as parameter.
(Hint: Handle List of Element and Select options)*/
            List<WebElement> listOfNames = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
            try {
                for (WebElement element : listOfNames) {
                    if (element.getText().equalsIgnoreCase(option)) {
                        element.click();
                    }
                }
            } catch (StaleElementReferenceException e) {
                listOfNames = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
            }
    }
    @Before
    public void setUp(){
        openBrowser(baseUrl);    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.linkText("My Account"));
      selectMyAccountOptions("Register");

        verifyText("Register Account", By.xpath("//div[@id='content']/h1"), "Verify Register account Text");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
            clickOnElement(By.linkText("My Account"));
        selectMyAccountOptions("Login");
            verifyText("Returning Customer",By.xpath("//div[@id='content']/div/div[2]/div/h2")," Verify return customer Text");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]"));
        selectMyAccountOptions("Register");
        clickNSendKey(By.id("input-firstname"),"Anish");
        clickNSendKey(By.id("input-lastname"),"Patel");
        clickNSendKey(By.id("input-email"),"acfgh@gmail.com");
        clickNSendKey(By.id("input-telephone"),"123456789");
        clickNSendKey(By.id("input-password"),"123456");
        clickNSendKey(By.id("input-confirm"),"123456");
        clickOnElement(By.xpath("//div[@id='content']/form/fieldset[3]/div/div/label[1]/input"));
        clickOnElement(By.xpath("//div[@id='content']/form/div/div/input[1]"));
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText("Your Account Has Been Created!",By.xpath("//div[@id='content']/h1"),"Verify account created Text");
        clickOnElement(By.linkText("Continue"));
        clickOnElement(By.xpath("//aside[@id='column-right']/div/a[1]"));
        clickOnElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]"));
        selectMyAccountOptions("Logout");
        verifyText("Account Logout",By.xpath("//div[@id='content']/h1"),"Verify account logout Text");
        clickOnElement(By.linkText("Continue"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        clickOnElement(By.linkText("My Account"));
        selectMyAccountOptions("Login");
        clickNSendKey(By.id("input-email"),"acfgh@gmail.com");
        clickNSendKey(By.id("input-password"),"123456");
        clickOnElement(By.xpath("//input[@value='Login']"));
        verifyText("My Account",By.xpath("//div[@id='content']/h2[1]"),"Verify My account Text");
        clickOnElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]"));
        selectMyAccountOptions("Logout");
        verifyText("Account Logout",By.xpath("//div[@id='content']/h1"),"Verify account logout Text");
        clickOnElement(By.linkText("Continue"));

    }
    @After
    public void tearUp(){//closeBrowser();
}}
