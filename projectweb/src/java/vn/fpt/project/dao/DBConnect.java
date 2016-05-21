/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.dao;

import java.sql.*;
import vn.fpt.project.bo.*;

/**
 *
 * @author MyPC
 */
public class DBConnect {

    /**
     * Information Connecting with database
     */
    private Connection connect;
    private String urlClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String serverName = "localhost";
    private String port = "1433";
    private String dataName = "PROJECT_G3";
    private String user = "sa";
    private String pass = "sa123456";
    /**
     * Field table in database
     */
    final String TABLE_USERS = "Pro_Users";
    final String TABLE_FOLDER = "Pro_Folder";
    final String TABLE_LESSON = "Pro_Lesson";
    final String TABLE_QUIZ = "Pro_Quiz";
    final String TABLE_LESSON_PK_FOLDER = "Pro_Folder_PK_Pro_Lesson";

    final String[] FIELD_TABLE_USERS = {"uid", "username", "password", "permission"};
    final String[] FIELD_TABLE_FOLDER = {"fid", "name", "uid", "sharefolder"};
    final String[] FIELD_TABLE_LESSON = {"lid", "title", "uid", "share"};
    final String[] FIELD_TABLE_QUIZ = {"qid", "question", "answer", "lid"};
    final String[] FIELD_TABLE_LESSON_PK_FOLDER = {"fid", "lid"};
    private String errors ;
    public DBConnect() {
        try {
            Class.forName(urlClass);
            connect = DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":" + port + ";databaseName = " + dataName + " ", user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            errors = "Cannot connect to database";
        }

    }

    public ResultSet selectQuery(String table, String where) throws SQLException {
        PreparedStatement query = null;
        String SQL = "SElECT * FROM " + table + " WHERE " + where;
        if (where.equals("")) {
            SQL = "SElECT * FROM " + table;
        }
        query = connect.prepareStatement(SQL);
        ResultSet relts = query.executeQuery();
        return relts;

    }

    public int toCountTable(String table, String where) throws SQLException {
        PreparedStatement query = null;
        String SQL = "SELECT COUNT (*) As count FROM " + table + "  where " + where;
        query = connect.prepareStatement(SQL);
        ResultSet relts = query.executeQuery();
        int count = 0;
        while (relts.next()) {
            count = relts.getInt("count");
        }
        return count;
    }

    public Object getFirst(String table, String where) throws SQLException {
        if (where.equals("")) {
            return null;
        }
        ResultSet resultSet = selectQuery(table, where);
        switch (table) {
            case TABLE_USERS:
                Users res = new Users();
                while (resultSet.next()) {
                    res.setUid(resultSet.getInt(FIELD_TABLE_USERS[0]));
                    res.setUsername(resultSet.getNString(FIELD_TABLE_USERS[1]));
                    res.setPassword(resultSet.getNString(FIELD_TABLE_USERS[2]));
                    res.setPermission(resultSet.getInt(FIELD_TABLE_USERS[3]));
                    break;
                }
                return res;
            case TABLE_FOLDER:
                Folder folder = new Folder();
                while (resultSet.next()) {
                    folder.setFid(resultSet.getInt(FIELD_TABLE_FOLDER[0]));
                    folder.setName(resultSet.getNString(FIELD_TABLE_FOLDER[1]));
                    folder.setUid(resultSet.getInt(FIELD_TABLE_FOLDER[2]));
                    folder.setSharefolder(resultSet.getInt(FIELD_TABLE_FOLDER[3]));
                    break;
                }
                return folder;
            case TABLE_LESSON:
                Lesson lesson = new Lesson();
                while (resultSet.next()) {
                    lesson.setLid(resultSet.getInt(FIELD_TABLE_LESSON[0]));
                    lesson.setTitle(resultSet.getNString(FIELD_TABLE_LESSON[1]));
                    lesson.setUid(resultSet.getInt(FIELD_TABLE_LESSON[2]));
                    lesson.setShare(resultSet.getInt(FIELD_TABLE_LESSON[3]));
                    break;
                }
                return lesson;
            case TABLE_QUIZ:
                Quiz quiz = new Quiz();
                while (resultSet.next()) {
                    quiz.setQid(resultSet.getInt(FIELD_TABLE_QUIZ[0]));
                    quiz.setQuestion(resultSet.getNString(FIELD_TABLE_QUIZ[1]));
                    quiz.setAnswer(resultSet.getNString(FIELD_TABLE_QUIZ[2]));
                    quiz.setLid(resultSet.getInt(FIELD_TABLE_QUIZ[3]));
                    break;
                }
                return quiz;

        }

        return null;
    }

    public boolean isConnect() {
        return connect != null;
    }

    public boolean toCloseData() {
        try {
            connect.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

//    public static void main(String[] args) {
//        DBConnect DB = new DBConnect();
//        try {
//            Object re = DB.getFirst(DB.TABLE_USERS, "uid = 1");
//            System.out.println(re);
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            DB.toCloseData();
//        }
//    }
}
