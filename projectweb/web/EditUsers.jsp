<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    Users user = null;
    if (request.getParameter("uid") == null) {
        session.removeAttribute("alert");
        session.setAttribute("alert", "Invalid Users !");
        response.sendRedirect("./AdminUser.jsp");
    } else {
        lista.getListData();
        int uid = -1;
        try {
            uid = Integer.parseInt(request.getParameter("uid"));
            user = lista.SearchUser(uid);
            if (user == null) {
                session.removeAttribute("alert");
                session.setAttribute("alert", "Uid is not have in Database !");
                response.sendRedirect("./AdminUser.jsp");
            }
        } catch (Exception e) {
            if (session.getAttribute("alert") != null) {
                session.removeAttribute("alert");
                session.removeAttribute("alert");
            }
            session.removeAttribute("alert");
            session.setAttribute("alert", "Uid is not invalid!");
            response.sendRedirect("./AdminUser.jsp");
        }

    }
    int uid = Integer.parseInt(request.getParameter("uid"));
    String errors = "";
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        session.removeAttribute("token");
        Validation validation = new Validation();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        if (password == null) {
            if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.NumberFormatMinMax(permission, 1, 2, "permission")) {
                boolean resu = lista.UpdateUser(username, password, permission, uid);
                if (resu) {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Update Users Successful!");
                    response.sendRedirect("./AdminUser.jsp");
                } else {
                    session.removeAttribute("alert");
                    errors = "Username exits in unique";
                    session.setAttribute("alert", errors);
                }
            } else {
                session.removeAttribute("alert");
                errors = validation.getShowErrors();
                session.setAttribute("alert", errors);
            }
        } else if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.NumberFormatMinMax(permission, 1, 2, "permission")) {
            boolean resu = lista.UpdateUser(username, password, permission, uid);
            if (resu) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Update Users Successful!");
                response.sendRedirect("./AdminUser.jsp");
            } else {
                session.removeAttribute("alert");
                errors = "Username exits in unique";
                session.setAttribute("alert", errors);
            }
        } else {
            session.removeAttribute("alert");
            errors = validation.getShowErrors();
            session.setAttribute("alert", errors);
        }
    }
    errors = null;

%>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Edit User <%                if (user != null) {
                    out.print(user.getUsername());
                }
                %> </h1>
        </div>
        <!-- /.col-lg-12 -->
        <div class="col-lg-12">

            <% if (session.getAttribute("alert") != null) {
                    errors = (String) session.getAttribute("alert");
                }
                session.removeAttribute("alert"); %>
            <% if (errors != null) {%>
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <%=  errors%>
            </div>
            <% } %>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Edit User <%                if (user != null) {
                            out.print(user.getUsername());
                        }
                        %></h3>
                </div>
                <form action="" method="POST" name="AddnewForm" >
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Username : </label>
                                    <input class="form-control" value="<%
                                        if (user != null) {
                                            out.print(user.getUsername());
                                        }
                                           %>"type="text" name="username" placeholder="Enter here Username"  required  >
                                </div>
                                <div class="form-group">
                                    <label>Selects</label>
                                    <select class="form-control" name="permission">
                                        <option value="1">Admin</option>
                                        <option value="2" selected="">Users</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Password : </label>
                                    <input class="form-control" type="password" placeholder="Enter Password Here" name="password"  autocomplete="off">
                                </div>
                                <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                                     out.print(session.getAttribute("token"));%>" name="token">
                                <div class="form-group">
                                    <input type="submit" class="btn btn-danger" value="Cập nhật">
                                    <input type="reset" class="btn btn-default" value="Reset">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- /#page-wrapper -->
<%@include file="AdminFooter.jsp"  %>
