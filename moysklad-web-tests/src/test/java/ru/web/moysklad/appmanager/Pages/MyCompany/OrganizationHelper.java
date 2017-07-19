package ru.web.moysklad.appmanager.pages.myCompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.web.moysklad.appmanager.HelperBase;
import ru.web.moysklad.model.OrganizationData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrganizationHelper extends HelperBase {

    public OrganizationHelper(WebDriver wd) {
        super(wd);
    }

    public void inputInformation(OrganizationData organizationData) {
        type(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input"), organizationData.getOrganizationName());
    }

    public void selectFirstOrganization() {
        click(By.xpath("//table[@id='DocumentTableMyCompany']/tbody[1]/tr/td[10]"));
    }

    public Set<OrganizationData> all() {
        Set<OrganizationData> organizations = new HashSet<>();
        WebElement table = wd.findElement(By.cssSelector("tbody[class='tutorial-document-table-body'"));
        List<WebElement> elements = table.findElements(By.tagName("tr"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String name = cells.get(1).getText();
            organizations.add(new OrganizationData().withOrganizationName(name));
        }
        return organizations;
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.title")).getText();
    }
}
