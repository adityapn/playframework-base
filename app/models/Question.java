package models;

import java.util.Date;

import javax.persistence.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import play.db.ebean.Model;

@Entity
public class Question extends Model {
	
	@Id
	@SequenceGenerator(name = "question_id", sequenceName = "qid_seq")
	@GeneratedValue(generator = "question_id")
	public Long id;
	
	private String question;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")	
	private User user;

	@Column(name = "created_at")
	@CreatedTimestamp
	public Date createdAt;

	@Column(name = "updated_at")
	@UpdatedTimestamp
	public Date updatedAt;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@PreUpdate
	void updatedAt() {
		this.updatedAt = new Date();
	}
}
