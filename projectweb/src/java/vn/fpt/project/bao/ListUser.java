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
                System.out.println(resultSet.getInt(DB.FIELD_TABLE_USERS[0]));
                listUser.add(new Users(resultSet.getInt(DB.FIELD_TABLE_USERS[0]), resultSet.getNString(DB.FIELD_TABLE_USERS[1]),
                        resultSet.getNString(DB.FIELD_TABLE_USERS[2]), resultSet.getInt(DB.FIELD_TABLE_USERS[3])
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
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
                    return DB.InsertUsers(DB.TABLE_USERS, username, password, Integer.parseInt(permisson));
                }
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

}
