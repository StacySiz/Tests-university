package ru.itis.testCases;

import org.junit.Test;
import ru.itis.helper.PostHelper;
import ru.itis.helper.TestBase;

public class PostTest extends TestBase {

    @Test
    public void testPost() throws Exception {
        getAppManager().getAuth().login(getAppManager().getAuth().createUser());
        getAppManager().getNavigation().getOnProfilePage();
        getAppManager().getPostHelper().makePost();
    }
}
