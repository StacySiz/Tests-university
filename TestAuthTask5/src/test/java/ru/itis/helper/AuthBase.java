package ru.itis.helper;

import ru.itis.utils.ApplicationManager;

public class AuthBase extends TestBase {

    private ApplicationManager manager;

    public void setUpTest() {
        super.setUp();
        getAppManager().getNavigation().getOnLoginPage();
    }
}
