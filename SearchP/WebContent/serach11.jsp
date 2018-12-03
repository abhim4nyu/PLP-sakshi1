<%@page import="java.util.*;"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search product</title>

</head>

<body>

<table align="center">

<%

List list=new ArrayList();

list=(ArrayList)request.getAttribute("list");

if(list!=null && list.size()>0 ){

%>

<h2 align="center">product List</h2>

<tr>

<th>ISBN Code</th>

<th>product Name</th>

<th>Category</th>

</tr>

<%

for(int i=0;i<list.size();i++){

List product=(List)list.get(i);

%>

<tr>

<td><%=product.get(1) %></td>

<td><%=product.get(2) %></td>

<td><%=product.get(3) %></td>

</tr>

<%

}

}else{

%>

Not  Available  

<%}%>

</table>

</body>

</html>