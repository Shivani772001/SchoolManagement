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
@WebServlet("/addstud")
public class AddStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
      String id1=req.getParameter("id");
      int id=Integer.parseInt(id1);
      String name=req.getParameter("name");
      String stream=req.getParameter("stream");
      String fees1=req.getParameter("fees");
      int fees=Integer.parseInt(fees1);
      
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("say");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  Student s=new Student();
	  s.setId(id);
	  s.setName(name);
	  s.setStream("stream");
	  s.setFees(fees);
	  
	  et.begin();
	  em.persist(s);
	  et.commit();
	  
	  
	  PrintWriter pw=res.getWriter();
	  pw.write("add student successfully");
	  RequestDispatcher rd=req.getRequestDispatcher("StudentCrudOps.html");
	  rd.include(req,res);
	  res.setContentType("text/html");
	  
	 
	}
}
