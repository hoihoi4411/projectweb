<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    ListUser listb = new ListUser();
    listb.getListData();
    String err = "";
    ArrayList<Users> li = listb.getListUser();
    if (request.getParameter("token") != null && session.getAttribute("token").equals(request.getParameter("token"))) {
        String title = request.getParameter("title");
        String share = request.getParameter("share");
        String uid = request.getParameter("uid");
        String hieu = request.getParameter("hieu");
        byte[] bytes = hieu.getBytes(StandardCharsets.ISO_8859_1);
        hieu = new String(bytes, StandardCharsets.UTF_8);
        Validation validation = new Validation();
        ListLession lisLession = new ListLession();
        ArrayList<Quiz> liQuiz = null;
        if (!hieu.equals("")) {
            liQuiz = lisLession.GetDataRequest(hieu);
        }
         
        if (validation.StringFormatOnlyLetterAndDigitsAndBackSpace(title, 5, 30, "title") && validation.NumberFormatMinMax(share, 1, 3, "share")
                && uid.matches("[0-9]+")) {
            if (liQuiz != null) {
                if (listb.SearchUser(Integer.parseInt(uid)) != null) {
                    boolean re = lisLession.addNewLesson(title, uid, share);
                    lisLession.getData();
                    Lesson get = lisLession.getListLessonB().get(lisLession.getListLessonB().size() - 1);
                    ListQuiz listQuizA = new ListQuiz();
                    boolean result = listQuizA.addNewListQuiz(liQuiz, get.getLid() + "");
                    if (re && result) {
                        session.removeAttribute("alert-sucess");
                        session.setAttribute("alert-sucess", "Thêm bài học thành công");
                        response.sendRedirect("./AdminLession.jsp");
                    } else {
                        err += "Thêm bài học thất bại, vui lòng kiểm tra lại";
                    }
                } else {
                    err += "Người dùng bạn chọn không tồn tại";
                }
            } else {
                err += "Câu hỏi ko dc bỏ trống";
            }

        } else {
            err += validation.getShowErrors();
        }
    }

%>
<div id="page-wrapper">

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
                <div class="form-group">
                    <label for="select" class="col-lg-2 control-label">Chọn Users</label>
                    <div class="col-lg-6">
                        <select class="form-control" name="uid" required>
                            <% for (int i = 0; i < li.size(); i++) {

                            %>

                            <option value="<%= li.get(i).getUid()%>"><%= li.get(i).getUsername()%></option>
                            <%
                                }%>
                        </select>
                        <br>
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

</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>