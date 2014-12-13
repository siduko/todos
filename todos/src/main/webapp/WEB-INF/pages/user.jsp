<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User info</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function search(){
		var txtsearch = $("#txtsearch").val();
		var userName = $("#userName");
		var password = $("#password");
		 $.ajax({
		        type: "GET",
		        url: "user/search",
		        data: "username=" + txtsearch ,
		        success: function(response){
		            // we have the response
		              userName.html(response.userName);
		              password.html(response.password);
		         },
		         error: function(e){
		             alert('Error: ' + e);
		         }
		    });
	}
</script>
</head>
<body>
	<h1 id="userName">${user.userName}</h1></br>
	<h1 id="password">${user.fullName}</h1></br>
	
	<input id="txtsearch" type="text" placeholder="search..."/>
	<input type="button" onclick="search()" value="search"/>
</body>
</html>