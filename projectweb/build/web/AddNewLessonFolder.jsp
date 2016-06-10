<%-- 
    Document   : EditFolder
    Created on : Jun 7, 2016, 8:15:52 AM
    Author     : MyPC
--%>

<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HashMap<Integer, Lesson> map = null;
    Users Author = null;
    String fid = request.getParameter("fid");
    if (request.getParameter("fid") == null || !request.getParameter("fid").matches("[0-9]{1,10}")) {
        try {
            response.sendRedirect("./Index.jsp");
            return;
        } catch (Exception ex) {

        }
        return;
    } else {
        ListFolder list = new ListFolder();
        list.getFolderInData();
        ListUser listUser = new ListUser();
        listUser.getListData();
        FolderJoinUser edit = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));
        if (session.getAttribute("user") != null) {
            Author = (Users) session.getAttribute("user");
        } else if (ck == true) {
            String id = user.substring(0, user.indexOf("|"));
            Author = listUser.SearchUser(Integer.parseInt(id));
        } else {
            response.sendRedirect("./Login.jsp");
            return;
        }
        if (edit.getUid() != Author.getUid()) {
            response.sendRedirect("./UsersPage.jsp");
            return;
        }
        ListLession listLession = new ListLession();
        map = listLession.getAllLessonNotHaveFolder(Author.getUid() + "", request.getParameter("fid"));
        if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
            boolean resut = false;
            for (Map.Entry<Integer, Lesson> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Lesson value = entry.getValue();
                String id = request.getParameter("lesson" + key);
                if (id != null && Integer.parseInt(id) == key) {
                    resut = list.AddNewLessonInFolder(id, request.getParameter("fid"));
                }
                if (resut == false) {
                    break;
                }
            }
            if (!resut) {
%>
<div class="container" >


    <div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Thêm bài học không thành công </strong>
    </div>

</div>
<%
            } else {
                try {
                    response.sendRedirect("./Folder.jsp?fid=" + fid);

                } catch (Exception ex) {

                }
                return;
            }
        }
    }
%>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Tất cả các bài học</h3>
                </div>
                <div class="panel-body">
                    <form action="" method="POST">
                        <table class="table table-striped table-hover ">
                            <tbody>
                                <% if (map != null) {
                                        for (Map.Entry<Integer, Lesson> entry : map.entrySet()) {
                                            Integer key = entry.getKey();
                                            Lesson value = entry.getValue();
                                %>
                                <tr>
                                    <td> <input type="checkbox" value="<%= key%>" name="lesson<%= key%>"></td>
                                    <td><i class="fa fa-file  fa-2x" aria-hidden="true"></i><a href="Lession.jsp?lid=<%= key%>"> <%= value.getTitle()%> </a></td>
                                    <td> <i class="fa fa-globe fa-2x" aria-hidden="true"></i> <%
                                        switch (value.getShare()) {
                                            case 1:
                                                out.print("Chỉ mình tôi");
                                                break;
                                            case 2:
                                                out.print("Dành cho thành viên");
                                                break;
                                            case 3:
                                                out.print("Công khai");
                                                break;
                                        }
                                        %> </td>
                                    <td class="center">
                                        <a class="btn btn-info btn-circle" href="./EditLession.jsp?lid=<%= key%>"><i class="fa fa-check"></i>
                                        </a>
                                        <a class="btn btn-danger btn-circle" href="./DeleteLession.jsp?lid=<%= key%>"><i class="fa fa-times"></i>
                                        </a>
                                    </td>
                                </tr>
                                <% }
                                    }%>
                            </tbody>
                        </table>
                               <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                                   out.print(session.getAttribute("token"));%>" name="token">
                        <input type="submit" value="Thêm bài học" class="btn btn-info"/> <a href="./Folder.jsp?fid=<%= fid %>" class="btn btn-danger">Quay Trở lại Thư mục</a>
                    </form>
                       
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="Footer.jsp"  %>