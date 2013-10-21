<%-- 
    Document   : logout
    Created on : Oct 10, 2013, 6:39:48 PM
    Author     : Kasun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%>