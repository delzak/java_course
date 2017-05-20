package ru.web.moysklad.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ClickHelper clickHelper;
    private OrganizationHelper organizationHelper;
    private ProductHelper productHelper;
    private SupplyHelper supplyHelper;
    private DemandHelper demandHelper;
    private TutorialHelper tutorialHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void initialization() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
            wd.manage().window().setSize(new Dimension(1280, 720));
        } else if (browser.equals(BrowserType.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--start-maximized"); установка максимального разрешения окна браузера
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            wd = new ChromeDriver(capabilities);
        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://online-1.moysklad.ru/");
        clickHelper = new ClickHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        organizationHelper = new OrganizationHelper(wd);
        productHelper = new ProductHelper(wd);
        supplyHelper = new SupplyHelper(wd);
        demandHelper = new DemandHelper(wd);
        tutorialHelper = new TutorialHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin@ab1", "111111");
    }

    public void stop() {
        wd.quit();
    }

    public ClickHelper click() {
        return clickHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public OrganizationHelper organization(){
        return organizationHelper;
    }

    public ProductHelper good() {
        return productHelper;
    }

    public SupplyHelper supply() {
        return supplyHelper;
    }

    public DemandHelper demand() {
        return demandHelper;
    }

    public TutorialHelper tutorial() {
        return tutorialHelper;
    }
}
