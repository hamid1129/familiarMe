package net.familiar.repository;

import net.familiar.domain.Question;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
	Question findByTitle(String title);
}
