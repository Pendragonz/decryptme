<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>decryptme</title>
</head>
<body>
<% String cipher = (String) request.getAttribute("cipher"); %>

<%
	Object success = (Object) request.getAttribute("success");
	String successString = "";
	if(success != null){
		if((boolean) success == true){
			successString = "Congratulations, you've succeeded!";
		} else {
			successString = "Try again.";
		}
	}
%>
<p>
<%=successString %>
</p>

<form action="/" method="post">
	<label >Ciphertext:	<%=cipher %></label><br>
	<input type="hidden" name="cipher" value="<%=cipher%>">
	<label for="attempt">Plaintext:</label>
	<input type="text" name="attempt">
	<input type="submit"><br><br><br>
	<label for="new">Too hard?</label>
	<input type="button" name="new" value="New Cipher" onclick="window.location.href='/'">
</form>
</body>
</html>