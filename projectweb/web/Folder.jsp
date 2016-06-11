<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
    ListUser listUser = new ListUser();
    listUser.getListData();
    FolderJoinUser re = null;
    Users newAdd = null;
    Users UsersSession = null;
    boolean checkEdit = false;
    ListFolder listFolder = new ListFolder();
    String fid = request.getParameter("fid");
    if (request.getParameter("fid") == null || !request.getParameter("fid").matches("[0-9]{1,10}")) {
        try {
            response.sendRedirect("./index.jsp");
            return;
        } catch (Exception ex) {

        }
    } else {
        ListFolder list = new ListFolder();
        list.getFolderInData();
        re = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));

        if (re == null) {
            try {
                response.sendRedirect("./index.jsp");
                return;
            } catch (Exception ex) {

            }
        }
        switch (re.getSharefolder()) {
            case 1:
                String idU = "";
                if (session.getAttribute("user") != null) {
                    Users author = (Users) session.getAttribute("user");
                    idU = author.getUid() + "";
                } else if (!user.equals("")) {
                    idU = user.substring(0, user.indexOf("|"));
                }
                if (idU.equals("")) {
                    try {
                        response.sendRedirect("./Login.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                String uid = idU;
                if (re.getUid() != Integer.parseInt(idU)) {
                    try {
                        response.sendRedirect("./UsersPage.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                break;
            case 2:
                if (session.getAttribute("user") == null && ck == false) {
                    try {
                        response.sendRedirect("./Login.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                break;
            case 3:
                break;
            default:
                try {
                    response.sendRedirect("./Index.jsp");
                    return;
                } catch (Exception ex) {

                }
                break;
        }

        if (session.getAttribute("user") != null) {
            newAdd = (Users) session.getAttribute("user");
            UsersSession = listUser.SearchUser(newAdd.getUid());
        } else if (ck == true) {
            String id = user.substring(0, user.indexOf("|"));
            UsersSession = listUser.SearchUser(Integer.parseInt(id));
        }
        String id = "";
        int uidCh;

        listLession = list.getAllLessionInData(request.getParameter("fid"));
        if (session.getAttribute("user") != null || ck == true) {
            if (session.getAttribute("user") != null) {
                Users userCheck = (Users) session.getAttribute("user");
                id = userCheck.getUid() + "";
            } else if (!user.equals("")) {
                id = user.substring(0, user.indexOf("|"));
            }
            uidCh = re.getUid();
            if (id.equals(uidCh + "")) {
                checkEdit = true;
            }

        }
        if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token")) && request.getParameter("deleteLesson") != null) {
            boolean resut = false;
            String outP = "a";
            for (int i = 0; i < listLession.size(); i++) {
                String idLeson = request.getParameter("lesson" + listLession.get(i).getLid());
                outP += idLeson + " ";
                out.print(request.getParameter("lesson1"));
                if (idLeson != null && Integer.parseInt(idLeson) == listLession.get(i).getLid()) {
                    resut = list.DeleteLessionInFolder(idLeson, request.getParameter("fid"));
                }
            }
           
            if (resut) {
                try {
                    response.sendRedirect("./Folder.jsp?fid=" + fid);
                } catch (Exception ex) {

                }
                return;
            } else {
%>

<div class="container">
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Xóa bài học không thành công!</strong>
    </div>
</div>

<%
            }
        }
    }
%>
<div class="container">
    <div class="col-lg-12">
        <ul class="breadcrumb">
            <li><a href="./index.jsp">Home</a></li>
            <li class="active">Thư mục <% if (re != null) {
                    out.print(re.getName());
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
    <% if (session.getAttribute("user") != null || ck == true) {%>
    <div class="col-lg-4">
        <ul class="list-group">
            <% if (UsersSession != null) {
                    for (Map.Entry<Integer, Folder> entry : UsersSession.getListFolder().entrySet()) {
                        Integer key = entry.getKey();
                        Folder value = entry.getValue();
                        ArrayList<FolderJoinLessionJoinUsers> li = listFolder.getAllLessionInData(value.getFid() + "");
                        if (request.getParameter("fid") != null && Integer.parseInt(request.getParameter("fid")) == key) {
            %>
            <li class="list-group-item active">
                <span class=" label label-info" style="float: right"><%= li.size()%> Lession</span>
                <i class="fa fa-folder-open-o fa-2x" style="    color: #921877;" aria-hidden="true"></i> <a href="./Folder.jsp?fid=<%= value.getFid()%>"><%= value.getName()%></a>
            </li>


            <%
            } else {
            %>

            <li class="list-group-item">
                <span class=" label label-info" style="float: right"><%= li.size()%> Lession</span>
                <i class="fa fa-folder fa-2x" style="    color: #921877;" aria-hidden="true"></i> <a href="./Folder.jsp?fid=<%= value.getFid()%>"><%= value.getName()%></a>
            </li>

            <%
                }
            %>

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
    <%}%>
    <div class=" <% if (session.getAttribute("user") != null || ck == true) {
            out.print("col-lg-8");
        } else {
            out.print("col-lg-12");
        } %>">
        <% session.removeAttribute("alert-sucess");
            session.removeAttribute("alert");
            if (checkEdit) {%>

        <div class="btn-group" style="    float: right;">
            <a href="#" class="btn btn-primary"><i class="fa fa-wrench" aria-hidden="true"></i></a>
            <a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="DeleteFolder.jsp?fid=<% if (re != null) {
                        out.print(re.getFid());
                    } %>">Xóa thư mục</a></li>
                <li class="divider"></li>
                       <li><a href="./EditFolder.jsp?fid=<% if (re != null) {
                        out.print(re.getFid());
                    } %>">Chỉnh sửa thư mục</a></li>
            </ul>
        </div>
        <% } %>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-folder-open-o fa-2x" aria-hidden="true"></i> Thư mục  <% if (re != null) {
                        out.print(re.getName());
                    } %> </h3>
            </div>
            <div class="panel-body">
                <% if (checkEdit) {%>
                <form action="" method="POST">
                    <% } %>
                    <table class="table table-striped table-hover ">

                        <tbody>
                            <%
                                if (listLession != null) {
                                    for (int i = 0; i < listLession.size(); i++) {

                            %>
                            <tr>
                                <% if (checkEdit) {%> <td><div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="<%= listLession.get(i).getLid()%>" name="lesson<%= listLession.get(i).getLid()%>">
                                        </label>
                                    </div></td><% }%>
                                <td><a href="./Lession.jsp?lid=<%= listLession.get(i).getLid()%>"><%= listLession.get(i).getTitle()%></a></td>
                                <td><i class="fa fa-globe fa-2x" aria-hidden="true"></i>
                                    <%
                                        switch (listLession.get(i).getShare()) {
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
                                    %></td>
                                <td><i class="fa fa-user fa-2x" aria-hidden="true"></i> <a href="User.jsp?uid=<%=  listLession.get(i).getUid()%>"><%= listLession.get(i).getUsername()%></td>
                                <% if (checkEdit) {%>  <td class="center">
                                    <a  class="btn btn-info btn-circle" href="./EditLession.jsp?lid=<%= listLession.get(i).getLid()%>"><i class="fa fa-check"></i>
                                    </a>
                                    <a  class="btn btn-danger btn-circle" href="./DeleteLession.jsp?lid=<%= listLession.get(i).getLid()%>"><i class="fa fa-times"></i>
                                    </a>
                                </td><%}%>
                            </tr>
                            <% }
                                }%>
                        </tbody>
                    </table>
                    <% if (checkEdit) {%>
                           <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                               out.print(session.getAttribute("token"));%>" name="token">
                    <input type="submit" value="Xóa Lession" class="btn btn-info" name="deleteLesson"/>
                    <a href="./AddNewLessonFolder.jsp?fid=<%= request.getParameter("fid")%>"  class="btn btn-danger" name=""/> <i class="fa fa-plus-square" aria-hidden="true"></i> Thêm bài học</a>
                </form>
                <% }%>
            </div>
        </div>
    </div>
    <div class="col-lg-12">
        <ul class="breadcrumb">
            <li><a href="./index.jsp">Home</a></li>
            <li class="active">Thư mục <% if (re != null) {
                    out.print(re.getName());
                }%></li>
        </ul>
    </div>
</div>
<style>
    .list-group-item.active a {
        color: #fff;
    }
</style>
<%@include file="Footer.jsp"  %>