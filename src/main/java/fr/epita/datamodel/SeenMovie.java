package fr.epita.datamodel;

import java.sql.Date;

public class SeenMovie {
	private Date date;
	public Movie movie;
	public User user;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
