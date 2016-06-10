/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

/**
 *
 * @author MyPC
 */
public class LessonJoinUser {

    private int lid;
    private String title;
    
    private int share;
    private int uid;
    private String username;
    private int permission;

    public LessonJoinUser() {
    }

    public LessonJoinUser(int lid, String title, int share, int uid, String username, int permission) {
        this.lid = lid;
        this.title = title;
        this.share = share;
        this.uid = uid;
        this.username = username;
        this.permission = permission;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
    
}
