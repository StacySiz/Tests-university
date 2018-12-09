package ru.itis.models;

public class PostData {
    private String mainPostBody;
    private String hashTags;

    public PostData(String mainPostBody, String hashTags) {
        this.mainPostBody = mainPostBody;
        this.hashTags = hashTags;
    }

    public PostData(String mainPostBody) {
        this.mainPostBody = mainPostBody;
    }

    public PostData() {
    }

    public String getMainPostBody() {
        return mainPostBody;
    }

    public void setMainPostBody(String mainPostBody) {
        this.mainPostBody = mainPostBody;
    }

    public String getHashTags() {
        return hashTags;
    }

    public void setHashTags(String hashTags) {
        this.hashTags = hashTags;
    }
}
