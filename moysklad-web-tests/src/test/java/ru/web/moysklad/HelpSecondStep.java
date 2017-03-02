package ru.web.moysklad;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class HelpSecondStep {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://online-1.moysklad.ru/");
        wd.findElement(By.id("lable-login")).click();
        wd.findElement(By.id("lable-login")).clear();
        wd.findElement(By.id("lable-login")).sendKeys("admin@ab1");
        wd.findElement(By.id("lable-password")).click();
        wd.findElement(By.id("lable-password")).clear();
        wd.findElement(By.id("lable-password")).sendKeys("111111");
        wd.findElement(By.id("submit")).click();
    }
    
    @Test
    public void testHelpGoods() throws InterruptedException {
       wd.findElement(By.xpath("//table[@class='info']//span[.='Помощь']")).click();
        wd.findElement(By.cssSelector("div.gwt-Label.GL-QOY4BOU")).click();
        wd.findElement(By.linkText("Справочники")).click();
        wd.findElement(By.linkText("Товары и услуги")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@class='pump-title-panel']/tbody/tr/td[2]/div/table/tbody/tr/td[2]")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).sendKeys("Товар");
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).click();
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).clear();
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).sendKeys("1500");
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@class='b-editor-toolbar']//span[.='Сохранить']")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@class='b-editor-toolbar']//span[.='Закрыть']")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Продолжить']")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
