package input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response .setContentType("text/html");
		PrintWriter con = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession();
		session.invalidate();
		con.print("you are sucessfully loged out!");
		con.close();
	}

}
