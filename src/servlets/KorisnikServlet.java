package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.KorisnikDAO;
import model.Korisnik;
import model.Korisnik.Uloga;

/**
 * Servlet implementation class KorisnikServlet
 */
@WebServlet("/korisnik")
public class KorisnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KorisnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String username = request.getParameter("username");
		String action = request.getParameter("action");
		if(action.equals("get")) {
			Korisnik korisnik = KorisnikDAO.getById(username);
			if(korisnik == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);	
			}
			String korisnikJson = gson.toJson(korisnik);
			response.setContentType("application/json");
			response.getWriter().write(korisnikJson);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String body = request.getReader().lines()
			    .reduce("", (accumulator, actual) -> accumulator + actual);
		Korisnik korisnik = gson.fromJson(body, Korisnik.class);
		korisnik.setBlokiran(false);
		korisnik.setUloga(Uloga.USER);
		korisnik.setDatumRegistracije(new Date());
		System.out.println(korisnik.toString());
		if(!KorisnikDAO.add(korisnik)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		response.setStatus(HttpServletResponse.SC_OK);
		
	}

}
