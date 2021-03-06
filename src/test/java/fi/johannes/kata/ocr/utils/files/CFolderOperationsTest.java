/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.johannes.kata.ocr.utils.files;

import TestUtils.TestFileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johannes Sarpola <johannes.sarpola@gmail.com>
 */
public class CFolderOperationsTest {

    static String testfolder = System.getProperty("user.dir") + "/src/test/resources/testfolder";

    public CFolderOperationsTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDownClass() {
        TestFileUtils.cleanTestFiles();
    }

    /**
     * Test of getFilesInFolder method, of class CFolderOperations.
     */
    @Test
    public void testAllFileMethods() throws IOException {
        CFolderOperations.recursiveDelete(testfolder + "1");
        CFolderOperations.createFolder(testfolder + "1");
        new File(testfolder + "1" + "/file").createNewFile();
        new File(testfolder + "1" + "/file2").createNewFile();
        Assert.assertEquals(2, CFolderOperations.getFilenamesInFolder(testfolder + "1").size());
        Assert.assertEquals(2, CFolderOperations.getFilenamesInFolder(testfolder + "1").size());
        Assert.assertEquals(2, CFolderOperations.readAllFilesInFolder(testfolder + "1").size());
        CFolderOperations.recursiveDelete(testfolder + "1");
        int i = 0;
    }

    /**
     * Test of countFiles method, of class CFolderOperations.
     */
    @Test
    public void testCountFiles() throws IOException {
        CFolderOperations.recursiveDelete(testfolder + "2");
        CFolderOperations.createFolder(testfolder + "2");
        File f = new File(testfolder + "2" + "/file");
        f.createNewFile();
        Assert.assertEquals(1, CFolderOperations.countFiles(testfolder + "2"));
        CFolderOperations.recursiveDelete(testfolder + "2");
    }

    @Test
    public void testFolderCreationAndExist() throws NotDirectoryException {
        CFolderOperations.recursiveDelete(testfolder + "3");
        CFolderOperations.createFolder(testfolder + "3");
        assertThat(CFolderOperations.createFolder(testfolder + "3"), is(not(nullValue())));
        assertThat(CFolderOperations.doesFolderExist(testfolder + "3"), is(true));
        CFolderOperations.recursiveDelete(testfolder + "3");
    }

    /**
     * Test of getFilesInFolder method, of class CFolderOperations.
     */
    @Test
    public void testGetFilesInFolder_String() {
    }

    /**
     * Test of getFilesInFolder method, of class CFolderOperations.
     */
    @Test
    public void testGetFilesInFolder_Path() throws Exception {
    }

    /**
     * Test of getFilenamesInFolder method, of class CFolderOperations.
     */
    @Test
    public void testGetFilenamesInFolder() {
    }

    /**
     * Test of readAllFilesInFolder method, of class CFolderOperations.
     */
    @Test
    public void testReadAllFilesInFolder() throws Exception {
    }

    /**
     * Test of createFolder method, of class CFolderOperations.
     */
    @Test
    public void testCreateFolder_Path() throws Exception {
    }

    /**
     * Test of createFolder method, of class CFolderOperations.
     */
    @Test
    public void testCreateFolder_Path_FileAttribute() throws Exception {
    }

    /**
     * Test of createFolder method, of class CFolderOperations.
     */
    @Test
    public void testCreateFolder_String() {
    }

    /**
     * Test of doesFolderExist method, of class CFolderOperations.
     */
    @Test
    public void testDoesFolderExist() {
    }

    /**
     * Test of recursiveDelete method, of class CFolderOperations.
     */
    @Test
    public void testRecursiveDelete() {
    }

    /**
     * Test of mergeFiles method, of class CFolderOperations.
     */
    @Test
    public void testMergeFiles() throws Exception {
    }

}
