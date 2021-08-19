package com.p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.p2.B;
@WebServlet("/A")
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public A() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String name = request.getParameter("name");
		String mob = request.getParameter("pw");
		B v=new B();
		v.connect();
		boolean retur = v.verify(name, mob);
		if (retur==true) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/reg.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("invalid","invalid da comali");
			RequestDispatcher requ = request.getRequestDispatcher("log.jsp");
			requ.forward(request, response);
		}
	}

}
