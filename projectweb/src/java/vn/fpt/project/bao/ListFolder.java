/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.fpt.project.bo.*;
import vn.fpt.project.dao.DBConnect;

/**
 *
 * @author MyPC
 */
public class ListFolder {

    private HashMap<Integer, Folder> listFolder;
    private DBConnect DB;

    public ListFolder() {
        DB = new DBConnect();
        listFolder = new HashMap<>();
    }

    public ListFolder(HashMap<Integer, Folder> listFolder) {
        this.listFolder = listFolder;
    }

    public void setListFolder(HashMap<Integer, Folder> listFolder) {
        this.listFolder = listFolder;
    }

    public HashMap<Integer, Folder> getListFolder() {
        return listFolder;
    }

    public HashMap<Integer, Lesson> getDataLession(int id) {
        HashMap<Integer, Lesson> listLessionInFolder = new HashMap<>();
        for (Map.Entry<Integer, Folder> entry : listFolder.entrySet()) {
            Integer key = entry.getKey();

        }
        return listLessionInFolder;
    }

//    public HashMap<Integer, Lesson> getAllLessionInData() {
//        try {
//            HashMap<Integer, Lesson> listLession = new HashMap<>();
//            ResultSet re =  DB.selectQuery(DB.TABLE_FOLDER, "");
//            while(re.next()){
//                
//            }
//            return listLession;
//        } catch (SQLException ex) {
//            Logger.getLogger(ListFolder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public boolean CreateFolder(Folder add){
        return true;
    }
}
