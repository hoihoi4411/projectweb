<%-- 
    Document   : Login
    Created on : 28-May-2016, 21:59:45
    Author     : phan2
--%>
<%@page import="vn.fpt.project.bao.ListUser"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./style/css/bootstrap.min.css">
        <link rel="stylesheet" href="./style/css/admin.css">

    </head>
    <body>
        <div class="container">
            <%
                
                Cookie[] cookies = request.getCookies();
                Cookie cookie = null;
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        if (cookie.getName().equalsIgnoreCase("username")) {
                            response.sendRedirect("./index.jsp");
                        }
                    }

                }else if (session.getAttribute("user") != null) {
                    response.sendRedirect("./index.jsp");
                }
                String errors = "";
                String username = "";
                String password = "";
                String repassword = "";
                if (request.getParameter("submit") != null) {
                    username = request.getParameter("username");
                    password = request.getParameter("password");
                    repassword = request.getParameter("repassword");
                    if (username.equals("") || password.equals("") || repassword.equals("")) {
                        errors += "You must enter enough information!";
                    } else if (!password.equals(repassword)) {
                        errors += "Check your password and re-password";
                    } else {
                        ListUser listUser = new ListUser();
                        listUser.getListData();
                        Validation validation = new Validation();
                        if (validation.StringFormatMinMax(username, 5, 30, "username") && validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username")
                                && validation.StringFormatMinMax(password, 5, 15, "password")) {
                            boolean re = listUser.SearchUser(username);
                            if (re) {
                                errors += "The username has been used!!!";
                            } else if (listUser.InsertNewUser(username, password, "2")) {
            %>
            <div class="alert alert-dismissible alert-danger"  >
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong> Create new account success! </strong> 
            </div>

            <%
                                response.sendRedirect("./Login.jsp?create=true");
                            } else {
                                errors += "Create new account fail";
                            }

                        } else {
                            errors += validation.getShowErrors();
                        }
                    }
                }


            %>

            <% if (!errors.equals("")) {%>
            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Có lỗi </strong> <%= errors%>
            </div>
            <% }%>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Enter Information</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="" method="POST">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Username" name="username" autofocus="" value="<%= username%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="<%= password%>">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Re-Password" name="repassword" type="password" value="<%= repassword%>">
                                    </div>
                                    <div class="input-group">
                                        <input type="hidden" value="<%= session.getAttribute("token")%>" name="token">
                                    </div>

                                    <!-- Change this to a button or input when using this as a form -->
                                    <!--<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>-->
                                    <div class="form-group">
                                        <!-- Button -->
                                        <div class="col-sm-12 controls">
                                            <input type="submit" class="btn btn-lg btn-success btn-block" name="submit" value="Create new account">                        
                                        </div>
                                    </div>

                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
