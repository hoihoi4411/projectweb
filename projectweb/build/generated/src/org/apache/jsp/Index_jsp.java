package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
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

            if (request.getParameter("style") != null) {
                session.removeAttribute("style");
                session.setAttribute("style", request.getParameter("style"));
                
            }
            if (session.getAttribute("style") == null) {
                style = "darkly.css";
            } else {
                style = (String) session.getAttribute("style") + ".css";
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
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .fa-btn {\n");
      out.write("            margin-right: 6px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <body ng-app=\"mytodoApp\">\n");
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
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("                    </form>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <!-- Authentication Links -->\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("\n");
      out.write("                            ");
 if (session.getAttribute("user") == null) {
      out.write("\n");
      out.write("                            <a class=\"dropdown-toggle\" href=\"./Login.jsp\" data-toggle=\"dropdown\" href=\"\" aria-expanded=\"false\">  <i class=\"fa fa-user fa-fw\"></i>Đăng nhập / Đăng ký <i class=\"fa fa-caret-down\"\n");
      out.write("                                                                                                                                                                                        ></i></a>\n");
      out.write("                                ");
 } else { 
      out.write("\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"\" aria-expanded=\"false\">  <i class=\"fa fa-user fa-fw\"></i> Dung Nguyen <i class=\"fa fa-caret-down\"\n");
      out.write("                                                                                                                                                              ></i></a>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 if (session.getAttribute("user") != null) { 
      out.write("\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Settings</a>\n");
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
      out.write("                                <i class=\"fa fa-tasks fa-fw\"></i> Change Style <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"?style=darkly\">\n");
      out.write("                                        Darkly-Defaults\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"?style=cerulean\">\n");
      out.write("                                        Cerulean\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"?style=cosmo\">\n");
      out.write("                                        Cosmo\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"?style=cyborg\">\n");
      out.write("                                        Cyborg\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"?style=united\">\n");
      out.write("                                        United\n");
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
      out.write("<div class=\"container\">\n");
      out.write("    <ul class=\"breadcrumb\">\n");
      out.write("        <li><a href=\"./Index.jsp\">Home</a></li>\n");
      out.write("    </ul>\n");
      out.write("    <div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("        <!-- Indicators -->\n");
      out.write("        <ol class=\"carousel-indicators\">\n");
      out.write("            <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("            <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n");
      out.write("            <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\n");
      out.write("            <li data-target=\"#carousel-example-generic\" data-slide-to=\"3\"></li>\n");
      out.write("\n");
      out.write("        </ol>\n");
      out.write("\n");
      out.write("        <!-- Wrapper for slides -->\n");
      out.write("        <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("            <div class=\"item active\">\n");
      out.write("                <img src=\"./style/img/1.jpg\" alt=\" Học Tập\" style=\"    height: 500px;\n");
      out.write("                     width: 1150px;\">\n");
      out.write("                <div class=\"carousel-caption\">\n");
      out.write("                    <h2>Chào mừng bạn đến với QUIZLETG3<h2>\n");
      out.write("                            <ul class=\"list-group\" >\n");
      out.write("                                <li class=\"list-group-item\" style=\"    background-color: rgba(48, 48, 48, 0.56);\">\n");
      out.write("                                    <span class=\"badge\">14</span>\n");
      out.write("                                    Thành viên\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"list-group-item\"  style=\"    background-color: rgba(48, 48, 48, 0.56);\">\n");
      out.write("                                    <span class=\"badge\">2</span>\n");
      out.write("                                    Folder\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"list-group-item\"  style=\"    background-color: rgba(48, 48, 48, 0.56);\">\n");
      out.write("                                    <span class=\"badge\">1</span>\n");
      out.write("                                    Lesson\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"./style/img/2.jpg\" alt=\" Học Tập\" style=\"    height: 500px;\n");
      out.write("                                     width: 1150px;\">\n");
      out.write("                                <div class=\"carousel-caption\">\n");
      out.write("                                    <h2>Cùng trải nghiệm học tập với QUIZLETG3<h2>\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-primary btn-lg\">Đăng ký</a><a href=\"#\" class=\"btn btn-primary btn-lg\">Đăng Nhập</a>\n");
      out.write("                                            </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"item\">\n");
      out.write("                                                <img src=\"./style/img/3.jpg\" alt=\" Học Tập\" style=\"    height: 500px;\n");
      out.write("                                                     width: 1150px;\">\n");
      out.write("                                                <div class=\"carousel-caption\">\n");
      out.write("                                                    Học Tập\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"item\">\n");
      out.write("                                                <img src=\"./style/img/4.jpg\" alt=\" Học Tập\" style=\"    height: 500px;\n");
      out.write("                                                     width: 1150px;\">\n");
      out.write("                                                <div class=\"carousel-caption\">\n");
      out.write("                                                    Học Tập\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <!-- Controls -->\n");
      out.write("                                            <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                                                <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("                                                <span class=\"sr-only\">Previous</span>\n");
      out.write("                                            </a>\n");
      out.write("                                            <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\n");
      out.write("                                                <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("                                                <span class=\"sr-only\">Next</span>\n");
      out.write("                                            </a>\n");
      out.write("                                            </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            ");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script type=\"text/javascript\" src=\"./style/js/jquery.min.js\"></script>\n");
      out.write("<script src=\"./style/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"./style/js/angular.min.js\"></script>\n");
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
