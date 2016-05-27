<%@include file="AdminHeader.jsp"  %>
<%  Users user = null;
    if (request.getParameter("uid") == null) {
        session.setAttribute("alert", "Invalid Users !");
        response.sendRedirect("./AdminUser.jsp");
    } else {
        lista.getListData();
        user = lista.SearchUser(Integer.parseInt(request.getParameter("uid")));
        if (user == null) {
            session.setAttribute("alert", "Uid is not have in Database !");
            response.sendRedirect("./AdminUser.jsp");
        }

    }
    int uid = Integer.parseInt(request.getParameter("uid"));
    String errors = "";

    if (session.getAttribute("token") == null) {
        String token = Hash.generateToken();
        session.setAttribute("token", token);
    } else {
        String token = Hash.generateToken();
    }

  
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        session.removeAttribute("token");
        if (request.getParameter("canncel") != null) {
            response.sendRedirect("./AdminUser.jsp");
        } else if (request.getParameter("ok") != null) {
            boolean re = lista.deleteUser(uid);
            if (re) {
                session.removeAttribute("alert-sucess");
                session.setAttribute("alert-sucess", "Delete Sucessful!");
                response.sendRedirect("./AdminUser.jsp");
            } else {
                session.removeAttribute("alert");
                session.setAttribute("alert", "Delete Errors!");
                response.sendRedirect("./AdminUser.jsp");
            }
        }
    }
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Delete  <%= user.getUsername()%> </h1>
        </div>
        <div class="col-lg-12">
            <div class="panel panel-green">
                <div class="panel-heading">
                    Delete  <%= user.getUsername()%>
                </div>
                <div class="panel-body">
                    <form action="" method="POST" >
                        <p>Do you want to delete this <%= user.getUsername()%> ? </p>
                        <input type="hidden" value="<%= session.getAttribute("token") %>" name="token">
                        <input type="submit" class="btn btn-success" value="Ok" name="ok"/>

                    </form>
                </div>

            </div>
        </div>
    </div>

</div>
<!-- /#page-wrapper -->
<%@include file="AdminFooter.jsp"  %>
