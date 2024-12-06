package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/CandidateListServlet")
public class CandidateListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Candidate> list = new ArrayList<>();
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			list = candDao.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("background-color");
		out.printf("<body bgcolor = '%s' >",appTitle);
		
		Cookie[] arr = req.getCookies();
		String username = "",role = "";
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname")) {
					username = c.getValue();
				}
				if(c.getName().equals("role")) {
					role = c.getValue();
				}
			}
		}
		
		out.printf("Hello, %s (%s)<hr/>\n", username, role);
		
		out.printf("<form method='post' action ='vote'>");
		for (Candidate c : list) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s <br/>\n", c.getId(),c.getName());
		}
		out.println("<br/><input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
