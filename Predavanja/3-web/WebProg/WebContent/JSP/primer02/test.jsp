<html>
<head>
<title>JSP skriptleti</title>
</head>
<style type="text/css">
table, td, th {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<body>

<h3>Primer JSP skriptleta</h3>

<table>
<tr>
  <th>R.br.</th>
  <th>Ime</th>
</tr>
<%
 String names[] = { "Bata", "Pera", "Mika", "Laza", "Sima" };
for (int i = 0; i < names.length; i++) {
%>
<tr>
  <td><%= i+1 %></td>
  <td><%= names[i] %></td>
</tr>
<% } %>
</table>

<p><a href="../index.html">Nazad</a></p>

</body>
</html>