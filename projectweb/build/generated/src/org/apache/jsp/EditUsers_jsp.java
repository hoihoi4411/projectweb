package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.*;

public final class EditUsers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
                return;
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
 Users admin = (Users) session.getAttribute("admin"); out.print(admin.getUsername()); 
      out.write(" </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"./index.jsp\"><i class=\"fa fa-gear fa-fw\"></i> Xem trang chủ</a>\n");
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
      out.write("                            \n");
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
      out.write('\n');
      out.write('\n');
    Users user = null;
    if (request.getParameter("uid") == null) {
        session.removeAttribute("alert");
        session.setAttribute("alert", "Invalid Users !");
        response.sendRedirect("./AdminUser.jsp");
    } else {
        lista.getListData();
        int uid = -1;
        try {
            uid = Integer.parseInt(request.getParameter("uid"));
            user = lista.SearchUser(uid);
            if (user == null) {
                session.removeAttribute("alert");
                session.setAttribute("alert", "Uid is not have in Database !");
                response.sendRedirect("./AdminUser.jsp");
            }
        } catch (Exception e) {
            if (session.getAttribute("alert") != null) {
                session.removeAttribute("alert");
                session.removeAttribute("alert");
            }
            session.removeAttribute("alert");
            session.setAttribute("alert", "Uid is not invalid!");
            response.sendRedirect("./AdminUser.jsp");
        }

    }
    int uid = Integer.parseInt(request.getParameter("uid"));
    String errors = "";
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        session.removeAttribute("token");
        Validation validation = new Validation();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        if (password == null) {
            if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.NumberFormatMinMax(permission, 1, 2, "permission")) {
                boolean resu = lista.UpdateUser(username, password, permission, uid);
                if (resu) {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Update Users Successful!");
                    response.sendRedirect("./AdminUser.jsp");
                } else {
                    session.removeAttribute("alert");
                    errors = "Username exits in unique";
                    session.setAttribute("alert", errors);
                }
            } else {
                session.removeAttribute("alert");
                errors = validation.getShowErrors();
                session.setAttribute("alert", errors);
            }
        } else if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.NumberFormatMinMax(permission, 1, 2, "permission")) {
            boolean resu = lista.UpdateUser(username, password, permission, uid);
            if (resu) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Update Users Successful!");
                response.sendRedirect("./AdminUser.jsp");
            } else {
                session.removeAttribute("alert");
                errors = "Username exits in unique";
                session.setAttribute("alert", errors);
            }
        } else {
            session.removeAttribute("alert");
            errors = validation.getShowErrors();
            session.setAttribute("alert", errors);
        }
    }
    errors = null;


      out.write("\n");
      out.write("\n");
      out.write("<div id=\"page-wrapper\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <h1 class=\"page-header\">Edit User ");
                if (user != null) {
                    out.print(user.getUsername());
                }
                
      out.write(" </h1>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col-lg-12 -->\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("\n");
      out.write("            ");
 if (session.getAttribute("alert") != null) {
                    errors = (String) session.getAttribute("alert");
                }
                session.removeAttribute("alert"); 
      out.write("\n");
      out.write("            ");
 if (errors != null) {
      out.write("\n");
      out.write("            <div class=\"alert alert-danger alert-dismissable\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n");
      out.write("                ");
      out.print(  errors);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title\">Edit User ");
                if (user != null) {
                            out.print(user.getUsername());
                        }
                        
      out.write("</h3>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"\" method=\"POST\" name=\"AddnewForm\" >\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Username : </label>\n");
      out.write("                                    <input class=\"form-control\" value=\"");

                                        if (user != null) {
                                            out.print(user.getUsername());
                                        }
                                           
      out.write("\"type=\"text\" name=\"username\" placeholder=\"Enter here Username\"  required  >\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Selects</label>\n");
      out.write("                                    <select class=\"form-control\" name=\"permission\">\n");
      out.write("                                        <option value=\"1\">Admin</option>\n");
      out.write("                                        <option value=\"2\" selected=\"\">Users</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Password : </label>\n");
      out.write("                                    <input class=\"form-control\" type=\"password\" placeholder=\"Enter Password Here\" name=\"password\"  autocomplete=\"off\">\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"hidden\" value=\"");
  session.setAttribute("token", Hash.generateToken());
                                     out.print(session.getAttribute("token"));
      out.write("\" name=\"token\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-danger\" value=\"Cập nhật\">\n");
      out.write("                                    <input type=\"reset\" class=\"btn btn-default\" value=\"Reset\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- /#page-wrapper -->\n");
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
