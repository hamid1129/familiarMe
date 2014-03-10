package net.familiar.common.upload.repository;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Repository
public class GridFsFileUploadRepositoryImpl implements
		GridFsFileUploadRepository {

	@Autowired
	private GridFsOperations gOperations;

	@Override
	public GridFSDBFile findOne(Query query) {

		return gOperations.findOne(query);
	}

	@Override
	public List<GridFSDBFile> find(Query query) {

		return gOperations.find(query);
	}

	@Override
	public GridFSFile store(InputStream content, String filename) {
		return store(content, filename, null);
	}

	@Override
	public GridFSFile store(InputStream content, String filename,
			DBObject metadata) {

		if (metadata != null) {
			return gOperations.store(content, filename, metadata);
		}
		return gOperations.store(content, filename);
	}

}