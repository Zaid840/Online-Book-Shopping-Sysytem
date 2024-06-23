import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;
@WebServlet("/WelcomeServlet")
public class Welcome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("Books_Id");
		
		System.out.println(id+" ");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shopping","root","Zaid1234");
			System.out.println("Connection Success");
			
			String s="select * from books";
			PreparedStatement stm=con.prepareStatement(s);
			ResultSet rs=stm.executeQuery();
			
			HttpSession session=req.getSession();
			session.setAttribute("resultset", rs);
			
			resp.sendRedirect("Welcome_jp.jsp");
			
			
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
