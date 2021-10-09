package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		String name= request.getParameter("name");
		String pw= request.getParameter("pw");
		try {
			//this is try catch block
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roc", "root", "test");
			Statement cr= con.createStatement();
			ResultSet rr = cr.executeQuery("select * from rocs where nama='"+name+"' and mob='"+pw+"'");
			if(rr.next()) {
				HttpSession ses= request.getSession();
				ses.setAttribute("sname", name);
				RequestDispatcher rd= request.getRequestDispatcher("2nd.html");
				rd.forward(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
