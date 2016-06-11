package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.*;

public final class AdminUserPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write('\n');
  Users user = null;

    if (request.getParameter("uid") == null) {
        try {
            response.sendRedirect("./AdminUser.jsp");
        } catch (Exception ex) {

        }

    } else {
        lista.getListData();
        int uid = -1;
        try {
            uid = Integer.parseInt(request.getParameter("uid"));
            if (lista.SearchUser(uid) == null) {
                response.sendRedirect("./AdminUser.jsp");
            } else {
                user = lista.SearchUser(uid);

            }

        } catch (Exception ex) {
            response.sendRedirect("./AdminUser.jsp");
        }

    }
    ListFolder listFolder = new ListFolder();
    listFolder.setListFolder(user.getListFolder());

      out.write("\n");
      out.write("<div id=\"page-wrapper\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <h1 class=\"page-header\"> ");
 if (user != null) {
                    out.print(user.getUsername());
                }
      out.write(" </h1>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col-lg-12 -->\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        <div class=\"col-lg-8\">\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    Information\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <p class=\"lead\">Total Folder :  ");

                        if (user.getListFolder() != null) {
                            out.print(user.getListFolder().size());
                        } else {
                            out.print(0);
                        }
                        
      out.write("</p>\n");
      out.write("                    <p>Total lession :\n");
      out.write("                        ");

                            if (user.getListLession() != null) {
                                out.print(user.getListLession().size());
                            } else {
                                out.print(0);
                            }
                        
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.panel-body -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xs-3\">\n");
      out.write("                            <i class=\"fa fa-user fa-5x\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xs-9 text-right\">\n");
      out.write("                            <div class=\"huge\">");
 if (user != null) {
                                    out.print(user.getUsername());
                                }
      out.write("</div>\n");
      out.write("                            <div></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"panel panel-success\">\n");
      out.write("            <div class=\"panel-heading\">\n");
      out.write("                All folder and lession\n");
      out.write("            </div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <div>\n");
      out.write("\n");
      out.write("                    <!-- Nav tabs -->\n");
      out.write("                    ");
 if (user.getListFolder() != null) { 
      out.write("\n");
      out.write("                    <ul class=\"nav nav-tabs\" role=\"tablist\">\n");
      out.write("                        ");
 int i = 0;
                            for (Map.Entry<Integer, Folder> entry : user.getListFolder().entrySet()) {
                                Folder value = entry.getValue();
                                if (i == 0) {

                        
      out.write("\n");
      out.write("                        <li role=\"presentation\" class=\"active\"><a href=\"#");
      out.print( value.getFid());
      out.write("\" aria-controls=\"");
      out.print(  value.getFid());
      out.write("\" role=\"tab\" data-toggle=\"tab\">");
      out.print( value.getName());
      out.write("</a></li>\n");
      out.write("                            ");
  } else {
      out.write("\n");
      out.write("                        <li role=\"presentation\"><a href=\"#");
      out.print( value.getFid());
      out.write("\" aria-controls=\"");
      out.print( value.getFid());
      out.write("\" role=\"tab\" data-toggle=\"tab\">");
      out.print( value.getName());
      out.write("</a></li>\n");
      out.write("                            ");
  }
                                    i++;
                                }
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <!-- Tab panes -->\n");
      out.write("                    <div class=\"tab-content\">\n");
      out.write("                        ");
  i = 0;
                            for (Map.Entry<Integer, Folder> entry : user.getListFolder().entrySet()) {
                                Integer key = entry.getKey();
                                Folder value = entry.getValue();
                                if (i == 0) {
                        
      out.write("\n");
      out.write("                        <div role=\"tabpanel\" class=\"tab-pane active\" id=\"");
      out.print( value.getFid());
      out.write("\">\n");
      out.write("                            <table class=\"table table-striped table-hover \">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>#</th>\n");
      out.write("                                        <th>Lesson</th>\n");
      out.write("                                        <th>Share</th>\n");
      out.write("                                        <th>Action</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");

                                        ArrayList<FolderJoinLessionJoinUsers> li = listFolder.getAllLessionInData(value.getFid() + "");
                                        for (int j = 0; j < li.size(); j++) {
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td> ");
      out.print( li.get(j).getLid());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( li.get(j).getTitle());
      out.write("</td>\n");
      out.write("                                        <td>");
 switch (li.get(j).getShare()) {
                                                case 1:
                                                    out.print("OnlyMe");
                                                    break;
                                                case 2:
                                                    out.print("For User");
                                                    break;
                                                case 3:
                                                    out.print("Public");
                                                    break;
                                            }
      out.write("</td>\n");
      out.write("                                        <td><a href=\".\\EditLession.jsp?lid= ");
      out.print( li.get(j).getLid());
      out.write("\" class=\"btn btn-info btn-circle\"><i class=\"fa fa-check\"></i>\n");
      out.write("                                            </a><a href=\".\\DeleteLession.jsp?lid= ");
      out.print( li.get(j).getLid());
      out.write("\" class=\"btn btn-warning btn-circle\"><i class=\"fa fa-times\"></i>\n");
      out.write("                                            </a></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
 }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        ");
  } else {
      out.write("\n");
      out.write("                        <div role=\"tabpanel\" class=\"tab-pane\" id=\"");
      out.print( value.getFid());
      out.write("\">\n");
      out.write("\n");
      out.write("                            <table class=\"table table-striped table-hover \">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>#</th>\n");
      out.write("                                        <th>Lesson</th>\n");
      out.write("                                        <th>Share</th>\n");
      out.write("                                        <th>Action</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");

                                        ArrayList<FolderJoinLessionJoinUsers> li = listFolder.getAllLessionInData(value.getFid() + "");
                                        for (int j = 0; j < li.size(); j++) {
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td> ");
      out.print( li.get(j).getLid());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( li.get(j).getTitle());
      out.write("</td>\n");
      out.write("                                        <td>");
 switch (li.get(j).getShare()) {
                                                case 1:
                                                    out.print("OnlyMe");
                                                    break;
                                                case 2:
                                                    out.print("For User");
                                                    break;
                                                case 3:
                                                    out.print("Public");
                                                    break;
                                            }
      out.write("</td>\n");
      out.write("                                        \n");
      out.write("                                        <td><a href=\".\\EditLession.jsp?lid= ");
      out.print( li.get(j).getLid());
      out.write("\" class=\"btn btn-info btn-circle\"><i class=\"fa fa-check\"></i>\n");
      out.write("                                            </a><a href=\".\\DeleteLession.jsp?lid= ");
      out.print( li.get(j).getLid());
      out.write("\" class=\"btn btn-warning btn-circle\"><i class=\"fa fa-times\"></i>\n");
      out.write("                                            </a></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
 }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        ");
  }
                                i++;
                            }
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    ");
  }
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\">\n");
      out.write("                Lession not have Folder\n");
      out.write("            </div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <table class=\"table table-striped table-hover \">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Name</th>\n");
      out.write("                            <th>Share</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
 if (user.getListLession() != null) {
                                for (Map.Entry<Integer, Lesson> entry : user.getListLession().entrySet()) {
                                    Lesson value = entry.getValue();
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td> ");
      out.print( value.getLid());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( value.getTitle());
      out.write("</td>\n");
      out.write("                            <td>");
 switch (value.getShare()) {
                                    case 1:
                                        out.print("OnlyMe");
                                        break;
                                    case 2:
                                        out.print("For User");
                                        break;
                                    case 3:
                                        out.print("Public");
                                        break;
                                }
      out.write("</td>\n");
      out.write("                            <td><a href=\".\\EditLession.jsp?lid=");
      out.print( value.getLid());
      out.write("\" class=\"btn btn-info btn-circle\"><i class=\"fa fa-check\"></i>\n");
      out.write("                                </a><a href=\".\\DeleteLession.jsp?lid=");
      out.print( value.getLid());
      out.write("\" class=\"btn btn-warning btn-circle\"><i class=\"fa fa-times\"></i>\n");
      out.write("                                </a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
  } 
      out.write("\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table> \n");
      out.write("            </div>\n");
      out.write("            <!-- /.panel-body -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
