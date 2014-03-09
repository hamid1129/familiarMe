package net.familiar.config;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MongoConfiguration.class)
public class MongoConfigurationTest extends AbstractConfigurationTest {
	@Autowired
	protected MongoTemplate template;

	@Test
	public void mongoTemplateShouldNotBeNull() {
		assertThat(template, not(nullValue()));
	}
}
