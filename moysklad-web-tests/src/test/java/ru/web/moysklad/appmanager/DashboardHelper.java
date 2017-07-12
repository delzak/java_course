package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardHelper extends HelperBase {
    public DashboardHelper(WebDriver wd) {
        super(wd);
    }

    public String getOverdueOrderText() {
        String text = wd.findElement(By.xpath
                ("//td[@class='dashboard-left-entire-wrap']/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div")).getText();
        return text;
    }
}
