package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vn.fpt.project.bao.*;
import java.nio.charset.StandardCharsets;
import vn.fpt.project.bo.*;
import vn.fpt.project.bo.Users;

public final class EditLession_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <form class=\"navbar-form navbar-left\" role=\"search\" >\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n");
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
      out.write("                                <li><a href=\"./UsersPage.jsp\"><i class=\"fa fa-gear fa-fw\"></i> Thiết lặp</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"divider\"></li>\n");
      out.write("                                <li><a href=\"login.html\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
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
      out.write("                                    <a href=\"#?style=darkly\">\n");
      out.write("                                        Darkly-Mặc định\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#?style=cerulean\">\n");
      out.write("                                        Giao diện Cerulean\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#?style=cosmo\">\n");
      out.write("                                        Giao diện Cosmo\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#?style=cyborg\">\n");
      out.write("                                        Giao diện Cyborg\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#?style=united\">\n");
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
      out.write("<div class=\"container\" style=\"background: #fff;\n");
      out.write("     padding-left: 37px;\n");
      out.write("     padding-top: 20px;\">\n");
      out.write("    ");

        if (session.getAttribute("user") == null && ck == false) {
           response.sendRedirect("./Login.jsp");
            return; 
        }
        String errors = "";
        ListUser listb = new ListUser();
        listb.getListData();
        ArrayList<Users> li = listb.getListUser();
        ListLession list = new ListLession();
        list.getData();
        HashMap<Integer, Quiz> listAQuiz = null;
        Lesson get = null;
        if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
            response.sendRedirect("./Lession.jsp");
            return;
        } else if (list.searchLession(request.getParameter("lid")) == null) {
            response.sendRedirect("./Lession.jsp");
            return;
        } else {
            get = list.searchLession(request.getParameter("lid"));
            listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
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
                liQuiz = lisLession.GetDataRequestUpdate(hieu);
            }
            if (validation.StringFormatMinMax(title, 5, 30, "title") && validation.NumberFormatMinMax(share, 1, 3, "share")
                    && uid.matches("[0-9]+")) {
                if (liQuiz != null) {
                    boolean re = list.UpdateLesson(get.getLid(), title, Integer.parseInt(uid), Integer.parseInt(share));
                    lisLession.getData();
                    Lesson getA = lisLession.getListLessonB().get(lisLession.getListLessonB().size() - 1);
                    ListQuiz listQuizA = new ListQuiz();
                    boolean result = listQuizA.UpdateListQuiz(liQuiz, get.getLid() + "");
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
    
      out.write("\n");
      out.write("    <div class=\"col-lg-12\">\n");
      out.write("        <ul class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("            <li class=\"active\">Chỉnh sửa bài học  ");
 if (get != null) {
                    out.print(get.getTitle());
                } 
      out.write("  </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"row\" ng-app=\"myApp\">\n");
      out.write("\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <h1 class=\"page-header\"> Chỉnh sửa bài học  ");
 if (get != null) {
                    out.print(get.getTitle());
                } 
      out.write("  </h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- /.col-lg-12 -->\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            ");
                if (!err.equals("")) {
            
      out.write("\n");
      out.write("            <div class=\"alert alert-danger alert-dismissable\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n");
      out.write("                ");
      out.print( err);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <form class=\"form-horizontal\" id=\"quizForm\" action=\"\" method=\"POST\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputtitle\" class=\"col-lg-2 control-label\">Tiêu đề: </label>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <input class=\"form-control\" name=\"title\" required=\"\" value=\"");
 if (get != null) {
                                out.print(get.getTitle());
                            } 
      out.write(" \">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-lg-2 control-label\">Chế độ chia sẻ: </label>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <div class=\"radio\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"radio\" name=\"share\" id=\"optionsRadios1\" value=\"1\" checked=\"\">\n");
      out.write("                                Chỉ mình tôi\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"radio\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"radio\" name=\"share\" id=\"optionsRadios2\" value=\"2\">\n");
      out.write("                                Cho Người Dùng xem\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"radio\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"radio\" name=\"share\" id=\"optionsRadios2\" value=\"3\">\n");
      out.write("                                Công khai\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <h3>Thêm Câu hỏi vào bài học</h3>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div ng-controller=\"Note\">\n");
      out.write("                        <div ng-repeat=\"item in items| filter:{ shouldBeDeleted: false }\"  class=\"form-group\">\n");
      out.write("                            <input type=\"hidden\" placeholder=\"Enter Question\" ng-model=\"item.id\" class=\"form-control\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-5\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Enter Question\" ng-model=\"item.question\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-5\">\n");
      out.write("                                <input ng-class=\"{\n");
      out.write("                                            'blockInput': !item.inlineChecked}\" type=\"text\" class=\"form-control\" placeholder=\"Enter Answer\" ng-model=\"item.text\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-2 checkbox\">\n");
      out.write("                                <button type=\"button\" name=\"check\" value=\"inline\"  class=\"btn btn-danger\" ng-click=\"remove(item)\"> Xóa câu này</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                               <input type=\"hidden\" value=\"");
  session.setAttribute("token", Hash.generateToken());
                                   out.print(session.getAttribute("token"));
      out.write("\" name=\"token\">\n");
      out.write("                        <input type=\"hidden\" value=\"\" id=\"result\" name=\"hieu\" />\n");
      out.write("                        <a class=\"btn btn-success\" ng-click=\"add()\">Thêm câu hỏi</a>\n");
      out.write("                        <a class=\"btn btn-primary\" ng-click=\"save()\">Lưu bài</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("           <script type=\"text/javascript\">\n");
      out.write("                    ");
 String data = "[";
                        if (listAQuiz != null) {
                            for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                                Integer key = entry.getKey();
                                Quiz value = entry.getValue();
      out.write("\n");
      out.write("                    ");

                        data += "{id: \"" + key + "\", question: \"" + value.getQuestion().trim()
                                + "\", text: \"" + value.getAnswer().trim() + "\", \"shouldBeDeleted\": false},";
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 }
                            data += "]";
                        }
                    
      out.write("\n");
      out.write("                    var data = ");
      out.print(data);
      out.write(";\n");
      out.write("                    var mymodal = angular.module('myApp', []);\n");
      out.write("                    mymodal.controller('Note', function ($scope) {\n");
      out.write("                        $scope.items = data;\n");
      out.write("                        $scope.add = function () {\n");
      out.write("\n");
      out.write("                            $scope.items.push({\n");
      out.write("                                id: \"0\",\n");
      out.write("                                question: \"\",\n");
      out.write("                                text: \"\",\n");
      out.write("                                shouldBeDeleted: false\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                        };\n");
      out.write("                        $scope.save = function () {\n");
      out.write("                            var result = \"\";\n");
      out.write("                            angular.forEach($scope.items, function (value, key) {\n");
      out.write("                                if (value.question !== \"\" && value.text !== \"\") {\n");
      out.write("                                    result += value.id + \"||||||\" + value.question + \"||||||\" + value.text + \"||||||\" + value.shouldBeDeleted + \"\\n\";\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                            $(\"#result\").val(result);\n");
      out.write("                            $(\"#quizForm\").submit();\n");
      out.write("                        };\n");
      out.write("                        $scope.remove = function (item) {\n");
      out.write("                            item.shouldBeDeleted = true;\n");
      out.write("                        };\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-12\">\n");
      out.write("        <ul class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("            <li class=\"active\">Chỉnh sửa bài học  ");
 if (get != null) {
                    out.print(get.getTitle());
                }
      out.write("  </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
