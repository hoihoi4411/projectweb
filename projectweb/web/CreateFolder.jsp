<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String errors1 = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ListFolder listFo = new ListFolder();
    out.print(request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token")));
    if (request.getParameter("submit") != null) {
        session.removeAttribute("token");
        Validation validation2 = new Validation();
        String name = request.getParameter("name");
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes, StandardCharsets.UTF_8);
        String id = "";
        if (session.getAttribute("user") != null) {
            Users author = (Users) session.getAttribute("user");
            id = author.getUid() + "";
        } else if (!user.equals("")) {
            id = user.substring(0, user.indexOf("|"));
        }
        
        String uid = id;
        String sharefolder = request.getParameter("sharefolder");
        if (validation2.StringFormatMinMax(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation2.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
            boolean resu = listFo.InsertFolder(name, uid, sharefolder);
            if (resu) {

                try {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Thêm folder thành công");
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
                return;
            } else {

                try {
                    session.removeAttribute("alert");
                    errors1 = "Thêm folder thất bại , mời bạ kiểm tra lại nội dung nhập vào";
                    session.setAttribute("alert", errors1);
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
                return;
            }

        } else {

            try {
                session.removeAttribute("alert");
                errors1 = validation2.getShowErrors();
                session.setAttribute("alert", errors1);
                response.sendRedirect("./UsersPage.jsp");
                return;
            } catch (Exception ex) {

            }
        }
    }
%>
<form action="" method="POST" id="FolderCreate" style="text-align: left;">
    <div class="form-group">
        <label>Tên Folder : </label>
        <input class="form-control" name="name" required>
        <p class="help-block">Hãy nhập trong khoảng 5 - 30 ký tự</p>
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
