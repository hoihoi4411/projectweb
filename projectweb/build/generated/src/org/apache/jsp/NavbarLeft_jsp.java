package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vn.fpt.project.bo.*;
import vn.fpt.project.bao.*;

public final class NavbarLeft_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equalsIgnoreCase("username")) {
                response.sendRedirect("./Index.jsp");
            }
        }

    } else if (session.getAttribute("user") != null) {
        response.sendRedirect("./Index.jsp");
    }
    Users newAdd = null;
    ListFolder listFolder = new ListFolder();
    if (session.getAttribute("user") == null) {
        response.sendRedirect("./Index.jsp");
    } else {
        newAdd = (Users) session.getAttribute("user");
        ListUser list = new ListUser();
        list.getListData();

        listFolder.setListFolder(newAdd.getListFolder());

    }


      out.write("\n");
      out.write("<ul class=\"list-group\">\n");
      out.write("    ");
  if (newAdd != null) {
            for (Map.Entry<Integer, Folder> entry : newAdd.getListFolder().entrySet()) {
                Integer key = entry.getKey();
                Folder value = entry.getValue();
                ArrayList<FolderJoinLessionJoinUsers> li = listFolder.getAllLessionInData(value.getFid() + "");

    
      out.write("\n");
      out.write("    <li class=\"list-group-item\">\n");
      out.write("        <span class=\"badge\">");
      out.print( li.size());
      out.write(" Lession</span>\n");
      out.write("        <i class=\"fa fa-folder fa-2x\" aria-hidden=\"true\"></i> <a href=\"./Folder.jsp?fid=");
      out.print( value.getFid());
      out.write('"');
      out.write('>');
      out.print( value.getName());
      out.write("</a>\n");
      out.write("    </li>\n");
      out.write("    ");
 }
                }
      out.write("\n");
      out.write("    <li class=\"list-group-item\" style=\"text-align: center\">\n");
      out.write("        <button ng-click=\"open()\" class=\"btn btn-primary\"><i class=\"fa fa-folder fa-2x\" aria-hidden=\"true\"></i>  Create Folder</button>\n");
      out.write("    <openmodal title=\"Add new Folder\" visible=\"showModal\">\n");
      out.write("dssdas\n");
      out.write("    </openmodal>\n");
      out.write("</li>\n");
      out.write("</ul>\n");
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
