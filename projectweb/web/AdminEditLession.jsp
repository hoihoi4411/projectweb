<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson get = null;
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
       response.sendRedirect("./AdminLession.jsp");
                return;
    } else if (list.searchLession(request.getParameter("lid")) == null) {
        response.sendRedirect("./AdminLession.jsp");
                return;
    } else {
        get = list.searchLession(request.getParameter("lid"));
        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
    }
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {

        Validation validation = new Validation();
        String title = request.getParameter("title");
        byte[] bytes = title.getBytes(StandardCharsets.ISO_8859_1);
        title = new String(bytes, StandardCharsets.UTF_8);
        String uid = request.getParameter("uid");
        String share = request.getParameter("share");
        if (validation.StringFormatMinMax(title, 5, 255, "title") && listb.SearchUser(Integer.parseInt(uid)) != null && validation.NumberFormatMinMax(share, 1, 3, "share")) {
            boolean re = list.UpdateLesson(get.getLid(), title, Integer.parseInt(uid), Integer.parseInt(share));
            if (re) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Cập nhật thành công");
                response.sendRedirect("./AdminLession.jsp");
                return;
            } else {
                session.removeAttribute("alert");
                errors = "Cập nhật thất bại mời thử lại";
                session.setAttribute("alert", errors);
                response.sendRedirect("./AdminLession.jsp");
                return;
            }
        } else {
            session.removeAttribute("alert");
            errors = validation.getShowErrors();
            session.setAttribute("alert", errors);
            response.sendRedirect("./AdminLession.jsp");
            return;
        }
    }
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Bài học <% if (get != null) {
                    out.print(get.getTitle());
                } %>  </h1>
        </div>
        <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <form action="" method="POST" class="ng-pristine ng-valid ng-scope">
                <div class="form-group">
                    <label>Tên thư mục : </label>
                    <input class="form-control" name="title" required="" value="<% if (get != null) {
                            out.print(get.getTitle());
                        } %> ">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
                <div class="form-group">
                    <label>Chọn tác giả</label>
                    <select class="form-control" name="uid" required>
                        <% for (int i = 0; i < li.size(); i++) {
                                if (get.getUid() == li.get(i).getUid()) {
                                    out.print("<option value='" + li.get(i).getUid() + "' selected >" + li.get(i).getUsername() + "</option>");
                                } else {
                        %>

                        <option value="<%= li.get(i).getUid()%>"><%= li.get(i).getUsername()%></option>
                        <%}
                            }%>
                    </select>
                </div>
                <div class="form-group">
                    <label>Share</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="share" id="optionsRadios1" value="1" <% if (get.getUid() == 1) {
                                    out.print("checked");
                                } %>>Chỉ dành cho tôi
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="share" id="optionsRadios2" value="2" <% if (get.getUid() == 2) {
                                    out.print("checked");
                                } %>>Dành cho thành viên
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="share" id="optionsRadios3" value="3" <% if (get.getUid() == 3) {
                                    out.print("checked");
                                } %>>Công khai
                        </label>
                    </div>
                </div>
                <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                    out.print(session.getAttribute("token"));%>" name="token">
                <div class="form-group">
                    <input class="btn btn-primary" type="submit" value="Add new Folder">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>