package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase{

    public LoginHelper(ApplicationManager app) {
        super(app);
    }

    public void byUser(String username, String password) {
        wd.get(app.getProperty("web.baseUrl"));
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.xpath("//form[@id='login-form']/fieldset/input[2]"));
    }
}
