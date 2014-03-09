package net.familiar.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import net.familiar.config.MongoConfigurationTest;
import net.familiar.domain.Question;
import net.familiar.domain.Question.QuestionBuiler;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * QuestionRepository integration tests
 * 
 * @author hamid
 * 
 */
public class QuestionRepositoryTest extends MongoConfigurationTest {
	@Autowired
	private QuestionRepository repository;

	@Test
	public void repositoryShouldNotBeNull() {
		assertThat(repository, not(nullValue()));
	}

	@Test
	public void saveQuestion() {

		Question savedQuestion = repository.save(dummyQuestion());

		assertThat(savedQuestion.getId(), not(nullValue()));
	}

	@Test
	public void findByTitle() {

		repository.save(dummyQuestion());
		Question findByTitle = repository.findByTitle("title");

		assertThat(findByTitle, not(nullValue()));
	}

	@After
	public void deleteAll() {
		repository.deleteAll();
	}

	private Question dummyQuestion() {
		return QuestionBuiler.newInstance().title("title").content("content")
				.build();
	}

}
