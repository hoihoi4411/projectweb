<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("admin") == null) {
        try {
            response.sendRedirect("./LoginAdmin.jsp");

        } catch (Exception ex) {

        }

    }
    String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ListFolder listF = new ListFolder();
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        session.removeAttribute("token");
        Validation validation = new Validation();
        String name = request.getParameter("name");
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes, StandardCharsets.UTF_8);
        String uid = request.getParameter("uid");
        String sharefolder = request.getParameter("sharefolder");
        if (validation.StringFormatMinMax(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
            boolean resu = listF.InsertFolder(name, uid, sharefolder);
            if (resu) {

                try {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Thêm folder thành công");
                    response.sendRedirect("./AdminFolder.jsp");

                } catch (Exception ex) {

                }
            } else {

                try {
                    session.removeAttribute("alert");
                    errors = "Thêm folder thất bại , mời bạ kiểm tra lại nội dung nhập vào";
                    session.setAttribute("alert", errors);
                    response.sendRedirect("./AdminFolder.jsp");

                } catch (Exception ex) {

                }
            }

        } else {

            try {
                session.removeAttribute("alert");
                errors = validation.getShowErrors();
                session.setAttribute("alert", errors);
                response.sendRedirect("./AdminFolder.jsp");

            } catch (Exception ex) {

            }
        }
    }
%>
<form action="" method="POST" id="FolderCreate">
    <div class="form-group">
        <label>Tên Folder : </label>
        <input class="form-control" name="name" required>
        <p class="help-block">Hãy nhập trong khoảng 5 - 30 ký tự</p>
    </div>
    <div class="form-group">
        <label>Chọn mộn tác giả cho folder</label>
        <select class="form-control" name="uid" required>
            <% for (int i = 0; i < li.size(); i++) {%>
            <option value="<%= li.get(i).getUid()%>"><%= li.get(i).getUsername()%></option>
            <%}%>
        </select>
    </div>
    <div class="form-group">
        <label>Share</label>
        <div class="radio">
            <label>
                <input type="radio" name="sharefolder" id="optionsRadios1" value="1" checked="">Chỉ mình tôi
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="sharefolder" id="optionsRadios2" value="2">Dành cho thành viên
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="sharefolder" id="optionsRadios3" value="3">Công khai
            </label>
        </div>
    </div>

           <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
        out.print(session.getAttribute("token"));%>" name="token">
    <div class="form-group">
        <button class="btn btn-primary" type="submit" value="" name="submit" ng-click="submitAdd()">Thêm một thư mục mới</button>
    </div>
</form>
