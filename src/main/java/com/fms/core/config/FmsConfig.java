package com.fms.core.config;

import com.fms.core.repository.CategoryDocTypeRepository;
import com.fms.core.repository.DocumentRepository;
import com.fms.core.repository.UploadCategoryRepository;


public interface FmsConfig {

    DocumentRepository getDocumentRepository();

    CategoryDocTypeRepository getCategoryDocTypeRepository();

    UploadCategoryRepository getUploadCategoryRepository();

    String getRootFolder();

}
