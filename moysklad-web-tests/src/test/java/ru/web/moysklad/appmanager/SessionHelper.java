package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String accountname, String password) {
        type(By.id("lable-login"), accountname);
        type(By.id("lable-password"), password);
        click(By.id("submit"));
    }
}
