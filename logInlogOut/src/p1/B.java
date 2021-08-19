package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/b")
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public B() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		try {
String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mob = request.getParameter("mob");
			HttpSession ses = request.getSession(false);
			if(ses.getAttribute("sname")!=null){
				//System.out.println(mob);
			
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul", "root", "test");
		Statement cre= con.createStatement();
		cre.executeUpdate("insert into bench values(null,'"+name+"','"+mob+"')");
			RequestDispatcher rd = request.getRequestDispatcher("2nd.html");
			rd.include(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			e.printStackTrace();
			
		}
		
	}

}
