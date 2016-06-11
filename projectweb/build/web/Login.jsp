<%--
    Document   : Login
    Created on : 28-May-2016, 21:59:45
    Author     : phan2
--%>
<%@page import="vn.fpt.project.bao.ListUser" %>
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
        <%
            Cookie cookie = null;
            Cookie cookie2 = null;
            String username = "";
            String u_id = "";
            String password = "";
            String errors = "";
            ListUser listUser = new ListUser();
            listUser.getListData();
            Validation validation = new Validation();
            boolean ck = false;

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {

                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equalsIgnoreCase("username")) {
                        ck = true;
                        break;
                    }
                }


            }

            if (session.getAttribute("user") != null || ck == true) {
                response.sendRedirect("./index.jsp");
            }
            if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
                Users user = new Users();
                session.removeAttribute("token");

                username = request.getParameter("username");
                password = request.getParameter("password");

                if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.StringFormatMinMax(password, 5, 15, "password")) {
                    boolean re = user.isLoggin(request.getParameter("username"), request.getParameter("password"));
                    if (re) {
                        u_id = "" + listUser.GetUserID(username);
                        
                        if (request.getParameter("remember") != null) {
                            cookie = new Cookie("username", listUser.SearchUser(Integer.parseInt(u_id)).toString());
                            cookie.setMaxAge(3000);
                            response.addCookie(cookie);

                        } else {
                            session.setAttribute("user", listUser.SearchUser(Integer.parseInt(u_id)));
                        };
                        response.sendRedirect("./UsersPage.jsp");
                    } else {
                        errors += "Incorrect Infor";
                    }
                } else {
                    errors += validation.getShowErrors() + "";
                }

            }

        %>
        <div class="container">
            <%  try {
                    if (request.getParameter("create").equals("true")) {
            %>
            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Create new account success! </strong> 
            </div>
            <% }
                } catch (Exception e) {
                }%>
            <% if (!errors.equals("")) {

            %>
            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Có lỗi </strong> <%= errors%>
            </div>
            <% }%>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Sign In</h3>
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
                                    <div class="input-group">
                                        <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                                            out.print(session.getAttribute("token"));%>" name="token">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <!--<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>-->
                                    <div class="form-group">
                                        <!-- Button -->
                                        <div class="col-sm-12 controls">
                                            <input type="submit" class="btn btn-lg btn-success btn-block" name="submit" value="Login">                        
                                        </div>
                                    </div>
                                    <a href="./CreateUser.jsp" >Create new account</a>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
