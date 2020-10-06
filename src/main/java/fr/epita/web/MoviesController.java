package fr.epita.web;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.epita.datamodel.Movie;

@Controller
@RequestMapping("/movies")
public class MoviesController {

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
		List<Movie> movieList = new ArrayList<>();
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
			movieList.add(movie1);			
			model.addAttribute("moviesList",movieList);
					

		}
		
		return "movies";
		
	}
	
	@GetMapping(value = "/new")
	public String displayNewMovies(Model model) throws SQLException{
		List<Movie> movieList = new ArrayList<>();
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from newmovies");
	
		ResultSet rs = pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			Movie movie1 = new Movie();
			movie1.setTitle(rs.getString("title"));
			movie1.setReleaseDate(rs.getString("releasedate"));
			
			movieList.add(movie1);
			

			model.addAttribute("moviesList", movieList);
			
		}
		
		return "movies";
		
		
	}
	
	
	
		
	
	@GetMapping(value = "/recommendations")
	public static String Recommendations(Model model) throws SQLException {
		List<Movie> movieList = new ArrayList<>();

		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from bestmovies");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Movie movie1 = new Movie();
			movie1.setTitle(rs.getString("title"));
			movie1.setReleaseDate(rs.getString("releasedate"));
			
			movieList.add(movie1);
						
			model.addAttribute("moviesList", Arrays.asList(movie1));
			

		}
		
		return "movies";
		
	}
	
		
	

	

	
	
	
	
}
