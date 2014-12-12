<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>
<h1>Register</h1>
<div class="errorDiv">
	<c:if test="${not empty msg}">
		<dir class="error">${msg}</dir>
	</c:if>
	<c:if test="${not empty error}">
		<form:errors path="*"/>
	</c:if>
</div>
<form:form method="post" commandName="user" action="register">
	<input type="text" name="userName" placeholder="Username"/><form:errors path="userName" cssClass="error"/></br>
	<input type="text" name="password" placeholder="password"/><form:errors path="password" cssClass="error"/></br>
	<input type="text" name="address" placeholder="address"/><form:errors path="address" cssClass="error"/></br>
	<input type="text" name="fullName" placeholder="fullName"/><form:errors path="fullName" cssClass="error"/></br>
	<input type="text" name="phone" placeholder="phone"/><form:errors path="phone" cssClass="error"/></br>
	<input type="text" name="email" placeholder="email"/><form:errors path="email" cssClass="error"/></br>
	<input type="submit" value="Register"/>
</form:form>
</body>
</html>