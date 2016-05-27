/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bao;

import java.sql.*;
import java.util.*;
import vn.fpt.project.bo.*;
import vn.fpt.project.dao.*;

/**
 *
 * @author MyPC
 */
public class ListUser {

    private DBConnect DB;
    private ArrayList<Users> listUser;

    public ListUser() {
        DB = new DBConnect();
        listUser = new ArrayList<>();
    }

    public ListUser(DBConnect DB, ArrayList<Users> listUser) {
        this.DB = DB;
        this.listUser = listUser;
    }

    public void getListData() {
        try {
            ResultSet resultSet = DB.selectQuery(DB.TABLE_USERS, "");
            while (resultSet.next()) {

                listUser.add(new Users(resultSet.getInt(DB.FIELD_TABLE_USERS[0]), resultSet.getNString(DB.FIELD_TABLE_USERS[1]),
                        resultSet.getNString(DB.FIELD_TABLE_USERS[2]), resultSet.getInt(DB.FIELD_TABLE_USERS[3])
                ));
            }
            for (int i = 0; i < listUser.size(); i++) {
                HashMap<Integer, Folder> listAUser = new HashMap<>();
                try {
                    ResultSet result = DB.selectQuery(DB.TABLE_FOLDER, "uid = " + listUser.get(i).getUid());
                    Users newUs = listUser.get(i);
                    while (result.next()) {
                        int fid = result.getInt(DB.FIELD_TABLE_FOLDER[0]);
                        String name = result.getString(DB.FIELD_TABLE_FOLDER[1]);
                        int uid = result.getInt(DB.FIELD_TABLE_FOLDER[2]);
                        int share = result.getInt(DB.FIELD_TABLE_FOLDER[3]);
                        listAUser.put(fid, new Folder(fid, name, uid, share));

                    }
                    listUser.get(i).setListFolder(listAUser);
                } catch (SQLException ex) {
                }
            }
            for (int i = 0; i < listUser.size(); i++) {
                HashMap<Integer, Lesson> listAUser = new HashMap<>();
                try {
                    ResultSet result = DB.selectQuery(DB.TABLE_LESSON, "uid = " + listUser.get(i).getUid());
                    Users newUs = listUser.get(i);
                    while (result.next()) {
                        int fid = result.getInt(DB.FIELD_TABLE_LESSON[0]);
                        String name = result.getNString(DB.FIELD_TABLE_LESSON[1]);
                        int uid = result.getInt(DB.FIELD_TABLE_LESSON[2]);
                        int share = result.getInt(DB.FIELD_TABLE_LESSON[3]);
                        listAUser.put(fid, new Lesson(fid, name, uid, share));

                    }
                    listUser.get(i).setListLession(listAUser);
                } catch (SQLException ex) {

                }
            }
        } catch (SQLException ex) {
        }

    }

    public ArrayList<Users> getListUser() {

        return listUser;
    }

    public boolean InsertNewUser(String username, String password, String permisson) {
        try {
            Validation validation = new Validation();
            int count = DB.toCountTable(DB.TABLE_USERS, "username = '" + username + "'");
            if (count == 0) {
                if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.StringFormatMinMax(password, 5, 15, "password") && validation.NumberFormatMinMax(permisson, 1, 2, "permission")) {
                    return DB.InsertUsers(DB.TABLE_USERS, username, Hash.Sha256(password + username), Integer.parseInt(permisson));
                }
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Users SearchUser(int uid) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUid() == uid && listUser.get(i).getPermission() != 1) {
                return listUser.get(i);
            }
        }
        return null;
    }

    public boolean UpdateUser(String username, String password, String permission, int uid) {
        if (password == null) {
            Validation validation = new Validation();
            int count = 0;
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getUsername().equals(username)) {
                    count++;
                }
            }

            if (count <= 1 && validation.NumberFormatMinMax(permission, 1, 2, "permission")) {
                String set = DB.FIELD_TABLE_USERS[1] + " = '" + username + "', " + DB.FIELD_TABLE_USERS[3] + " = " + Integer.parseInt(permission);
                String where = DB.FIELD_TABLE_USERS[0] + " = " + uid + "";

                return DB.Update(DB.TABLE_USERS, set, where);
            } else {
                return false;
            }
        } else {
            Validation validation = new Validation();
            int count = 0;
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getUsername().equals(username)) {
                    count++;
                }
            }
            if (count <= 1 && validation.NumberFormatMinMax(permission, 1, 2, "permisson") && validation.StringFormatMinMax(password, 5, 15, "password")) {
                String set = DB.FIELD_TABLE_USERS[1] + " = '" + username + "'," + DB.FIELD_TABLE_USERS[2] + "= '" + Hash.Sha256(password + username) + "', " + DB.FIELD_TABLE_USERS[3]
                        + " = " + Integer.parseInt(permission);
                String where = DB.FIELD_TABLE_USERS[0] + " = " + uid + "";
                return DB.Update(DB.TABLE_USERS, set, where);
            } else {
                return false;
            }
        }
    }

    public boolean deleteUser(int uid) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUid() == uid) {
                String fied = DB.FIELD_TABLE_USERS[0] + " = " + uid;
                return DB.delete(fied, DB.TABLE_USERS);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListUser list = new ListUser();
        DBConnect DB = new DBConnect();
        list.getListData();
//        for (int i = 0; i < list.listUser.size(); i++) {
//            HashMap<Integer, Lesson> listAUser = new HashMap<>();
//            try {
//                ResultSet result = DB.selectQuery(DB.TABLE_LESSON, "uid = " + list.listUser.get(i).getUid());
//                Users newUs = list.listUser.get(i);
//                while (result.next()) {
//                    int fid = result.getInt(DB.FIELD_TABLE_LESSON[0]);
//                    String name = result.getNString(DB.FIELD_TABLE_LESSON[1]);
//                    int uid = result.getInt(DB.FIELD_TABLE_LESSON[2]);
//                    int share = result.getInt(DB.FIELD_TABLE_LESSON[3]);
//                    listAUser.put(fid, new Lesson(fid, name, uid, share));
//
//                }
//                list.listUser.get(i).setListLession(listAUser);
//            } catch (SQLException ex) {
//
//            }
//        }
        System.out.println(list.listUser.get(2).getListFolder());
        System.out.println(list.listUser.get(1).getUid());
    }

}
