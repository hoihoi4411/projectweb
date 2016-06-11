/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.dao;

import java.sql.*;
import java.util.ArrayList;
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
    public final String TABLE_USERS = "Pro_Users";
    public final String TABLE_FOLDER = "Pro_Folder";
    public final String TABLE_LESSON = "Pro_Lesson";
    public final String TABLE_QUIZ = "Pro_Quiz";
    public final String TABLE_LESSON_PK_FOLDER = "Pro_Folder_PK_Pro_Lesson";

    public final String[] FIELD_TABLE_USERS = {"uid", "username", "password", "permission"};
    public final String[] FIELD_TABLE_FOLDER = {"fid", "name", "uid", "sharefolder"};
    public final String[] FIELD_TABLE_LESSON = {"lid", "title", "uid", "share"};
    public final String[] FIELD_TABLE_QUIZ = {"qid", "question", "answer", "lid"};
    public final String[] FIELD_TABLE_LESSON_PK_FOLDER = {"fid", "lid"};
    private String errors;

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

    public ResultSet selectQueryLessonNotHaveFolder(String table, String where, String fid) throws SQLException {
        PreparedStatement query = null;
        String SQL = "SELECT  Pro_Lesson.lid, title, uid, share From " + table + " left join Pro_Folder_PK_Pro_Lesson on Pro_Lesson.lid = Pro_Folder_PK_Pro_Lesson.lid  where Pro_Lesson.uid = " + where + " and( Pro_Folder_PK_Pro_Lesson.fid IS NULL OR Pro_Folder_PK_Pro_Lesson.fid != " + fid + ")";
        query = connect.prepareStatement(SQL);
        ResultSet relts = query.executeQuery();
        return relts;

    }

    public ResultSet selectQueryJoinTwoTable(String table1, String table2, String on, String fied) {
        try {
            PreparedStatement query = null;
            String SQL = "SElECT " + fied + " FROM " + table1 + " Inner join " + table2 + " on " + on;
            query = connect.prepareStatement(SQL);
            ResultSet relts = query.executeQuery();
            return relts;
        } catch (SQLException ex) {

            return null;
        }

    }

    public ResultSet selectQueryJoinFourTable(String table[], String on[], String fied, String where) {
        try {
            PreparedStatement query = null;
            String SQL = "SELECT " + fied + "  from " + table[0] + " INNER JOIN " + table[1] + " on " + on[0] + " INNER JOIN " + table[2] + " On " + on[1] + " and " + on[2] + "  Inner join " + table[3] + " on " + on[3] + "  Where " + where;
            query = connect.prepareStatement(SQL);
            ResultSet relts = query.executeQuery();
            return relts;
        } catch (SQLException ex) {

            return null;
        }

    }

    public int toCountTable(String table, String where) throws SQLException {
        PreparedStatement query = null;
        String SQL = "";
        if (where.equals("")) {
            SQL = "SELECT COUNT (*) As count FROM " + table;
        } else {
            SQL = "SELECT COUNT (*) As count FROM " + table + "  where " + where;

        }
        query = connect.prepareStatement(SQL);
        ResultSet relts = query.executeQuery();
        int count = 0;
        while (relts.next()) {
            count = relts.getInt("count");
        }
        return count;
    }

    public boolean InsertUsers(String table, String username, String password, int permisson) {
        try {
            String insertTableSQL = "INSERT INTO " + table + " "
                    + "(username,password,permission) VALUES"
                    + "(?,?,?)";
            PreparedStatement preparedStatement;
            preparedStatement = connect.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, permisson);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean InSertDataQuiz(ArrayList<Quiz> input, String lid) {
        try {
            for (int i = 0; i < input.size(); i++) {
                //Assume a valid connection object conn
                connect.setAutoCommit(false);
                Statement stmt = connect.createStatement();

                String SQL = "INSERT INTO " + TABLE_QUIZ + "  "
                        + "VALUES (N'" + input.get(i).getQuestion() + "', N'" + input.get(i).getAnswer() + "', " + lid + ")";
                stmt.executeUpdate(SQL);

                connect.commit();
            }
            return true;
        } catch (SQLException se) {
            try {
                // If there is any error.
                connect.rollback();
            } catch (SQLException ex) {
                return false;
            }
            return false;
        }
    }

    public boolean UpdateDataQuiz(ArrayList<Quiz> input, String lid) {
        try {
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i).getQid() != 0 && input.get(i).getLid() != -1) {
                    //Assume a valid connection object conn
                    connect.setAutoCommit(false);
                    Statement stmt = connect.createStatement();

                    String SQL = "Update " + TABLE_QUIZ + "  SET " + FIELD_TABLE_QUIZ[1] + " =  N'" + input.get(i).getQuestion() + "', " + FIELD_TABLE_QUIZ[2] + ""
                            + " = N'" + input.get(i).getAnswer() + "' WHERE  " + FIELD_TABLE_QUIZ[0] + "= " + input.get(i).getQid();
                    stmt.executeUpdate(SQL);

                    connect.commit();
                } else if (input.get(i).getQid() == 0 && input.get(i).getLid() != -1) {
                    connect.setAutoCommit(false);
                    Statement stmt = connect.createStatement();

                    String SQL = "INSERT INTO " + TABLE_QUIZ + "  "
                            + "VALUES (N'" + input.get(i).getQuestion() + "', N'" + input.get(i).getAnswer() + "', " + lid + ")";
                    stmt.executeUpdate(SQL);

                    connect.commit();
                } else if (input.get(i).getQid() != 0 && input.get(i).getLid() == -1) {
                    //Assume a valid connection object conn
                    connect.setAutoCommit(false);
                    Statement stmt = connect.createStatement();

                    String SQL = "DELETE FROM " + TABLE_QUIZ + "  WHERE  " + FIELD_TABLE_QUIZ[0] + "= " + input.get(i).getQid();
                    stmt.executeUpdate(SQL);

                    connect.commit();
                }
            }
            return true;
        } catch (SQLException se) {
            try {
                // If there is any error.
                connect.rollback();
            } catch (SQLException ex) {
                return false;
            }
            return false;
        }
    }

    public boolean InsertFolder(String table, String fied, String value) {
        Statement st;
        try {
            String sql = "Insert into " + table + " " + fied + " values " + value;
            st = connect.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {

            return false;
        }
        return true;
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

    public boolean Update(String table, String set, String where) {
        try {
            Statement stmt;
            stmt = connect.createStatement();
            String sql = "UPDATE " + table
                    + " SET " + set + " WHERE " + where;

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean delete(String fied, String table) {
        ResultSet rs;
        Statement st;
        try {
            String sql = "delete from " + table + " where " + fied;

            st = connect.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean deleteLessonInfolder(String lid, String fid) {
        ResultSet rs;
        Statement st;
        try {
            String sql = "delete from " + TABLE_LESSON_PK_FOLDER + " where " + FIELD_TABLE_LESSON_PK_FOLDER[0] + " = " + fid + " and " + FIELD_TABLE_LESSON_PK_FOLDER[1] + " = " + lid;
            st = connect.createStatement();
            st.execute(sql);

        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
