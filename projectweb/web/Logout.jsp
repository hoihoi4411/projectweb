<%@page import="vn.fpt.project.bo.Users"%>
<%
    Users aUser = new Users();
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    boolean ck = false;
    String user = "";
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
    if (session.getAttribute("user") == null && ck == false) {
        response.sendRedirect("./Index.jsp");
    } else if (session.getAttribute("user") != null) {
        session.invalidate();
    } else if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equalsIgnoreCase("username")) {
                cookie.setMaxAge(0);
                break;
            }
        }
    }
    try {
        response.sendRedirect("./Index.jsp");
    } catch (Exception e) {

    }

%>