<%-- 
    Document   : Learn
    Created on : May 22, 2016, 3:32:51 PM
    Author     : MyPC
--%>

<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;" ng-app="myApp">
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
    <ul class="breadcrumb">
        <li><a href="./index.jsp">Home</a></li>
        <li class="active">Học bài <% if (get != null) {
                out.print(get.getTitle());
            } %></li>
    </ul>
    <h2><% if (get != null) {
            out.print(get.getTitle());
        } %></h2>
    <hr>
    <div class="row" ng-controller="QuizCtrl">
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <a href="#" class="btn btn-info disabled">Số câu đúng: {{checkTrue}} </a>

                    <a href="#" class="btn btn-warning disabled">Số câu sai : {{checkFalse}}  </a>
                </div>
                <div class="panel-footer">
                    <div class="text-center">
                        Vòng thứ {{round}}
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div id="idLearn" >
                        <form>
                            <h1>{{currentQuestion.question}}</h1>
                            <div class="form-group block" id="showAns">
                                <div class="col-lg-12" >
                                    Gợi ý : {{currentQuestion.answer}}
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-8">
                                    <input ng-model="currentQuestion.userAnswer" class="form-control" >
                                </div>

                                <div class="col-lg-2">
                                    <button ng-click="check()" class="btn btn-success">Check</button>
                                </div>
                                <div class="col-lg-2 block" id="GetReFal">
                                    <span class='label label-danger'>Sai</span>
                                </div>
                                <div class="col-lg-2 block" id="GetReTrue">
                                    <span class='label label-success'>Đúng</span>
                                </div>
                                <br/>
                            </div>

                        </form>
                    </div>
                    <div class="form-group block" id="checkNext">
                        <div class="col-lg-12 text-center">
                            <h3 class="text-center"> Kết thúc round thứ {{round}} </h3>
                            <h4><span class="label label-primary">Số câu trả lời đúng : {{checkTrue}} </span></h4>
                            <h4><span class="label label-danger"> Số câu trả lời sai : {{checkFalse}} </span></h4>
                        </div>

                        <div class="col-lg-12 text-center">
                            <button ng-click="checkNextRoud()" class="btn btn-success">Nhấn để tiếp tục học bài </button>
                        </div>
                        <br/>
                    </div>
                    <div id="idEndLearn" class="block">
                        <h3 class="text-center"> Bạn đã học hết bài này </h3>
                        <div class="row" ng-repeat="dat in arr">
                            <div class="col-lg-4" > <h4 > <i class="fa fa-undo" aria-hidden="true"></i>  <span class="label label-primary">Vòng : {{dat.round}} </span></h4></div>
                            <div class="col-lg-4"> <h4><span class="label label-success">Số câu trả lời đúng : {{dat.checkTrue}} </span></h4></div>
                            <div class="col-lg-4"><h4><span class="label label-danger"> Số câu trả lời sai : {{dat.checkFalse}} </span></h4></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <ul class="breadcrumb">
        <li><a href="./index.jsp">Home</a></li>
        <li class="active">Học bài <%  if (get != null) {
                out.print(get.getTitle());
            }%></li>
    </ul>
</div>
<script type="text/javascript">
    function shuffle(array) {
        var currentIndex = array.length, temporaryValue, randomIndex;

        // While there remain elements to shuffle...
        while (0 !== currentIndex) {

            // Pick a remaining element...
            randomIndex = Math.floor(Math.random() * currentIndex);
            currentIndex -= 1;

            // And swap it with the current element.
            temporaryValue = array[currentIndex];
            array[currentIndex] = array[randomIndex];
            array[randomIndex] = temporaryValue;
        }

        return array;
    }
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
                + "\", text: \"\",  answer: \"" + value.getAnswer().trim() + "\" },";
    %>


    <% }
            data += "]";
        }
    %>
    var data = <%= data%>;
    angular.module('myApp', [])
            .controller('QuizCtrl', function ($scope) {
                $scope.questionBank = shuffle(data);
                $scope.checkTrue = 0;
                $scope.checkFalse = 0;
                $scope.round = 1;
                $scope.wrongAnswers = [];
                $scope.currentQuestionIndex = 0;
                $scope.currentQuestion = $scope.questionBank[$scope.currentQuestionIndex];
                $scope.arr = [];
                $scope.checkNextRound = false;
                $scope.checkNextRoud = function () {
                    $("#idLearn").removeClass("block");
                    $("#checkNext").addClass("block");
                    $scope.checkTrue = 0;
                    $scope.checkFalse = 0;
                    $scope.round ++;
                };
                $scope.check = function () {
                    
                    var current = $scope.currentQuestion;
                    var userAnswer = current.userAnswer || '';
                    var currentAnswer = current.answer;
                    var check = true;
                    if (currentAnswer.toLowerCase() === userAnswer.toLowerCase()) {
                        $scope.checkTrue++;
                    } else {
                        $("#showAns").removeClass("block");
                        $("#getAns").removeClass("block");
                        $("#getQ").addClass("block");
                        var currentQuestion = $scope.currentQuestion;
                        $scope.wrongAnswers.push({
                            id: currentQuestion.id,
                            question: currentQuestion.question,
                            text: currentQuestion.text,
                            answer: currentQuestion.answer
                        });
                        $scope.checkFalse++;
                        check = false;
                    }
                    if (check) {
                        $("#showAns").addClass("block");
                        $scope.currentQuestionIndex++;
                    }
                    
                    if ($scope.currentQuestionIndex < $scope.questionBank.length) {
                        $scope.currentQuestion = $scope.questionBank[$scope.currentQuestionIndex];
                    } else {
                        $scope.arr.push({
                            round: $scope.round,
                            checkTrue: $scope.checkTrue,
                            checkFalse: $scope.checkFalse
                        });
                        $("#idLearn").addClass("block");
                        $("#checkNext").removeClass("block");
                         
                        if ($scope.wrongAnswers.length === 0) {
                            $scope.end = "End";
                            $("#idEndLearn").removeClass("block");
                            $("#idLearn").addClass("block");
                            $("#checkNext").addClass("block");
                        } else {

                            $scope.questionBank = shuffle($scope.wrongAnswers);
                            $scope.wrongAnswers = [];
                            $scope.currentQuestionIndex = 0;
                            $scope.currentQuestion = $scope.questionBank[$scope.currentQuestionIndex];
                        }
                       
                    }
                };
            });

</script>
<style>
    .block{
        display: none;
    }
</style>
<%@include file="Footer.jsp"  %>
