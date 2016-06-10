package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.*;
import java.nio.charset.StandardCharsets;
import vn.fpt.project.bo.*;
import java.util.*;
import vn.fpt.project.bao.*;

public final class AdminFolder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/AdminHeader.jsp");
    _jspx_dependants.add("/AdminCreateFolder.jsp");
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
      out.write("    <body ng-app=\"myApp\">\n");
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
      out.write("<div id=\"page-wrapper\" >\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("            <h1 class=\"page-header\">Thư mục </h1>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.col-lg-12 -->\n");
      out.write("    </div>\n");
      out.write("    <button ng-click=\"open()\" class=\"btn btn-primary\">Thêm một thư mục mới</button>\n");
      out.write("    <openmodal title=\"Add new Folder\" visible=\"showModal\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    if (session.getAttribute("admin") == null) {
        try {
            response.sendRedirect("./LoginAdmin.jsp");

        } catch (Exception ex) {

        }

    }
    String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ListFolder listF = new ListFolder();
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        session.removeAttribute("token");
        Validation validation = new Validation();
        String name = request.getParameter("name");
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes, StandardCharsets.UTF_8);
        String uid = request.getParameter("uid");
        String sharefolder = request.getParameter("sharefolder");
        if (validation.StringFormatMinMax(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
            boolean resu = listF.InsertFolder(name, uid, sharefolder);
            if (resu) {

                try {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Thêm folder thành công");
                    response.sendRedirect("./AdminFolder.jsp");

                } catch (Exception ex) {

                }
            } else {

                try {
                    session.removeAttribute("alert");
                    errors = "Thêm folder thất bại , mời bạ kiểm tra lại nội dung nhập vào";
                    session.setAttribute("alert", errors);
                    response.sendRedirect("./AdminFolder.jsp");

                } catch (Exception ex) {

                }
            }

        } else {

            try {
                session.removeAttribute("alert");
                errors = validation.getShowErrors();
                session.setAttribute("alert", errors);
                response.sendRedirect("./AdminFolder.jsp");

            } catch (Exception ex) {

            }
        }
    }

      out.write("\n");
      out.write("<form action=\"\" method=\"POST\" id=\"FolderCreate\">\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Tên Folder : </label>\n");
      out.write("        <input class=\"form-control\" name=\"name\" required>\n");
      out.write("        <p class=\"help-block\">Hãy nhập trong khoảng 5 - 30 ký tự</p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Chọn mộn tác giả cho folder</label>\n");
      out.write("        <select class=\"form-control\" name=\"uid\" required>\n");
      out.write("            ");
 for (int i = 0; i < li.size(); i++) {
      out.write("\n");
      out.write("            <option value=\"");
      out.print( li.get(i).getUid());
      out.write('"');
      out.write('>');
      out.print( li.get(i).getUsername());
      out.write("</option>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Share</label>\n");
      out.write("        <div class=\"radio\">\n");
      out.write("            <label>\n");
      out.write("                <input type=\"radio\" name=\"sharefolder\" id=\"optionsRadios1\" value=\"1\" checked=\"\">Chỉ mình tôi\n");
      out.write("            </label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"radio\">\n");
      out.write("            <label>\n");
      out.write("                <input type=\"radio\" name=\"sharefolder\" id=\"optionsRadios2\" value=\"2\">Dành cho thành viên\n");
      out.write("            </label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"radio\">\n");
      out.write("            <label>\n");
      out.write("                <input type=\"radio\" name=\"sharefolder\" id=\"optionsRadios3\" value=\"3\">Công khai\n");
      out.write("            </label>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("           <input type=\"hidden\" value=\"");
  session.setAttribute("token", Hash.generateToken());
        out.print(session.getAttribute("token"));
      out.write("\" name=\"token\">\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <button class=\"btn btn-primary\" type=\"submit\" value=\"\" name=\"submit\" ng-click=\"submitAdd()\">Thêm một thư mục mới</button>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    </openmodal>\n");
      out.write("    ");

        ListFolder lis = new ListFolder();
        lis.getFolderInData();
        HashMap<Integer, FolderJoinUser> listFolderJoin = new HashMap<>();
        listFolderJoin = lis.getListFolderJoin();

    
      out.write("\n");
      out.write("    ");
          if (session.getAttribute("alert") != null) {
            session.removeAttribute("alert-sucess");
      out.write("\n");
      out.write("    <div class=\"alert alert-danger alert-dismissable\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n");
      out.write("        ");
      out.print( session.getAttribute("alert"));
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    ");

        if (session.getAttribute("alert-sucess") != null) {
            session.removeAttribute("alert");
      out.write("\n");
      out.write("    <div class=\"alert alert-success alert-dismissable\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n");
      out.write("        ");
      out.print( session.getAttribute("alert-sucess"));
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    <div class=\"panel-body\">\n");
      out.write("        <div class=\"dataTable_wrapper\">\n");
      out.write("           \n");
      out.write("                <table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Tên thư mục</th>\n");
      out.write("                            <th>Chế độ chia sẻ</th>\n");
      out.write("                            <th>Tác giả</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            for (Map.Entry<Integer, FolderJoinUser> entry : listFolderJoin.entrySet()) {
                                Integer key = entry.getKey();
                                FolderJoinUser value = entry.getValue();


                        
      out.write("\n");
      out.write("                        <tr class=\"odd gradeX\">\n");
      out.write("                            <td>");
      out.print( key);
      out.write("</td>\n");
      out.write("                            <td><a href=\"AdminFolderPage.jsp?fid=");
      out.print( key);
      out.write('"');
      out.write('>');
      out.print( value.getName());
      out.write("</a></td>\n");
      out.write("                            <td>");

                                switch (value.getPermission()) {
                                    case 1:
                                        out.print("Chỉ mình tôi");
                                        break;
                                    case 2:
                                        out.print("Dành cho thành viên");
                                        break;
                                    case 3:
                                        out.print("Công khai");
                                        break;
                                }
                                
      out.write("</td>\n");
      out.write("                            <td class=\"center\"><a href=\"AdminUserPage.jsp?uid=");
      out.print( value.getUid());
      out.write('"');
      out.write('>');
      out.print( value.getUsername());
      out.write("</a></td>\n");
      out.write("                            <td class=\"center\">\n");
      out.write("                                <a  class=\"btn btn-info btn-circle\" href=\"./AdminEditFolder.jsp?fid=");
      out.print( key);
      out.write("\"><i class=\"fa fa-check\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <a  class=\"btn btn-danger btn-circle\" href=\"./AdminDeleteFolder.jsp?fid=");
      out.print( key);
      out.write("\"><i class=\"fa fa-times\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
  }
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                 \n");
      out.write("        </div>\n");
      out.write("        <!-- /.table-responsive -->\n");
      out.write("\n");
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
