<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="components/header.jsp">
    <jsp:param name="title" value="Upload Tutorials"/>
</jsp:include>
<body>
<%@include file="components/navbar.jsp"%>

<div class="container">
    <h1>Tutorial Name : <%=request.getAttribute("tutorialName")%></h1>
    <video controls width="100%" height="60%">
        <source src="<%="videos/"  + request.getAttribute("videoURL")%>" type="video/mp4">
    </video>
</div>
<script>
    const video = document.getElementsByTagName('video')[0];
    let arr = [];
    let setArrayOnce = false;
    video.onplaying = function (e) {
        let len = Math.round(video.duration);
        if (setArrayOnce === false){
            for (let i = 0; i < 5; i++) {
                arr.push(Math.round(Math.random() * (len + 1)));
            }
            setArrayOnce = true;
        }
        setInterval(() => {
            let index = arr.indexOf(Math.round(video.currentTime));
            if (index !== -1) {
                arr.splice(index, 1);
            }
            console.log(arr,Math.round(video.currentTime));
        },100)
     }
    video.onended = function(e) {
        if (arr.length === 0) {
            alert("you can move to the next tutorial");
        }else{
            alert("please re-watch the tutorial")
            arr = [];
            setArrayOnce = false;
        }
    };
</script>

<%@include file="components/footer.jsp"%>

</body>
</html>
