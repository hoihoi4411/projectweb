<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    ListLession listLession = new ListLession();
    listLession.getData();
    HashMap<Integer, Lesson> list = listLession.getListLession();

%>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            
            <%                if (session.getAttribute("alert") != null) {
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
            <h1 class="page-header">Bài học </h1>
            <a href="./AddNewLesson.jsp" class="btn btn-primary">Tạo một bài học mới</a>
            <div class="dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Đề bài</th>
                            <th>Tác giả</th>
                            <th>Chế độ chia sẻ</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%   for (Map.Entry<Integer, Lesson> entry : list.entrySet()) {
                                Integer key = entry.getKey();
                                Lesson value = entry.getValue();%>
                        <tr>
                            <td> <%= key %></td>
                            <td><a href="./AdminLessionPage.jsp?lid=<%= key%>"><%= value.getTitle() %></a></td>
                            <td><%= value.getUid() %></td>
                            <td>
                            <%
                                switch (value.getShare()) {
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
                                %>
                            </td>
                            <td class="center">
                                    <a  class="btn btn-info btn-circle" href="./AdminEditLession.jsp?lid=<%= key%>"><i class="fa fa-check"></i>
                                    </a>
                                    <a  class="btn btn-danger btn-circle" href="./AdminDeleteLession.jsp?lid=<%= key%>"><i class="fa fa-times"></i>
                                    </a>
                                </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">

    </div>
</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>