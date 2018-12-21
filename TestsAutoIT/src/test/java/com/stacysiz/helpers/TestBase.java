package com.stacysiz.helpers;

import com.stacysiz.utils.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    public ApplicationManager applicationManager;

    public TestBase() {
        applicationManager = new ApplicationManager();
    }

    @Before
    public void start() throws InterruptedException {
        applicationManager.getStartUpHelper().startUp();
    }

    @After
    public void close() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationManager.getAutoItX().winClose("Калькулятор");
    }
}
