package ru.itis.utils;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.helper.LoginHelper;
import ru.itis.helper.NavigationHelper;
import ru.itis.helper.PostHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private String baseUrl = "https://www.tumblr.com/login";
    private StringBuffer verificationErrors = new StringBuffer();
    private String pathToDriver = "C:\\Users\\Stacy\\Desktop\\Уник\\Тесты\\chromedriver_win32\\chromedriver.exe";
    private String driverName = "webdriver.chrome.driver";

    private NavigationHelper navigationHelper;

    private LoginHelper loginHelper;
    private PostHelper postHelper;

    private static ApplicationManager instance;


    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private ApplicationManager() {
        System.setProperty(driverName, pathToDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        navigationHelper  = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        postHelper = new PostHelper(this);
    }

    public static ApplicationManager getInstance() {
        ApplicationManager result = instance;
        if (result == null) {
            synchronized (ApplicationManager.class) {
                result = instance;
                if (result == null)
                    instance = result = new ApplicationManager();
            }
        }
        return result;
    }

    public NavigationHelper getNavigation() {
        return navigationHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginHelper getAuth() {
        return loginHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
