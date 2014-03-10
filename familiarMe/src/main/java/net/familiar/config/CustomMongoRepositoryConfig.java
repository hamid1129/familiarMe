package net.familiar.config;

import net.familiar.common.upload.repository.GridFsFileUploadRepositoryImpl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = GridFsFileUploadRepositoryImpl.class)
public class CustomMongoRepositoryConfig {
}