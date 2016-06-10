/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bao;

import java.util.*;
import vn.fpt.project.bo.*;
import vn.fpt.project.dao.DBConnect;

/**
 *
 * @author MyPC
 */
public class ListQuiz {

    private HashMap<Integer, Quiz> listQuiz;
    private DBConnect DB;

    public ListQuiz() {
        DB = new DBConnect();
        listQuiz = new HashMap<>();
    }

    public ListQuiz(HashMap<Integer, Quiz> listQuiz) {
        this.listQuiz = listQuiz;
    }

    public void setListQuiz(HashMap<Integer, Quiz> listQuiz) {
        this.listQuiz = listQuiz;
    }

    public HashMap<Integer, Quiz> getListQuiz() {
        return listQuiz;
    }

    public boolean addNewListQuiz(ArrayList<Quiz> input, String lid) {
        return DB.InSertDataQuiz(input, lid);
    }
    public boolean UpdateListQuiz(ArrayList<Quiz> input, String lid){
        return DB.UpdateDataQuiz(input, lid);
    }

}
