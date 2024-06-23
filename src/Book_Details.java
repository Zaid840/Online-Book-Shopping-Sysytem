import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/UserServlet")
public class Book_Details extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s1=req.getSession();

		
		String bld=(String)s1.getAttribute("bkid");
		System.out.println(bld);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Book_Shopping","root","Zaid1234");
			
			PreparedStatement pm=con.prepareStatement("select * from Books where Books_Id=?");
			pm.setString(1, bld);
			
			ResultSet r1=pm.executeQuery();
			
			s1.setAttribute("resultset1", r1);
			
			
			resp.sendRedirect("Book_Details.jsp");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
