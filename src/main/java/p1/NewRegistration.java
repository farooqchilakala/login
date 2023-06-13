package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/New")//@Webservlet annotation it help us finding the form with back-end code of our  application.
public class NewRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Mobile = request.getParameter("Mobile");
		String City = request.getParameter("City");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/faru","root","farooq");
			System.out.println(con);
			Statement stmnt= con.createStatement();
			stmnt.executeUpdate("insert into faru values('"+Name+"','"+Email+"','"+Mobile+"','"+City+"',)");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
