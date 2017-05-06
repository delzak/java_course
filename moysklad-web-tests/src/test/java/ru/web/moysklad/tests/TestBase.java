package ru.web.moysklad.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.web.moysklad.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.initialization();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
