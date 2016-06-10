<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"  %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ListLession listLession = new ListLession();
    ListFolder folder = new ListFolder();
    ArrayList<LessonJoinUser> arrayList = null;
    ArrayList<FolderJoinUser> arrayList1 = null;
    if (request.getParameter("ValueSearch") != null) {
        String input = request.getParameter("ValueSearch");
        byte[] bytes1 = input.getBytes(StandardCharsets.ISO_8859_1);
        input = new String(bytes1, StandardCharsets.UTF_8);
        out.print(input);
        arrayList = listLession.GetDataSearch(input);
        arrayList1 = folder.getSearchData(input);
    }
%>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;">
    <% if (request.getParameter("ValueSearch") == null) {%>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3 class="text-center">bạn chưa nhập thông tin search</h3>
                </div>
            </div>

        </div>
    </div>
    <% } else %>
    <% if (arrayList != null)
        for (int i = 0; i < arrayList.size(); i++) {%>
    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-lg-4">
                        <i class="fa fa-user fa-2x"></i>
                    </div>
                    <div class="col-lg-8">
                        <%= arrayList.get(i).getUsername()%>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-lg-8">
                        <i class="fa fa-file  fa-2x" aria-hidden="true"></i>    <a href="./Lession.jsp?lid=<%=  arrayList.get(i).getLid()%>"><%= arrayList.get(i).getTitle()%></a>
                    </div>
                    <div class="col-lg-4"><i class="fa fa-globe fa-2x" aria-hidden="true"></i>
                        <%
                            switch (arrayList.get(i).getPermission()) {
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
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%}%>
    <% if (arrayList1 != null)
             for (int i = 0; i < arrayList1.size(); i++) {%>
    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-lg-4">
                        <i class="fa fa-user fa-2x"></i>
                    </div>
                    <div class="col-lg-8">
                        <%= arrayList1.get(i).getUsername()%>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-lg-8">
                        <i class="fa fa-folder fa-2x" style="    color: #921877;" aria-hidden="true"></i>    <a href="./Lession.jsp?lid=<%=  arrayList1.get(i).getFid()%>"><%= arrayList1.get(i).getName()%></a>
                    </div>
                    <div class="col-lg-4"><i class="fa fa-globe fa-2x" aria-hidden="true"></i>
                        <%
                            switch (arrayList1.get(i).getPermission()) {
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
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%}%>
</div>
<%@include file="Footer.jsp"  %>