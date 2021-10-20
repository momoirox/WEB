<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title> Registracija za posao. </title>
    </head>
<body>
    <h1><b>HTP. Unos nove registracije</b></h1>
    <!--  -->
    <form id="forma" action="RegistracijaServlet" method="POST">
    <table>
        <tr>
            <td>Broj registracije.</td>
            <td><input type="text" name="broj"></td>
        </tr>
        <tr>
            <td>Ime</td>
            <td><input type="text" name="ime"></td>
        </tr>
        <tr>
            <td>Prezime</td>
            <td><input type="text" name="prezime"></td>
        </tr>
        <tr>
            <td>Strucna sprema </td>
            <td><select name="combo">
                <option value="I">I</option>
                <option value="II">II</option>
                <option value="III">III</option>
                <option value="IV">IV</option>
            </select></td>
        </tr>
        <tr>
            <td>Zanimanje</td>
            <td><input type="text" name="zanimanje"></td>
        </tr>
        <tr>
            <td>Godiste</td>
            <td><input type="text" name="godiste"></td>
        </tr>
        <tr>
        	<td>Predji na JSP stranicu : </td>
            <td><input type="submit" value="jsp" /></td>
        </tr>
        
        
    </table>
</form>

       <c:if test="${not empty err}">
		<p style="color: red">${err}</p> 
	</c:if>     
       
</body>
</html>