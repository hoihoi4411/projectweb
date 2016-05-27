package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class anh_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>File Uploading Form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>File Upload Form</h1>\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Upload File</legend>\n");
      out.write("            <form action=\"FileUploadServlet\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                <label for=\"fileName\">Select File: </label>\n");
      out.write("                <input id=\"fileName\" type=\"file\" name=\"fileName\" size=\"30\" /><br/> <input type=\"submit\" value=\"Upload\" />\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("        <img src=\"./uploads/");
      out.print(request.getAttribute("url"));
      out.write("\" width=\"200px\">\n");
      out.write("        <a href=\"index.jsp\">Click Upload Image</a>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
