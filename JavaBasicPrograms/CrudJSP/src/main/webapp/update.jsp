<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "sreedar";
String userid = "root";
String password = "khadeer@944";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from user where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body align="center">
<h1>Update data from database in jsp</h1>
<form method="post" action="update-process.jsp">

<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
ID:<input type="text" name="id" value="<%=resultSet.getString("id") %>"><br><br>
First name:<input type="text" name="first_name" value="<%=resultSet.getString("first_name") %>"><br><br>
Last name:<input type="text" name="last_name" value="<%=resultSet.getString("last_name") %>"><br><br>
City name:<input type="text" name="city_name" value="<%=resultSet.getString("city_name") %>"><br><br>
Email Id:<input type="email" name="email" value="<%=resultSet.getString("email") %>"><br><br>
Mobile No:<input type="number" name="mobileno" value="<%=resultSet.getString("mobileno") %>">
<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>