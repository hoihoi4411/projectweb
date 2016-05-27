/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bao;

import java.util.*;
import vn.fpt.project.bo.*;

/**
 *
 * @author MyPC
 */
public class ListQuiz {

    HashMap<Integer, Quiz> listQuiz;

    public ListQuiz() {
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

    

}
