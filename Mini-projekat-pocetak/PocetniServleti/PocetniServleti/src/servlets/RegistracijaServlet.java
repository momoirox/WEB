package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.User;
/**
 * Servlet implementation class RegistracijaServlet
 */
@WebServlet("/RegistracijaServlet")
public class RegistracijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	   public RegistracijaServlet() {
		   super();
	   }
	
    public void init() throws ServletException {
        super.init();
        ArrayList<User> users = new ArrayList<User>();
    	users.add(new User("111_AA", "Aleksandra", "Jovanovic", "III", "Hemijski laborant", 1995));
        users.add(new User("111_BB", "Nikola", "Nikodijevic", "III", "Masinski laborant", 1985));
        getServletContext().setAttribute("users", users);
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("reg.jsp"); //RequestDispatcher nam sluzi da preusmjerimo korisnika na
    	disp.forward(request, response);										// neku drugu stranicu a da korisnik nije svjestan tog preusmjeravanja.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String broj = request.getParameter("broj");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String sprema = request.getParameter("combo");
		String zanimanje = request.getParameter("zanimanje");
		String god = request.getParameter("godiste");
		int godiste = Integer.parseInt(god);
		
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
		
		if(!isValid(broj)) {
			request.setAttribute("err", "Broj registracije mora biti u formi 000_XX!"); //Error mi je nad request scope-om
    		doGet(request,response);
    		return;
		}
		
		if(isBrojUnique(broj,users)) {
			
			users.add(new User(broj,ime,prezime,sprema,zanimanje,godiste));
			getServletContext().setAttribute("users",users);
			getServletContext().getRequestDispatcher("/UserListServlet").forward(request, response);
		
		}else {
			
			System.out.println("Nije jedinstven broj! ");
			request.setAttribute("err", "Regostracija vec kreirana!"); //Error mi je nad request scope-om
    		doGet(request,response);
    		return;
		}
	}
	public Integer parseIntOrNull(String value) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return null;
	    }
	}

	private boolean isValid(String broj) {
		
			broj = broj.trim();
		if(!broj.contains("_")) {
			return false;
		}
		  String[] tokens = broj.split("_");
		  String first = tokens[0];
		  String second = tokens[1];
		 
		  if(first.length()!=3) {
			  return false;
		  }
		  if(parseIntOrNull(first) == null) {
			  return false;
		  }
		  if(second.length()!=2) {
			  return false;
		  }
		  return true;
		 
	}

	private boolean isBrojUnique(String broj, ArrayList<User> users) {
		for (User u : users) {
			if(u.getBroj().equals(broj)) {
				return false;
			}
		}
		return true;
	}
}
