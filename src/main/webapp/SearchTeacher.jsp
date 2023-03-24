<%@page import="com.schoolmanage.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  Teacher t=em.find(Teacher.class,id);
  %>
  
   Id:<input type="text" value="<%=t.getId()%>" name="id" disabled>
   Name:<input type="text" value="<%=t.getName()%>" name="name" disabled>
   Subject:<input type="text" value="<%=t.getSubject()%>" name="subject" disabled>
   Salary:<input type="text" value="<%=t.getSalary()%>" name="salary" disabled>
   <a href="TeacherCrudOps.html">main bar</a>
</body>
</html>