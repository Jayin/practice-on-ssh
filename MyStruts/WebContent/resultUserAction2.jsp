<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib uri="/struts-tags" prefix="s" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>User Details</h2>  
<hr>   
<!-- getUser().getName() -->
User Name :<s:property value="name" /><br> 
Age :<s:property value="age" /><br>   
Hobbies :<s:property value="hobby" /><br>  
Country :<s:property value="country" /><br>
</body>
</html>