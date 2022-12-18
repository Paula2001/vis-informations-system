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
    <jsp:param name="title" value="FAST RESCUE | LOGIN"/>
</jsp:include>
<body>
<%@include file="components/navbar.jsp"%>

<div class="container login-container">
    <div class="h-100 d-flex align-items-center justify-content-center login-form-1">
        <h3>Paramedic Login</h3>
        <div>
            <div class="form-group">
                <input id="email" type="text" class="form-control" placeholder="Your Email *" />
            </div>
            <div class="form-group">
                <input id="password" type="password" class="form-control" placeholder="Your Password *" />
            </div>
            <button class="btnSubmit">Login</button>
        </div>
    </div>
</div>

<style>
    .login-container{
        margin-top: 5%;
        margin-bottom: 5%;
        height: 68%;
        width: 30%;
        min-width: 400px;
    }
    .login-form-1{
        padding: 5%;
        box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
    }
    .login-form-1 h3{
        text-align: center;
        color: #333;
    }
    .login-form-2{
        padding: 5%;
        background: #0062cc;
        box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
    }
    .login-form-2 h3{
        text-align: center;
        color: #fff;
    }
    .login-container form{
        padding: 10%;
    }
    .btnSubmit
    {
        display: block;
        width: 50%;
        border-radius: 1rem;
        margin: 0 auto;
        padding: 1.5%;
        text-align: center;
        border: none;
        cursor: pointer;
    }
    .login-form-1 .btnSubmit{
        font-weight: 600;
        color: #fff;
        background-color: #0062cc;
    }
    .login-form-2 .btnSubmit{
        font-weight: 600;
        color: #0062cc;
        background-color: #fff;
    }
    .login-form-2 .ForgetPwd{
        color: #fff;
        font-weight: 600;
        text-decoration: none;
    }
    .login-form-1 .ForgetPwd{
        color: #0062cc;
        font-weight: 600;
        text-decoration: none;
    }

</style>
<script>
    $(".btnSubmit").click(() => {
        $.ajax({
            url: "<%=Helper.getServerRoute(request)%>/civil-login",
            method: "POST",
            data: {
              email : $("#email").val(),
              password: $("#password").val()
            },
            success: (e) => {
                window.location.replace(e);
            },
            error: (e) => {
                console.log(e);
            }
        })
    })
</script>
<%@include file="components/footer.jsp"%>

</body>
</html>
