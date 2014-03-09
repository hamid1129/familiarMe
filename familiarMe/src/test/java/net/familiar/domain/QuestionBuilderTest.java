package net.familiar.domain;

import static org.junit.Assert.*;
import net.familiar.domain.Question.QuestionBuiler;

import org.junit.Test;

public class QuestionBuilderTest {

	@Test
	public void test() {
		Question question = QuestionBuiler.newInstance().title("title")
				.content("content").build();

		assertEquals("title", question.getTitle());
		assertEquals("content", question.getContent());

	}

}
