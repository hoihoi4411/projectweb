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
import vn.fpt.project.dao.*;

/**
 *
 * @author MyPC
 */
public class ListLession {

    private HashMap<Integer, Lesson> listLession;
    private DBConnect DB;
    private ArrayList<Lesson> listLessonB;

    public ListLession(HashMap<Integer, Lesson> listLession) {
        this.listLession = listLession;
    }

    public ListLession() {
        listLession = new HashMap<>();
        DB = new DBConnect();
        listLessonB = new ArrayList<>();

    }

    public ArrayList<Lesson> getListLessonB() {
        return listLessonB;
    }

    public void getData() {
        try {
            ResultSet re = DB.selectQuery(DB.TABLE_LESSON, "");
            while (re.next()) {

                Lesson add = new Lesson(re.getInt(DB.FIELD_TABLE_LESSON[0]),
                        re.getNString(DB.FIELD_TABLE_LESSON[1]),
                        re.getInt(DB.FIELD_TABLE_LESSON[2]),
                        re.getInt(DB.FIELD_TABLE_LESSON[3]));
                listLession.put(add.getLid(), add);
                listLessonB.add(add);
            }

            for (Map.Entry<Integer, Lesson> entry : listLession.entrySet()) {
                Integer key = entry.getKey();
                Lesson value = entry.getValue();
                ResultSet result = DB.selectQuery(DB.TABLE_QUIZ, DB.FIELD_TABLE_QUIZ[3] + " = " + value.getLid());
                HashMap<Integer, Quiz> listAQuiz = new HashMap<>();
                while (result.next()) {
                    int qid = result.getInt(DB.FIELD_TABLE_QUIZ[0]);
                    String ques = result.getString(DB.FIELD_TABLE_QUIZ[1]);
                    String ans = result.getString(DB.FIELD_TABLE_QUIZ[2]);
                    int lid = result.getInt(DB.FIELD_TABLE_QUIZ[3]);
                    listAQuiz.put(qid, new Quiz(qid, ques, ans, lid));

                }
                value.setListAQuiz(listAQuiz);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public String NomalForm(String input) {
        String[] SliString = input.split("\\s+");
        String out = "";
        for (int i = 0; i < SliString.length; i++) {
            char arrChar[] = SliString[i].toCharArray();
            int position = -1;
            int count = 0;
            for (int j = 0; j < arrChar.length; j++) {
                if (Character.isLetter(arrChar[j]) && count == 0) {
                    position = j;
                    count++;
                    arrChar[j] = Character.toUpperCase(arrChar[j]);
                }
                if (position != j && Character.isUpperCase(arrChar[j])) {
                    arrChar[j] = Character.toLowerCase(arrChar[j]);
                }
                out += arrChar[j];
            }
            out += " ";

        }
        return out;
    }

    public boolean UpdateLesson(int lid, String title, int uid, int share) {
        title = NomalForm(title);
        String set = DB.FIELD_TABLE_LESSON[1] + " = N'" + title + "', " + DB.FIELD_TABLE_LESSON[2] + " = " + uid + " , " + DB.FIELD_TABLE_LESSON[3] + " = " + share;
        String where = DB.FIELD_TABLE_LESSON[0] + " = " + lid;
        return DB.Update(DB.TABLE_LESSON, set, where);
    }

    public Lesson searchLession(String lid) {
        for (Map.Entry<Integer, Lesson> entry : listLession.entrySet()) {
            Integer key = entry.getKey();
            Lesson value = entry.getValue();
            if (key == Integer.parseInt(lid)) {
                return value;
            }

        }
        return null;
    }

    public boolean addNewLesson(String title, String uid, String share) {
        title = NomalForm(title);
        String fiel = "(" + DB.FIELD_TABLE_LESSON[1] + ", " + DB.FIELD_TABLE_LESSON[2] + ", " + DB.FIELD_TABLE_LESSON[3] + ")";
        String value = "(N'" + title + "', " + uid + ", " + share + ")";
        return DB.InsertFolder(DB.TABLE_LESSON, fiel, value);
    }

    public boolean deleteLession(int id) {
        return DB.delete(DB.FIELD_TABLE_LESSON[0] + "=" + id, DB.TABLE_LESSON);
    }

    public HashMap<Integer, Lesson> getListLession() {
        return listLession;
    }

    public void setListLession(HashMap<Integer, Lesson> listLession) {
        this.listLession = listLession;
    }

    public ArrayList<Quiz> GetDataRequest(String input) {
        if (input == null || input.equals("")) {
            return null;
        }
        StringTokenizer a = new StringTokenizer(input, "\n");
        ArrayList<Quiz> listQuiz = new ArrayList<>();

        while (a.hasMoreTokens()) {
            StringTokenizer InputB = new StringTokenizer(a.nextToken(), "||||||");
            while (InputB.hasMoreTokens()) {
                listQuiz.add(new Quiz(0, InputB.nextToken(), InputB.nextToken(), 0));
            }

        }

        return listQuiz;
    }

    public ArrayList<Quiz> GetDataRequestUpdate(String input) {
        if (input == null || input.equals("")) {
            return null;
        }
        StringTokenizer a = new StringTokenizer(input, "\n");
        ArrayList<Quiz> listQuiz = new ArrayList<>();

        while (a.hasMoreTokens()) {
            StringTokenizer InputB = new StringTokenizer(a.nextToken(), "||||||");
            while (InputB.hasMoreTokens()) {
                int qid = Integer.parseInt(InputB.nextToken());
                String ques = InputB.nextToken();
                String an = InputB.nextToken();
                int lid = 0;
                String check = InputB.nextToken().trim();
                if (check.equalsIgnoreCase("true")) {
                    lid = -1;
                }
                listQuiz.add(new Quiz(qid, ques, an, lid));

            }

        }

        return listQuiz;
    }

    public HashMap<Integer, Lesson> getAllLessonNotHaveFolder(String uid, String fid) {
        HashMap<Integer, Lesson> hashmap = new HashMap<>();
        try {
            ArrayList<Lesson> arrAllLessonUID = new ArrayList<>();
            ResultSet reAllLesson = DB.selectQuery(DB.TABLE_LESSON, "uid = " + uid);
            while (reAllLesson.next()) {
                int lid = reAllLesson.getInt(DB.FIELD_TABLE_LESSON[0]);
                String title = reAllLesson.getNString(DB.FIELD_TABLE_LESSON[1]);
                int uidL = reAllLesson.getInt(DB.FIELD_TABLE_LESSON[2]);
                int share = reAllLesson.getInt(DB.FIELD_TABLE_LESSON[3]);
                arrAllLessonUID.add(new Lesson(lid, title, uidL, share));
            }
            System.out.println(arrAllLessonUID);
            ArrayList<LessonJoinFolder> arrLessonJoin = new ArrayList<>();
            ResultSet reAllLessonJoin = DB.selectQuery(DB.TABLE_LESSON_PK_FOLDER, "fid = " + fid);
            while (reAllLessonJoin.next()) {
                int fidL = reAllLessonJoin.getInt(DB.FIELD_TABLE_LESSON_PK_FOLDER[0]);
                int lidL = reAllLessonJoin.getInt(DB.FIELD_TABLE_LESSON_PK_FOLDER[1]);
                arrLessonJoin.add(new LessonJoinFolder(fidL, lidL));
            }
            System.out.println(arrLessonJoin);
            for (int i = 0; i < arrAllLessonUID.size(); i++) {
                boolean check = false;
                for (int j = 0; j < arrLessonJoin.size(); j++) {
                    if (arrAllLessonUID.get(i).getLid() == arrLessonJoin.get(j).getLid()) {
                        check = true;
                    }
                }
                if (check == false) {
                    hashmap.put(arrAllLessonUID.get(i).getLid(), arrAllLessonUID.get(i));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return hashmap;
    }
    public String toLowerCase(String input){
        String out = "";
        char arr[] = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            arr[i] = Character.toLowerCase(arr[i]);
            out+=arr[i];
            
        }
        return out;
    }
    public ArrayList<LessonJoinUser> GetDataSearch(String input) {
        ArrayList<LessonJoinUser> arr = new ArrayList<>();
        try {
            ResultSet resultSet = DB.selectQueryJoinTwoTable(DB.TABLE_LESSON, DB.TABLE_USERS, "Pro_Lesson.uid = Pro_Users.uid", "lid, title, Pro_Users.uid, share, username, permission");
            while (resultSet.next()) {
                int lid = resultSet.getInt(DB.FIELD_TABLE_LESSON[0]);
                String title = resultSet.getNString(DB.FIELD_TABLE_LESSON[1]);
                int share = resultSet.getInt(DB.FIELD_TABLE_LESSON[3]);
                int uid = resultSet.getInt(DB.FIELD_TABLE_LESSON[2]);
                String username = resultSet.getNString(DB.FIELD_TABLE_USERS[1]);
                int permission = resultSet.getInt(DB.FIELD_TABLE_USERS[3]);
                String title2 = toLowerCase(title);
                input = toLowerCase(input);
                if (title2.contains(input)) {
                    arr.add(new LessonJoinUser(lid, title, share, uid, username, permission));
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return arr;
    }
}

class LessonJoinFolder {

    private int fid;
    private int lid;

    public LessonJoinFolder() {
    }

    public LessonJoinFolder(int fid, int lid) {
        this.fid = fid;
        this.lid = lid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

}
