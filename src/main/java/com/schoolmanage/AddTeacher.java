package com.schoolmanage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ateacher")
public class AddTeacher extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String id2=req.getParameter("id");
		int id=Integer.parseInt(id2);
		String name=req.getParameter("name");
		String sub=req.getParameter("subject");
		String sal1=req.getParameter("salary");
		int sal=Integer.parseInt(sal1);
		
		
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("say");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	 Teacher t=new Teacher();
	 t.setId(id);
	 t.setName(name);
	 t.setSubject(sub);
	 t.setSalary(sal);
	 
	 et.begin();
	 em.persist(t);
	 et.commit();
	 
	PrintWriter pw=res.getWriter();
	pw.write("Teacher successfully added");
	
	RequestDispatcher rd=req.getRequestDispatcher("TeacherCrudOps.html");
	rd.include(req,res);
	res.setContentType("text/html");
	
}
}

