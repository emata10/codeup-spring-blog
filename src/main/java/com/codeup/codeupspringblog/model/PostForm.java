package com.codeup.codeupspringblog.model;

public class PostForm {
    private Long id;
    private String title;
    private String body;

    public PostForm() {
    }

    public PostForm(String title, String body) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getContent() {

        return null;
    }
}
