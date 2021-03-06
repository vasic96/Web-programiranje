package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.SubDAO;
import dao.VideoDAO;
import dto.VideoDTO;
import model.Korisnik;
import model.Sub;
import model.Video;

/**
 * Servlet implementation class VideosServlet
 */
@WebServlet("/videos")
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		List<Video> videos = VideoDAO.getAll();
		Korisnik korisnik = (Korisnik) session.getAttribute("ulogovanKorisnik");
		
		
		List<VideoDTO> dtos  = videos.stream()
				.filter(video -> 
				!video.getKorisnik().isBlokiran() && !video.isBlokiran())
		.map(video ->{
			
			VideoDTO dto = new VideoDTO(video);
			if(korisnik != null) {
				dto.setSubscribed(SubDAO.subscribed(new Sub(korisnik.getUsername(),video.getKorisnik().getUsername())));
			}
			return dto;
			
		}).collect(Collectors.toList());
		
		if(korisnik != null)	
			System.out.println(korisnik.toString());
		String videosJson = gson.toJson(dtos);	
		response.setContentType("application/json");
		response.getWriter().write(videosJson);	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
