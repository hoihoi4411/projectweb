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
public class ListLession {

    HashMap<Integer, Lesson> listLession;
    private DBConnect DB;

    public ListLession(HashMap<Integer, Lesson> listLession, DBConnect DB) {
        this.listLession = listLession;
        this.DB = DB;
    }

    public ListLession(HashMap<Integer, Lesson> listLession) {
        this.listLession = listLession;
    }

    public ListLession() {
        DB = new DBConnect();
    }

    public void getData() {
        try {
            ResultSet re = DB.selectQuery(DB.TABLE_LESSON, "");
            while (re.next()) {
                Lesson add = new Lesson(re.getInt(DB.FIELD_TABLE_LESSON[0]), re.getNString(DB.FIELD_TABLE_LESSON[1]), re.getInt(DB.FIELD_TABLE_LESSON[2]), re.getInt(DB.FIELD_TABLE_LESSON[3]));
                listLession.put(add.getLid(), add);
            }
            for (int i = 0; i < listLession.size(); i++) {
                HashMap<Integer, Quiz> listAQuiz = new HashMap<>();
                try {
                    ResultSet result = DB.selectQuery(DB.TABLE_QUIZ, DB.FIELD_TABLE_QUIZ[3] + " = " + listLession.get(i).getLid());
                    Lesson newUs = listLession.get(i);
                    while (result.next()) {
                        int fid = result.getInt(DB.FIELD_TABLE_QUIZ[0]);
                        String ques = result.getString(DB.FIELD_TABLE_QUIZ[1]);
                        String ans = result.getString(DB.FIELD_TABLE_QUIZ[2]);
                        int lid = result.getInt(DB.FIELD_TABLE_QUIZ[3]);
                        listAQuiz.put(fid, new Quiz(fid, ques, ans, lid));

                    }
                    listLession.get(i).setListAQuiz(listAQuiz);
                } catch (SQLException ex) {
                }
            }
        } catch (SQLException ex) {
        }

    }
    
    public HashMap<Integer, Lesson> getListLession() {
        return listLession;
    }

    public void setListLession(HashMap<Integer, Lesson> listLession) {
        this.listLession = listLession;
    }

}
