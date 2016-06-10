<%@page import="java.util.ArrayList"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <%    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
                FolderJoinUser re = null;

                if (request.getParameter("fid") == null || !request.getParameter("fid").matches("[0-9]{1,10}")) {
                    try {
                        response.sendRedirect("./AdminFolder.jsp");

                    } catch (Exception ex) {

                    }
                } else {
                    ListFolder list = new ListFolder();
                    list.getFolderInData();
                    re = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));
                    if (re == null) {
                        try {
                            response.sendRedirect("./AdminFolder.jsp");

                        } catch (Exception ex) {

                        }
                    } else {
                        String fid = request.getParameter("fid");
                        listLession = list.getAllLessionInData(request.getParameter("fid"));
                        boolean resut = false;
                        if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
                            for (int i = 0; i < listLession.size(); i++) {
                                String id = request.getParameter("lesson" + listLession.get(i).getLid());
                                if (id != null && Integer.parseInt(id) == listLession.get(i).getLid()) {
                                    resut = list.DeleteLessionInFolder(id, request.getParameter("fid"));
                                }
                                if (resut == false) {
                                    break;
                                }
                            }
                            if (!resut) {
            %>
            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Xóa bài học thành công!</strong>
            </div>

            <%
                            } else {
                                try {
                                    response.sendRedirect("./AdminFolderPage.jsp?fid=" + fid);

                                } catch (Exception ex) {

                                }
                                return;
                            }

                        }
                    }

                }
            %>

            <h1 class="page-header">Thư mục <% if (re != null) {
                    out.print(re.getName());
                } %> </h1>
        </div>
        <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <a href="./AddnewLessionInFolder.jsp?fid=<%
                if (re != null) {
                    out.print(re.getFid());
                }
               %>&uid=<%
                   if (re != null) {
                       out.print(re.getUid());
                   }
               %>" class="btn btn-success">Thêm bài học vào folder này</a>

            <div class="dataTable_wrapper">
                <form action="" method="POST">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Tên bài học</th>
                                <th>Chế độ</th>
                                <th>Tác giả</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if (listLession != null) {
                                    for (int i = 0; i < listLession.size(); i++) {

                            %>
                            <tr>
                                <td><div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="<%= listLession.get(i).getLid()%>" name="lesson<%= listLession.get(i).getLid()%>"><%= listLession.get(i).getLid()%>
                                        </label>
                                    </div></td>
                                <td><a href="./AdminLessionPage.jsp?lid=<%= listLession.get(i).getLid()%>"><%= listLession.get(i).getTitle()%></a></td>
                                <td>
                                    <%
                                        switch (listLession.get(i).getShare()) {
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
                                <td><a href="AdminUserPage.jsp?uid=<%=  listLession.get(i).getUid()%>"><%= listLession.get(i).getUsername()%></td>
                                <td class="center">
                                    <a  class="btn btn-info btn-circle" href="./AdminEditLession.jsp?lid=<%= listLession.get(i).getLid()%>"><i class="fa fa-check"></i>
                                    </a>
                                    <a  class="btn btn-danger btn-circle" href="./AdminDeleteLession.jsp?lid=<%= listLession.get(i).getLid()%>"><i class="fa fa-times"></i>
                                    </a>
                                </td>
                            </tr>
                            <% }
                                }%>
                        </tbody>
                    </table>

                           <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                        out.print(session.getAttribute("token"));%>" name="token">
                    <input type="submit" value="Xóa Lession" class="btn btn-info"/>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>