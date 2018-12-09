package ru.itis.helper;

import org.openqa.selenium.By;
import ru.itis.models.AccountData;
import ru.itis.utils.ApplicationManager;
import ru.itis.utils.ReadXmlFile;

public class LoginHelper extends HelperBase {

    public AccountData getUser() {
        return user;
    }

    public void setUser(AccountData user) {
        this.user = user;
    }

    public AccountData user = new AccountData();

    ReadXmlFile readXmlFile = new ReadXmlFile();

    public AccountData createUser() {
        user.setEmail(readXmlFile.getUserEmail());
        user.setPassword(readXmlFile.getUserPassword());
        return user;
    }


    private boolean isLoggedIn() {
        getAppManager().getNavigation().getOnProfilePage();
        String currentUrl = getAppManager().getDriver().getCurrentUrl();
        String profilePage = getAppManager().getNavigation().getProfilePage();
        return currentUrl.equals(profilePage);
    }

    private boolean isLoggedIn(String email) {
        if (isLoggedIn()) {
            return getLoggedInEmail().equals(email);
        }
        return false;
    }

    private String getLoggedInEmail() {
        getAppManager().getNavigation().getOnProfilePage();
        getAppManager().getDriver().findElement(By.className("tab iconic tab_nav_account ")).click();
        String loggedEmail = getAppManager().getDriver().findElements(By.className("blog-list-item-info-name")).get(0).getText();
        System.out.println(loggedEmail);
        return loggedEmail;
    }

    public LoginHelper(ApplicationManager appManager) {
        super(appManager);
    }

    public void login(AccountData user) throws InterruptedException {
        if (isLoggedIn()) {
            logout();
        } else {
            getAppManager().getNavigation().getOnLoginPage();
            fillInEmailTestCase(user);
            fillInPasswordTestCase(user);
        }
    }

    public void logout() {
        getAppManager().getNavigation().getOnLogoutPage();
    }

    private void loginEmail(AccountData user) {
        getAppManager().getDriver().switchTo().activeElement().sendKeys(user.getEmail());
    }

    private void loginPassword(AccountData user) {
        getAppManager().getDriver().switchTo().activeElement().sendKeys(user.getPassword());
    }

    public void fillInEmailTestCase(AccountData user) throws InterruptedException {
        Thread.sleep(5000);
        loginEmail(user);
        submitForm();
    }

    public void fillInPasswordTestCase(AccountData user) throws InterruptedException {
        Thread.sleep(5000);
        getAppManager().getDriver().findElement(By.className("forgot_password_link")).click();
        loginPassword(user);
        submitForm();
    }

    public void submitForm() {
        getAppManager().getDriver().findElement(By.id("signup_forms_submit")).click();
    }

}
