<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.Query"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.persistence.EntityManagerFactory"%>
    <%@page import="javax.persistence.EntityManager"%>
    <%@page import="java.io.PrintWriter"%>
    <%@page import="com.schoolmanage.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("say");
  EntityManager em = emf.createEntityManager(); 
  Query q=em.createQuery("select a from Teacher a");
  List<Teacher>l=q.getResultList();
%>
  <h2>Teacher Data</h2>
  <table border="2px">
  <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Subject</th>
   <th>Salary</th>
  </tr>
   
  <%for(Teacher t:l)
  {
  %>
  <tr>
  <td><%=t.getId()%></td>
  <td><%=t.getName()%></td>
  <td><%=t.getSubject()%></td>
  <td><%=t.getSalary()%></td>
  </tr>
   <% }%>
   </table>
</body>
</html>