package com.fms.core.document;

import com.fms.core.common.Do;
import com.fms.core.model.CategoryDocType;
import com.fms.core.model.DocumentModel;
import com.fms.core.model.UploadCategory;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by satish on 15/03/19.
 */


public class DocumentConverterTest {

    private static DocumentModel documentModel;
    private static DocumentInfo documentInfo;
    private static UploadCategory uploadCategory;
    private static CategoryDocType categoryDocType;

    @BeforeClass
    public static void setUp(){
        documentInfo = mock(DocumentInfo.class);
        documentModel = mock(DocumentModel.class);
        uploadCategory = mock(UploadCategory.class);
        categoryDocType = mock(CategoryDocType.class);

        when(documentInfo.getId()).thenReturn(100l);
        when(documentInfo.getDocumentTypeId()).thenReturn(101l);
        when(documentInfo.getUploaderId()).thenReturn("102");
        when(documentInfo.getFileInfo()).thenReturn("FILE_INFORMATION");
        when(documentInfo.getFileLocation()).thenReturn("C://");
        when(documentInfo.getFileName()).thenReturn("FILE_NAME");
        when(documentInfo.getFileSequence()).thenReturn(100l);

        when(uploadCategory.getId()).thenReturn(200l);
        when(uploadCategory.getName()).thenReturn("UPLOAD_FILE_NAME");
        when(uploadCategory.getDesc()).thenReturn("UPLOAD_FILE_NAME_DESC");

        when(categoryDocType.getId()).thenReturn(400l);
        when(categoryDocType.getDesc()).thenReturn("CATEGORY_DESC");
        when(categoryDocType.getType()).thenReturn("CATEGORY_TYPE");
        when(categoryDocType.getUploadCategory()).thenReturn(uploadCategory);

        when(documentModel.getId()).thenReturn(300l);
        when(documentModel.getDocumentUploaderId()).thenReturn("200");
        when(documentModel.getCategoryDocType()).thenReturn(categoryDocType);
        when(documentModel.getFileInfo()).thenReturn("DOCUMENT_INFO");
        when(documentModel.getFileLocation()).thenReturn("DOCUMENT_UPLOAD_LOCATION");
        when(documentModel.getFileName()).thenReturn("DOCUMENT_FILE_NAME");
        when(documentModel.getFileSequence()).thenReturn(300l);
    }

    @Test
    public void testObject(){
        DocumentConverter documentConverter = new DocumentConverter();
        assertNotNull(documentConverter);
    }
    @Test
    public void testConvert(){
        DocumentModel model = DocumentConverter.convert(documentInfo).apply(categoryDocType);
        assertNotNull(model);
    }

    @Test
    public void testConvertTo(){
        DocumentInfo documentInfo = DocumentConverter.convertTo(documentModel);
        assertNotNull(documentInfo);
    }

    @Test
    public void testBuild(){
        DocumentInfo docInfo = DocumentConverter.build(documentInfo).apply("FILE_INFORMATION");
        assertNotNull(docInfo);
    }
}
