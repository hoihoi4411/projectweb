<%-- 
    Document   : UsersPage
    Created on : May 30, 2016, 11:37:53 AM
    Author     : MyPC
--%>

<%@page import="java.util.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"  %>
<%
    Cookie cookie7 = null;
    Cookie cookie2 = null;
    String errors = "";
    ListUser listUser = new ListUser();
    listUser.getListData();
    Validation validation = new Validation();
    boolean check = false;
    ListFolder listFolder = new ListFolder();
    Cookie[] cookieh = request.getCookies();
    if (cookieh != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie7 = cookieh[i];
            if (cookie7.getName().equalsIgnoreCase("username")) {
                check = true;
                break;
            }
        }

    }
    Users newAdd = null;
    Users UsersSession = null;
    if (session.getAttribute("user") == null && check == false) {
        response.sendRedirect("./index.jsp");
        return;
    } else if (session.getAttribute("user") != null) {
        newAdd = (Users) session.getAttribute("user");
        UsersSession = listUser.SearchUser(newAdd.getUid());
    } else {
        String id = user.substring(0, user.indexOf("|"));
        UsersSession = listUser.SearchUser(Integer.parseInt(id));
    }
   

%>
<div class="container">
    <div class="col-lg-12">
        <ul class="breadcrumb">
            <li><a href="./index.jsp">Home</a></li>
            <li class="active"><% if (newAdd != null) {
                    out.print(newAdd.getUsername());
                } %></li>
        </ul>
        <%          if (session.getAttribute("alert") != null) {
                session.removeAttribute("alert-sucess");%>
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <%= session.getAttribute("alert")%>
        </div>
        <%}%>
        <%
            if (session.getAttribute("alert-sucess") != null) {
                session.removeAttribute("alert");%>
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <%= session.getAttribute("alert-sucess")%>
        </div>
        <%}%>
    </div>
    <div class="col-lg-4">
        <ul class="list-group">
            <% if (UsersSession != null) {
                
                    for (Map.Entry<Integer, Folder> entry : UsersSession.getListFolder().entrySet()) {
                        Integer key = entry.getKey();
                        Folder value = entry.getValue();
                        ArrayList<FolderJoinLessionJoinUsers> li = listFolder.getAllLessionInData(value.getFid() + "");
            %>
            <li class="list-group-item">
                <span class=" label label-info" style="float: right"> <%= li.size()%> Lession</span>
                <i class="fa fa-folder fa-2x" style="    color: #921877;" aria-hidden="true"></i> <a href="./Folder.jsp?fid=<%= value.getFid()%>"><%= value.getName()%></a>
            </li>

            <% }
                }%>
            <li class="list-group-item" style="text-align: center" ng-app="myappMo" ng-controller="MyController">
                <button ng-click="open()" class="btn btn-danger"><i class="fa fa-folder fa-2x" aria-hidden="true"></i>  Create Folder</button>
            <openmodal title="Tạo thư mục mới" visible="showModal">
                <%@include file="CreateFolder.jsp"  %>
            </openmodal>
            </li>
        </ul>
    </div>
    <div class="col-lg-8">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">Tất cả các bài học</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-hover ">
                    <tbody>
                        <% session.removeAttribute("alert-sucess");
                            session.removeAttribute("alert");
                            if (UsersSession != null) {
                                for (Map.Entry<Integer, Lesson> entry : UsersSession.getListLession().entrySet()) {
                                    Lesson value = entry.getValue();
                        %>
                        <tr>
                            <td><i class="fa fa-file  fa-2x" aria-hidden="true"></i><a href="Lession.jsp?lid=<%= value.getLid()%>" > <%= value.getTitle()%> </a></td>
                            <td> <i class="fa fa-globe fa-2x" aria-hidden="true"></i> <% switch (value.getShare()) {
                                    case 1:
                                        out.print("OnlyMe");
                                        break;
                                    case 2:
                                        out.print("For User");
                                        break;
                                    case 3:
                                        out.print("Public");
                                        break;
                                }%></td>
                                <td class="center">
                                <a  class="btn btn-info btn-circle" href="./EditLession.jsp?lid=<%= value.getLid()%>"><i class="fa fa-check"></i>
                                    </a>
                                    <a  class="btn btn-danger btn-circle" href="./DeleteLession.jsp?lid=<%= value.getLid()%>"><i class="fa fa-times"></i>
                                    </a>
                                </td>
                        </tr>
                        <%}
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
     <div class="col-lg-12">
        <ul class="breadcrumb">
            <li><a href="./index.jsp">Home</a></li>
            <li class="active"><% if (newAdd != null) {
                    out.print(newAdd.getUsername());
                }%></li>
        </ul>
    </div>
</div>
<%@include file="Footer.jsp"  %>
