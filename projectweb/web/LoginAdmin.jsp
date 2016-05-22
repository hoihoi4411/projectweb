<%-- 
    Document   : Login
    Created on : May 21, 2016, 9:28:59 PM
    Author     : MyPC
--%>

<%@page import="vn.fpt.project.bo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Admin</title>
        <link rel="stylesheet" href="./style/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="./style/css/bootstrap-theme.min.css" >
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="./style/css/style.css" >
    </head>
    <body ng-app="">
        <%
            if (session.getAttribute("admin") != null) {
                response.sendRedirect("./Admin.jsp");
            }
            String token = Hash.generateToken();
            session.setAttribute("token", token);
            String errors = "";
            if (request.getParameter("token") != session.getAttribute(token)) {
                session.removeAttribute("token");
                Admin user = new Admin();
                Validation validation = new Validation();
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.StringFormatMinMax(password, 5, 15, "password")) {
                    boolean re = user.isAdmin(request.getParameter("username"), request.getParameter("password"));
                    if (re) {
                        session.setAttribute("admin", request.getParameter("username"));
                        session.setAttribute("user", request.getParameter("username"));
                        response.sendRedirect("./Admin.jsp");
                    } else {
                        errors = "You Not Admin";
                    }
                } else {
                    errors = validation.getShowErrors();
                }

            }
        %>
        <div class="container">
            <% if (!errors.equals("")) {%>
            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Có lỗi </strong> <%= errors%>
            </div>
            <% }%>
            <div class="panel panel-primary" style="    width: 50%;
                 margin: auto;
                 margin-top: 50px;">
                <div class="panel-heading">
                    <div class="panel-title text-center">Admin Login </div>
                </div>     

                <div class="panel-body">

                    <form  name="myForm" id="form" class="form-horizontal" method="POST" action="" >

                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input id="user" type="text" class="form-control"  value="" placeholder="User" ng-model="username" name="username" required autofocus>  
                          
                        </div>
                          <span ng-show="myForm.username.$touched && myForm.username.$invalid" class="label label-danger">The username is required.</span>


                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input id="password" type="password" class="form-control"  placeholder="Password" name="password" ng-model="password" required>
                           
                        </div>
                           <span ng-show="myForm.password.$touched && myForm.password.$invalid" class="label label-danger">The password is required.</span>

                        <div class="input-group">
                            <input type="hidden" value="<%= token%>" name="token">
                        </div>
                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-sm-12 controls">
                                <input type="submit" class="btn btn-primary pull-right" name="submit" value="Log in">                        
                            </div>
                        </div>

                    </form>     

                </div>                     
            </div>
        </div> <!-- /container -->
        <!-- Latest compiled and minified JavaScript -->
        <script type="text/javascript" src="./style/js/jquery.min.js"></script>
        <script src="./style/js/bootstrap.min.js"></script>
        <script src="./style/js/angular.min.js"></script>
    </body>
</html>
