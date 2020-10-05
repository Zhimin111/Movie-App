package fr.epita.web;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.epita.datamodel.Movie;

@Controller
@RequestMapping("/movies")
public class MoviesController {
//	
//	@Autowired
//	MyMovieDAO dao;
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from movies ");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("connection successful!");
		}
		
		connection.close();
	}
	
	
	
	@GetMapping(value = "/list")
	public String displaySeenMovies(Model model) throws SQLException{
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from seenmovies,movies");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Movie movie1 = new Movie();
			movie1.setMovieid(rs.getInt("sm_id"));
			movie1.setUserid(rs.getInt("su_id"));
			movie1.setSeendate(rs.getString("seendate"));
			movie1.setReleaseDate(rs.getString("releasedate"));
			movie1.setTitle(rs.getString("title"));
			
			model.addAttribute("moviesList", Arrays.asList(movie1));
					

		}
		
		return "movies";
		
	}
	
	@GetMapping(value = "/new")
	public String displayNewMovies(Model model) throws SQLException{
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from movies");
		pstmt.setFetchSize(5);
		ResultSet rs = pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			Movie movie1 = new Movie();
			movie1.setTitle(rs.getString("title"));
			movie1.setReleaseDate(rs.getString("releasedate"));
			movie1.setMovieid(rs.getInt("m_id"));
			

			model.addAttribute("moviesList", Arrays.asList(movie1));
			
		}
		
		return "movies";
		
		
	}
	
	/*@GetMapping(value ="/definition")
	public void Definition(Model model) throws SQLException{
		Driver driver = GraphDatabase.driver("bolt://localhost:7687", 
				AuthTokens.basic("neo4j", "root"));
		Session session = driver.session();
		Transaction tx = session.beginTransaction();

		Result rs = tx.run("match(m:Movie) return m.title,m.releaseDate,m.category,m.movieDirector");
		while(rs.hasNext()) {
			
			model.addAttribute("moviesList", Arrays.asList(rs.toString()));
			
		}
		}*/
		
	
	
	
		
	
	@GetMapping(value = "/recommendations")
	public static String Recommendations(Model model) throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from movies");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Movie movie1 = new Movie();
			movie1.setTitle(rs.getString("title"));
			movie1.setReleaseDate(rs.getString("releasedate"));
			movie1.setMovieid(rs.getInt("m_id"));
			

			
			model.addAttribute("moviesList", Arrays.asList(movie1));
			

		}
		
		return "movies";
		
	}
		
	

	

	
	
	
	
}
