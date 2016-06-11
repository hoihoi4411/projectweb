<%-- 
    Document   : Lession
    Created on : May 20, 2016, 8:56:21 PM
    Author     : MyPC
--%>

<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@page import="vn.fpt.project.bao.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="Header.jsp"  %>
<%    ListLession list = new ListLession();
    list.getData();
    HashMap<Integer, Quiz> listAQuiz = null;
    Lesson get = null;
    boolean checkEdit = false;
    String id = request.getParameter("lid");
    if (request.getParameter("lid") == null || !request.getParameter("lid").matches("[0-9]{1,100}")) {
        try {
            response.sendRedirect("./UsersPage.jsp");
        } catch (Exception ex) {

        }
        return;
    } else {
        get = list.searchLession(request.getParameter("lid"));
        String idU = "";
        switch (get.getShare()) {
            case 1:
                if (session.getAttribute("user") != null) {
                    Users author = (Users) session.getAttribute("user");
                    idU = author.getUid() + "";
                } else if (!user.equals("")) {
                    idU = user.substring(0, user.indexOf("|"));
                }
                if (idU.equals("")) {
                    try {
                        response.sendRedirect("./Login.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                String uid = idU;
                if (get.getUid() != Integer.parseInt(idU)) {
                    try {
                        response.sendRedirect("./UsersPage.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                break;
            case 2:

                if (session.getAttribute("user") != null) {
                    Users author = (Users) session.getAttribute("user");
                    idU = author.getUid() + "";
                } else if (!user.equals("")) {
                    idU = user.substring(0, user.indexOf("|"));
                }
                if (idU.equals("")) {
                    try {
                        response.sendRedirect("./Login.jsp");
                    } catch (Exception ex) {

                    }
                    return;
                }
                break;
        }
        if (session.getAttribute("user") != null) {
            Users author = (Users) session.getAttribute("user");
            idU = author.getUid() + "";
        } else if (!user.equals("")) {
            idU = user.substring(0, user.indexOf("|"));
        }
        if (!idU.equals("")) {
            if (get.getUid() == Integer.parseInt(idU)) {
                checkEdit = true;
               
            }
        }

        listAQuiz = list.searchLession(request.getParameter("lid")).getListAQuiz();
    }

%>
<div class="container" style="background: #fff;
     padding-left: 37px;
     padding-top: 20px;    padding-bottom: 20px;">
     <ul class="breadcrumb">
            <li><a href="./index.jsp">Home</a></li>
            <li class="active">Bài học <% if (get != null) {
                    out.print(get.getTitle());
                } %></li>
        </ul>
    <div class="row">
        <div class="col-lg-8">
            <div style="width: 100%">
                <% if (listAQuiz != null)
                        for (Map.Entry<Integer, Quiz> entry : listAQuiz.entrySet()) {
                            Integer key = entry.getKey();
                            Quiz value = entry.getValue();%>
                <div class="chunk-terms">
                    <div class="text-left-Lesion">
                        <%= value.getQuestion()%>
                    </div>
                    <div class="text-right-Lesion">
                        <%= value.getAnswer()%>
                    </div>
                </div>
                <% }%>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="col-lg-6">
                <a href="./Learn.jsp?lid=<%= get.getLid()%>" class="learn has-status  ModeButton btn btn-danger" data-sourcename="mode-link-learn">
                    <span class="ModeButton-inner">
                        <span class="glyph icon learn-icon ModeButton-icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></span>		<span class="ModeButton-name">
                            Học 		</span>
                    </span>
                </a>
            </div>

            <div class="col-lg-6"><a href="./TestLession.jsp?lid=<%= get.getLid()%>" class="learn has-status  ModeButton btn btn-info" data-sourcename="mode-link-learn">
                    <span class="ModeButton-inner">
                        <span class="glyph icon learn-icon ModeButton-icon"><i class="fa fa-comments" aria-hidden="true"></i></span>		<span class="ModeButton-name">
                            Kiểm tra		</span>

                    </span>
                </a>
            </div>
                    <% if(checkEdit) {%>
            <div class="col-lg-6" style="    margin-top: 15px;">
                <a href="./EditLession.jsp?lid=<%= get.getLid()%>" class="learn has-status  ModeButton btn btn-success" data-sourcename="mode-link-learn">
                    <span class="ModeButton-inner">
                        <span class="glyph icon learn-icon ModeButton-icon"><i class="fa fa-pencil" aria-hidden="true"></i></span>		<span class="ModeButton-name">
                            Chỉnh sửa		</span>
                    </span>
                </a>
            </div>

            <div class="col-lg-6" style="    margin-top: 15px;"><a href="./DeleteLession.jsp?lid=<%= get.getLid()%>" class="learn has-status  ModeButton btn btn-warning" data-sourcename="mode-link-learn">
                    <span class="ModeButton-inner">
                        <span class="glyph icon learn-icon ModeButton-icon"><i class="fa fa-trash-o" aria-hidden="true"></i></span>		<span class="ModeButton-name">
                            Xóa 	</span>

                    </span>
                </a>
            </div>
                      <% }%>
        </div>
    </div>
         <ul class="breadcrumb">
            <li><a href="./index.jsp">Home</a></li>
            <li class="active">Bài học <% if (get != null) {
                    out.print(get.getTitle());
                } %></li>
        </ul>
</div>
<style>
    .chunk-terms {
        border-radius: 4px;
        border-top: 1px solid #d7d6d3;
        border-right: 1px solid #d7d6d3;
        border-bottom: 1px solid #d7d6d3;
        border-left: 1px solid #d7d6d3;
        font-size: 20px;
        padding: 15px;
    }
    .text-left-Lesion{
        float: left;
        margin-left: 20px;
    }
    .text-right-Lesion{

        margin-left: 200px;
    }
    .ModeButton{
        border: 1px solid #b8c0c7;
        border-radius: 5px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        display: table;
        text-align: center;
        -webkit-transition: background-color 300ms,color 300ms,border-color 300ms;
        -moz-transition: background-color 300ms,color 300ms,border-color 300ms;
        -ms-transition: background-color 300ms,color 300ms,border-color 300ms;
        transition: background-color 300ms,color 300ms,border-color 300ms;
        width: 100%;
    }
    .ModeButton-inner {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        display: table-cell;
        height: 85px;
        padding: 8px;
        vertical-align: middle;
    }
    .ModeButton.has-status .ModeButton-icon {
        font-size: 28px;
        margin-bottom: 0;
    }
    .ModeButton-icon {
        display: block;
        font-size: 32px;
        margin: 0 auto 3px auto;
    }
    .ModeButton.has-status .ModeButton-name {
        margin-bottom: 0;
    }
    .ModeButton-name {
        display: block;
        font: 16px "open sans",opensans-webfont,"lucida grande","lucida sans unicode",arial,sans-serif;
        margin-bottom: 3px;
        white-space: nowrap;
    }
    .ModeButton-status {
        color: inherit;
        font-size: 11px;
        opacity: 0.7;
        -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=70)";
        filter: alpha(opacity=70);
    }

</style>
<%@include file="Footer.jsp"  %>