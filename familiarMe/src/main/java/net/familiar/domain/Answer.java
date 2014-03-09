package net.familiar.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

public class Answer extends AbstractDocument<String> {

	@CreatedDate
	private DateTime createdDate;

	@CreatedBy
	private User createdBy;

	private String content;

	private int score;

	private boolean accept;

	public Answer(DateTime createdDate, User createdBy, String content,
			int score, boolean accept) {
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.content = content;
		this.score = score;
		this.accept = accept;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

}
