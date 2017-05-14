package fr.jcjTeam.theSocialNetwork.beans;

import java.sql.Timestamp;
import java.text.DateFormat;

public class Message {

	private Long id;
	private String title;
	private String content;
	private User author;
	private Timestamp creationDate;
	private Timestamp updateDate;
	private Status status;
	
	public Message(Long id, User author, Timestamp creationDate){
		this.id = id;
		this.author = author;
		this.creationDate = creationDate;
		this.updateDate = creationDate;
		this.title = "";
		this.content = "";
		this.status = Status.PUBLIC;
	}
	
	public Message(Long id, String title, String content, User author, Timestamp creationDate, Timestamp updateDate, Status status){
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getAuthor() {
		return author;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public String getUpdateDate() {
		return toCleanDate(updateDate);
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	private String toCleanDate(Timestamp date){
		return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date);
	}

}
