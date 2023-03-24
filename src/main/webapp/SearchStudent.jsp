<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.schoolmanage.Student"%>
    <%@page import="javax.persistence.Persistence"%>
    <%@page import="javax.persistence.EntityManagerFactory"%>
    <%@page import="javax.persistence.EntityManager"%>
    <%@page import="java.io.PrintWriter"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

   String id1=request.getParameter("id");
   int id=Integer.parseInt(id1);
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("say");
   EntityManager em=emf.createEntityManager();
   Student s=em.find(Student.class,id);
%>
    
    
    Id:<input type="text" value="<%=s.getId()%>" name="id" disabled><br><br>
	Name:<input type="text" value="<%=s.getName()%>" name="name" disabled><br><br>
	Stream:<input type="text" value=<%=s.getStream()%> name="stream" disabled><br><br>
	Fees:<input type="text" value="<%=s.getFees()%>" name="fees" disabled><br><br>
	<a href="StudentCrudOps.html">main bar</a>
	
</body>
</html>