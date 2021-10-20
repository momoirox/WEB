package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class PretraziServlet
 */
@WebServlet("/PretraziServlet")
public class PretraziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PretraziServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String krit = request.getParameter("combo");
		System.out.println(krit);
		
		ArrayList<User> users = (ArrayList<User>)getServletContext().getAttribute("users");
		ArrayList<User> filteredUsers = new ArrayList<User>();
		
		for (User u : users) {
			if(u.getSprema().equals(krit)){
				filteredUsers.add(u);
			}
		}
		for (User u : filteredUsers) {
			System.out.println(u.getIme());
		}
		getServletContext().setAttribute("filteredUsers", filteredUsers);
		
		getServletContext().getRequestDispatcher("/filteredUsers.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
