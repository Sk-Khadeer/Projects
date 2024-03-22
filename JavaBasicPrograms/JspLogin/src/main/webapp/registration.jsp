<%@page import="java.sql.*" %>


<%!
String uname;
String upwd;
String uemail;
String umobile;

Connection con;
PreparedStatement pst;
ResultSet rs;

%>

<%
RequestDispatcher requestDispatcher=null;
try{
 uname=request.getParameter("uname");
 upwd=request.getParameter("upwd");
 uemail=request.getParameter("uemail");
 umobile=request.getParameter("umobile");
 session.setAttribute("operation", "Registration");
// session.setAttribute(uname,uname);
 Class.forName("com.mysql.cj.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944");
 pst=con.prepareStatement("select * from reg_Users where UNAME=? or UEMAIL=?");
 pst.setString(1,uname);
 pst.setString(2,uemail);
 rs=pst.executeQuery();
 boolean b=rs.next();
 
 if(b==true){
 	requestDispatcher=application.getRequestDispatcher("/existed.jsp");
 	requestDispatcher.forward(request, response);
 	}
 else{
 	pst=con.prepareStatement("insert into reg_Users values(?,?,?,?)");
 	pst.setString(1,uname);
 	pst.setString(2,upwd);
 	pst.setString(3,uemail);
 	pst.setString(4,umobile);
 	int rowCount=pst.executeUpdate();
 	if(rowCount==1){
 		requestDispatcher=application.getRequestDispatcher("/success.jsp");
    	requestDispatcher.forward(request, response);
    	}
    else{
    	requestDispatcher=application.getRequestDispatcher("/failure.jsp");
    	requestDispatcher.forward(request, response);
    }
 	}}
catch(Exception e){
	e.printStackTrace();
	try{
		requestDispatcher=application.getRequestDispatcher("/failure.jsp");
    	requestDispatcher.forward(request, response);
	}catch(Exception e1){
		e1.printStackTrace();
	}
	
}

%>