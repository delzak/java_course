package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.web.moysklad.model.OrganizationData;

public class OrganizationHelper {
    private FirefoxDriver wd;

    public OrganizationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void inputOrganizationInformation(OrganizationData organizationData) {
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).sendKeys(organizationData.getOrganizationName());
    }

    public void selectFirstOrganization() {
        wd.findElement(By.xpath("//table[@id='DocumentTableMyCompany']/tbody[1]/tr/td[10]")).click();
    }
}
