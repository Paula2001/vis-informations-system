<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.vis.helpers.Helper" %><%
    String path = request.getRequestURL().toString();

    List<HashMap<String , String>> routes = new ArrayList<HashMap<String,String>>();

    routes.add(0, Helper.createRoute(
            "http://localhost:8080/",
            "Home",
            "/",
            "both"
    ));

    routes.add(1, Helper.createRoute(
            "http://localhost:8080/admin-login.jsp",
            "Admin Login",
            "/admin-login",
            "false"
    ));

    routes.add(2, Helper.createRoute(
            "http://localhost:8080/admin.jsp",
            "Admin",
            "/admin",
            "true"
    ));

    routes.add(3, Helper.createRoute(
            "http://localhost:8080/index.jsp",
            "test",
            "/",
            "both"
    ));

    Object isLoggedIn = request.getSession().getAttribute("isLoggedInAdmin");
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
                <% for (int i = 0;i < routes.size();i++) { %>
                    <% if( routes.get(i).get("isLoggedIn").equals(isLoggedIn) || routes.get(i).get("isLoggedIn").equals("both")) { %>
                        <li class="<% if (path.equals(routes.get(i).get("url"))) { %> active <% } %>">
                            <a href="<%=routes.get(i).get("realRoute")%>">
                                <%=routes.get(i).get("name")%>
                            </a>
                        </li>
                    <% } %>
                <% } %>
            </ul>
            <% if( isLoggedIn != null && isLoggedIn.equals("true")) { %>
                <form action="/admin-login">
                    <input type="hidden" name="_method" value="put" />
                    <button style="float: right" class="danger">Logout</button>
                </form>
            <% } %>
        </div>
    </div>
</nav>