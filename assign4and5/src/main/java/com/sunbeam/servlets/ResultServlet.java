package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	
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
		out.println("<title>Result</title>");
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
		
		out.println("<h2>Result<h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(Candidate c : list) {
		out.println("<tr>");
		out.printf("<td>%d</td>\n", c.getId());
		out.printf("<td>%s</td>\n", c.getName());
		out.printf("<td>%s</td>\n", c.getParty());
		out.printf("<td>%d</td>\n", c.getVotes());
		out.printf("<td></td>\n");
		out.printf("<td>\n");
		out.printf("<a href='editcand?id=%d'><img src='image/edit.png' alt='edit' height='18' width='18'></img></a>\n", c.getId());
		out.printf("<a href='delcand?id=%d'><img src='image/delete.png' alt='delete' height='24' width='18'></a>\n", c.getId());
		out.printf("</td>\n");
		out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		String message = (String) req.getAttribute("msg");
		if(message != null) {
			out.printf("<p>" + message + "</p>");
		}
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("<a href='newcandidate.html' >new candidate</a>");
		out.println("</body>");
		out.println("</html>");
	}

}