package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String candId = req.getParameter("candidate");
		int id = Integer.parseInt(candId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>result</title>");
		out.println("</head>");
		out.println("<body>");
		
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
		
		out.println("<h2>Voting Status</h2>");
		try(CandidateDao candDao = new CandidateDaoImpl()){
			int count = candDao.castVote(id);
			if(count == 1) {
				out.println("<h4>you have successfully casted your vote. </h4>");
			}
			else {
				out.println("<h4>your voting failed.<h4>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
