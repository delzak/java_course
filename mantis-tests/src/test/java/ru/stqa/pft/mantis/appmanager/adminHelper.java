package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.model.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class adminHelper extends HelperBase{

    public adminHelper(ApplicationManager app) {
        super(app);
    }

    public void goToManagePanel() {
        click(By.linkText("управление"));
    }

    public void goToManageUsers() {
        click(By.linkText("Управление пользователями"));
    }

    public Set<UserData> all() {
        Set<UserData> users = new HashSet<>();
        WebElement body = wd.findElement(By.tagName("tbody"));
        List<WebElement> elements = body.findElements(By.tagName("tr"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String name = cells.get(0).getText();
            String email = cells.get(2).getText();
            users.add(new UserData().withName(name).withEmail(email));
        }
        return users;
    }

    public UserData changeUser() {
        WebElement body = wd.findElement(By.tagName("tbody"));
        List<WebElement> row = body.findElements(By.tagName("tr"));
        List<WebElement> cells = row.get(1).findElements(By.tagName("td"));
        String name = cells.get(0).getText();
        String email = cells.get(2).getText();
        return new UserData().withName(name).withEmail(email);
    }

    public void selectUser(String username) {
        click(By.linkText(username));
    }

    public void resetPassword() {
        click(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input"));
    }
}
