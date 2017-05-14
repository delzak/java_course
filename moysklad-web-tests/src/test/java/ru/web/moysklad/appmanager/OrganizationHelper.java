package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.model.OrganizationData;

public class OrganizationHelper extends HelperBase {

    public OrganizationHelper(WebDriver wd) {
        super(wd);
    }

    public void inputOrganizationInformation(OrganizationData organizationData) {
        type(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input"), organizationData.getOrganizationName());
    }

    public void selectFirstOrganization() {
        click(By.xpath("//table[@id='DocumentTableMyCompany']/tbody[1]/tr/td[10]"));
    }
}
