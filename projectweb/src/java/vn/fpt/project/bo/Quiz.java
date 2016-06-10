/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

/**
 *
 * @author MyPC
 */
public class Quiz {

    private int qid;
    private String question;
    private String answer;
    private int lid;

    public Quiz() {
    }

    public Quiz(int qid, String question, String answer, int lid) {
        this.qid = qid;
        this.question = question;
        this.answer = answer;
        this.lid = lid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return qid + "" + answer+ question + lid;
    }
    
}
