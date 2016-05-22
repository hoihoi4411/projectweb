<%@include file="AdminHeader.jsp"  %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"> Admin Control Panel Users </h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Add new User</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Email : </label>
                                <input class="form-control">
                                <p class="help-block">Example block-level help text here.</p>
                            </div>
                            <div class="form-group">
                                <label>Selects</label>
                                <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Password : </label>
                                <input class="form-control">
                                <p class="help-block">Example block-level help text here.</p>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="submit" class="btn btn-default">Submit Button</button>
                            </div>
                        </div>
                    </div>
                </div>
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
                                <% for (int i = 1; i < list.getListUser().size(); i++) {%>
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