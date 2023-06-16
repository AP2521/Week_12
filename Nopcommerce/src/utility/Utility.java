package utility;

import base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseClass {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    public void clickNSendKey(By by,String key){
        WebElement element=driver.findElement(by);
        element.click();
        element.sendKeys(key);
    }

    public void selectdropdownmenu(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }
    public void verifyText(String message,String expected , By by){
       String actualMessage=getTextFromElement(by);
        Assert.assertEquals(message,expected,actualMessage);
    }
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();}

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
//        Thread.sleep(3000);
        // waitUnitVisibilityOfElementLocated(by,2000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
//        Thread.sleep(3000);
        // waitUnitVisibilityOfElementLocated(by,2000);
        actions.moveToElement(mouseHoover).build().perform();
    }
    public void clickClearnSendKey(By by,String key){
        WebElement element=driver.findElement(by);
        element.click();
        element.clear();
        element.sendKeys(key);
    }
}

