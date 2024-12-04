package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		Date date = Date.valueOf(req.getParameter("dob"));
		
		try(UserDao userDao = new UserDaoImpl()){
			User usr = new User(0,fname,lname,email,password,date,0,"voter");
			userDao.save(usr);
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>success</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>registered</h1>");
			out.println("<a href='index.html' >Login</a>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
