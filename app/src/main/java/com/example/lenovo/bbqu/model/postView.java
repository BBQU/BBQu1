package com.example.lenovo.bbqu.model;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/6/10.
 */
public class postView implements Serializable {
    String postName;
    String mainPost;
    String user;

    public String getPostName() {
        return postName;
    }

    public String getMainPost() {
        return mainPost;
    }

    public String getUser() {
        return user;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setMainPost(String mainPost) {
        this.mainPost = mainPost;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDate(String postName,String mainPost,String user){
        this.postName=postName;
        this.mainPost=mainPost;
        this.user=user;
    }
}
