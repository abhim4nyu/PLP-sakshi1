<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}		
</style>
</head>

<body>
<center>
<table bgcolor="Biege">
<fo:form action="adddata" method="post" name="frmReg" modelAttribute="my" onSubmit="return chkEmpty()">

<tr>
<td>Product Name</td>
<td><fo:input path="name" id="name"/></td>
</tr>

<tr>
<td>Product Id</td>
<td><fo:input path="mobileNo" id="mobile"/></td>
</tr>

<!-- <tr> -->
<!-- <td>Age</td> -->
<%-- <td><fo:input path="age" id="age"/></td> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- <td>Initial Balance</td> -->
<%-- <td><fo:input path="initialBalance" id="inibal"/></td> --%>
<!-- </tr> -->
<tr>
<td colspan="2"><input type="submit" value="Add Product"/></td>
</tr>
</fo:form>

</table>
</center>
</body>
</html>