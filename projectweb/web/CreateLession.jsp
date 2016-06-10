<%-- 
    Document   : CreateLession
    Created on : May 20, 2016, 9:21:24 PM
    Author     : MyPC
--%>

<%@page import="java.util.*"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"  %>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;">
    <div class="col-lg-12">
        <ul class="breadcrumb">
            <li><a href="./Index.jsp">Home</a></li>
            <li class="active">Tạo Bài học mới</li>
        </ul>
    </div>
    <%
        if (session.getAttribute("user") == null && ck == false) {
           response.sendRedirect("./Login.jsp");
            return; 
        }
        String err = "";
        if (request.getParameter("token") != null && session.getAttribute("token").equals(request.getParameter("token"))) {
            String title = request.getParameter("title");
            byte[] bytes1 = title.getBytes(StandardCharsets.ISO_8859_1);
            title = new String(bytes1, StandardCharsets.UTF_8);
            String share = request.getParameter("share");
            String id = "";
            if (session.getAttribute("user") != null) {
                Users author = (Users) session.getAttribute("user");
                id = author.getUid() + "";
            } else if (!user.equals("")) {
                id = user.substring(0, user.indexOf("|"));
            }

            String uid = id;
            String hieu = request.getParameter("hieu");
            byte[] bytes = hieu.getBytes(StandardCharsets.ISO_8859_1);
            hieu = new String(bytes, StandardCharsets.UTF_8);
            Validation validation = new Validation();
            ListLession lisLession = new ListLession();
            ArrayList<Quiz> liQuiz = null;
            if (!hieu.equals("")) {
                liQuiz = lisLession.GetDataRequest(hieu);
            }
            if (validation.StringFormatMinMax(title, 5, 30, "title") && validation.NumberFormatMinMax(share, 1, 3, "share")
                    && uid.matches("[0-9]+")) {
                if (liQuiz != null) {
                    boolean re = lisLession.addNewLesson(title, uid, share);
                    lisLession.getData();
                    Lesson get = lisLession.getListLessonB().get(lisLession.getListLessonB().size() - 1);
                    ListQuiz listQuizA = new ListQuiz();
                    boolean result = listQuizA.addNewListQuiz(liQuiz, get.getLid() + "");
                    if (re && result) {
                        session.removeAttribute("alert-sucess");
                        session.setAttribute("alert-sucess", "Thêm bài học thành công");
                        response.sendRedirect("./UsersPage.jsp");
                    } else {
                        err += "Thêm bài học thất bại, vui lòng kiểm tra lại";
                    }
                } else {
                    err += "Câu hỏi ko dc bỏ trống";
                }
            } else {
                err += validation.getShowErrors();
            }
        }
    %>
    <div class="row" ng-app="myApp">

        <div class="col-lg-12">
            <h1 class="page-header">Tạo một bài học mới </h1>
        </div>

        <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <%                if (!err.equals("")) {
            %>
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <%= err%>
            </div>
            <%}%>
            <form class="form-horizontal" id="quizForm" action="" method="POST">
                <div class="form-group">
                    <label for="inputtitle" class="col-lg-2 control-label">Tiêu đề: </label>
                    <div class="col-lg-6">
                        <input type="text" name="title" class="form-control" id="inputtitle" placeholder="Lesson name" ng-model="myInput" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Chế độ chia sẻ: </label>
                    <div class="col-lg-6">
                        <div class="radio">
                            <label>
                                <input type="radio" name="share" id="optionsRadios1" value="1" checked="">
                                Chỉ mình tôi
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="share" id="optionsRadios2" value="2">
                                Cho Người Dùng xem
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="share" id="optionsRadios2" value="3">
                                Công khai
                            </label>
                        </div>
                    </div>
                </div>
                <h3>Thêm Câu hỏi vào bài học</h3>
                <hr>
                <div class="form-group">
                    <div ng-controller="Note">
                        <div ng-repeat="item in items"  class="form-group">
                            <div class="col-lg-5">
                                <input type="text" placeholder="Enter Question" ng-model="item.question" class="form-control" required="">
                            </div>
                            <div class="col-lg-5">
                                <input ng-class="{
                                            'blockInput': !item.inlineChecked}" type="text" class="form-control" placeholder="Enter Answer" ng-model="item.text" required="">
                            </div>
                            <div class="col-lg-2 checkbox">
                                <button type="button" name="check" value="inline"  class="btn btn-danger" ng-click="remove(item)"> Xóa câu này</button>
                            </div>
                        </div>
                               <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                            out.print(session.getAttribute("token"));%>" name="token">
                        <input type="hidden" value="" id="result" name="hieu" />
                        <a class="btn btn-success" ng-click="add()">Thêm câu hỏi</a>
                        <a class="btn btn-primary" ng-click="save()">Lưu bài</a>
                    </div>
                </div>
            </form>
            <script type="text/javascript">
                var data = [];
                for (var i = 0; i < 5; i++) {
                    data.push({
                        question: "",
                        text: ""
                    });
                }

                var mymodal = angular.module('myApp', []);
                mymodal.controller('Note', function ($scope) {
                    $scope.items = data;
                    $scope.add = function () {

                        $scope.items.push({
                            question: "",
                            text: ""
                        });

                    };
                    $scope.save = function () {
                        var result = "";
                        angular.forEach($scope.items, function (value, key) {
                            if (value.question !== "" && value.text !== "") {
                                result += value.question + "||||||" + value.text + "\n";
                            }
                        });
                        $("#result").val(result);
                        $("#quizForm").submit();
                    };
                    $scope.remove = function (item) {
                        var index = $scope.items.indexOf(item);
                        $scope.items.splice(index, 1);
                    };
                });



            </script>
        </div>
    </div>
    <div class="col-lg-12">
        <ul class="breadcrumb">
            <li><a href="./Index.jsp">Home</a></li>
            <li class="active">Tạo Bài học mới</li>
        </ul>
    </div>
</div>
<%@include file="Footer.jsp"  %>
