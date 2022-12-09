<%
    String path = request.getRequestURL().toString();
    String []jspFiles = {
            "http://localhost:8080/",
            "http://localhost:8080/admin-login.jsp",
            "http://localhost:8080/admin.jsp",
            "http://localhost:8080/index.jsp",
    };
    String []routeNames = {"Home","Admin Login","Admin", "test"};
    String []realRoutes = {"/","/admin-login","/admin","/"};
%>

<nav class=" navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="https://paula-george.guru">FAST AMBULANCE</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <% for (int i = 0;i < jspFiles.length;i++) { %>
                    <li class="<% if (path.equals(jspFiles[i])) { %> active <% } %>">
                        <a href="<%=realRoutes[i]%>"><%=routeNames[i]%></a>
                    </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>