<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user") == null && ck == false) {
        response.sendRedirect("./Login.jsp");
        return;
    }
    String id = "";
    if (session.getAttribute("user") != null) {
        Users author = (Users) session.getAttribute("user");
        id = author.getUid() + "";
    } else if (!user.equals("")) {
        id = user.substring(0, user.indexOf("|"));
    }

    String uid = id;
    String errors = "";
    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson re = null;
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
        try {
            response.sendRedirect("./UsersPage.jsp");
        } catch (Exception ex) {

        }
        return;
    } else if (list.searchLession(request.getParameter("lid")) == null) {
        try {
            response.sendRedirect("./UsersPage.jsp");
        } catch (Exception ex) {

        }
        return;
    } else {
        re = list.searchLession(request.getParameter("lid"));
        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
        if (re.getUid() != Integer.parseInt(uid)) {
            try {
                response.sendRedirect("./UsersPage.jsp");

            } catch (Exception ex) {

            }
            return;
        }
    }
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        if (listAQuiz.size() > 0) {
            session.removeAttribute("alert");
            errors = "Bạn không thể xóa bài học này vì nó đã có quiz";
            session.setAttribute("alert", errors);
            try {
                response.sendRedirect("./UsersPage.jsp");

            } catch (Exception ex) {

            }
        } else {
            boolean reSul = list.deleteLession(re.getLid());
            if (reSul) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Xóa Thành công!");
                try {
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
            } else {
                session.removeAttribute("alert");
                errors = "Xóa thất bại, vui lòng thử lại!";
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
     padding-top: 20px;">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"> Xóa Bài học  <% if (re != null) {
                    out.print(re.getTitle());
                }%> </h1>
            <div class="panel panel-green">
                <div class="panel-heading">
                    Xóa Bài học  <% if (re != null) {
                            out.print(re.getTitle());
                        }%>
                </div>
                <div class="panel-body">
                    <form action="" method="POST" class="ng-pristine ng-valid">
                        <p>Bạn có chắc chắn muốn xóa bài học  <% if (re != null) {
                                out.print(re.getTitle());
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