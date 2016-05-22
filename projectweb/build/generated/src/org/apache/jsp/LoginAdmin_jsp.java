package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.fpt.project.bo.*;

public final class LoginAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login Admin</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/bootstrap.min.css\">\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/bootstrap-theme.min.css\" >\n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style/css/style.css\" >\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"\">\n");
      out.write("        ");

            if (session.getAttribute("admin") != null) {
                response.sendRedirect("./Admin.jsp");
            }
            String token = Hash.generateToken();
            session.setAttribute("token", token);
            String errors = "";
            if (request.getParameter("token") != session.getAttribute(token)) {
                session.removeAttribute("token");
                Admin user = new Admin();
                Validation validation = new Validation();
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.StringFormatMinMax(password, 5, 15, "password")) {
                    boolean re = user.isAdmin(request.getParameter("username"), request.getParameter("password"));
                    if (re) {
                        session.setAttribute("admin", request.getParameter("username"));
                        response.sendRedirect("./Admin.jsp");
                    } else {
                        errors = "You Not Admin";
                    }
                } else {
                    errors = validation.getShowErrors();
                }

            }
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
 if (!errors.equals("")) {
      out.write("\n");
      out.write("            <div class=\"alert alert-dismissible alert-danger\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                <strong>Có lỗi </strong> ");
      out.print( errors);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            <div class=\"panel panel-default\" style=\"    width: 50%;\n");
      out.write("                 margin: auto;\n");
      out.write("                 margin-top: 50px;\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <div class=\"panel-title text-center\">Bootsnipp.com</div>\n");
      out.write("                </div>     \n");
      out.write("\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                    <form  name=\"myForm\" id=\"form\" class=\"form-horizontal\" enctype=\"multipart/form-data\" method=\"POST\" >\n");
      out.write("\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n");
      out.write("                            <input id=\"user\" type=\"text\" class=\"form-control\"  value=\"\" placeholder=\"User\" ng-model=\"username\" name=\"username\" required autofocus>  \n");
      out.write("                            <span ng-show=\"myForm.username.$touched && myForm.username.$invalid\" class=\"label label-danger\">The username is required.</span>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-lock\"></i></span>\n");
      out.write("                            <input id=\"password\" type=\"password\" class=\"form-control\"  placeholder=\"Password\" name=\"password\" ng-model=\"password\" required>\n");
      out.write("                            <span ng-show=\"myForm.password.$touched && myForm.password.$invalid\" class=\"label label-danger\">The password is required.</span>\n");
      out.write("\n");
      out.write("                        </div>                                                                  \n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"checkbox\" value=\"remember-me\" name=\"remember-me\"> Remember me\n");
      out.write("                            </label>\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print( token);
      out.write("\" name=\"token\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <!-- Button -->\n");
      out.write("                            <div class=\"col-sm-12 controls\">\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary pull-right\" value=\"Log in\">                        \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </form>     \n");
      out.write("\n");
      out.write("                </div>                     \n");
      out.write("            </div>\n");
      out.write("        </div> <!-- /container -->\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script type=\"text/javascript\" src=\"./style/js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"./style/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"./style/js/angular.min.js\"></script>\n");
      out.write("    </body>\n");
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
