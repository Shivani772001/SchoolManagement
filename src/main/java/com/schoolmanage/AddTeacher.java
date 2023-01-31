package com.schoolmanage;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AddTeacher extends HttpServlet 
{
	@Override
	protected void doPost(HttpServlet req,HttpServlet res)throws ServletException,IOException
	{
		
	}
	
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("say");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	String id=req.getParameter("id");
	
}
}
