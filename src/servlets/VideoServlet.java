package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.KorisnikDAO;
import dao.VideoDAO;
import dto.VideoDTO;
import model.Korisnik;
import model.Video;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet("/video")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		int videoId = Integer.parseInt(request.getParameter("video_id"));
		String action = request.getParameter("action");
		System.out.println(action + "  " + videoId);
		if(action.equals("get")) {
			Video video = VideoDAO.getVideo(videoId);
			if(video == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);	
			} 
			VideoDAO.incrementViews(videoId);
			String videoJson = gson.toJson(new VideoDTO(video));
			response.setContentType("application/json");
			response.getWriter().write(videoJson);
		} else if(action.equals("delete")) {
			
			if(!VideoDAO.deleteVideo(videoId)) {
				
				response.sendError(HttpServletResponse.SC_NOT_FOUND);	

			}
			response.setStatus(HttpServletResponse.SC_OK);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Korisnik korisnik = (Korisnik) session.getAttribute("ulogovanKorisnik");
		if(korisnik == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		if(korisnik.isBlokiran()) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String body = request.getReader().lines()
			    .reduce("", (accumulator, actual) -> accumulator + actual);
		System.out.println(body);
		VideoDTO videoDTO = gson.fromJson(body, VideoDTO.class);
		Video video = new Video();
		video.setNaziv(videoDTO.getNaziv());
		video.setUrl(convertUrl(videoDTO.getUrl()));
		video.setOpis(videoDTO.getOpis());
		video.setDozvoljeniKomentari(videoDTO.isDozvoljeniKomentari());
		video.setVidljivostRejtinga(videoDTO.isVidljivostRejtinga());
		video.setBlokiran(false);
		video.setBrojPregleda(0);
		video.setDatumKreiranja(new Date());
		video.setKorisnik(korisnik);
		System.out.println(video.toString());
		
		if(!VideoDAO.saveVideo(video)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		response.setStatus(HttpServletResponse.SC_OK);
		
		
	}
	
	public static String convertUrl(String ytUrl) {
		
		String[] urls = ytUrl.split("=");
		String videoId = urls[1];
		return "https://www.youtube.com/embed/" + videoId;
	}

	

}
