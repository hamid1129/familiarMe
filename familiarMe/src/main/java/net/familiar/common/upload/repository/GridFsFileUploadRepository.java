package net.familiar.common.upload.repository;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@NoRepositoryBean
public interface GridFsFileUploadRepository {

	public GridFSDBFile findOne(Query query);

	public List<GridFSDBFile> find(Query query);

	public GridFSFile store(InputStream content, String filename);

	public GridFSFile store(InputStream content, String filename,
			DBObject metadata);
}
