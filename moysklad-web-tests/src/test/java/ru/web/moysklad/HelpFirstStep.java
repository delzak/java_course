package ru.web.moysklad;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class HelpFirstStep {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://online-1.moysklad.ru/");
        login("admin@ab1", "111111");
    }

    private void login(String accountname, String password) {
        wd.findElement(By.id("lable-login")).click();
        wd.findElement(By.id("lable-login")).clear();
        wd.findElement(By.id("lable-login")).sendKeys(accountname);
        wd.findElement(By.id("lable-password")).click();
        wd.findElement(By.id("lable-password")).clear();
        wd.findElement(By.id("lable-password")).sendKeys(password);
        wd.findElement(By.id("submit")).click();
    }

    @Test
    public void testHelpRequisites() throws InterruptedException {
        clickHelp();
        clickFirstStepHelp();
        goToOrganizations();
        Thread.sleep(500);
        selectFirstOrganization();
        inputNameOfOrganization("saaa");
        clickPopupButton();
        Thread.sleep(1000);
        saveInputInformation();
        Thread.sleep(500);
        closeOrganizationPage();
        Thread.sleep(500);
        clickOverOfFirstStepHelp();
    }

    private void clickOverOfFirstStepHelp() {
        wd.findElement(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Продолжить']")).click();
    }

    private void closeOrganizationPage() {
        wd.findElement(By.xpath("//table[@class='b-editor-toolbar']//span[.='Закрыть']")).click();
    }

    private void saveInputInformation() {
        wd.findElement(By.xpath("//table[@class='b-editor-toolbar']//span[.='Сохранить']")).click();
    }

    private void clickPopupButton() {
        wd.findElement(By.xpath("//div[@class='popupContent']//button[.='Далее']")).click();
    }

    private void inputNameOfOrganization(String organizationName) {
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).sendKeys(organizationName);
    }

    private void selectFirstOrganization() {
        wd.findElement(By.xpath("//table[@id='DocumentTableMyCompany']/tbody[1]/tr/td[10]")).click();
    }

    private void goToOrganizations() {
        wd.findElement(By.linkText("Юр. лица")).click();
    }

    private void clickFirstStepHelp() {
        wd.findElement(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[1]/div/div/div[1]/img[3]")).click();
    }

    private void clickHelp() {
        wd.findElement(By.xpath("//table[@class='info']//span[.='Помощь']")).click();
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
