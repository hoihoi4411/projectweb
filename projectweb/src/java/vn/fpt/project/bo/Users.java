/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

import java.sql.SQLException;
import java.util.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.dao.*;

/**
 *
 * @author MyPC
 */
public class Users {

    private int uid;
    private String username;
    private String password;
    private int permission;
    private DBConnect DB;
    private HashMap<Integer, Folder> listFolder;
    private HashMap<Integer, Lesson> listLession;

    public Users(int uid, String username, String password, int permission) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    public Users() {
        DB = new DBConnect();
        permission = 1;
    }

    public void setListFolder(HashMap<Integer, Folder> listFolder) {
        this.listFolder = listFolder;
    }

    public void setListLession(HashMap<Integer, Lesson> listLession) {
        this.listLession = listLession;
    }

    public HashMap<Integer, Folder> getListFolder() {
        return listFolder;
    }

    public HashMap<Integer, Lesson> getListLession() {
        return listLession;
    }

    public boolean isLoggin(String username, String password) {
        try {
            String where = "username = '" + username + "' and password = '" + Hash.Sha256(password) + "'";
            int count = DB.toCountTable(DB.TABLE_USERS, where);
            if (count == 1) {
                return true;
            }

        } catch (SQLException ex) {
            return false;
        }
        return false;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {

        this.permission = permission;
    }

    @Override
    public String toString() {
        return uid + "|" + getUsername() + "|" + getPermission();
    }

}
