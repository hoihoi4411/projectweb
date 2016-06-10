package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.*;
import vn.fpt.project.bo.*;
import java.util.*;
import vn.fpt.project.bo.Users;

public final class Learn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta contentType=\"text/html; charset=UTF-8\" >\n");
      out.write("        <title>QUIZLETG3</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <!-- endbuild -->\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        ");

            
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
            if (cookies != null) {

                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equalsIgnoreCase("username")) {
                        ck = true;
                        user = cookie.getValue();
                        break;
                    }
                }

            }
            String url = request.getRequestURL().toString();
            if(request.getParameter("lid") != null){
                url += "?lid="+request.getParameter("lid")+"&";
            }else if(request.getParameter("fid") != null){
                 url += "?fid="+request.getParameter("fid")+"&";
            }else{
                url += "?";
            }
        
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/");
      out.print( style);
      out.write("\">\n");
      out.write("\n");
      out.write("        <link href=\"./style/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <!-- DataTables CSS -->\n");
      out.write("        <link href=\"./style/css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Fonts -->\n");
      out.write("        <script src=\"./style/js/angular.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .fa-btn {\n");
      out.write("            margin-right: 6px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <body >\n");
      out.write("        <!--[if lte IE 8]>\n");
      out.write("        <p class=\"browsehappy\">You are using an <strong>outdated</strong> browser. Please <a href=\"http://browsehappy.com/\">upgrade\n");
      out.write("            your browser</a> to improve your experience.\n");
      out.write("        </p>\n");
      out.write("        <![endif]-->\n");
      out.write("        <!-- Add your site or application content here -->\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top navbar-top-links\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <!-- Collapsed Hamburger -->\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\"\n");
      out.write("                            data-target=\"#app-navbar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle Navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <!-- Branding Image -->\n");
      out.write("                    <a id=\"gkLogo\"></a>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"./Index.jsp\">\n");
      out.write("                        QUIZLETG3\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"app-navbar-collapse\">\n");
      out.write("\n");
      out.write("                    <!-- Left Side Of Navbar -->\n");
      out.write("                    <form class=\"navbar-form navbar-left\" role=\"search\" action=\"./Search.jsp\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Search\" name=\"ValueSearch\">\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-warning\"><i class=\"fa fa-search\" aria-hidden=\"true\"></i> Submit</button>\n");
      out.write("                    </form>\n");
      out.write("                     ");
 if (session.getAttribute("user") != null || ck == true) {
      out.write("\n");
      out.write("                     <div class=\"nav navbar-nav\" style=\"    margin-top: 8px;\">\n");
      out.write("                         <a href=\"./CreateLession.jsp\" class=\"btn btn-success\"><i class=\"fa fa-circle-o-notch\" aria-hidden=\"true\"></i> Tạo một bài học mới</a>\n");
      out.write("                     </div>\n");
      out.write("                     ");
 }  
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <!-- Authentication Links -->\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("\n");
      out.write("                            ");
 if (session.getAttribute("user") == null && ck == false) {
      out.write("\n");
      out.write("                            <a class=\"dropdown-toggle\" href=\"./Login.jsp\" data-toggle=\"dropdown\" href=\"\" aria-expanded=\"false\">  <i class=\"fa fa-user fa-fw\"></i>Đăng nhập / Đăng ký <i class=\"fa fa-caret-down\"\n");
      out.write("                                                                                                                                                                                        ></i></a>\n");
      out.write("                                ");
 } else{ 
      out.write("\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"\" aria-expanded=\"false\">  <i class=\"fa fa-user fa-fw\"></i> ");


                                if (session.getAttribute("user") != null) {
                                    Users add = (Users) session.getAttribute("user");
                                    out.print(add.getUsername());
                                } else {
                                    out.print(user.substring(user.indexOf("|")+1, user.length()));
                                }
                                
      out.write(" <i class=\"fa fa-caret-down\"\n");
      out.write("                                   ></i></a>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 if (session.getAttribute("user") != null || ck == true) { 
      out.write("\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                <li><a href=\"./UsersPage.jsp\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\n");
      out.write("                                </li>\n");
      out.write("                                ");
 if(session.getAttribute("user") != null){
                                    Users aUser = (Users) session.getAttribute("user");
                                } 
      out.write("\n");
      out.write("                                <li><a href=\"./Admin.jsp\"><i class=\"fa fa-gear fa-fw\"></i>AdminCP</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"divider\"></li>\n");
      out.write("                                <li><a href=\"./Logout.jsp\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                <li><a href=\"./Login.jsp\"><i class=\"fa fa-user fa-fw\"></i>Đăng Nhập </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"./CreateUser.jsp\"><i class=\"fa fa-gear fa-fw\"></i> Đăng ký </a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                            <!-- /.dropdown-user -->\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"fa fa-tasks fa-fw\"></i> Đổi giao diện <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"");
      out.print(url);
      out.write("style=darkly\">\n");
      out.write("                                        Darkly-Mặc định\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"");
      out.print(url);
      out.write("style=cerulean\">\n");
      out.write("                                        Giao diện Cerulean\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"");
      out.print(url);
      out.write("style=cosmo\">\n");
      out.write("                                        Giao diện Cosmo\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"");
      out.print(url);
      out.write("style=cyborg\">\n");
      out.write("                                        Giao diện Cyborg\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"");
      out.print(url);
      out.write("style=united\">\n");
      out.write("                                        Giao diện United\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <!-- /.dropdown-tasks -->\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\" style=\"background: #fff;\n");
      out.write("     padding-left: 37px;\n");
      out.write("     padding-top: 20px;\" ng-app=\"myApp\">\n");
      out.write("    ");

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

    
      out.write("\n");
      out.write("    <ul class=\"breadcrumb\">\n");
      out.write("        <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("        <li class=\"active\">Học bài ");
 if (get != null) {
                out.print(get.getTitle());
            } 
      out.write("</li>\n");
      out.write("    </ul>\n");
      out.write("    <h2>");
 if (get != null) {
            out.print(get.getTitle());
        } 
      out.write("</h2>\n");
      out.write("    <hr>\n");
      out.write("    <div class=\"row\" ng-controller=\"QuizCtrl\">\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <a href=\"#\" class=\"btn btn-info disabled\">Số câu đúng: {{checkTrue}} </a>\n");
      out.write("\n");
      out.write("                    <a href=\"#\" class=\"btn btn-warning disabled\">Số câu sai : {{checkFalse}}  </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        Vòng thứ {{round}}\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-8\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <div id=\"idLearn\" >\n");
      out.write("                        <form>\n");
      out.write("                            <h1>{{currentQuestion.question}}</h1>\n");
      out.write("                            <div class=\"form-group block\" id=\"showAns\">\n");
      out.write("                                <div class=\"col-lg-12\" >\n");
      out.write("                                    Gợi ý : {{currentQuestion.answer}}\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"col-lg-8\">\n");
      out.write("                                    <input ng-model=\"currentQuestion.userAnswer\" class=\"form-control\" >\n");
      out.write("                                </div>\n");
      out.write("                               \n");
      out.write("                                <div class=\"col-lg-2\">\n");
      out.write("                                    <button ng-click=\"check()\" class=\"btn btn-success\">Check</button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-2 block\" id=\"GetReFal\">\n");
      out.write("                                   <span class='label label-danger'>Sai</span>\n");
      out.write("                                </div>\n");
      out.write("                                 <div class=\"col-lg-2 block\" id=\"GetReTrue\">\n");
      out.write("                                   <span class='label label-success'>Đúng</span>\n");
      out.write("                                </div>\n");
      out.write("                                <br/>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"idEndLearn\" class=\"block\">\n");
      out.write("                        <h3 class=\"text-center\"> Bạn đã học hết bài này </h3>\n");
      out.write("                        <div class=\"row\" ng-repeat=\"dat in arr\">\n");
      out.write("                            <div class=\"col-lg-4\" > <h4 > <i class=\"fa fa-undo\" aria-hidden=\"true\"></i>  <span class=\"label label-primary\">Vòng : {{dat.round}} </span></h4></div>\n");
      out.write("                            <div class=\"col-lg-4\"> <h4><span class=\"label label-success\">Số câu trả lời đúng : {{dat.checkTrue}} </span></h4></div>\n");
      out.write("                            <div class=\"col-lg-4\"><h4><span class=\"label label-danger\"> Số câu trả lời sai : {{dat.checkFalse}} </span></h4></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"breadcrumb\">\n");
      out.write("        <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("        <li class=\"active\">Học bài ");
  if (get != null) {
                out.print(get.getTitle());
            }
      out.write("</li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function shuffle(array) {\n");
      out.write("        var currentIndex = array.length, temporaryValue, randomIndex;\n");
      out.write("\n");
      out.write("        // While there remain elements to shuffle...\n");
      out.write("        while (0 !== currentIndex) {\n");
      out.write("\n");
      out.write("            // Pick a remaining element...\n");
      out.write("            randomIndex = Math.floor(Math.random() * currentIndex);\n");
      out.write("            currentIndex -= 1;\n");
      out.write("\n");
      out.write("            // And swap it with the current element.\n");
      out.write("            temporaryValue = array[currentIndex];\n");
      out.write("            array[currentIndex] = array[randomIndex];\n");
      out.write("            array[randomIndex] = temporaryValue;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        return array;\n");
      out.write("    }\n");
      out.write("    ");
 String data = "[";
        String dataCheck = "[";
        int total = 0;
        if (listAQuiz != null) {
            total = listAQuiz.size();
            for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                Integer key = entry.getKey();
                Quiz value = entry.getValue();
      out.write("\n");
      out.write("    ");

        data += "{id: \"" + key + "\", question: \"" + value.getQuestion().trim()
                + "\", text: \"\",  answer: \"" + value.getAnswer().trim() + "\" },";
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
 }
            data += "]";
        }
    
      out.write("\n");
      out.write("    var data = ");
      out.print( data);
      out.write(";\n");
      out.write("    angular.module('myApp', [])\n");
      out.write("            .controller('QuizCtrl', function ($scope) {\n");
      out.write("                $scope.questionBank = shuffle(data);\n");
      out.write("                $scope.checkTrue = 0;\n");
      out.write("                $scope.checkFalse = 0;\n");
      out.write("                $scope.round = 0;\n");
      out.write("                $scope.wrongAnswers = [];\n");
      out.write("                $scope.currentQuestionIndex = 0;\n");
      out.write("                $scope.currentQuestion = $scope.questionBank[$scope.currentQuestionIndex];\n");
      out.write("                $scope.arr = [];\n");
      out.write("                $scope.check = function () {\n");
      out.write("                    var current = $scope.currentQuestion;\n");
      out.write("                    var userAnswer = current.userAnswer || '';\n");
      out.write("                    var check = true;\n");
      out.write("                    if (current.answer.toLowerCase() === userAnswer.toLowerCase()) {\n");
      out.write("                        $(\"#GetReTrue\").removeClass(\"block\");\n");
      out.write("                        $scope.checkTrue++;\n");
      out.write("                    } else {\n");
      out.write("                        $(\"#showAns\").removeClass(\"block\");\n");
      out.write("                        $(\"#getAns\").removeClass(\"block\");\n");
      out.write("                        $(\"#getQ\").addClass(\"block\");\n");
      out.write("                        $(\"#GetReFal\").removeClass(\"block\");\n");
      out.write("                        $scope.wrongAnswers.push($scope.currentQuestion);\n");
      out.write("                        $scope.checkFalse++;\n");
      out.write("                        check = false;\n");
      out.write("                    }\n");
      out.write("                    if (check) {\n");
      out.write("                        $(\"#GetReFal\").addClass(\"block\");\n");
      out.write("                        $(\"#showAns\").addClass(\"block\");\n");
      out.write("                        $scope.currentQuestionIndex++;\n");
      out.write("                    }else{\n");
      out.write("                         $(\"#GetReTrue\").addClass(\"block\");\n");
      out.write("                    }\n");
      out.write("                    if ($scope.currentQuestionIndex < $scope.questionBank.length) {\n");
      out.write("                        $scope.currentQuestion = $scope.questionBank[$scope.currentQuestionIndex];\n");
      out.write("                    } else {\n");
      out.write("                        $scope.round++;\n");
      out.write("                        $scope.arr.push({\n");
      out.write("                            round: $scope.round,\n");
      out.write("                            checkTrue: $scope.checkTrue,\n");
      out.write("                            checkFalse: $scope.checkFalse\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                        if ($scope.wrongAnswers.length === 0) {\n");
      out.write("                            $scope.end = \"End\";\n");
      out.write("                            $(\"#idEndLearn\").removeClass(\"block\");\n");
      out.write("                            $(\"#idLearn\").addClass(\"block\");\n");
      out.write("                        } else {\n");
      out.write("                            $scope.checkTrue = 0;\n");
      out.write("                            $scope.checkFalse = 0;\n");
      out.write("                            $scope.questionBank = shuffle($scope.wrongAnswers);\n");
      out.write("                            $scope.wrongAnswers = [];\n");
      out.write("                            $scope.currentQuestionIndex = 0;\n");
      out.write("                            $scope.currentQuestion = $scope.questionBank[$scope.currentQuestionIndex];\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("            });\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<style>\n");
      out.write("    .block{\n");
      out.write("        display: none;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script type=\"text/javascript\" src=\"./style/js/jquery.min.js\"></script>\n");
      out.write("<script src=\"./style/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"./style/js/angular_style.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
