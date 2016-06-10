<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@include file="AdminHeader.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson get = null;
    String id = request.getParameter("lid");
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
        try {
            response.sendRedirect("./AdminLession.jsp");
        } catch (Exception ex) {

        }
    } else if (list.searchLession(request.getParameter("lid")) == null) {
        try {
            response.sendRedirect("./AdminLession.jsp");
        } catch (Exception ex) {

        }
    } else {
        get = list.searchLession(request.getParameter("lid"));
        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
    }
%>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Bài học <% if (get != null) {
                    out.print(get.getTitle());
                }%> </h1>
            <div class="dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Câu hỏi</th>
                            <th>Đáp án</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                                Integer key = entry.getKey();
                                Quiz value = entry.getValue();%>
                        <tr>
                            <td><%= key%> </td>
                            <td><%= value.getQuestion()%> </td>
                            <td><%= value.getAnswer()%></td>

                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
            <a href="./AdminEditQuiz.jsp?lid=<%= id %>" class="btn btn-warning">Chỉnh sửa Câu hỏi</a>
        </div>
        <!-- /.col-lg-12 -->
    </div>

</div>
<!-- /#page-wrapper -->

<%@include file="AdminFooter.jsp"  %>