<%--
  Created by IntelliJ IDEA.
  User: paula
  Date: 12/8/22
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="components/header.jsp">
    <jsp:param name="title" value="Upload Tutorials"/>
</jsp:include>
<body>
<%@include file="components/navbar.jsp"%>

<div class="container">
    <% if (request.getParameter("uploaded") != null) {%>
    <div class="alert alert-success" role="alert">
        The file(s) are uploaded successfully
    </div>
    <% } %>
    <form
            style="height: 75%"
            method="post"
            enctype="multipart/form-data"
            action="<%=Helper.getServerRoute(request)%>/admin"
    >
        <br />
        <br />
        <br />
        <label>Tutorial name</label>
        <input placeholder="Tutorial description" name="tutorial_name" type="text" class="form-control">
        <label>Tutorial description</label>
        <textarea class="form-control" name="tutorial_description" placeholder="Tutorial description"></textarea>
        <br />
        <br />
        <br />
        <input type="file" multiple name="video" class="form-control" id="customFile" />
        <br />
        <br />
        <br />
        <input class="form-control btn btn-success" type="submit" value="Upload" name="submit">
    </form>
</div>
<script>
    window.history.replaceState({}, document.title, "/" + "admin");
</script>
<%@include file="components/footer.jsp"%>

</body>
</html>
