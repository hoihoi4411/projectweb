<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson get = null;
    String lid = request.getParameter("lid");
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
        try {
            response.sendRedirect("./AdminLession.jsp");
        } catch (Exception e) {
        }

        return;
    } else if (list.searchLession(request.getParameter("lid")) == null) {
        try {
            response.sendRedirect("./AdminLession.jsp");
        } catch (Exception e) {
        }
        return;
    } else {
        get = list.searchLession(request.getParameter("lid"));
        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
        if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
            String hieu = request.getParameter("hieu");
            byte[] bytes = hieu.getBytes(StandardCharsets.ISO_8859_1);
            hieu = new String(bytes, StandardCharsets.UTF_8);
            ArrayList<Quiz> liQuiz = list.GetDataRequestUpdate(hieu);
            ListQuiz listQuizA = new ListQuiz();
            boolean result = listQuizA.UpdateListQuiz(liQuiz, lid + "");
            if (result) {
                try {
                    response.sendRedirect("./AdminLessionPage.jsp?lid=" + lid);
                } catch (Exception e) {
                }
                return;
            } else {
%>
<div class="alert alert-dismissible alert-danger">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Có lỗi !</strong> Các quiz của bài học này, đã không dc cập nhật!
</div>
<%}
        }
    }
%>

<div id="page-wrapper" ng-app="myApp">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Chỉnh sửa Quiz <% if (get != null) {
                    out.print(get.getTitle());
                }%> </h1>
            <hr>
            <div class="dataTable_wrapper">
                <form method="POST" id="quizForm" action="">
                    <div ng-controller="Note">
                        <div ng-repeat="item in items| filter:{ shouldBeDeleted: false }"  class="form-group">
                            <input type="hidden" placeholder="Enter Question" ng-model="item.id" class="form-control">

                            <div class="col-lg-5">
                                <input type="text" placeholder="Enter Question" ng-model="item.question" class="form-control">
                            </div>
                            <div class="col-lg-5">
                                <input ng-class="{
                                            'blockInput': !item.inlineChecked}" type="text" class="form-control" placeholder="Enter Answer" ng-model="item.text">
                            </div>
                            <div class="col-lg-2 checkbox">
                                <button type="button" name="check" value="inline"  class="btn btn-danger" ng-click="remove(item)"> Xóa câu này</button>
                            </div>
                        </div>
                               <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                                   out.print(session.getAttribute("token"));%>" name="token">
                        <input type="hidden" value="" id="result" name="hieu" />
                        <a class="btn btn-success" ng-click="add()">Thêm một quiz</a>
                        <a class="btn btn-primary" ng-click="save()">Lưu bài </a>
                    </div>
                </form>
                <script type="text/javascript">
                    <% String data = "[";
                        if (listAQuiz != null) {
                            for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                                Integer key = entry.getKey();
                                Quiz value = entry.getValue();%>
                    <%
                        data += "{id: \"" + key + "\", question: \"" + value.getQuestion().trim()
                                + "\", text: \"" + value.getAnswer().trim() + "\", \"shouldBeDeleted\": false},";
                    %>


                    <% }
                            data += "]";
                        }
                    %>
                    var data = <%=data%>;
                    var mymodal = angular.module('myApp', []);
                    mymodal.controller('Note', function ($scope) {
                        $scope.items = data;
                        $scope.add = function () {

                            $scope.items.push({
                                id: "0",
                                question: "",
                                text: "",
                                shouldBeDeleted: false
                            });

                        };
                        $scope.save = function () {
                            var result = "";
                            angular.forEach($scope.items, function (value, key) {
                                if (value.question !== "" && value.text !== "") {
                                    result += value.id + "||||||" + value.question + "||||||" + value.text + "||||||" + value.shouldBeDeleted + "\n";
                                }
                            });
                            $("#result").val(result);
                            $("#quizForm").submit();
                        };
                        $scope.remove = function (item) {
                            item.shouldBeDeleted = true;
                        };
                    });
                </script>
            </div>
            <hr>
        </div>
        <!-- /.col-lg-12 -->
    </div>
</div>
<!-- /#page-wrapper -->
<%@include file="AdminFooter.jsp"  %>