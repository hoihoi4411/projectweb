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
public class Lesson {
    private int lid;
    private String title;
    private int uid;
    private int share;

    public Lesson() {
        share = 1;
    }

    public Lesson(int lid, String title, int uid, int share) {
        this.lid = lid;
        this.title = title;
        this.uid = uid;
        this.share = share;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }
    
    
    
    
}
