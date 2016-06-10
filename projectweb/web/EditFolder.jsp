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
    if (session.getAttribute("user") == null && ck == false) {
        response.sendRedirect("./Login.jsp");
        return;
    }
    String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
    FolderJoinUser re = null;
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
        } else if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
            session.removeAttribute("token");
            Validation validation = new Validation();
            String name = request.getParameter("name");
            byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
            name = new String(bytes, StandardCharsets.UTF_8);

            String sharefolder = request.getParameter("sharefolder");
            if (validation.StringFormatMinMax(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
                session.setAttribute("alert-sucess", name);
                boolean resu = list.EditFolder(request.getParameter("fid"), name, uid, sharefolder);
                if (resu) {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Cập nhập folder thành công!");
                    try {
                        response.sendRedirect("./UsersPage.jsp");

                    } catch (Exception ex) {

                    }
                } else {
                    session.removeAttribute("alert");
                    errors = "Cập nhập nội dung folder không thành công";
                    session.setAttribute("alert", errors);
                    try {
                        response.sendRedirect("./UsersPage.jsp");

                    } catch (Exception ex) {

                    }
                }

            } else {
                session.removeAttribute("alert");
                errors = validation.getShowErrors();
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
    <div class="col-lg-12">
        <form action="" method="POST" class="ng-pristine ng-valid ng-scope">
            <div class="form-group">
                <label>Tên thư mục : </label>
                <input class="form-control" name="name" required="" value="<% if (re != null) {
                        out.print(re.getName());
                    } %> ">
                <p class="help-block">Vui lòng nhập tên folder không quá 30 ký tự</p>
            </div>
            <div class="form-group">
                <label>Chế độ chia sẻ :</label>
                <div class="radio">
                    
                    <label>
                        <input type="radio" name="sharefolder" id="optionsRadios1" value="1" <% if (re != null) {
                        if(re.getSharefolder() == 1){
                            out.print("checked");
                        }
                    } %> >Chỉ mình tôi
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sharefolder" id="optionsRadios2" value="2" <% if (re != null) {
                        if(re.getSharefolder() == 2){
                            out.print("checked");
                        }
                    } %>>Dành cho thành viên
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sharefolder" id="optionsRadios3" value="3" <% if (re != null) {
                        if(re.getSharefolder() == 3){
                            out.print("checked");
                        }
                    } %>>Công khai
                    </label>
                </div>
            </div>
                   <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                       out.print(session.getAttribute("token"));%>" name="token">
            <div class="form-group">
                <input class="btn btn-primary" type="submit" value="Cập nhật">
            </div>
        </form>
    </div>
</div>
<%@include file="Footer.jsp"  %>