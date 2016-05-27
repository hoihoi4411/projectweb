/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

import vn.fpt.project.bao.*;

/**
 *
 * @author MyPC
 */
public class Folder {
    private int fid;
    private String name;
    private int uid;
    private int sharefolder;
    private ListLession listlession;

    public Folder() {
        listlession = new ListLession();
        sharefolder = 1;
    }

    public Folder(int fid, String name, int uid, int sharefolder) {
        this.fid = fid;
        this.name = name;
        this.uid = uid;
        this.sharefolder = sharefolder;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSharefolder() {
        return sharefolder;
    }

    public void setSharefolder(int sharefolder) {
        this.sharefolder = sharefolder;
    }
    
    
}
