<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    String errors = "";
    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson re = null;
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
        try {
            response.sendRedirect("./AdminLession.jsp");
        } catch (Exception ex) {

        }
    } else if (list.searchLession(request.getParameter("lid")) == null) {
        try {
            response.sendRedirect("./AdminLession.jsp");
        } catch (Exception ex) {

        }
    } else {
        re = list.searchLession(request.getParameter("lid"));
        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
    }
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        if (listAQuiz.size() > 0) {
            session.removeAttribute("alert");
            errors = "Bạn không thể xóa bài học này vì nó đã có quiz";
            byte[] bytes = errors.getBytes(StandardCharsets.ISO_8859_1);
            errors = new String(bytes, StandardCharsets.UTF_8);
            
            session.setAttribute("alert", errors);
            try {
                response.sendRedirect("./AdminLession.jsp");

            } catch (Exception ex) {

            }
        } else {
            boolean reSul = list.deleteLession(re.getLid());
            if (reSul) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Xóa Thành công!");
                try {
                    response.sendRedirect("./AdminFolder.jsp");

                } catch (Exception ex) {

                }
            } else {
                session.removeAttribute("alert");
                errors = "Xóa thất bại, vui lòng thử lại!";
                session.setAttribute("alert", errors);
                try {
                    response.sendRedirect("./AdminLession.jsp");

                } catch (Exception ex) {

                }
            }
        }
    }
%>
<div id="page-wrapper">
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

<%@include file="AdminFooter.jsp"  %>