package fr.epita.web;

import java.sql.SQLException;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rating")

public class RatingController {
	@GetMapping(value = "/list")
	public Result displayMovies(Model model) throws SQLException{
		
		Driver driver = GraphDatabase.driver("bolt://localhost:7687", 
				AuthTokens.basic("neo4j", "root"));
		Session session = driver.session();
		Transaction tx = session.beginTransaction();

		
		Result result = tx.run("match (m:Movie) return m.title,m.releaseDate,m.category,m.movieDirector");
		
		return result;
		
}
}
