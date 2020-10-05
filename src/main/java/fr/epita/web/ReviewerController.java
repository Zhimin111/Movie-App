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

import fr.epita.datamodel.User;

@Controller
@RequestMapping("/reviewers")
public class ReviewerController {

	
	@GetMapping(value = "/list")
	public String listReviewers(Model model) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from users,contact");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setUserid(rs.getInt("u_id"));
			user.setBirthday(rs.getString("birthday"));
			
			model.addAttribute("reviewersList", Arrays.asList(user));
					
	}
		return "reviewers";
		
	}
	
	
	
}
