<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.schoolmanage.Student"%>
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
EntityManagerFactory emf = Persistence.createEntityManagerFactory("say");
EntityManager  em =emf.createEntityManager(); 
Query q=em.createQuery("select b from Student b");
List<Student>l=q.getResultList();
%>
<h2>Student Data</h2>
<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Stream</th>
<th>Fees</th>
</tr>
<%
for(Student s:l)
{
%>
<tr>
<th><%=s.getId()%></th>
<th><%=s.getName()%></th>
<th><%=s.getStream()%></th>
<th><%=s.getFees()%></th>
</tr>
<%
}
%>
</table>
<a href="StudentCrudOps.html">Main bar</a>
</body>
</html>