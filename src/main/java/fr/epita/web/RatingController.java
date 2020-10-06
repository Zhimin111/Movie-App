package fr.epita.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.epita.datamodel.Rate;

@Controller
@RequestMapping("/rating")

public class RatingController {
		@GetMapping(value = "/list")
		public String  Recommendations(Model model) throws SQLException {
			List<Rate> rateList = new ArrayList<>();
			Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
			PreparedStatement pstmt = connection.prepareStatement("select * from rate");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Rate rate = new Rate();
				rate.setUserid(rs.getInt("userid"));
				rate.setCommenttitle(rs.getString("title"));
				rate.setCommentcontent(rs.getString("content"));
				rate.setRating(rs.getInt("rating"));
				rateList.add(rate);						
				model.addAttribute("ratesList", rateList);
				
			}
			return "rating";
			
			
			
		}
		
}
