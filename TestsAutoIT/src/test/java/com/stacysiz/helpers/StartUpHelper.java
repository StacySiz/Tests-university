package com.stacysiz.helpers;

import autoitx4java.AutoItX;
import com.stacysiz.utils.ApplicationManager;

public class StartUpHelper extends HelperBase{

    public StartUpHelper(ApplicationManager manager) {
        super(manager);
    }
    public void startUp() throws InterruptedException {
        applicationManager.getAutoItX().run("calc.exe","C:\\Users\\Stacy\\Desktop\\Уник", AutoItX.SW_SHOWNORMAL);
        applicationManager.getAutoItX().winActivate("Calculator");
        Thread.sleep(5000);
    }
}
