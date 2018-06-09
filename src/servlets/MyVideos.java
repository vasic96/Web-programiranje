package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.VideoDAO;
import dto.VideoDTO;
import model.Korisnik;
import model.Video;

/**
 * Servlet implementation class MyVideos
 */
@WebServlet("/my-videos")
public class MyVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyVideos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Korisnik korisnik = (Korisnik) session.getAttribute("ulogovanKorisnik");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		List<Video> videos = VideoDAO.getAllByKorisnikUsername(korisnik.getUsername());
		List<VideoDTO> dtos = videos.stream()
				.map(video -> new VideoDTO(video)).collect(Collectors.toList());
		
		String videosJSon = gson.toJson(dtos);
		response.setContentType("application/json");
		response.getWriter().write(videosJSon);
		response.setStatus(200);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
