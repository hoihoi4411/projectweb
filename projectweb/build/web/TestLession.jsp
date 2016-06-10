<%-- 
    Document   : TestLession
    Created on : May 20, 2016, 9:27:10 PM
    Author     : MyPC
--%>

<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson get = null;
    boolean checkEdit = false;
    String id = request.getParameter("lid");
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
        try {
            response.sendRedirect("./UsersPage.jsp");
        } catch (Exception ex) {

        }
        return;
    } else {
        get = list.searchLession(request.getParameter("lid"));
        String idU = "";
        switch (get.getShare()) {
            case 1:
                if (session.getAttribute("user") != null) {
                    Users author = (Users) session.getAttribute("user");
                    idU = author.getUid() + "";
                } else if (!user.equals("")) {
                    idU = user.substring(0, user.indexOf("|"));
                }
                if (idU.equals("")) {
                    try {
                        response.sendRedirect("./Login.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                String uid = idU;
                if (get.getUid() != Integer.parseInt(idU)) {
                    try {
                        response.sendRedirect("./UsersPage.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                break;
            case 2:

                if (session.getAttribute("user") != null) {
                    Users author = (Users) session.getAttribute("user");
                    idU = author.getUid() + "";
                } else if (!user.equals("")) {
                    idU = user.substring(0, user.indexOf("|"));
                }
                if (idU.equals("")) {
                    try {
                        response.sendRedirect("./Login.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                break;
        }
        if (session.getAttribute("user") != null) {
            Users author = (Users) session.getAttribute("user");
            idU = author.getUid() + "";
        } else if (!user.equals("")) {
            idU = user.substring(0, user.indexOf("|"));
        }
        if (!idU.equals("")) {
            if (get.getUid() == Integer.parseInt(idU)) {
                checkEdit = true;

            }
        }

        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
    }

%>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;" ng-app="myApp">
    <ul class="breadcrumb">
        <li><a href="./UsersPage.jsp">Home</a></li>
        <li class="active">Kiểm tra <% if (get != null) {
                out.print(get.getTitle());
            } %></li>
    </ul>
    <h2><% if (get != null) {
            out.print(get.getTitle());
        } %></h2>
    <hr>

    <form class="form-horizontal" id="quizForm" action="" method="POST">
        <div class="form-group">
            <div ng-controller="Note">
                <div ng-repeat="(key, item) in items"  class="form-group">
                    <input type="hidden" placeholder="Enter Question" ng-model="item.id" class="form-control">

                    <div class="col-lg-4">
                        <i class="fa fa-question fa-2x" aria-hidden="true"></i> <span style="font-size: 15px; font-weight: 800"> Câu hỏi {{key + 1}}: {{item.question}}<span>
                                </div>
                                <div class="col-lg-5">
                                    <input ng-class="{
                                                'blockInput': !item.inlineChecked}" type="text" class="form-control" placeholder="Enter Answer" ng-model="item.text" required="">

                                </div>
                                {{item.result}}
                                </div>
                                <div class="col-lg-12">
                                    <div class="col-lg-3">
                                        <h4> <span class="label label-success">Tổng số câu hỏi :</span> {{total}} câu</h4>
                                    </div>
                                    <div class="col-lg-3">
                                         <h4>  <span class="label label-danger">Số câu trả lời sai : </span>  {{refalse}}  </h4>   
                                    </div>

                                    <div class="col-lg-3">
                                         <h4>  <span class="label label-primary">Số câu trả lời đúng : </span>  {{retrue}}    </h4> 
                                    </div>
                                    <div class="col-lg-3">
                                        <h4>   <span class="label label-default">Điểm số: </span>  {{retrue * (total / 10)}}    </h4> 
                                    </div>
                                    <div class="col-lg-12">
                                        <a class="btn btn-primary" ng-click="check()">Kiểm tra</a>
                                    </div>
                                </div>
                                </div>
                                </div>
                                </form>  

                                <ul class="breadcrumb">
                                    <li><a href="./UsersPage.jsp">Home</a></li>
                                    <li class="active">Kiểm tra <% if (get != null) {
                                            out.print(get.getTitle());
                                        } %></li>
                                </ul>
                                </div>
                                <script type="text/javascript">
                                    <% String data = "[";
                                        String dataCheck = "[";
                                        int total = 0;
                                        if (listAQuiz != null) {
                                            total = listAQuiz.size();
                                            for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                                                Integer key = entry.getKey();
                                                Quiz value = entry.getValue();%>
                                    <%
                                        data += "{id: \"" + key + "\", question: \"" + value.getQuestion().trim()
                                                + "\", text: \"\"},";
                                        dataCheck += "{id: \"" + key + "\", answer: \"" + value.getAnswer().trim() + "\"},";
                                    %>


                                    <% }
                                            data += "]";
                                            dataCheck += "]";
                                        }
                                    %>
                                    var tottal = <%= total%>;
                                    var data = <%=data%>;
                                    var dataCheck = <%=dataCheck%>;
                                    var mymodal = angular.module('myApp', []);
                                    mymodal.controller('Note', function ($scope) {
                                        $scope.items = data;
                                        $scope.total = tottal;
                                        $scope.retrue = 0;
                                        $scope.refalse = 0;

                                        $scope.check = function () {
                                            angular.forEach($scope.items, function (value, key) {
                                                if (value.key === dataCheck[key].key) {
                                                    if (value.text === dataCheck[key].answer) {
                                                        value.result = "Dung";
                                                        $scope.retrue++;
                                                    } else {
                                                        value.result = "Sai";
                                                        $scope.refalse++;
                                                    }
                                                }
                                            });

                                        }
                                    });
                                </script>
                                <%@include file="Footer.jsp"  %>