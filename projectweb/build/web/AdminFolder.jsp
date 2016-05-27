<%@include file="AdminHeader.jsp"  %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Lession </h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <button ng-click="open()" class="btn btn-primary">Add New Folder</button>
    <openmodal title="Add new Folder" visible="showModal">
        <%@include file="AdminCreateFolder.jsp"  %>
    </openmodal>
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
                                            i < lista.getListUser()
                                            .size(); i++) {
                                        if (lista.getListUser().get(i).getPermission() != 1) {
                                %>

                                <tr class="odd gradeX">
                                    <td><%= lista.getListUser().get(i).getUid()%></td>
                                    <td><%= lista.getListUser().get(i).getUsername()%></td>
                                    <td><%
                                        if (lista.getListUser().get(i).getPermission() == 1) {
                                            out.print("Admin");
                                        } else {
                                            out.print("User");
                                        }
                                        %></td>
                                    <td class="center">4</td>
                                    <td class="center">
                                        <a  class="btn btn-info btn-circle" href="./EditUsers.jsp?uid=<%= lista.getListUser().get(i).getUid()%>"><i class="fa fa-check"></i>
                                        </a>
                                        <a  class="btn btn-danger btn-circle" href="./DeleteUsers.jsp?uid=<%= lista.getListUser().get(i).getUid()%>"><i class="fa fa-times"></i>
                                        </a>
                                    </td>
                                </tr>
                                <% }
                                    }%>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->

                </div>
</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>