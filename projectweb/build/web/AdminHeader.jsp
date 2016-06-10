<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Control Panel</title>
        <!-- Latest compiled and minified CSS -->

        <link rel="stylesheet" href="./style/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="./style/css/bootstrap-theme.min.css" >

        <!-- Custom CSS -->
        <link href="./style/css/admin.css" rel="stylesheet">
        <link href="./style/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- DataTables CSS -->
        <link href="./style/css/dataTables.bootstrap.css" rel="stylesheet">
        
        <script src="./style/js/angular.min.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body >
        <%
            if (session.getAttribute("admin") == null) {
                try {
                    response.sendRedirect("./LoginAdmin.jsp");
                    
                } catch (Exception ex) {

                }
                return;
            }
            ListUser lista = new ListUser();

        %>

        <div id="wrapper" >

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Điều hướng</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./Admin.jsp">Admin Control Panel</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> <% Users admin = (Users) session.getAttribute("admin"); out.print(admin.getUsername()); %> </a>
                            </li>
                            <li><a href="./Index.jsp"><i class="fa fa-gear fa-fw"></i> Xem trang chủ</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="LogoutAdmin.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Tìm kiếm...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                                <!-- /input-group -->
                            </li>
                            <li>
                                <a href="./Admin.jsp"><i class="fa fa-dashboard fa-fw"></i> Trang chủ</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Thành viên <span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./AdminUser.jsp">Thành viên</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>


                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> Bài học <span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./AdminLession.jsp">Bài học</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> Thư mục <span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./AdminFolder.jsp">Thư mục</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>