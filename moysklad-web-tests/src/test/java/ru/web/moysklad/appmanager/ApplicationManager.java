package ru.web.moysklad.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.web.moysklad.appmanager.pages.myCompany.*;
import ru.web.moysklad.appmanager.pages.purchases.*;
import ru.web.moysklad.appmanager.pages.retail.*;
import ru.web.moysklad.appmanager.pages.sales.*;
import ru.web.moysklad.appmanager.pages.store.*;

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

    private PurchaseOrderHelper purchaseOrderHelper;
    private InvoiceInHelper invoiceInHelper;
    private SupplyHelper supplyHelper;
    private PurchaseReturnHelper purchaseReturnHelper;
    private FactureInHelper factureInHelper;
    private PurchaseControlHelper purchaseControlHelper;

    private CustomOrderHelper customOrderHelper;
    private InvoiceOutHelper invoiceOutHelper;
    private DemandHelper demandHelper;
    private CommissionReportInHelper commissionReportInHelper;
    private CommissionReportOutHelper commissionReportOutHelper;
    private SalesReturnHelper salesReturnHelper;
    private FactureOutHelper factureOutHelper;
    private PricelistHelper pricelistHelper;
    private DiscountHelper discountHelper;
    private ProfitabilityHelper profitabilityHelper;
    private CommissionGoodsHelper commissionGoodsHelper;
    private PurchaseFunnelHelper purchaseFunnelHelper;

    private LossHelper lossHelper;
    private EnterHelper enterHelper;
    private MoveHelper moveHelper;
    private InventoryHelper inventoryHelper;
    private ProcessingHelper processingHelper;
    private ProcessingPlanHelper processingPlanHelper;
    private ProcessingOrderHelper processingOrderHelper;
    private InternalOrderHelper internalOrderHelper;
    private StocksHelper stocksHelper;
    private TurnOverHelper turnOverHelper;
    private SerialNumberHelper serialNumberHelper;

    private ProductHelper productHelper;
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
        productHelper = new ProductHelper(wd);
        tutorialHelper = new TutorialHelper(wd);
        sessionHelper = new SessionHelper(wd);

        dashboardHelper = new DashboardHelper(wd);
        organizationHelper = new OrganizationHelper(wd);
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

        purchaseOrderHelper = new PurchaseOrderHelper(wd);
        invoiceInHelper = new InvoiceInHelper(wd);
        supplyHelper = new SupplyHelper(wd);
        purchaseReturnHelper = new PurchaseReturnHelper(wd);
        factureInHelper = new FactureInHelper(wd);
        purchaseControlHelper = new PurchaseControlHelper(wd);

        customOrderHelper = new CustomOrderHelper(wd);
        invoiceOutHelper = new InvoiceOutHelper(wd);
        demandHelper = new DemandHelper(wd);
        commissionReportInHelper = new CommissionReportInHelper(wd);
        commissionReportOutHelper = new CommissionReportOutHelper(wd);
        salesReturnHelper = new SalesReturnHelper(wd);
        factureOutHelper = new FactureOutHelper(wd);
        pricelistHelper = new PricelistHelper(wd);
        discountHelper = new DiscountHelper(wd);
        profitabilityHelper = new ProfitabilityHelper(wd);
        commissionGoodsHelper = new CommissionGoodsHelper(wd);
        purchaseFunnelHelper = new PurchaseFunnelHelper(wd);

        lossHelper = new LossHelper(wd);
        enterHelper = new EnterHelper(wd);
        moveHelper = new MoveHelper(wd);
        inventoryHelper = new InventoryHelper(wd);
        processingHelper = new ProcessingHelper(wd);
        processingPlanHelper = new ProcessingPlanHelper(wd);
        processingOrderHelper = new ProcessingOrderHelper(wd);
        internalOrderHelper = new InternalOrderHelper(wd);
        stocksHelper = new StocksHelper(wd);
        turnOverHelper = new TurnOverHelper(wd);
        serialNumberHelper = new SerialNumberHelper(wd);

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

    public EmployeesHelper employee() {
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

    public PurchaseOrderHelper purchaseOrder() {
        return purchaseOrderHelper;
    }

    public InvoiceInHelper invoiceIn() {
        return invoiceInHelper;
    }

    public SupplyHelper supply() {
        return supplyHelper;
    }

    public PurchaseReturnHelper purchaseReturn() {
        return purchaseReturnHelper;
    }

    public FactureInHelper factureIn() {
        return factureInHelper;
    }

    public PurchaseControlHelper purchaseControl() {
        return purchaseControlHelper;
    }

    public CustomOrderHelper customerOrder() {
        return customOrderHelper;
    }

    public InvoiceOutHelper invoiceOut() {
        return invoiceOutHelper;
    }

    public DemandHelper demand() {
        return demandHelper;
    }

    public CommissionReportInHelper commissionReportIn() {
        return commissionReportInHelper;
    }

    public CommissionReportOutHelper commissionReportOut() {
        return commissionReportOutHelper;
    }

    public SalesReturnHelper salesReturn() {
        return salesReturnHelper;
    }

    public FactureOutHelper factureOut() {
        return factureOutHelper;
    }

    public PricelistHelper pricelist() {
        return pricelistHelper;
    }

    public DiscountHelper discount() {
        return discountHelper;
    }

    public ProfitabilityHelper profitability() {
        return profitabilityHelper;
    }

    public CommissionGoodsHelper commissionGoods() {
        return commissionGoodsHelper;
    }

    public PurchaseFunnelHelper purchaseFunnel() {
        return purchaseFunnelHelper;
    }

    public LossHelper loss() {
        return lossHelper;
    }

    public EnterHelper enter() {
        return enterHelper;
    }

    public MoveHelper move() {
        return moveHelper;
    }

    public InventoryHelper inventory() {
        return inventoryHelper;
    }

    public ProcessingHelper processing() {
        return processingHelper;
    }

    public ProcessingPlanHelper processingPlan() {
        return processingPlanHelper;
    }

    public ProcessingOrderHelper processingOrder() {
        return processingOrderHelper;
    }

    public InternalOrderHelper internalOrder() {
        return internalOrderHelper;
    }

    public StocksHelper stocks() {
        return stocksHelper;
    }

    public TurnOverHelper turnOver() {
        return turnOverHelper;
    }

    public SerialNumberHelper serialNumber() {
        return serialNumberHelper;
    }

    public ProductHelper good() {
        return productHelper;
    }




}
