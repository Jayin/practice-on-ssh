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
	<s:form action="UserAction" > 
		<!-- getUser().setName() -->
		<s:textfield name="user.name" label="User Name" />      
		<s:textfield name="user.age" label="Age" /> 
		<s:radio name="user.sex" label="Sex" list="{'M','F'}" /> 
		<s:checkboxlist name="user.hobby" label="Hobby" list="{'Music','Art','Dance'}" /> 
		<s:select name="user.country" label="Country" list="{'Select','India','USA','France', 'Spain'}"  />  
		<s:submit /> 
	  
	</s:form> 
	
</body>
</html>