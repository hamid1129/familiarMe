package net.familiar.config;

import net.familiar.repository.QuestionRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackageClasses = QuestionRepository.class)
@EnableMongoAuditing
@Import(CustomMongoRepositoryConfig.class)
public class MongoConfiguration extends AbstractMongoConfiguration {
	private static final String DATABASE_NAME = "familiarMe";

	@Override
	protected String getDatabaseName() {
		return DATABASE_NAME;
	}

	@Override
	public Mongo mongo() throws Exception {

		MongoClient mongo = new MongoClient();
		return mongo;

	}

	@Bean
	public GridFsOperations gridFsOperations() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

}
