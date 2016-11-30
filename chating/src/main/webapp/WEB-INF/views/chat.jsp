<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
</head>
<body>
<h2>GROUP CHAT</h2>
<form:form commandName="message" action="sendMsg" method="post">
<form:hidden path="username" value="${username}"/>
<form:input path="msg"/>
<input type="submit" value="send"/> 
</form:form>
<br>
<br>
<c:forEach items="${msgs}" var="x">
<h6>${x.username}</h6>
<p>${x.msg}</p>
<h5>${x.time}</h5>
</c:forEach>
</body>
</html>
