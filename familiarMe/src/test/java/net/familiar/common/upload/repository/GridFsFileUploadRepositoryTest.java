package net.familiar.common.upload.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereMetaData;

import java.io.IOException;

import net.familiar.config.MongoConfigurationTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

public class GridFsFileUploadRepositoryTest extends MongoConfigurationTest {
	@Autowired
	private GridFsFileUploadRepository repository;

	Resource resource = new ClassPathResource("log4j.xml");

	@Test
	public void girdFsRepository() {
		assertThat(repository, not(nullValue()));
	}

	@Test
	public void storeFileInDB() throws IOException {
		repository.store(resource.getInputStream(), "log4j.xml");
	}

	@Test
	public void findFile() throws IOException {
		BasicDBObject metadata = new BasicDBObject("foo", "bar");

		GridFSFile store = repository.store(resource.getInputStream(),
				"log4j.xml", metadata);

		GridFSDBFile findOne = repository.findOne(query(whereMetaData("foo")
				.is("bar")));

		assertEquals(findOne.getMD5(), store.getMD5());

	}
}
