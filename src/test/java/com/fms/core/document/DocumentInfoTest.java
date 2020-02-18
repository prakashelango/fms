package com.fms.core.document;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by satish on 16/03/19.
 */
public class DocumentInfoTest {

    private static UploadInfo uploadInfo;
    private static DocumentInfo documentInfo;

    @BeforeClass
    public static void setUp(){
        uploadInfo = mock(UploadInfo.class);
        documentInfo = mock(DocumentInfo.class);

        when(uploadInfo.getUploaderId()).thenReturn("100");
        when(uploadInfo.getDocumentTypeId()).thenReturn(100L);
        when(uploadInfo.getFileInfo()).thenReturn("FILE_INFORMATION");
        when(uploadInfo.getFileName()).thenReturn("FILE_NAME");
        when(uploadInfo.getFileSequence()).thenReturn(1000L);

        when(documentInfo.getFileLocation()).thenReturn("FILE_LOCATION");
    }

    @Test
    public void testClassObject(){
        DocumentInfo documentInfo = new DocumentInfo();
        assertNotNull(documentInfo);
    }

    @Test
    public void testBuilder(){
        DocumentInfo documentInfo = DocumentInfo.builder(uploadInfo).build();
        assertNotNull(documentInfo);
    }

    @Test
    public void testBuilderWithOwnClass(){
        DocumentInfo docInfo = new DocumentInfo();
        DocumentInfo documentInfo = DocumentInfo.builder(docInfo).build();
        assertNotNull(documentInfo);
    }

    @Test
    public void testGetFileLocation(){
        DocumentInfo documentInfo = new DocumentInfo();
        String fileLocation = documentInfo.getFileLocation();
        assertNull(fileLocation);
    }

    @Test
    public void testGetFileName() throws Exception {
        DocumentInfo documentInfo = new DocumentInfo();
        assertNull(documentInfo.getFileName());
    }

    @Test
    public void testGetFileInfo() throws Exception {
        DocumentInfo documentInfo = new DocumentInfo();
        assertNull(documentInfo.getFileInfo());
    }

    @Test
    public void testGetUploaderId() throws Exception {
        DocumentInfo documentInfo = new DocumentInfo();
        assertNull(documentInfo.getUploaderId());
    }

    @Test
    public void testGetId() throws Exception {
        DocumentInfo documentInfo = new DocumentInfo();
        assertNull(documentInfo.getId());
    }

    @Test
    public void testGetFileSequence(){
        DocumentInfo documentInfo = new DocumentInfo();
        assertNull(documentInfo.getFileSequence());
    }

    @Test
    public void testGetDocumentTypeId(){
        DocumentInfo documentInfo = new DocumentInfo();
        assertNull(documentInfo.getDocumentTypeId());
    }
}
