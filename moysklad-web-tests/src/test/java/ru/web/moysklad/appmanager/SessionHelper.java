package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper {
    private FirefoxDriver wd;

    public SessionHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void login(String accountname, String password) {
        wd.findElement(By.id("lable-login")).click();
        wd.findElement(By.id("lable-login")).clear();
        wd.findElement(By.id("lable-login")).sendKeys(accountname);
        wd.findElement(By.id("lable-password")).click();
        wd.findElement(By.id("lable-password")).clear();
        wd.findElement(By.id("lable-password")).sendKeys(password);
        wd.findElement(By.id("submit")).click();
    }
}
