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
public class FolderJoinUser {

    private int fid;
    private String name;
    private int sharefolder;
    private int uid;
    private String username;
    private int permission;

    public FolderJoinUser(int fid, String name, int sharefolder, int uid, String username, int permission) {
        this.fid = fid;
        this.name = name;
        this.sharefolder = sharefolder;
        this.uid = uid;
        this.username = username;
        this.permission = permission;
    }

    public FolderJoinUser() {
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
