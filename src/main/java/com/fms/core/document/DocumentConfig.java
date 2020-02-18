package com.fms.core.document;

import com.fms.core.config.FmsConfig;
import com.fms.core.model.DocumentModel;
import com.fms.core.repository.CategoryDocTypeRepository;
import com.fms.core.repository.DocumentRepository;
import com.fms.core.common.Builder;
import com.fms.core.common.TwoTrack;
import java.util.function.Function;


@SuppressWarnings("all")
public class DocumentConfig {

    private FmsConfig fmsConfig;
    private Function<DocumentModel, TwoTrack<DocumentModel>> fileWriter;

    public DocumentRepository getDocumentRepository() {
        return fmsConfig.getDocumentRepository();
    }

    public Function<DocumentModel, TwoTrack<DocumentModel>> getFileWriter() {
        return fileWriter;
    }

    public CategoryDocTypeRepository getCategoryDocTypeRepository() {
        return fmsConfig.getCategoryDocTypeRepository();
    }

    public String getRootFolder() {
        return fmsConfig.getRootFolder();
    }

    public FmsConfig getFmsConfig() {
        return fmsConfig;
    }

    public static Builder<DocumentConfig> builder() {
        return Builder.of(DocumentConfig.class);
    }
}
