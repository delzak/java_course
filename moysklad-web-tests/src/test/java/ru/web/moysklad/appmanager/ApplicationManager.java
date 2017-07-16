package ru.web.moysklad.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.web.moysklad.appmanager.Pages.MyCompany.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ClickHelper clickHelper;
    private TutorialHelper tutorialHelper;
    private DashboardHelper dashboardHelper;
    private OrganizationHelper organizationHelper;
    private EmployeesHelper employeesHelper;
    private StoragesHelper storagesHelper;
    private DocumentsHelper documentsHelper;
    private RecyclebinHelper recyclebinHelper;
    private AppsHelper appsHelper;
    private SettingsHelper settingsHelper;
    private SubscriptionHelper subscriptionHelper;
    private SpecialOfferHelper specialOfferHelper;
    private RetailStoreHelper retailStoreHelper;
    private RetailShiftHelper retailShiftHelper;
    private RetailDemandHelper retailDemandHelper;
    private RetailSalesReturnHelper retailSalesReturnHelper;
    private RetailDrawerCashinHelper retailDrawerCashinHelper;
    private RetailDrawerCashoutHelper retailDrawerCashoutHelper;
    private ProductHelper productHelper;
    private SupplyHelper supplyHelper;
    private DemandHelper demandHelper;
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
        wd.get("https://online-13.moysklad.ru/");
        clickHelper = new ClickHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        organizationHelper = new OrganizationHelper(wd);
        productHelper = new ProductHelper(wd);
        supplyHelper = new SupplyHelper(wd);
        demandHelper = new DemandHelper(wd);
        tutorialHelper = new TutorialHelper(wd);
        sessionHelper = new SessionHelper(wd);
        dashboardHelper = new DashboardHelper(wd);
        employeesHelper = new EmployeesHelper(wd);
        storagesHelper = new StoragesHelper(wd);
        documentsHelper = new DocumentsHelper(wd);
        recyclebinHelper = new RecyclebinHelper(wd);
        settingsHelper = new SettingsHelper(wd);
        appsHelper = new AppsHelper(wd);
        subscriptionHelper = new SubscriptionHelper(wd);
        specialOfferHelper = new SpecialOfferHelper(wd);
        retailStoreHelper = new RetailStoreHelper(wd);
        retailShiftHelper = new RetailShiftHelper(wd);
        retailDemandHelper = new RetailDemandHelper(wd);
        retailSalesReturnHelper = new RetailSalesReturnHelper(wd);
        retailDrawerCashinHelper = new RetailDrawerCashinHelper(wd);
        retailDrawerCashoutHelper = new RetailDrawerCashoutHelper(wd);
        sessionHelper.login("admin@aatest", "111111");
    }

    public void stop() {
        wd.quit();
    }

    public ClickHelper click() {
        return clickHelper;
    }

    public TutorialHelper tutorial() {
        return tutorialHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public DashboardHelper dashboard() {
        return dashboardHelper;
    }

    public OrganizationHelper organization(){
        return organizationHelper;
    }

    public EmployeesHelper employees() {
        return employeesHelper;
    }

    public StoragesHelper storages() {
        return storagesHelper;
    }

    public DocumentsHelper documents(){
        return documentsHelper;
    }

    public RecyclebinHelper recyclebin() {
        return recyclebinHelper;
    }

    public SettingsHelper settings() {
        return settingsHelper;
    }

    public AppsHelper apps() {
        return appsHelper;
    }

    public SubscriptionHelper subscription() {
        return subscriptionHelper;
    }

    public SpecialOfferHelper special() {
        return specialOfferHelper;
    }

    public RetailStoreHelper retailStore() {
        return retailStoreHelper;
    }

    public RetailShiftHelper retailShift() {
        return retailShiftHelper;
    }

    public RetailDemandHelper retailDemand() {
        return retailDemandHelper;
    }

    public RetailSalesReturnHelper retailSalesReturn() {
        return retailSalesReturnHelper;
    }

    public RetailDrawerCashinHelper retailDrawerCashin() {
        return retailDrawerCashinHelper;
    }

    public RetailDrawerCashoutHelper retailDrawerCashout() {
        return retailDrawerCashoutHelper;
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


}
