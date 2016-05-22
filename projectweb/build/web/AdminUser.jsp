
<%@include file="AdminHeader.jsp"  %>
<%    String token = Hash.generateToken();
    session.setAttribute("token", token);
    String errors = "";
    if (request.getParameter("token") != session.getAttribute(token)) {
        session.removeAttribute("token");
        Validation validation = new Validation();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permisson = request.getParameter("permission");
        if (validation.StringFormatOnlyLetterAndDigits(username, 5, 30, "username") && validation.StringFormatMinMax(password, 5, 15, "password") && validation.NumberFormatMinMax(permisson, 1, 2, "permission")) {
            boolean resu = list.InsertNewUser(username, password, permisson);
            if (resu) {
                session.setAttribute("alert-sucess", "Insert Successful!");
                response.sendRedirect("./AdminUser.jsp");
            } else {
                errors = "Username exits in unique";
                session.setAttribute("alert", errors);
            }
        } else {
            errors = validation.getShowErrors();
            session.setAttribute("alert", errors);
        }
    }
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"> Admin Control Panel Users </h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <% session.removeAttribute("alert-sucess");
                if (session.getAttribute("alert") != null) {%>
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <%= session.getAttribute("alert")%>
            </div>
            <%}%>
            <%session.removeAttribute("alert");
                if (session.getAttribute("alert-sucess") != null) {%>
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <%= session.getAttribute("alert-sucess")%>
            </div>
            <%}%>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Add new User</h3>
                </div>
                <form action="" method="POST"  name="AddnewForm" >
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Username : </label>
                                    <input class="form-control" type="text" name="username"  placeholder="Enter here Username" ng-model="username" required autocomplete="off">
                                    <p ng-show="AddnewForm.username.$touched && AddnewForm.username.$invalid" class="label label-danger">Example block-level help text here.</p>
                                </div>
                                <div class="form-group">
                                    <label>Selects</label>
                                    <select class="form-control" name="permission">
                                        <option value="1">Admin</option>
                                        <option value="2">Users</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Password : </label>
                                    <input class="form-control" type="password" placeholder="Enter Password Here" name="password" ng-model="password" required autocomplete="off">
                                    <p ng-show="AddnewForm.password.$touched && AddnewForm.password.$invalid" class="label label-danger">Example block-level help text here.</p>
                                </div>
                                <input type="hidden" value="<%= token%>" name="token">
                                <div class="form-group">
                                    <input type="submit" class="btn btn-default" value="Add new user">
                                    <input type="reset" class="btn btn-default" value="Reset">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Users Information
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Username</th>
                                    <th>Permisson</th>
                                    <th>Lession</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 1;
                                            i < list.getListUser()
                                            .size(); i++) {%>
                                <tr class="odd gradeX">
                                    <td><%= list.getListUser().get(i).getUid()%></td>
                                    <td><%= list.getListUser().get(i).getUsername()%></td>
                                    <td><%= list.getListUser().get(i).getPermission()%></td>
                                    <td class="center">4</td>
                                    <td class="center">
                                        <a  class="btn btn-info btn-circle" href=""><i class="fa fa-check"></i>
                                        </a>
                                        <a  class="btn btn-warning btn-circle" href=""><i class="fa fa-times"></i>
                                        </a>
                                    </td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->

                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>