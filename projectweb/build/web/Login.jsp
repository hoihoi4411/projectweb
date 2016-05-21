<%-- 
    Document   : Login
    Created on : May 21, 2016, 9:28:59 PM
    Author     : MyPC
--%>

<%@page import="javax.print.attribute.HashAttributeSet"%>
<%@page import="vn.fpt.project.bo.Hash"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login User</title>
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
            String token = Hash.generateToken();
            session.setAttribute("token", token);
            if (request.getParameter("token") != session.getAttribute(token)) {
                
            }
        %>
        <div class="container">
            <form class="form-signin" action="" method="POST" name="myForm">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" class="sr-only">Username</label>
                <input type="text" id="inputEmail" ng-model="username" class="form-control" placeholder="Username" name="username" required autofocus>
                <span ng-show="myForm.username.$touched && myForm.username.$invalid" class="label label-danger">The username is required.</span>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" ng-model="password" required>
                <span ng-show="myForm.password.$touched && myForm.password.$invalid" class="label label-danger">The password is required.</span>
                
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me" name="remember-me"> Remember me
                    </label>
                    <input type="hidden" value="<%= token%>" name="token">
                </div>
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
            </form>
        </div> <!-- /container -->
        <!-- Latest compiled and minified JavaScript -->
        <script type="text/javascript" src="./style/js/jquery.min.js"></script>
        <script src="./style/js/bootstrap.min.js"></script>
        <script src="./style/js/angular.min.js"></script>
    </body>
</html>
