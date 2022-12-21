<%@ page import="com.example.vis.models.IModel" %>
<%@ page import="com.example.vis.models.VideoModel" %>
<%@ page import="com.example.vis.models.TutorialModel" %><%--
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
    <% int tutorialId = 0 ;%>
    <%for (IModel[] x : (ArrayList<IModel[]>) request.getAttribute("videos")) { %>
        <% if (tutorialId != ((VideoModel)x[1]).getTutorialId()) { %>
            <% tutorialId = ((VideoModel)x[1]).getTutorialId(); %>
            <br />
            <h1><%=((TutorialModel) x[0]).getName()%></h1>
            <br />
            <h3><%=((TutorialModel) x[0]).getDescription()%></h3>
        <% } %>
        <a href="/video?id=<%=((VideoModel)x[1]).getId()%>&tutorialName=<%=((TutorialModel) x[0]).getName()%>">
            <video class="col-sm-4">
                <source src="<%="videos/"  + ((VideoModel)x[1]).getUrl()%>" type="video/mp4">
            </video>
        </a>

    <% } %>
<%--    <div class="container">--%>
<%--        <h2>1st EP.: Heart Attack aiding</h2>--%>
<%--        <video title="asd"  height="80%" width="100%" controls  >--%>

<%--        </video>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-sm">--%>
<%--            One of three columns--%>
<%--        </div>--%>
<%--        <div class="col-sm">--%>
<%--            One of three columns--%>
<%--        </div>--%>
<%--        <div class="col-sm">--%>
<%--            One of three columns--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

<%@include file="components/footer.jsp"%>

</body>
</html>
