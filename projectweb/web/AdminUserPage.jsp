
<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>

<%  Users user = null;
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
    for (Map.Entry<Integer, Folder> entry : user.getListFolder().entrySet()) {

    }
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"> <% if (user != null) {
                    out.print(user.getUsername());
                }%> </h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">

        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Information
                </div>
                <div class="panel-body">
                    <p class="lead">Total Folder :  <%
                        if (user.getListFolder() != null) {
                            out.print(user.getListFolder().size());
                        } else {
                            out.print(0);
                        }
                        %></p>
                    <p>Total lession :
                        <%
                            if (user.getListLession() != null) {
                                out.print(user.getListLession().size());
                            } else {
                                out.print(0);
                            }
                        %></p>
                </div>
                <!-- /.panel-body -->
            </div>
        </div>
        <div class="col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-user fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><% if (user != null) {
                                    out.print(user.getUsername());
                                }%></div>
                            <div></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-success">
            <div class="panel-heading">
                All folder and lession
            </div>
            <div class="panel-body">
                <div>

                    <!-- Nav tabs -->
                    <% if (user.getListFolder() != null) { %>
                    <ul class="nav nav-tabs" role="tablist">
                        <% int i = 0;
                            for (Map.Entry<Integer, Folder> entry : user.getListFolder().entrySet()) {
                                Folder value = entry.getValue();
                                if (i == 0) {

                        %>
                        <li role="presentation" class="active"><a href="#<%= value.getFid()%>" aria-controls="<%=  value.getFid()%>" role="tab" data-toggle="tab"><%= value.getName()%></a></li>
                            <%  } else {%>
                        <li role="presentation"><a href="#<%= value.getFid()%>" aria-controls="<%= value.getFid()%>" role="tab" data-toggle="tab"><%= value.getName()%></a></li>
                            <%  }
                                    i++;
                                }%>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <%  i = 0;
                            for (Map.Entry<Integer, Folder> entry : user.getListFolder().entrySet()) {
                                Folder value = entry.getValue();
                                if (i == 0) {
                        %>
                        <div role="tabpanel" class="tab-pane active" id="<%= value.getFid()%>">fdsf</div>
                        <%  } else {%>
                        <div role="tabpanel" class="tab-pane" id="<%= value.getFid()%>">xccz</div>
                        <%  }
                                i++;
                            }%>

                    </div>
                    <%  }%>
                </div>
            </div>

        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                Lession not have Folder
            </div>
            <div class="panel-body">
                <table class="table table-striped table-hover ">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Share</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if (user.getListLession() != null) {
                                for (Map.Entry<Integer, Lesson> entry : user.getListLession().entrySet()) {
                                    Lesson value = entry.getValue();
                        %>
                        <tr>
                            <td> <%= value.getLid()%></td>
                            <td><%= value.getTitle()%></td>
                            <td><%= value.getShare()%></td>
                            <td><a href=".\EditLession.jsp?lid=<%= value.getLid()%>" class="btn btn-info btn-circle"><i class="fa fa-check"></i>
                            </a><a href=".\DeleteLession.jsp?lid=<%= value.getLid()%>" class="btn btn-warning btn-circle"><i class="fa fa-times"></i>
                            </a></td>
                        </tr>
                        <%  } %>
                        <% }%>
                    </tbody>
                </table> 
            </div>
            <!-- /.panel-body -->
        </div>
    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>