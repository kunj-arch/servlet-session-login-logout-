package input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServ extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter con = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		
		if (Password.equals("ooo")) {
			con.print("welcome"+Name);
			HttpSession session=request.getSession();
			session.setAttribute("name", Name);
			con.print("<form action='ProfileServ' method=post>");
			con.print("<input type='submit' value=profile>");
			con.print("</form>");
			
		} else {
			con.print("soory user name or password error plese enter corect information !");
			request.getRequestDispatcher("login.html").include(request, response);

		}
		con.close();
		
	}

}
