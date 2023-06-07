package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class DesktopsTest extends Utility {
    String baseUrl="https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
      mouseHoverToElementAndClick(By.linkText("Desktops"));
      clickOnElement(By.linkText("Show AllDesktops"));
      selectByVisibleTextFromDropdown(By.id("input-sort"),"Name (Z - A)");
      verifyText("Name (Z - A)",By.xpath("//select[@id='input-sort']/option[3]"),"Verify DESC order");

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        clickOnElement(By.linkText("Show AllDesktops"));
        selectByVisibleTextFromDropdown(By.id("input-sort"),"Name (A - Z)");
        clickOnElement(By.linkText("HP LP3065"));
        String year = "2022";
        String month = "November";
        String date = "30";
        driver.findElement(By.xpath("//div[@class='input-group date']/span/button")).click();
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[3]/div/div[1]/table/thead/tr[1]/th[2]")).getText();
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[3]/div/div[1]/table/thead/tr[1]/th[3]"));
        }}
        driver.findElement(By.xpath("//div[3]/div/div[1]/table/tbody/tr[5]/td[3]")).click();
        WebElement qty= driver.findElement(By.xpath("//input[@name='quantity']"));
             qty.click();
             qty.clear();
             qty.sendKeys("1");
            clickOnElement(By.xpath("//button[@id='button-cart']"));
            verifyText("Success: You have added HP LP3065 to your shopping cart!\n"+"×",By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Verify shopping cart text");

            clickOnElement(By.linkText("shopping cart"));
            verifyText("Shopping Cart",By.xpath("//*[@id=\"checkout-cart\"]/ul/li[2]/a"),"Verify shopping cart text");
            verifyText("HP LP3065",By.xpath("//div/table/tbody/tr/td[2]/a"),"Verify Hp text");
            verifyText("Delivery Date:2022-11-30",By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[2]/small[1]"),"Verify Delivery date Text");
            verifyText("Product 21",By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[3]"),"Verify Model no. Text");
            clickOnElement(By.xpath("//form[@id=\"form-currency\"]/div/button/span"));
            clickOnElement(By.xpath("//form[@id=\"form-currency\"]/div/ul/li[2]/button"));
            verifyText("£74.73",By.xpath("//div[@id=\"content\"]/form/div/table/tbody/tr/td[6]"),"Verify Total Text");

    }
    @After
    public void tearUp(){closeBrowser();}
    }

