<%@page import="vn.fpt.project.bo.Users"%>
<%@page import="vn.fpt.project.bao.*"%>
<!doctype html>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta contentType="text/html; charset=UTF-8" >
        <title>QUIZLETG3</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <!-- endbuild -->
        <!-- Custom CSS -->
        <%
            
            String style = "";
            Cookie[] cookies = request.getCookies();
            Cookie cookie = null;
            boolean ck = false;
            String user = "";
            if (request.getParameter("style") != null) {
                session.removeAttribute("style");
                session.setAttribute("style", request.getParameter("style"));

            }
            if (session.getAttribute("style") == null) {
                style = "darkly.css";
            } else {
                style = (String) session.getAttribute("style") + ".css";
            }
            Users author_H = null;
            if(session.getAttribute("user") != null){
                author_H = (Users) session.getAttribute("user");
            }else if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equalsIgnoreCase("username")) {
                        ck = true;
                        user = cookie.getValue();
                        
                        break;
                    }
                }

            }
            ListUser listUserH = new ListUser();
            listUserH.getListData();
            if(ck){
                author_H = listUserH.SearchUser(Integer.parseInt(user.substring(0, user.indexOf("|"))));
            }
            String url = request.getRequestURL().toString();
            if(request.getParameter("lid") != null){
                url += "?lid="+request.getParameter("lid")+"&";
            }else if(request.getParameter("fid") != null){
                 url += "?fid="+request.getParameter("fid")+"&";
            }else{
                url += "?";
            }
        %>
        <link rel="stylesheet" href="./style/css/<%= style%>">

        <link href="./style/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- DataTables CSS -->
        <link href="./style/css/style.css" rel="stylesheet">
        <!-- Fonts -->
        <script src="./style/js/angular.min.js"></script>
    </head>
    <style>
        .fa-btn {
            margin-right: 6px;
        }

    </style>
    <body >
        <!--[if lte IE 8]>
        <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
            your browser</a> to improve your experience.
        </p>
        <![endif]-->
        <!-- Add your site or application content here -->
        <nav class="navbar navbar-default navbar-static-top navbar-top-links">
            <div class="container">
                <div class="navbar-header">
                    <!-- Collapsed Hamburger -->
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#app-navbar-collapse">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Branding Image -->
                    <a id="gkLogo"></a>
                    <a class="navbar-brand" href="./index.jsp">
                        QUIZLETG3
                    </a>
                </div>

                <div class="collapse navbar-collapse" id="app-navbar-collapse">

                    <!-- Left Side Of Navbar -->
                    <form class="navbar-form navbar-left" role="search" action="./Search.jsp" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search" name="ValueSearch">
                        </div>
                        <button type="submit" class="btn btn-warning"><i class="fa fa-search" aria-hidden="true"></i> Submit</button>
                    </form>
                     <% if (session.getAttribute("user") != null || ck == true) {%>
                     <div class="nav navbar-nav" style="    margin-top: 8px;">
                         <a href="./CreateLession.jsp" class="btn btn-success"><i class="fa fa-circle-o-notch" aria-hidden="true"></i> Tạo một bài học mới</a>
                     </div>
                     <% }  %>
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Authentication Links -->
                        <li class="dropdown">

                            <% if (session.getAttribute("user") == null && ck == false) {%>
                            <a class="dropdown-toggle" href="./Login.jsp" data-toggle="dropdown" href="" aria-expanded="false">  <i class="fa fa-user fa-fw"></i>Đăng nhập / Đăng ký <i class="fa fa-caret-down"
                                                                                                                                                                                        ></i></a>
                                <% } else{ %>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="" aria-expanded="false">  <i class="fa fa-user fa-fw"></i> <%

                                if (session.getAttribute("user") != null) {
                                    Users add = (Users) session.getAttribute("user");
                                    out.print(add.getUsername());
                                } else {
                                    out.print(user.substring(user.indexOf("|")+1, user.lastIndexOf("|")));
                                }
                                %> <i class="fa fa-caret-down"
                                   ></i></a>
                                <% } %>

                            <% if (session.getAttribute("user") != null || ck == true) { %>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="./UsersPage.jsp"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <% if(session.getAttribute("user") != null){
                                    Users aUser = (Users) session.getAttribute("user");
                                } %>
                                <%  if(author_H != null && author_H.getPermission() == 1) {%>
                                <li><a href="./Admin.jsp"><i class="fa fa-gear fa-fw"></i>AdminCP</a>
                                </li>
                                <%}%>
                                <li class="divider"></li>
                                <li><a href="./Logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                            <% } else { %>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="./Login.jsp"><i class="fa fa-user fa-fw"></i>Đăng Nhập </a>
                                </li>
                                <li><a href="./CreateUser.jsp"><i class="fa fa-gear fa-fw"></i> Đăng ký </a>
                                </li>
                            </ul>
                            <% }%>
                            <!-- /.dropdown-user -->
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                                <i class="fa fa-tasks fa-fw"></i> Đổi giao diện <i class="fa fa-caret-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <a href="<%=url%>style=darkly">
                                        Darkly-Mặc định
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=url%>style=cerulean">
                                        Giao diện Cerulean
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=url%>style=cosmo">
                                        Giao diện Cosmo
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=url%>style=cyborg">
                                        Giao diện Cyborg
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=url%>style=united">
                                        Giao diện United
                                    </a>
                                </li>
                            </ul>
                            <!-- /.dropdown-tasks -->
                        </li>
                    </ul>
                </div>
            </div>
        </nav>