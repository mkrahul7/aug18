package com.miniPractice;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Showserv")
public class Showserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Showserv() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Model a= new Model();
		a.connctor2();
		ResultSet b = a.get() ;
		request.setAttribute("result", b);
		RequestDispatcher re = request.getRequestDispatcher("seeresult.jsp");
		re.forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
