package com.cg.search.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class SearchFunc extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException{
response.setContentType("text/html"); 
HttpSession session = request.getSession(true);
List list=new ArrayList();
Connection con = null;

String url = "jdbc:mysql://localhost:3306/";
String db = "searchbook";
String driver = "com.mysql.jdbc.Driver";
String user = "root";
String pass = "";

String productcode="";
String category="";
productcode=request.getParameter("productcode");
category=request.getParameter("categories");
String sqlqueary="SELECT * FROM product WHERE product_name LIKE '%%' ";
if(productcode!=null && !(productcode.equals(""))){
sqlqueary+=" and isbn_code='"+productcode+"'";
}
if(category!=null && !(category.equals("-1"))){
sqlqueary+=" and category='"+category+"'";
}

try{
Class.forName(driver);
con = DriverManager.getConnection(url+db, user, pass);
try{
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sqlqueary);
while (rs.next()) {
List book=new ArrayList();
book.add(rs.getInt(1));
book.add(rs.getInt(2));
book.add(rs.getString(3));
book.add(rs.getString(4));
list.add(book);
}
}catch (SQLException s){
System.out.println("SQL statement is not executed!");
}
}
catch (Exception e){
e.printStackTrace();
}
request.setAttribute("list",list); 
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/search11.jsp");
dispatcher.forward(request, response); 
}

}