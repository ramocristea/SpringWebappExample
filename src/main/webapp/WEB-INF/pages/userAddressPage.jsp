<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <!--provide an html table start tag -->
   <table style="border: 1px solid;">
   <!-- iterate over the collection using forEach loop -->
   <c:forEach var="address" items="${addresses}">
       <!-- create an html table row -->
       <tr>
       <!-- create cells of row -->
       <td>${address.id}</td>
       <td>${address.street}</td>
       <td>${address.city}</td>
       <td>${address.country}</td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
   <!-- close table -->
   </table>

</body>
</html>