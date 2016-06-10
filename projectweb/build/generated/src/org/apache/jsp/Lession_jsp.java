package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.fpt.project.bo.*;
import java.util.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.Users;
import vn.fpt.project.bao.*;

public final class Lession_jsp extends org.apache.jasper.runtime.HttpJspBase
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
                                    out.print(user.substring(user.indexOf("|")+1, user.lastIndexOf("|")));
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
      out.write('\n');
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
      out.write("<div class=\"container\" style=\"background: #fff;\n");
      out.write("     padding-left: 37px;\n");
      out.write("     padding-top: 20px;    padding-bottom: 20px;\">\n");
      out.write("     <ul class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("            <li class=\"active\">Bài học ");
 if (get != null) {
                    out.print(get.getTitle());
                } 
      out.write("</li>\n");
      out.write("        </ul>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-8\">\n");
      out.write("            <div style=\"width: 100%\">\n");
      out.write("                ");
 if (listAQuiz != null)
                        for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                            Integer key = entry.getKey();
                            Quiz value = entry.getValue();
      out.write("\n");
      out.write("                <div class=\"chunk-terms\">\n");
      out.write("                    <div class=\"text-left-Lesion\">\n");
      out.write("                        ");
      out.print( value.getQuestion());
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"text-right-Lesion\">\n");
      out.write("                        ");
      out.print( value.getAnswer());
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("            <div class=\"col-lg-6\">\n");
      out.write("                <a href=\"./Learn.jsp?lid=");
      out.print( get.getLid());
      out.write("\" class=\"learn has-status  ModeButton btn btn-danger\" data-sourcename=\"mode-link-learn\">\n");
      out.write("                    <span class=\"ModeButton-inner\">\n");
      out.write("                        <span class=\"glyph icon learn-icon ModeButton-icon\"><i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i></span>\t\t<span class=\"ModeButton-name\">\n");
      out.write("                            Học \t\t</span>\n");
      out.write("                    </span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-lg-6\"><a href=\"./TestLession.jsp?lid=");
      out.print( get.getLid());
      out.write("\" class=\"learn has-status  ModeButton btn btn-info\" data-sourcename=\"mode-link-learn\">\n");
      out.write("                    <span class=\"ModeButton-inner\">\n");
      out.write("                        <span class=\"glyph icon learn-icon ModeButton-icon\"><i class=\"fa fa-comments\" aria-hidden=\"true\"></i></span>\t\t<span class=\"ModeButton-name\">\n");
      out.write("                            Kiểm tra\t\t</span>\n");
      out.write("\n");
      out.write("                    </span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("                    ");
 if(checkEdit) {
      out.write("\n");
      out.write("            <div class=\"col-lg-6\" style=\"    margin-top: 15px;\">\n");
      out.write("                <a href=\"./EditLession.jsp?lid=");
      out.print( get.getLid());
      out.write("\" class=\"learn has-status  ModeButton btn btn-success\" data-sourcename=\"mode-link-learn\">\n");
      out.write("                    <span class=\"ModeButton-inner\">\n");
      out.write("                        <span class=\"glyph icon learn-icon ModeButton-icon\"><i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></span>\t\t<span class=\"ModeButton-name\">\n");
      out.write("                            Chỉnh sửa\t\t</span>\n");
      out.write("                    </span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-lg-6\" style=\"    margin-top: 15px;\"><a href=\"./DeleteLession.jsp?lid=");
      out.print( get.getLid());
      out.write("\" class=\"learn has-status  ModeButton btn btn-warning\" data-sourcename=\"mode-link-learn\">\n");
      out.write("                    <span class=\"ModeButton-inner\">\n");
      out.write("                        <span class=\"glyph icon learn-icon ModeButton-icon\"><i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i></span>\t\t<span class=\"ModeButton-name\">\n");
      out.write("                            Xóa \t</span>\n");
      out.write("\n");
      out.write("                    </span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("                      ");
 }
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("         <ul class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("            <li class=\"active\">Bài học ");
 if (get != null) {
                    out.print(get.getTitle());
                } 
      out.write("</li>\n");
      out.write("        </ul>\n");
      out.write("</div>\n");
      out.write("<style>\n");
      out.write("    .chunk-terms {\n");
      out.write("        border-radius: 4px;\n");
      out.write("        border-top: 1px solid #d7d6d3;\n");
      out.write("        border-right: 1px solid #d7d6d3;\n");
      out.write("        border-bottom: 1px solid #d7d6d3;\n");
      out.write("        border-left: 1px solid #d7d6d3;\n");
      out.write("        font-size: 20px;\n");
      out.write("        padding: 15px;\n");
      out.write("    }\n");
      out.write("    .text-left-Lesion{\n");
      out.write("        float: left;\n");
      out.write("        margin-left: 20px;\n");
      out.write("    }\n");
      out.write("    .text-right-Lesion{\n");
      out.write("\n");
      out.write("        margin-left: 200px;\n");
      out.write("    }\n");
      out.write("    .ModeButton{\n");
      out.write("        border: 1px solid #b8c0c7;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        -webkit-box-sizing: border-box;\n");
      out.write("        -moz-box-sizing: border-box;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        display: table;\n");
      out.write("        text-align: center;\n");
      out.write("        -webkit-transition: background-color 300ms,color 300ms,border-color 300ms;\n");
      out.write("        -moz-transition: background-color 300ms,color 300ms,border-color 300ms;\n");
      out.write("        -ms-transition: background-color 300ms,color 300ms,border-color 300ms;\n");
      out.write("        transition: background-color 300ms,color 300ms,border-color 300ms;\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("    .ModeButton-inner {\n");
      out.write("        -webkit-box-sizing: border-box;\n");
      out.write("        -moz-box-sizing: border-box;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        display: table-cell;\n");
      out.write("        height: 85px;\n");
      out.write("        padding: 8px;\n");
      out.write("        vertical-align: middle;\n");
      out.write("    }\n");
      out.write("    .ModeButton.has-status .ModeButton-icon {\n");
      out.write("        font-size: 28px;\n");
      out.write("        margin-bottom: 0;\n");
      out.write("    }\n");
      out.write("    .ModeButton-icon {\n");
      out.write("        display: block;\n");
      out.write("        font-size: 32px;\n");
      out.write("        margin: 0 auto 3px auto;\n");
      out.write("    }\n");
      out.write("    .ModeButton.has-status .ModeButton-name {\n");
      out.write("        margin-bottom: 0;\n");
      out.write("    }\n");
      out.write("    .ModeButton-name {\n");
      out.write("        display: block;\n");
      out.write("        font: 16px \"open sans\",opensans-webfont,\"lucida grande\",\"lucida sans unicode\",arial,sans-serif;\n");
      out.write("        margin-bottom: 3px;\n");
      out.write("        white-space: nowrap;\n");
      out.write("    }\n");
      out.write("    .ModeButton-status {\n");
      out.write("        color: inherit;\n");
      out.write("        font-size: 11px;\n");
      out.write("        opacity: 0.7;\n");
      out.write("        -ms-filter: \"progid:DXImageTransform.Microsoft.Alpha(Opacity=70)\";\n");
      out.write("        filter: alpha(opacity=70);\n");
      out.write("    }\n");
      out.write("\n");
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
