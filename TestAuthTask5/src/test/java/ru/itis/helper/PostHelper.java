package ru.itis.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.itis.models.PostData;
import ru.itis.utils.ApplicationManager;
import ru.itis.utils.ReadXmlFromConsole;

import java.util.List;

public class PostHelper extends HelperBase {

    private PostData postData;
    private ReadXmlFromConsole xmlFromConsole = new ReadXmlFromConsole();

    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void makePost() throws InterruptedException {
        getAppManager().getDriver().get("https://www.tumblr.com/blog/canigetmaxscoreplz/new/text");
        Thread.sleep(3000);
//        xmlFromConsole = new ReadXmlFromConsole();
        postData = new PostData();
        postData.setMainPostBody(xmlFromConsole.getPost());
        this.postMainBody(postData);
//        getAppManager().getDriver().findElement(By.className("post-form--tag-editor")).click();
//        postHashTags(post);
        getAppManager().getDriver().findElement(By.className("post-form--save-button")).click();
//        Thread.sleep(2000);
    }

    private void postMainBody(PostData postOne) {
        getAppManager().getDriver().switchTo().activeElement().sendKeys(postOne.getMainPostBody());
    }

    private void postHashTags(PostData post) {
        getAppManager().getDriver().switchTo().activeElement().sendKeys(post.getHashTags());
    }

    public PostData getCreatedPostData() {
        PostData createdPostData = new PostData();
        List<WebElement> liPostBody = getAppManager().getDriver().findElements(By.className("post_body"));
        String postBody = liPostBody.get(0).getText();
        createdPostData.setMainPostBody(postBody);
        List<WebElement> liHashTags = getAppManager().getDriver().findElements(By.className("post_tags_inner"));
        String hashTags = liHashTags.get(0).getText();
        createdPostData.setHashTags(hashTags);
        return createdPostData;
    }

    public PostData getPostDataGenerated() {
        PostData data = new PostData();
        data.setMainPostBody(xmlFromConsole.getPost());
        return data;
    }
}
