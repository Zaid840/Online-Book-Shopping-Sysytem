import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThankServlet")
public class Thanks extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String btn=req.getParameter("UserButton");
			String cname=req.getParameter("CName");
			String add=req.getParameter("Add");
			String mob=req.getParameter("PhNo");
			
			HttpSession s1=req.getSession();
			int rid=(int)s1.getAttribute("random");
			int qnt=(int)s1.getAttribute("qnt");
			String bld=(String)s1.getAttribute("UserBookId");
			
			Date date=new Date();
			SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
			String dat=formatter.format(date);
			
			if(btn.equals("Confirm"))
			{
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Book_Shopping","root","Zaid1234");
						PreparedStatement pm=con.prepareStatement("insert into Order_Details values(?,?,?,?,?,?,?)");
						pm.setInt(1, rid);
						pm.setString(2, cname);
						pm.setString(3, mob);
						pm.setString(4, add);
						pm.setInt(5,qnt);
						pm.setString(6, bld );
						pm.setString(7, dat);
						
						int c=pm.executeUpdate();
						
						if(c!=0)
						{
							resp.sendRedirect("ThankYou.jsp");
						}
						else
						{
							resp.sendRedirect("Error.jsp");
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

}
