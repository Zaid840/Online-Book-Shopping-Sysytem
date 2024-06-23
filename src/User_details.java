import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
		
@WebServlet("/DetailsServlet")
public class User_details extends HttpServlet {
	
	Random rand=new Random();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String btn=req.getParameter("btn");
		HttpSession s1=req.getSession();
		String bId=(String)s1.getAttribute("bkid");
		int qnt=Integer.parseInt(req.getParameter("quantity"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shopping","root","Zaid1234");
			
			PreparedStatement pm=con.prepareStatement("select * from Books where Books_Id=?");
			pm.setString(1, bId);
			
			ResultSet r1=pm.executeQuery();
			
			int rId=rand.nextInt(100000);
			s1.setAttribute("UserResultSet", r1);
			s1.setAttribute("random", rId);
			
			if(btn.equals("Purchase"))
			{
				s1.setAttribute("qnt", qnt);
				resp.sendRedirect("UserDetails.jsp");
			}
			else
			{
				resp.sendRedirect("Starting.jsp");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
