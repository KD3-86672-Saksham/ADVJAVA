package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class ProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("myInfo");
		out.println("</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<h1>Saksham Katyal</h1>");
		out.println("<h2>Btech in ECE</h2>");
		out.println("<h2>MSIT</h2>");
		out.println("<h2>01/01/2001</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
