/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import vn.fpt.project.bo.*;
import vn.fpt.project.dao.DBConnect;

/**
 *
 * @author MyPC
 */
public class ListFolder {

    private HashMap<Integer, Folder> listFolder;
    private DBConnect DB;
    private HashMap<Integer, FolderJoinUser> listFolderJoin;

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

    public ArrayList<FolderJoinLessionJoinUsers> getAllLessionInData(String whereID) {
        try {
            ArrayList<FolderJoinLessionJoinUsers> listLession = new ArrayList<>();
            String[] table = {DB.TABLE_FOLDER, DB.TABLE_LESSON_PK_FOLDER, DB.TABLE_LESSON, DB.TABLE_USERS};
            String[] on = {DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_FOLDER[0] + " = " + DB.TABLE_LESSON_PK_FOLDER + "." + DB.FIELD_TABLE_LESSON_PK_FOLDER[0],
                DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_USERS[0] + " = " + DB.TABLE_LESSON + "." + DB.FIELD_TABLE_LESSON[2],
                DB.TABLE_LESSON_PK_FOLDER + "." + DB.FIELD_TABLE_LESSON_PK_FOLDER[1] + " = " + DB.TABLE_LESSON + "." + DB.FIELD_TABLE_LESSON[0],
                DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_FOLDER[2] + " = " + DB.TABLE_USERS + "." + DB.FIELD_TABLE_USERS[0]};
            String fied = DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_FOLDER[0] + ","
                    + DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_FOLDER[1] + ",  "
                    + DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_FOLDER[3] + ", "
                    + DB.TABLE_LESSON + "." + DB.FIELD_TABLE_LESSON[0] + ", "
                    + DB.TABLE_LESSON + "." + DB.FIELD_TABLE_LESSON[1] + ", "
                    + DB.TABLE_LESSON + "." + DB.FIELD_TABLE_LESSON[3] + ", "
                    + DB.TABLE_USERS + "." + DB.FIELD_TABLE_USERS[0] + ", "
                    + DB.TABLE_USERS + "." + DB.FIELD_TABLE_USERS[1];
            String where = DB.TABLE_LESSON_PK_FOLDER + "." + DB.FIELD_TABLE_LESSON_PK_FOLDER[0] + " = " + whereID;
            ResultSet re = DB.selectQueryJoinFourTable(table, on, fied, where);

            while (re.next()) {
                int fid = re.getInt(DB.FIELD_TABLE_FOLDER[0]);
                String name = re.getString(DB.FIELD_TABLE_FOLDER[1]);
                int sharefolder = re.getInt(DB.FIELD_TABLE_FOLDER[3]);
                int lid = re.getInt(DB.FIELD_TABLE_LESSON[0]);
                String title = re.getNString(DB.FIELD_TABLE_LESSON[1]);
                int share = re.getInt(DB.FIELD_TABLE_LESSON[3]);
                int uid = re.getInt(DB.FIELD_TABLE_USERS[0]);
                String username = re.getNString(DB.FIELD_TABLE_USERS[1]);
                FolderJoinLessionJoinUsers add = new FolderJoinLessionJoinUsers(fid, name, sharefolder, lid, title, share, uid, username);
                listLession.add(add);
            }
            return listLession;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public boolean InsertFolder(String name, String uid, String sharefolder) {
        String fiel = "(" + DB.FIELD_TABLE_FOLDER[1] + "," + DB.FIELD_TABLE_FOLDER[2] + "," + DB.FIELD_TABLE_FOLDER[3] + ")";
        String value = "(N'" + name + "'," + Integer.parseInt(uid) + "," + Integer.parseInt(sharefolder) + ")";
        return DB.InsertFolder(DB.TABLE_FOLDER, fiel, value);
    }

    public boolean CreateFolder(Folder add) {
        return true;
    }

    public void getFolderInData() {
        try {
            HashMap<Integer, FolderJoinUser> listFolderJoin = new HashMap<>();
            String on = DB.TABLE_FOLDER + "." + DB.FIELD_TABLE_FOLDER[2] + " = " + DB.TABLE_USERS + "." + DB.FIELD_TABLE_USERS[0];
            System.out.println(on);
            String fied = " " + DB.FIELD_TABLE_FOLDER[0] + " , " + DB.FIELD_TABLE_FOLDER[1] + " , "
                    + "" + DB.FIELD_TABLE_FOLDER[3] + ","
                    + " " + DB.TABLE_USERS + "." + DB.FIELD_TABLE_USERS[0] + " , " + DB.FIELD_TABLE_USERS[1] + " , " + DB.FIELD_TABLE_USERS[3] + "";
            ResultSet re = DB.selectQueryJoinTwoTable(DB.TABLE_FOLDER, DB.TABLE_USERS, on, fied);
            while (re.next()) {
                int fid = re.getInt(DB.FIELD_TABLE_FOLDER[0]);
                String name = re.getNString(DB.FIELD_TABLE_FOLDER[1]);
                int sharefolder = re.getInt(DB.FIELD_TABLE_FOLDER[3]);
                int uid = re.getInt(DB.FIELD_TABLE_USERS[0]);
                String username = re.getNString(DB.FIELD_TABLE_USERS[1]);
                int permission = re.getInt(DB.FIELD_TABLE_USERS[3]);
                FolderJoinUser add = new FolderJoinUser(fid, name, sharefolder, uid, username, permission);
                listFolderJoin.put(re.getInt(DB.FIELD_TABLE_FOLDER[0]), add);
            }
            this.listFolderJoin = listFolderJoin;
        } catch (SQLException ex) {

        }
    }

    public FolderJoinUser searchInFolder(int id) {
        for (Map.Entry<Integer, FolderJoinUser> entry : listFolderJoin.entrySet()) {
            Integer key = entry.getKey();
            FolderJoinUser value = entry.getValue();
            if (key == id) {
                return value;
            }
        }
        return null;
    }

    public HashMap<Integer, FolderJoinUser> getListFolderJoin() {
        return listFolderJoin;
    }

    public void setListFolderJoin(HashMap<Integer, FolderJoinUser> listFolderJoin) {
        this.listFolderJoin = listFolderJoin;
    }

    public boolean EditFolder(String id, String name, String uid, String sharefolder) {
        if (id == null || id.equals("") || !id.matches("[0-9]{1,10}")) {
            return false;
        }
        int fid = Integer.parseInt(id);
        String set = DB.FIELD_TABLE_FOLDER[1] + "=N'" + name + "'," + DB.FIELD_TABLE_FOLDER[2] + " = " + uid + "," + DB.FIELD_TABLE_FOLDER[3] + "=" + sharefolder;
        String where = DB.FIELD_TABLE_FOLDER[0] + "=" + id;
        return DB.Update(DB.TABLE_FOLDER, set, where);
    }

    public ListFolder(HashMap<Integer, Folder> listFolder, DBConnect DB, HashMap<Integer, FolderJoinUser> listFolderJoin) {
        this.listFolder = listFolder;
        this.DB = DB;
        this.listFolderJoin = listFolderJoin;
    }

    public boolean DeleteFolder(String fid) {
        Validation validation = new Validation();
        if (validation.NumberFormatMinMax(fid, 1, 100000000, fid)) {
            FolderJoinUser re = searchInFolder(Integer.parseInt(fid));
            if (re != null) {
                boolean resutl = DB.delete(DB.FIELD_TABLE_FOLDER[0] + "=" + Integer.parseInt(fid), DB.TABLE_FOLDER);
                boolean resut = DB.delete(DB.FIELD_TABLE_FOLDER[0] + "=" + Integer.parseInt(fid), DB.TABLE_LESSON_PK_FOLDER);
                if (resutl && resut) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean DeleteLessionInFolder(String lid, String fid) {
        return DB.deleteLessonInfolder(lid, fid);
    }

    public boolean AddNewLessonInFolder(String lid, String fid) {
        String fied = "(fid, lid)";
        String val = "(" + fid + ", " + lid + ")";
        return DB.InsertFolder(DB.TABLE_LESSON_PK_FOLDER, fied, val);
    }
    public ArrayList<FolderJoinUser> getSearchData(String input){
         ArrayList<FolderJoinUser> arrayList = new ArrayList<>();
         try {
            ResultSet resultSet = DB.selectQueryJoinTwoTable(DB.TABLE_FOLDER, DB.TABLE_USERS, "Pro_Folder.uid = Pro_Users.uid ", "fid, name, Pro_Users.uid, sharefolder, username, permission");
            while (resultSet.next()) {
                int fid = resultSet.getInt(DB.FIELD_TABLE_FOLDER[0]);
                String name = resultSet.getNString(DB.FIELD_TABLE_FOLDER[1]);
                int sharefolder = resultSet.getInt(DB.FIELD_TABLE_FOLDER[3]);
                int uid = resultSet.getInt(DB.FIELD_TABLE_FOLDER[2]);
                String username = resultSet.getNString(DB.FIELD_TABLE_USERS[1]);
                int permission = resultSet.getInt(DB.FIELD_TABLE_USERS[3]);
                if(name.contains(input)){
                   arrayList.add(new FolderJoinUser(fid, name, sharefolder, uid, username, permission)); 
                }
            }
        } catch (SQLException ex) {
            return null;
        }
         return arrayList;
    }
}


