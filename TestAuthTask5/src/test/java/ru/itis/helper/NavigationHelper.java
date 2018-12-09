package ru.itis.helper;

import ru.itis.utils.ApplicationManager;
import ru.itis.utils.ReadXmlFile;

public class NavigationHelper extends HelperBase {

    ReadXmlFile readXmlFile = new ReadXmlFile();

    public String getProfilePage() {
        return readXmlFile.getProfileUrl();
    }

    public NavigationHelper(ApplicationManager appManager) {
        super(appManager);
    }

    public void getOnLoginPage(){
        getAppManager().getDriver().get(readXmlFile.getLoginUrl());
    }
    public void getOnProfilePage(){
        getAppManager().getDriver().get(readXmlFile.getProfileUrl());
    }

    public void getOnLogoutPage(){
        getAppManager().getDriver().get(readXmlFile.getLogoutUrl());
    }
}
