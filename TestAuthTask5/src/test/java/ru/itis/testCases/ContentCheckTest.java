package ru.itis.testCases;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.helper.PostHelper;
import ru.itis.helper.TestBase;
import ru.itis.models.PostData;

public class ContentCheckTest extends TestBase {
    @Test
    public void testContentCheck() throws Exception {
        getAppManager().getAuth().login(getAppManager().getAuth().createUser());
        getAppManager().getNavigation().getOnProfilePage();
        PostData createdPost = getAppManager().getPostHelper().getCreatedPostData();
        Assert.assertEquals(getAppManager().getPostHelper().getPostDataGenerated().getMainPostBody(), createdPost.getMainPostBody());
//        Assert.assertEquals(PostHelper.post.getHashTags(), createdPost.getHashTags());
    }
}
