package ru.itis.helper;

import org.junit.After;
import org.junit.Before;
import ru.itis.utils.ApplicationManager;


public class TestBase {

    private ApplicationManager appManager;

    @Before
    public void setUp() {
        appManager = ApplicationManager.getInstance() ;
    }

//    @After
//    public void tearDown() {
//        appManager.stop();
//    }

    protected void setApp(ApplicationManager appManager) {
        this.appManager = appManager;
    }

    protected ApplicationManager getAppManager() {
        return appManager;
    }
}