<%-- 
    Document   : Index
    Created on : May 20, 2016, 8:56:01 PM
    Author     : MyPC
--%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"  %>
<% ListFolder l = new ListFolder();
    int countF = l.countFolder();
    ListLession listLession = new ListLession();
    int countL = listLession.countLesson();%>
<div class="container">
    <ul class="breadcrumb">
        <li><a href="./index.jsp">Home</a></li>
    </ul>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>

        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="./style/img/1.jpg" alt=" Học Tập" style="    height: 500px;
                     width: 1150px;">
                <div class="carousel-caption">
                    <h2>Chào mừng bạn đến với QUIZLETG3<h2>
                            <ul class="list-group" >
                                <li class="list-group-item" style="    background-color: rgba(48, 48, 48, 0.56);">
                                    <span class="badge"><%= listUserH.getListUser().size()%></span>
                                    Thành viên
                                </li>
                                <li class="list-group-item"  style="    background-color: rgba(48, 48, 48, 0.56);">
                                    <span class="badge"><%=countF%></span>
                                    Folder
                                </li>
                                <li class="list-group-item"  style="    background-color: rgba(48, 48, 48, 0.56);">
                                    <span class="badge"><%= countL%></span>
                                    Lesson
                                </li>
                            </ul>
                            </div>
                            </div>
                            <div class="item">
                                <img src="./style/img/2.jpg" alt=" Học Tập" style="    height: 500px;
                                     width: 1150px;">
                                <div class="carousel-caption">
                                    <h2>Cùng trải nghiệm học tập với QUIZLETG3<h2>
                                            <a href="./Login.jsp" class="btn btn-primary btn-lg">Đăng ký</a><a href="./CreateUser.jsp" class="btn btn-primary btn-lg">Đăng Nhập</a>
                                            </div>
                                            </div>
                                            <div class="item">
                                                <img src="./style/img/3.jpg" alt=" Học Tập" style="    height: 500px;
                                                     width: 1150px;">
                                                <div class="carousel-caption">
                                                    <h1> Học Từ mới một cách thuận tiện hơn</h1>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <img src="./style/img/4.jpg" alt=" Học Tập" style="    height: 500px;
                                                     width: 1150px;">
                                                <div class="carousel-caption">
                                                    <h1>Học từ mới mỗi ngày với Quizlet</h1>
                                                </div>
                                            </div>
                                            </div>

                                            <!-- Controls -->
                                            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                                <span class="sr-only">Next</span>
                                            </a>
                                            </div>
                                            </div>
                                            <%@include file="Footer.jsp"  %>