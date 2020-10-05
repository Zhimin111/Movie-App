package fr.epita.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPG {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.13:10532/MOVIES", "postgres","postgres");
		PreparedStatement pstmt = connection.prepareStatement("select * from movies ");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs);
		}
		
		connection.close();
	}
	
}
