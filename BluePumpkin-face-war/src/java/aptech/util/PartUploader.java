/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.util;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.http.Part;

/**
 *
 * @author NguyenDucHuy
 */
public class PartUploader {
    
    private Part uploadPart;
    private String path;
    private Boolean success;
    
    public PartUploader(Part uploadPart) {
        this.uploadPart = uploadPart;
    }
    
    public Boolean save() {
        String folderPath = "../docroot/uploadImage/news/";
        try (InputStream input = uploadPart.getInputStream()){
            String[] tempArray = uploadPart.getSubmittedFileName().split("\\.");
            String fileName = tempArray[0];
            String fileSuffix = tempArray[1];
            System.out.println(fileName + ".." + fileSuffix);
            File tempFile = new File(folderPath + fileName + "." + fileSuffix);
            while(tempFile.exists()) {
                fileName += "1";
                tempFile = new File(folderPath + fileName + "." + fileSuffix);
            }
            Files.copy(input, tempFile.toPath());
            this.path = folderPath.replace("../docroot", "") + fileName + "." + fileSuffix;
            System.out.println("File is successfully save at: " + this.path);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("There has been an error when saving file..");
            return false;
        }
    }
    
    public void rollback() {
        try {
            System.out.println("Something wrong.. rolling back");
            File f = new File(this.path);
            f.delete();
        } catch (Exception e) {
            System.out.println("Error occured while rollback-ing the uploadfile.");
        }
    }

    /**
     * @return the uploadPart
     */
    public Part getUploadPart() {
        return uploadPart;
    }

    /**
     * @param uploadPart the uploadPart to set
     */
    public void setUploadPart(Part uploadPart) {
        this.uploadPart = uploadPart;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
