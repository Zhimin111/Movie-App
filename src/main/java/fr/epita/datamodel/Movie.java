package fr.epita.datamodel;

public class Movie {
	
	private String title;
	private String releaseDate;
	private String category;
	private String movieDirecter;
	private String rating;
	private String commentTitle;
	private String commentContent;
	private Integer movieid;
	private Integer userid;
	private String seendate;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMovieDirecter() {
		return movieDirecter;
	}
	public void setMovieDirecter(String movieDirecter) {
		this.movieDirecter = movieDirecter;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getMovieid() {
		return movieid;
	}
	
	public void setMovieid(int movieid) {
		this.movieid = movieid;
		
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSeendate() {
		return seendate;
	}
	public void setSeendate(String seendate) {
		this.seendate = seendate;
	}
	
	


}
