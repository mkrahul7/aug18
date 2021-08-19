package com.p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/B")
public class D extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public D() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String name= request.getParameter("fname");
		String city= request.getParameter("city");
		String mobile= request.getParameter("mobile");
		E d=new E();
		d.dconnection();
		d.statement(name,city,mobile);
		request.setAttribute("save","your useless record saved");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/reg.jsp");
		rd.include(request, response);
	}
	

}
