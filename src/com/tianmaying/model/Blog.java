package com.tianmaying.model;

import java.util.Date;

 public class Blog {
    private long id;
    private String title;
    private String content;
    private Date createdTime;
    private User author;
    
    private static int count = 0;
    
    public Blog(){
        id = count++; // count的类型为int，这里Java编译器会自动将int转换为long
        createdTime = new Date();
    }
    
    public Blog(String title, String content) {
        this.id = count++;
        this.title = title;
        this.content = content;
        createdTime = new Date();
    }
    
    public Blog(String title, String content, User author) {
        this(title, content);
        this.author = author;
    }
    
    public void print() {
        System.out.println(this.title);
        System.out.println(this.content);
    }
     public long getId() {
        return id;
    }
     public void setId(long id) {
        this.id = id;
    }
     public String getTitle() {
        return title;
    }
     public void setTitle(String title) {
        this.title = title;
    }
     public String getContent() {
        return content;
    }
     public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
 }