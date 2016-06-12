<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.ArrayList"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
    FolderJoinUser re = null;
    if (request.getParameter("fid") == null || !request.getParameter("fid").matches("[0-9]{1,10}")) {
        try {
            response.sendRedirect("./AdminFolder.jsp");

        } catch (Exception ex) {

        }
    } else {
        ListFolder list = new ListFolder();
        list.getFolderInData();
        re = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));
        if (re == null) {
            try {
                response.sendRedirect("./AdminFolder.jsp");

            } catch (Exception ex) {

            }
        } else {
            if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
                session.removeAttribute("token");
                Validation validation = new Validation();
                String name = request.getParameter("name");
                byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
                name = new String(bytes, StandardCharsets.UTF_8);
                String uid = request.getParameter("uid");
                String sharefolder = request.getParameter("sharefolder");
                if (validation.StringFormatMinMax(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
                    session.setAttribute("alert-sucess", name);
                    boolean resu = list.EditFolder(request.getParameter("fid"), name, uid, sharefolder);
                    if (resu) {
                          session.removeAttribute("alert-sucess");
                        session.setAttribute("alert-sucess", "Cập nhập folder thành công!");
                        try {
                            response.sendRedirect("./AdminFolder.jsp");

                        } catch (Exception ex) {

                        }
                    } else {
                          session.removeAttribute("alert");
                        errors = "Cập nhập nội dung folder không thành công";
                        session.setAttribute("alert", errors);
                        try {
                            response.sendRedirect("./AdminFolder.jsp");

                        } catch (Exception ex) {

                        }
                    }

                } else {
                      session.removeAttribute("alert");
                    errors = validation.getShowErrors();
                    session.setAttribute("alert", errors);
                    try {
                        response.sendRedirect("./AdminFolder.jsp");

                    } catch (Exception ex) {

                    }
                }
            }
        }

    }
%>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Thư mục <% if (re != null) {
                    out.print(re.getName());
                } %>  </h1>
        </div>
        <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <form action="" method="POST" class="ng-pristine ng-valid ng-scope">
                <div class="form-group">
                    <label>Tên thư mục : </label>
                    <input class="form-control" name="name" required="" value="<% if (re != null) {
                            out.print(re.getName());
                        } %> ">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
                <div class="form-group">
                    <label>Chọn tác giả : </label>
                    <select class="form-control" name="uid" required>
                        <% for (int i = 0; i < li.size(); i++) {%>
                        <option value="<%= li.get(i).getUid()%>"><%= li.get(i).getUsername()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="form-group">
                    <label>Chế độ chia sẻ :</label>
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
                    <input class="btn btn-primary" type="submit" value="Cập nhập">
                </div>
            </form>
        </div>
    </div>

</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>