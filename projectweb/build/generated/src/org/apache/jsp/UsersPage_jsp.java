package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vn.fpt.project.bo.*;
import vn.fpt.project.bao.*;
import vn.fpt.project.bo.Users;
import java.nio.charset.StandardCharsets;
import vn.fpt.project.bo.*;
import java.util.*;
import vn.fpt.project.bao.*;

public final class UsersPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/CreateFolder.jsp");
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
      out.write('\n');

    Cookie cookie7 = null;
    Cookie cookie2 = null;
    String errors = "";
    ListUser listUser = new ListUser();
    listUser.getListData();
    Validation validation = new Validation();
    boolean check = false;
    ListFolder listFolder = new ListFolder();
    Cookie[] cookieh = request.getCookies();
    if (cookieh != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie7 = cookieh[i];
            if (cookie7.getName().equalsIgnoreCase("username")) {
                check = true;
                break;
            }
        }

    }
    Users newAdd = null;
    Users UsersSession = null;
    if (session.getAttribute("user") == null && check == false) {
        response.sendRedirect("./Index.jsp");
        return;
    } else if (session.getAttribute("user") != null) {
        newAdd = (Users) session.getAttribute("user");
        UsersSession = listUser.SearchUser(newAdd.getUid());
    } else {
        String id = user.substring(0, user.indexOf("|"));
        UsersSession = listUser.SearchUser(Integer.parseInt(id));
    }
   


      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"col-lg-12\">\n");
      out.write("        <ul class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"./UsersPage.jsp\">Home</a></li>\n");
      out.write("            <li class=\"active\">");
 if (newAdd != null) {
                    out.print(newAdd.getUsername());
                } 
      out.write("</li>\n");
      out.write("        </ul>\n");
      out.write("        ");
          if (session.getAttribute("alert") != null) {
                session.removeAttribute("alert-sucess");
      out.write("\n");
      out.write("        <div class=\"alert alert-danger alert-dismissable\">\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n");
      out.write("            ");
      out.print( session.getAttribute("alert"));
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        ");

            if (session.getAttribute("alert-sucess") != null) {
                session.removeAttribute("alert");
      out.write("\n");
      out.write("        <div class=\"alert alert-success alert-dismissable\">\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n");
      out.write("            ");
      out.print( session.getAttribute("alert-sucess"));
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-4\">\n");
      out.write("        <ul class=\"list-group\">\n");
      out.write("            ");
 if (UsersSession != null) {
                
                    for (Map.Entry<Integer, Folder> entry : UsersSession.getListFolder().entrySet()) {
                        Integer key = entry.getKey();
                        Folder value = entry.getValue();
                        ArrayList<FolderJoinLessionJoinUsers> li = listFolder.getAllLessionInData(value.getFid() + "");
            
      out.write("\n");
      out.write("            <li class=\"list-group-item\">\n");
      out.write("                <span class=\" label label-info\" style=\"float: right\"> ");
      out.print( li.size());
      out.write(" Lession</span>\n");
      out.write("                <i class=\"fa fa-folder fa-2x\" style=\"    color: #921877;\" aria-hidden=\"true\"></i> <a href=\"./Folder.jsp?fid=");
      out.print( value.getFid());
      out.write('"');
      out.write('>');
      out.print( value.getName());
      out.write("</a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            ");
 }
                }
      out.write("\n");
      out.write("            <li class=\"list-group-item\" style=\"text-align: center\" ng-app=\"myappMo\" ng-controller=\"MyController\">\n");
      out.write("                <button ng-click=\"open()\" class=\"btn btn-danger\"><i class=\"fa fa-folder fa-2x\" aria-hidden=\"true\"></i>  Create Folder</button>\n");
      out.write("            <openmodal title=\"Tạo thư mục mới\" visible=\"showModal\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String errors1 = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ListFolder listFo = new ListFolder();
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token")) && request.getParameter("submit") != null) {
        session.removeAttribute("token");
        Validation validation2 = new Validation();
        String name = request.getParameter("name");
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes, StandardCharsets.UTF_8);
        String id = "";
        if (session.getAttribute("user") != null) {
            Users author = (Users) session.getAttribute("user");
            id = author.getUid() + "";
        } else if (!user.equals("")) {
            id = user.substring(0, user.indexOf("|"));
        }
        
        String uid = id;
        String sharefolder = request.getParameter("sharefolder");
        if (validation2.StringFormatMinMax(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation2.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
            boolean resu = listFo.InsertFolder(name, uid, sharefolder);
            if (resu) {

                try {
                    session.removeAttribute("alert-sucess");
                    session.setAttribute("alert-sucess", "Thêm folder thành công");
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
                return;
            } else {

                try {
                    session.removeAttribute("alert");
                    errors1 = "Thêm folder thất bại , mời bạ kiểm tra lại nội dung nhập vào";
                    session.setAttribute("alert", errors1);
                    response.sendRedirect("./UsersPage.jsp");

                } catch (Exception ex) {

                }
                return;
            }

        } else {

            try {
                session.removeAttribute("alert");
                errors1 = validation2.getShowErrors();
                session.setAttribute("alert", errors1);
                response.sendRedirect("./UsersPage.jsp");
                return;
            } catch (Exception ex) {

            }
        }
    }

      out.write("\n");
      out.write("<form action=\"\" method=\"POST\" id=\"FolderCreate\" style=\"text-align: left;\">\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Tên Folder : </label>\n");
      out.write("        <input class=\"form-control\" name=\"name\" required>\n");
      out.write("        <p class=\"help-block\">Hãy nhập trong khoảng 5 - 30 ký tự</p>\n");
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
      out.write("            </openmodal>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-lg-8\">\n");
      out.write("        <div class=\"panel panel-success\">\n");
      out.write("            <div class=\"panel-heading\">\n");
      out.write("                <h3 class=\"panel-title\">Tất cả các bài học</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <table class=\"table table-striped table-hover \">\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
 session.removeAttribute("alert-sucess");
                            session.removeAttribute("alert");
                            if (UsersSession != null) {
                                for (Map.Entry<Integer, Lesson> entry : UsersSession.getListLession().entrySet()) {
                                    Lesson value = entry.getValue();
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><i class=\"fa fa-file  fa-2x\" aria-hidden=\"true\"></i><a href=\"Lession.jsp?lid=");
      out.print( value.getLid());
      out.write("\" > ");
      out.print( value.getTitle());
      out.write(" </a></td>\n");
      out.write("                            <td> <i class=\"fa fa-globe fa-2x\" aria-hidden=\"true\"></i> ");
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
      out.write("                                <td class=\"center\">\n");
      out.write("                                <a  class=\"btn btn-info btn-circle\" href=\"./EditLession.jsp?lid=");
      out.print( value.getLid());
      out.write("\"><i class=\"fa fa-check\"></i>\n");
      out.write("                                    </a>\n");
      out.write("                                    <a  class=\"btn btn-danger btn-circle\" href=\"./DeleteLession.jsp?lid=");
      out.print( value.getLid());
      out.write("\"><i class=\"fa fa-times\"></i>\n");
      out.write("                                    </a>\n");
      out.write("                                </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
                            }
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("     <div class=\"col-lg-12\">\n");
      out.write("        <ul class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"./UsersPage.jsp\">Home</a></li>\n");
      out.write("            <li class=\"active\">");
 if (newAdd != null) {
                    out.print(newAdd.getUsername());
                }
      out.write("</li>\n");
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
