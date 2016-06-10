/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

import java.util.*;
import vn.fpt.project.bao.*;

/**
 *
 * @author MyPC
 */
public class Lesson {

    private int lid;
    private String title;
    private int uid;
    private int share;
    private HashMap<Integer, Quiz> listAQuiz;

    public Lesson() {
        listAQuiz = new HashMap<>();
        share = 1;
    }

    public Lesson(int lid, String title, int uid, int share, HashMap<Integer, Quiz> listAQuiz) {
        this.lid = lid;
        this.title = title;
        this.uid = uid;
        this.share = share;
        this.listAQuiz = listAQuiz;
    }

    public Lesson(int lid, String title, int uid, int share) {
        this.lid = lid;
        this.title = title;
        this.uid = uid;
        this.share = share;
    }

    public void setListAQuiz(HashMap<Integer, Quiz> listAQuiz) {
        this.listAQuiz = listAQuiz;
    }

    public HashMap<Integer, Quiz> getListAQuiz() {
        return listAQuiz;
    }

    public String NomalForm(String input) {
        String[] SliString = input.split("\\s+");
        String out = "";
        for (int i = 0; i < SliString.length; i++) {
            char arrChar[] = SliString[i].toCharArray();
            int position = -1;
            for (int j = 0; j < arrChar.length; j++) {
                if (Character.isLetter(arrChar[j])) {
                    position = j;
                    arrChar[j] = Character.toUpperCase(arrChar[j]);
                }
                if (position != -1) {
                    arrChar[j] = Character.toLowerCase(arrChar[j]);
                }
                out += arrChar[j];
            }
            out += " ";

        }
        return out;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return lid + "   " + title + "\n";
    }
    public static void main(String[] args) {
        Lesson l = new Lesson();
        System.out.println(l.NomalForm(".net and java"));
    }
}
