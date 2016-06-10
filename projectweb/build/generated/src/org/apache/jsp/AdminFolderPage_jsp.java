package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.*;

public final class AdminFolderPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Control Panel</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/bootstrap-theme.min.css\" >\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"./style/css/admin.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./style/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <!-- DataTables CSS -->\n");
      out.write("        <link href=\"./style/css/dataTables.bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"myappMo\">\n");
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
      out.write("        <div id=\"wrapper\" ng-controller=\"MyController\">\n");
      out.write("\n");
      out.write("            <!-- Navigation -->\n");
      out.write("            <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Điều hướng</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.html\">Admin Control Panel</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-header -->\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                    <!-- /.dropdown -->\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                            <i class=\"fa fa-bell fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <i class=\"fa fa-envelope fa-fw\"></i> Tiếng Việt\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"divider\"></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <i class=\"fa fa-tasks fa-fw\"></i> Tiếng Anh\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <!-- /.dropdown-alerts -->\n");
      out.write("                    </li>\n");
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
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Settings</a>\n");
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
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("                                    <span class=\"input-group-btn\">\n");
      out.write("                                        <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                            <i class=\"fa fa-search\"></i>\n");
      out.write("                                        </button>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /input-group -->\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"./Admin.jsp\"><i class=\"fa fa-dashboard fa-fw\"></i> Setting</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Users <span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"./AdminUser.jsp\">Users</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- /.nav-second-level -->\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-wrench fa-fw\"></i> Lession <span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"./AdminLession.jsp\">Lession</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- /.nav-second-level -->\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-wrench fa-fw\"></i> Folder <span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"./AdminFolder.jsp\">Folder</a>\n");
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
    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
    FolderJoinUser re = null;

    if (request.getParameter("fid") == null || !request.getParameter("fid").matches("[0-9]{1,10}")) {
        try {
            response.sendRedirect("./AdminFolder.jsp");

        } catch (Exception ex) {

        }
    } else {
        ListFolder list = new ListFolder();
        list.getFolderInData();
        re = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));
        if (re == null) {
            try {
                response.sendRedirect("./AdminFolder.jsp");

            } catch (Exception ex) {

            }
        }
        listLession = list.getAllLessionInData(request.getParameter("fid"));
    }

      out.write("\n");
      out.write("<div id=\"page-wrapper\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <h1 class=\"page-header\">Folder ");
 if (re != null) {
                    out.print(re.getName());
                } 
      out.write(" </h1>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col-lg-12 -->\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <a href=\"./AddnewLessionInFolder.jsp?fid=");

                if (re != null) {
                    out.print(re.getFid());
                }
               
      out.write("&uid=");

                   if (re != null) {
                       out.print(re.getUid());
                   }
               
      out.write("\" class=\"btn btn-success\">Add new Lession In Folder</a>\n");
      out.write("\n");
      out.write("            <div class=\"dataTable_wrapper\">\n");
      out.write("                <form action=\"\" method=\"POST\">\n");
      out.write("                    <table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Lession Name</th>\n");
      out.write("                                <th>Permisson</th>\n");
      out.write("                                <th>Author</th>\n");
      out.write("                                <th>Action</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                if (listLession != null) {
                                    for (int i = 0; i < listLession.size(); i++) {

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><div class=\"checkbox\">\n");
      out.write("                                        <label>\n");
      out.write("                                            <input type=\"checkbox\" value=\"");
      out.print( listLession.get(i).getLid());
      out.write('"');
      out.write('>');
      out.print( listLession.get(i).getLid());
      out.write("\n");
      out.write("                                        </label>\n");
      out.write("                                    </div></td>\n");
      out.write("                                <td><a href=\"./AdminLessionPage.jsp?lid=");
      out.print( listLession.get(i).getLid());
      out.write('"');
      out.write('>');
      out.print( listLession.get(i).getTitle());
      out.write("</a></td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");

                                        switch (listLession.get(i).getShare()) {
                                            case 1:
                                                out.print("Only Me");
                                                break;
                                            case 2:
                                                out.print("For User");
                                                break;
                                            case 3:
                                                out.print("Public");
                                                break;
                                        }
                                    
      out.write("</td>\n");
      out.write("                                <td><a href=\"AdminUserPage.jsp?uid=");
      out.print(  listLession.get(i).getUid());
      out.write('"');
      out.write('>');
      out.print( listLession.get(i).getUsername());
      out.write("</td>\n");
      out.write("                                <td class=\"center\">\n");
      out.write("                                    <a  class=\"btn btn-info btn-circle\" href=\"./AdminEditLession.jsp?lid=");
      out.print( listLession.get(i).getLid());
      out.write("\"><i class=\"fa fa-check\"></i>\n");
      out.write("                                    </a>\n");
      out.write("                                    <a  class=\"btn btn-danger btn-circle\" href=\"./AdminDeleteLession.jsp?lid=");
      out.print( listLession.get(i).getLid());
      out.write("\"><i class=\"fa fa-times\"></i>\n");
      out.write("                                    </a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
 }
                                }
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                        \n");
      out.write("  <input type=\"hidden\" value=\"");
  session.setAttribute("token", Hash.generateToken()); out.print(session.getAttribute("token")); 
      out.write("\" name=\"token\">\n");
      out.write("                    <input type=\"submit\" value=\"Xóa Lession\" class=\"btn btn-info\"/>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
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
      out.write("<script src=\"./style/js/angular.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- DataTables JavaScript -->\n");
      out.write("<script src=\"./style/js/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"./style/js/dataTables.bootstrap.min.js\"></script>\n");
      out.write("<script src=\"./style/js/angular_style.js\"></script>\n");
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
