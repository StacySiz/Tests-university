package ru.itis.testCases;

import org.junit.Test;
import ru.itis.helper.AuthBase;
import ru.itis.helper.LoginHelper;
import ru.itis.models.AccountData;

public class LoginTest extends AuthBase {
    @Test
    public void LoginWithValidData() throws Exception {
        AccountData user = getAppManager().getAuth().createUser();
        getAppManager().getAuth().login(user);
    }

    @Test
    public void LoginWithInvalidData() throws Exception {
        AccountData invalidAccount = new AccountData("kurica_jenshina@mail.ru", "InvalidPassword");
        getAppManager().getAuth().login(invalidAccount);
    }
}
