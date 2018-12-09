package ru.itis.helper;

import ru.itis.utils.ApplicationManager;

public class HelperBase {

    private ApplicationManager appManager;

    public HelperBase(ApplicationManager appManager) {
        this.appManager = appManager;
    }

    public ApplicationManager getAppManager() {
        return appManager;
    }
}
