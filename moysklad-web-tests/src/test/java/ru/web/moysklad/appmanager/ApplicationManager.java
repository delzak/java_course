package ru.web.moysklad.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ClickHelper clickHelper;
    private OrganizationHelper organizationHelper;
    private ProductHelper productHelper;

    public void initialization() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://online-1.moysklad.ru/");
        clickHelper = new ClickHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        organizationHelper = new OrganizationHelper(wd);
        productHelper = new ProductHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin@ab1", "111111");
    }

    public void stop() {
        wd.quit();
    }

    public ClickHelper getClickHelper() {
        return clickHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public OrganizationHelper getOrganizationHelper(){
        return organizationHelper;
    }

    public ProductHelper getProductHelper() {
        return productHelper;
    }
}