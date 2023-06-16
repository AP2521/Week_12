package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
    public void selectMenu(String menu) {
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                }
            }
        }
        catch(StaleElementReferenceException e){
            menuList=driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
        }
    }
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("Electronics");
        WebElement pageTitle=driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualPageTitle=pageTitle.getText();
        String expectedPageTitle="Electronics";
        Assert.assertEquals("Verify page title",expectedPageTitle,actualPageTitle);
    }

   @After
    public void tearUp(){
        //closeBrowser();
    }
}
