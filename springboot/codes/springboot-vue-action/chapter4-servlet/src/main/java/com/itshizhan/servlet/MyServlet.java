package com.itshizhan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("name>>>"+name);
		resp.setContentType("text/html");
	  PrintWriter out = resp.getWriter();
		out.println("<h1>");
	  out.println("hello servlet");
		out.println("</h1>");
		out.println("<p> the request parameter is:" + name +"</p>");
		out.flush();
		out.close();
	}

}
