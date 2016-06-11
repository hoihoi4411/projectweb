<%

    if (session.getAttribute("admin") == null) {
        try {
            response.sendRedirect("./LoginAdmin.jsp");

        } catch (Exception ex) {

        }

    }else{
        session.removeAttribute("admin");
        session.removeAttribute("user");
        response.sendRedirect("./index.jsp");
    }
%>
