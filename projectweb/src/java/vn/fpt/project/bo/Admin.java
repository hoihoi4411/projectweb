/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

import java.sql.SQLException;
import vn.fpt.project.dao.DBConnect;

/**
 *
 * @author MyPC
 */
public class Admin extends Users {

    private final int[] idAdmin = {1};
    private DBConnect DB;

    public Admin() {
        DB = new DBConnect();
    }

    public boolean isAdmin(String username, String password) {
        try {
            for (int i = 0; i < idAdmin.length; i++) {
                String where = "username = '" + username + "' and password = '" + Hash.Sha256(password + username) + "' and uid = " + idAdmin[i];
                int count = DB.toCountTable(DB.TABLE_USERS, where);
                if (count == 1) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
//    public static void main(String[] args) {
//        Admin a = new Admin();
//        System.out.println(a.isAdmin("hoatran", "hoatran"));
//    }
}
