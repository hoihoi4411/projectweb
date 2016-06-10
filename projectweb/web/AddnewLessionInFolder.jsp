<%@page import="java.util.*"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ArrayList<FolderJoinLessionJoinUsers> listLession = null;
    FolderJoinUser re = null;
    ListLession listLession1 = new ListLession();
    HashMap<Integer, Lesson> arr = null;
    if (request.getParameter("fid") == null || request.getParameter("uid") == null || !request.getParameter("fid").matches("[0-9]{1,10}") || !request.getParameter("uid").matches("[0-9]{1,10}")) {
        try {
            response.sendRedirect("./AdminFolder.jsp");

        } catch (Exception ex) {

        }
    } else {
        ListFolder list = new ListFolder();
        list.getFolderInData();
        re = list.searchInFolder(Integer.parseInt(request.getParameter("fid")));
        Users author = listb.SearchUser(Integer.parseInt(request.getParameter("uid")));
        if (re == null || author == null) {
            try {
                response.sendRedirect("./AdminFolder.jsp");

            } catch (Exception ex) {

            }
        } else {
            String fid = request.getParameter("fid");
            arr = listLession1.getAllLessonNotHaveFolder(request.getParameter("uid"), request.getParameter("fid"));
            boolean resut = false;
            if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
                for (Map.Entry<Integer, Lesson> entry : arr.entrySet()) {
                    Integer key = entry.getKey();
                    Lesson value = entry.getValue();
                    String id = request.getParameter("lesson" + key);
                    if (id != null && Integer.parseInt(id) == key) {
                        resut = list.AddNewLessonInFolder(id, request.getParameter("fid"));
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

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Thêm bài học vào thư mục <% if (re != null) {
                    out.print(re.getName());
                } %>  </h1>
        </div>
        <!-- /.col-lg-12 -->
        <form action="" method="POST">
            <div class="dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Tiêu đề</th>
                            <th>Chế độ chia sẻ</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if (arr != null) {
                                for (Map.Entry<Integer, Lesson> entry : arr.entrySet()) {
                                    Integer key = entry.getKey();
                                    Lesson value = entry.getValue();%>
                        <tr>
                            <td>  <input type="checkbox" value="<%= value.getLid()%>" name="lesson<%= value.getLid()%>"><%= value.getLid()%></td>
                            <td><%= value.getTitle()%> </td>
                            <td><%
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
                                %> </td>
                            <td class="center">
                                <a  class="btn btn-info btn-circle" href="./AdminEditLession.jsp?lid=<%= value.getLid()%>"><i class="fa fa-check"></i>
                                </a>
                                <a  class="btn btn-danger btn-circle" href="./AdminDeleteLession.jsp?lid=<%= value.getLid()%>"><i class="fa fa-times"></i>
                                </a>
                            </td>
                        </tr>
                        <% }
                            }%>
                    </tbody>
                </table>
            </div>

            <input type="hidden" value="<%  session.setAttribute("token", Hash.generateToken());
                       out.print(session.getAttribute("token"));%>" name="token">
            <input type="submit" value="Thêm bài học" class="btn btn-info"/>
        </form>
    </div>

</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>