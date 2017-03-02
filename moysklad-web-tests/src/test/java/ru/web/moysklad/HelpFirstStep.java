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

public class HelpFirstStep {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
    public void testHelpRequisites() throws InterruptedException {
        wd.findElement(By.xpath("//table[@class='info']//span[.='Помощь']")).click();
        wd.findElement(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[1]/div/div/div[1]/img[3]")).click();
        wd.findElement(By.linkText("Юр. лица")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@id='DocumentTableMyCompany']/tbody[1]/tr/td[10]")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).sendKeys("saaa");
        wd.findElement(By.xpath("//div[@class='popupContent']//button[.='Далее']")).click();
        Thread.sleep(1000);
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
