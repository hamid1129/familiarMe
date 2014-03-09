/**
 * 
 */
package net.familiar.domain;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hamid
 * 
 */
@Document
public class Question extends AbstractDocument<String> {

	private String title;

	private String content;

	private int score;

	private String category;

	private boolean ownerVisible;
	@CreatedDate
	private DateTime createdAt;

	@CreatedBy
	private User createdBy;

	private double[] askedLocation;
	private double[] asnwerLocation;

	private List<Answer> answers;

	// TODO refactor this horrible constructor
	@PersistenceConstructor
	public Question(String title, String content, int score, String category,
			boolean ownerVisible, DateTime createdAt, User createdBy,
			double[] askedLocation, double[] asnwerLocation,
			List<Answer> answers) {
		this.title = title;
		this.content = content;
		this.score = score;
		this.category = category;
		this.ownerVisible = ownerVisible;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.askedLocation = askedLocation;
		this.asnwerLocation = asnwerLocation;
		this.answers = answers;
	}

	public Question(QuestionBuiler questionBuiler) {
		this.title = questionBuiler._title;
		this.content = questionBuiler._content;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isOwnerVisible() {
		return ownerVisible;
	}

	public void setOwnerVisible(boolean ownerVisible) {
		this.ownerVisible = ownerVisible;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public double[] getAskedLocation() {
		return askedLocation;
	}

	public void setAskedLocation(double[] askedLocation) {
		this.askedLocation = askedLocation;
	}

	public double[] getAsnwerLocation() {
		return asnwerLocation;
	}

	public void setAsnwerLocation(double[] asnwerLocation) {
		this.asnwerLocation = asnwerLocation;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public static class QuestionBuiler {
		private String _title;
		private String _content;

		private QuestionBuiler() {
		}

		public static QuestionBuiler newInstance() {
			return new QuestionBuiler();
		}

		public QuestionBuiler title(String title) {
			this._title = title;
			return this;
		}

		public QuestionBuiler content(String content) {
			this._content = content;
			return this;
		}

		public Question build() {
			return new Question(this);
		}
	}

}
