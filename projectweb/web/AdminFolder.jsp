<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="page-wrapper" ng-app="myappMo" ng-controller="MyController">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Thư mục </h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <button ng-click="open()" class="btn btn-primary">Thêm một thư mục mới</button>
    <openmodal title="Add new Folder" visible="showModal">
        <%@include file="AdminCreateFolder.jsp"  %>
    </openmodal>
    <%
        ListFolder lis = new ListFolder();
        lis.getFolderInData();
        HashMap<Integer, FolderJoinUser> listFolderJoin = new HashMap<>();
        listFolderJoin = lis.getListFolderJoin();

    %>
    <%          if (session.getAttribute("alert") != null) {
            session.removeAttribute("alert-sucess");%>
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <%= session.getAttribute("alert")%>
    </div>
    <%}%>
    <%
        if (session.getAttribute("alert-sucess") != null) {
            session.removeAttribute("alert");%>
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <%= session.getAttribute("alert-sucess")%>
    </div>
    <%}%>
    <div class="panel-body">
        <div class="dataTable_wrapper">
           
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Tên thư mục</th>
                            <th>Chế độ chia sẻ</th>
                            <th>Tác giả</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Map.Entry<Integer, FolderJoinUser> entry : listFolderJoin.entrySet()) {
                                Integer key = entry.getKey();
                                FolderJoinUser value = entry.getValue();


                        %>
                        <tr class="odd gradeX">
                            <td><%= key%></td>
                            <td><a href="AdminFolderPage.jsp?fid=<%= key%>"><%= value.getName()%></a></td>
                            <td><%
                                switch (value.getPermission()) {
                                    case 1:
                                        out.print("Chỉ mình tôi");
                                        break;
                                    case 2:
                                        out.print("Dành cho thành viên");
                                        break;
                                    case 3:
                                        out.print("Công khai");
                                        break;
                                }
                                %></td>
                            <td class="center"><a href="AdminUserPage.jsp?uid=<%= value.getUid()%>"><%= value.getUsername()%></a></td>
                            <td class="center">
                                <a  class="btn btn-info btn-circle" href="./AdminEditFolder.jsp?fid=<%= key%>"><i class="fa fa-check"></i>
                                </a>
                                <a  class="btn btn-danger btn-circle" href="./AdminDeleteFolder.jsp?fid=<%= key%>"><i class="fa fa-times"></i>
                                </a>
                            </td>
                        </tr>
                        <%  }%>
                    </tbody>
                </table>
                 
        </div>
        <!-- /.table-responsive -->

    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>