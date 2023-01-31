package com.schoolmanage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/accountcreated")
public class AccountCreated extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String Id1=(String)req.getParameter("id");
		int Id=Integer.parseInt(Id1);
		String name=(String)req.getParameter("name");
		String age1=(String)req.getParameter("age");
		int age=Integer.parseInt(age1);
		String email=(String)req.getParameter("email");
		String contact1=(String)req.getParameter("contact");
		long contact=Long.parseLong(contact1);
		String password=(String)req.getParameter("password");
		String password1=(String)req.getParameter("password1");
		
		if(password.equals(password1))
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("say");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Query q=em.createQuery("select a from Principal a where email=?1");
			q.setParameter(1,email);
			List<Principal>l=q.getResultList();
			if(l.isEmpty())
			{
				Principal p=new Principal();
				p.setId(Id);
				p.setName(name);
				p.setAge(age);
				p.setEmail(email);
				p.setContact(contact);
				p.setPassword(password);
				
				et.begin();
				em.persist(p);
				et.commit();
				
				PrintWriter pw=res.getWriter();
				pw.write("Account created");
				RequestDispatcher rd=req.getRequestDispatcher("1File.html");
				rd.include(req,res);
				res.setContentType("text/html");
				
			}
			else
			{
				PrintWriter pw=res.getWriter();
				pw.write("email already exist");
				RequestDispatcher rd=req.getRequestDispatcher("File2.html");
				rd.include(req,res);
				res.setContentType("text/html");
			}
			
			
		}
		else
		{
			PrintWriter pw=res.getWriter();
			pw.write("password doesn't matches");
			RequestDispatcher rd=req.getRequestDispatcher("File2.html");
			rd.include(req,res);
			res.setContentType("text/html");
			
		}
		
	    	
	}

}

