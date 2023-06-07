package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl ="https://tutorialsninja.com/demo/index.php";

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }}
@Before
public void setUp(){
    openBrowser(baseUrl);
}


    @Test
            public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        Actions actions=new Actions(driver);
        WebElement desktops=driver.findElement(By.linkText("Desktops"));
        actions.moveToElement(desktops).click().build().perform();
        selectMenu("Show AllDesktops");
        WebElement dsktop=driver.findElement(By.linkText("Desktops"));
        String actualDesktopsText=dsktop.getText();
        String expectedDesktopText="Desktops";
        Assert.assertEquals(actualDesktopsText,expectedDesktopText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        Actions actions=new Actions(driver);
        WebElement laptopNotebook =driver.findElement(By.linkText("Laptops & Notebooks"));
        actions.moveToElement(laptopNotebook).click().build().perform();
        selectMenu("Show AllLaptops & Notebooks");
        WebElement laptop=driver.findElement(By.linkText("Laptops & Notebooks"));
        String actualLaptopText=laptop.getText();
        String expectedLaptopText="Laptops & Notebooks";
        Assert.assertEquals(expectedLaptopText,actualLaptopText);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        Actions actions=new Actions(driver);
        WebElement componentes=driver.findElement(By.linkText("Components"));
        actions.moveToElement(componentes).click().build().perform();
        selectMenu("Show AllComponents");
        WebElement compon=driver.findElement(By.linkText("Components"));
        String actualComponentsText=compon.getText();
        String expectedComponentsText="Components";
        Assert.assertEquals(expectedComponentsText,actualComponentsText);
    }


@After
    public void tearUP(){
    closeBrowser();
}
}
