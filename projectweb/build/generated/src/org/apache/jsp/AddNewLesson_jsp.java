package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.*;

public final class AddNewLesson_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/AdminHeader.jsp");
    _jspx_dependants.add("/AdminFooter.jsp");
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Control Panel</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/bootstrap.min.css\" >\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/bootstrap-theme.min.css\" >\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"./style/css/admin.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./style/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <!-- DataTables CSS -->\n");
      out.write("        <link href=\"./style/css/dataTables.bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        \n");
      out.write("        <script src=\"./style/js/angular.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        ");

            if (session.getAttribute("admin") == null) {
                try {
                    response.sendRedirect("./LoginAdmin.jsp");

                } catch (Exception ex) {

                }

            }
            ListUser lista = new ListUser();

        
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\" >\n");
      out.write("\n");
      out.write("            <!-- Navigation -->\n");
      out.write("            <nav class=\"navbar navbar-inverse navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Điều hướng</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"./Admin.jsp\">Admin Control Panel</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-header -->\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                    <!-- /.dropdown -->\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> ");
      out.print( session.getAttribute("admin"));
      out.write(" </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"./Index.jsp\"><i class=\"fa fa-gear fa-fw\"></i> Xem trang chủ</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"divider\"></li>\n");
      out.write("                            <li><a href=\"LogoutAdmin.jsp\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <!-- /.dropdown-user -->\n");
      out.write("                    </li>\n");
      out.write("                    <!-- /.dropdown -->\n");
      out.write("                </ul>\n");
      out.write("                <!-- /.navbar-top-links -->\n");
      out.write("\n");
      out.write("                <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("                    <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                        <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("                            <li class=\"sidebar-search\">\n");
      out.write("                                <div class=\"input-group custom-search-form\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Tìm kiếm...\">\n");
      out.write("                                    <span class=\"input-group-btn\">\n");
      out.write("                                        <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                            <i class=\"fa fa-search\"></i>\n");
      out.write("                                        </button>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /input-group -->\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"./Admin.jsp\"><i class=\"fa fa-dashboard fa-fw\"></i> Trang chủ</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Thành viên <span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"./AdminUser.jsp\">Thành viên</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- /.nav-second-level -->\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-wrench fa-fw\"></i> Bài học <span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"./AdminLession.jsp\">Bài học</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- /.nav-second-level -->\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-wrench fa-fw\"></i> Thư mục <span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"./AdminFolder.jsp\">Thư mục</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- /.nav-second-level -->\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.sidebar-collapse -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-static-side -->\n");
      out.write("            </nav>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    ListUser listb = new ListUser();
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


      out.write("\n");
      out.write("<div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("    <div class=\"row\" ng-app=\"myApp\">\n");
      out.write("\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <h1 class=\"page-header\">Tạo một bài học mới </h1>\n");
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
      out.write("                        <input type=\"text\" name=\"title\" class=\"form-control\" id=\"inputtitle\" placeholder=\"Lesson name\" ng-model=\"myInput\" required>\n");
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
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"select\" class=\"col-lg-2 control-label\">Chọn Users</label>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <select class=\"form-control\" name=\"uid\" required>\n");
      out.write("                            ");
 for (int i = 0; i < li.size(); i++) {

                            
      out.write("\n");
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( li.get(i).getUid());
      out.write('"');
      out.write('>');
      out.print( li.get(i).getUsername());
      out.write("</option>\n");
      out.write("                            ");

                                }
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <h3>Thêm Câu hỏi vào bài học</h3>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div ng-controller=\"Note\">\n");
      out.write("                        <div ng-repeat=\"item in items\"  class=\"form-group\">\n");
      out.write("                            <div class=\"col-lg-5\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Enter Question\" ng-model=\"item.question\" class=\"form-control\" required=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-5\">\n");
      out.write("                                <input ng-class=\"{\n");
      out.write("                                            'blockInput': !item.inlineChecked}\" type=\"text\" class=\"form-control\" placeholder=\"Enter Answer\" ng-model=\"item.text\" required=\"\">\n");
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
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                var data = [];\n");
      out.write("                for (var i = 0; i < 5; i++) {\n");
      out.write("                    data.push({\n");
      out.write("                        question: \"\",\n");
      out.write("                        text: \"\"\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                var mymodal = angular.module('myApp', []);\n");
      out.write("                mymodal.controller('Note', function ($scope) {\n");
      out.write("                    $scope.items = data;\n");
      out.write("                    $scope.add = function () {\n");
      out.write("\n");
      out.write("                        $scope.items.push({\n");
      out.write("                            question: \"\",\n");
      out.write("                            text: \"\"\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                    };\n");
      out.write("                    $scope.save = function () {\n");
      out.write("                        var result = \"\";\n");
      out.write("                        angular.forEach($scope.items, function (value, key) {\n");
      out.write("                            if (value.question !== \"\" && value.text !== \"\") {\n");
      out.write("                                result += value.question + \"||||||\" + value.text + \"\\n\";\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                        $(\"#result\").val(result);\n");
      out.write("                        $(\"#quizForm\").submit();\n");
      out.write("                    };\n");
      out.write("                    $scope.remove = function (item) {\n");
      out.write("                        var index = $scope.items.indexOf(item);\n");
      out.write("                        $scope.items.splice(index, 1);\n");
      out.write("                    };\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- /#page-wrapper -->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script type=\"text/javascript\" src=\"./style/js/jquery.min.js\"></script>\n");
      out.write("<!-- Metis Menu Plugin JavaScript -->\n");
      out.write("<script src=\"./style/js/metisMenu.min.js\"></script>\n");
      out.write("<!-- Custom Theme JavaScript -->\n");
      out.write("<script src=\"./style/js/sb-admin-2.js\"></script>\n");
      out.write("<script src=\"./style/js/bootstrap.min.js\"></script>\n");
      out.write(" <script src=\"./style/js/angular_style.js\"></script>\n");
      out.write("\n");
      out.write("<!-- DataTables JavaScript -->\n");
      out.write("<script src=\"./style/js/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"./style/js/dataTables.bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write(" <script>\n");
      out.write("    $(document).ready(function() {\n");
      out.write("        $('#dataTables-example').DataTable({\n");
      out.write("                responsive: true\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
