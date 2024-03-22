<%@page import="java.sql.*" %>

<%!
String uname;
String upwd;

Connection con;
PreparedStatement pst;
ResultSet rs;
%>

<%
try{
	String uname=request.getParameter("uname");
	String upwd=request.getParameter("upwd");
	session.setAttribute("operation","Login");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944");
    pst =con.prepareStatement("select * from reg_Users where uname=? and upwd= ?");
    pst.setString(1,uname);
    pst.setString(2,upwd);
    rs=pst.executeQuery();
    boolean b=rs.next();
    RequestDispatcher requestDispatcher=null;
    if(b==true){
    	requestDispatcher=application.getRequestDispatcher("/success.jsp");
    	requestDispatcher.forward(request, response);
    	}
    else{
    	requestDispatcher=application.getRequestDispatcher("/failure.jsp");
    	requestDispatcher.forward(request, response);
    }
}
catch(Exception e){
	e.printStackTrace();
}

%>