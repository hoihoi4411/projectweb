<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.ArrayList"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    
    
    if (session.getAttribute("user") == null && ck == false) {
        response.sendRedirect("./Login.jsp");
        return;
    }
    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
    FolderJoinUser re = null;
    String errors = "";
    String id = "";
    if (session.getAttribute("user") != null) {
        Users author = (Users) session.getAttribute("user");
        id = author.getUid() + "";
    } else if (!user.equals("")) {
        id = user.substring(0, user.indexOf("|"));
    }

    String uid = id;
    if (request.getParameter("fid") == null || !request.getParameter("fid").matches("[0-9]{1,10}")) {
        try {
            response.sendRedirect("./UsersPage.jsp");

        } catch (Exception ex) {

        }
    } else {
        ListFolder list = new ListFolder();
        list.getFolderInData();
        re = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));
        if (re == null) {
            try {
                response.sendRedirect("./UsersPage.jsp");

            } catch (Exception ex) {

            }
        } else if (re.getUid() != Integer.parseInt(uid)) {
             try {
                response.sendRedirect("./UsersPage.jsp");

            } catch (Exception ex) {

            }
        } 
        listLession = list.getAllLessionInData(request.getParameter("fid"));

        if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
            if (list.DeleteFolder(request.getParameter("fid"))) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Xóa Folder thành công");
                try {
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
            } else {
                session.removeAttribute("alert");
                errors = "Xóa folder thất bại";
                session.setAttribute("alert", errors);
                try {
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
            }
        }

    }
%>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;    padding-bottom: 20px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Delete  <% if (re != null) {
                    out.print(re.getName());
                }%> </h1>
            <div class="panel panel-green">
                <div class="panel-heading">
                    Delete  <% if (re != null) {
                            out.print(re.getName());
                        }%>
                </div>
                <div class="panel-body">
                    <form action="" method="POST" class="ng-pristine ng-valid">
                        <p>Bạn có chắc muốn xóa <% if (re != null) {
                                out.print(re.getName());
                            }%> ? </p>
                        <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                            out.print(session.getAttribute("token"));%>" name="token">
                        <input type="submit" class="btn btn-success" value="Đồng ý" name="ok">

                    </form>
                </div>

            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>

</div>
<!-- /#page-wrapper -->

<%@include file="Footer.jsp"  %>