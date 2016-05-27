<%@page import="vn.fpt.project.bo.*"%>
<%@page import="java.util.*"%>
<%@page import="vn.fpt.project.bao.*"%>
<%
    String errors = "";
    ListUser listb = new ListUser();
    listb.getListData();
    ArrayList<Users> li = listb.getListUser();
    ListFolder listF = new ListFolder();
    
    if (session.getAttribute("token") == null) {
        String token = Hash.generateToken();
        session.setAttribute("token", token);
    } else {
        String token = Hash.generateToken();
    }
    if (request.getParameter("token") != null && request.getParameter("token").equals(session.getAttribute("token"))) {
        session.removeAttribute("token");
        Validation validation = new Validation();
        String name = request.getParameter("name");
        String uid = request.getParameter("uid");
        String sharefolder = request.getParameter("sharefolder");
        if (validation.StringFormatOnlyLetterAndDigits(name, 5, 30, "name") && listb.SearchUser(Integer.parseInt(uid)) != null && validation.NumberFormatMinMax(sharefolder, 1, 3, "sharefolder")) {
           // boolean resu = lista.InsertNewUser(username, password, permisson);
//            if (resu) {
//                session.setAttribute("alert-sucess", "Insert Successful!");
//                response.sendRedirect("./AdminFolder.jsp");
//            } else {
//                errors = "Username exits in unique";
//                session.setAttribute("alert", errors);
//            }
            //csrf
        } else {
            errors = validation.getShowErrors();
            session.setAttribute("alert", errors);
        }
    }
%>
<form action="" method="POST">
    <div class="form-group">
        <label>Folder name : </label>
        <input class="form-control" name="name" required>
        <p class="help-block">Example block-level help text here.</p>
    </div>
    <div class="form-group">
        <label>Selects Users author</label>
        <select class="form-control" name="uid" required>
            <% for (int i = 1; i < li.size(); i++) {%>
            <option value="<%= li.get(i).getUid()%>"><%= li.get(i).getUsername()%></option>
            <%}%>
        </select>
    </div>
    <div class="form-group">
        <label>Share</label>
        <div class="radio">
            <label>
                <input type="radio" name="sharefolder" id="optionsRadios1" value="1" checked="">Only me
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="sharefolder" id="optionsRadios2" value="2">For users
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="sharefolder" id="optionsRadios3" value="3">Public
            </label>
        </div>
    </div>
    <input type="hidden" value="<%= session.getAttribute("token")%>" name="token">
    <div class="form-group">
        <input class="btn btn-primary" type="submit" value="Add new Folder"/>
    </div>
</form>
