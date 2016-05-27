package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.fpt.project.bo.Users;
import java.util.ArrayList;
import org.apache.catalina.User;
import vn.fpt.project.bao.ListUser;

public final class AdminCreateFolder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();

      out.write("\n");
      out.write("<form action=\"\" method=\"POST\">\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Folder name : </label>\n");
      out.write("        <input class=\"form-control\" name=\"name\">\n");
      out.write("        <p class=\"help-block\">Example block-level help text here.</p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label>Selects Users author</label>\n");
      out.write("        <select class=\"form-control\" name=\"uid\">\n");
      out.write("            ");
 for(int i = 1; i < li.size();i++){ 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( li.get(i).getUid() );
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
      out.write("                <input type=\"radio\" name=\"sharefolder\" id=\"optionsRadios1\" value=\"1\" checked=\"\">Only me\n");
      out.write("            </label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"radio\">\n");
      out.write("            <label>\n");
      out.write("                <input type=\"radio\" name=\"sharefolder\" id=\"optionsRadios2\" value=\"2\">For users\n");
      out.write("            </label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"radio\">\n");
      out.write("            <label>\n");
      out.write("                <input type=\"radio\" name=\"sharefolder\" id=\"optionsRadios3\" value=\"3\">Public\n");
      out.write("            </label>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <input class=\"btn btn-primary\" type=\"submit\" value=\"Add new Folder\"/>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
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
