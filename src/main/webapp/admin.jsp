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
    <h1><%=Helper.getServerRoute(request)%></h1>
    <form method="post" action="<%=request.getServerName()%>">

    </form>
</div>

<%@include file="components/footer.jsp"%>

</body>
</html>
