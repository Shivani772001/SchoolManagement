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
@WebServlet("/reteacher")
public class RemoveTeacher extends HttpServlet
{
	@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	String id1=req.getParameter("id");
	int id=Integer.parseInt(id1);
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("say");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Teacher t=em.find(Teacher.class,id);
	
	if(t!=null) 
	{
	et.begin();
	em.remove(t);
	et.commit();
	PrintWriter pw=res.getWriter();
	pw.write("successfully removed");
	 
	RequestDispatcher rd=req.getRequestDispatcher("TeacherCrudOps.html");
	rd.include(req,res);
	res.setContentType("text/html");
	}
	else
	{
		PrintWriter pw=res.getWriter();
		pw.write("Id not found");
		RequestDispatcher rd=req.getRequestDispatcher("TeacherCrudOps.html");
		rd.include(req,res);
		res.setContentType("text/html");
	}
	
}
}
