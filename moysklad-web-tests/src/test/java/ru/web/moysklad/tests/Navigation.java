package ru.web.moysklad.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Navigation extends TestBase{

    @Test
    public void testNavigation() {
        assertEquals("Просроченные заказы", app.dashboard().getOverdueOrderText());
        app.goTo().organizations();
        //assertEquals("Юр. лица", app.organization().getTitleText());
        app.goTo().employees();
        //assertEquals("Сотрудники", );
        app.goTo().storages();

        app.goTo().documents();

        app.goTo().recyclebin();

        app.goTo().settings();

        app.goTo().apps();

        app.goTo().subscriprion();

        app.goTo().specialOffer();
    }
}
