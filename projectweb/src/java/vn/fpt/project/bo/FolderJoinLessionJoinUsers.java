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
public class FolderJoinLessionJoinUsers {

    private int fid;
    private String name;
    private int sharefolder;
    private int lid;
    private String title;
    private int share;
    private int uid;
    private String username;

    public FolderJoinLessionJoinUsers() {
    }

    public FolderJoinLessionJoinUsers(int fid, String name, int sharefolder, int lid, String title, int share, int uid, String username) {
        this.fid = fid;
        this.name = name;
        this.sharefolder = sharefolder;
        this.lid = lid;
        this.title = title;
        this.share = share;
        this.uid = uid;
        this.username = username;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSharefolder() {
        return sharefolder;
    }

    public void setSharefolder(int sharefolder) {
        this.sharefolder = sharefolder;
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
    
}
