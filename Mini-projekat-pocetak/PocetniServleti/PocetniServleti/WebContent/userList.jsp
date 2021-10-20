<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled korisnika</title>
</head>
<body>
	<table id="userList" border="1">
			<tr>
	            <th>Broj registracije </th>
	            <th>Ime </th>
	            <th>Prezime </th>
	            <th>Strucna sprema</th>
	            <th>Zanimanje</th>
	            <th>Godiste</th>
	            <th>...</th>
	           
            </tr>
       <c:forEach var="u" items="${users}">
       	<c:choose>
	       	<c:when test="${u.getOdobreno().equals(false)}">
	       		<tr bgcolor="#ff4000">     	
	       	</c:when>
	       	<c:otherwise>
	       		<tr bgcolor="#bfff00">
	       	</c:otherwise>
       	</c:choose>
		       	<td><c:out value = "${u.getBroj()}"/></td>
		       	<td><c:out value = "${u.getIme()}"/></td>
		       	<td><c:out value = "${u.getPrezime()}"/></td>
		       	<td><c:out value = "${u.getSprema()}"/></td>
		       	<td><c:out value = "${u.getZanimanje()}"/></td>
		       	<td><c:out value = "${u.getGodiste()}"/></td>
		     	<c:choose>
		       		<c:when test="${u.getOdobreno().equals(true)}">
		       			<td></td>
		       		</c:when>
		       		<c:otherwise>
   						<td><a href ="PrihvatiServlet?broj=${ u.getBroj() }"> Prihvati </a></td>
  					</c:otherwise>
		       	</c:choose>
		       	
       
       </c:forEach>
       
  </table>
  <p>Izaberite strucnu spremu</p>
   <form action="PretraziServlet" method="get">
  <select name="combo" >
                <option value="I">I</option>
                <option value="II">II</option>
                <option value="III">III</option>
                <option value="IV">IV</option>
            </select><br>

  <input type="submit" value="Pretrazi" />
  </form>
  
</body>
</html>