package input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class ProfileServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter con = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session!=null) {
			String name=(String)session.getAttribute("name");
			con.print("hello"+name+"Welcome to profile ");
			con.print("<form action='Logout' method=post>");
			con.print("<input type='submit' value=logout>");
			con.print("</form>");
			
		}else {
			con.print("plese login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		con.close();
	}

}
