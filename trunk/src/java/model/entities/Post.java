/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Post {

    private int postID;
    private String title;
    private String pathContent;
    private String pathImage;
    private Date postDate;
    private User user;
    private Category category;
    private boolean isActive;

    public Post() {

    }

    public Post(int postID, String title, String pathContent, String pathImage, Date postDate, User user, Category category, boolean isActive) {
        this.postID = postID;
        this.title = title;
        this.pathContent = pathContent;
        this.pathImage = pathImage;
        this.postDate = postDate;
        this.user = user;
        this.category = category;
        this.isActive = isActive;
    }

   

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPathContent() {
        return pathContent;
    }

    public void setPathContent(String pathContent) {
        this.pathContent = pathContent;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }   

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}
