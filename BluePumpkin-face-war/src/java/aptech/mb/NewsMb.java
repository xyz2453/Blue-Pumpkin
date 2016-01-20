/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.mb;

import aptech.entity.Account;
import aptech.entity.News;
import aptech.sb.NewsFacadeLocal;
import aptech.util.PartUploader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author NguyenDucHuy
 */
@ManagedBean
@ViewScoped
public class NewsMb {
    @EJB
    private NewsFacadeLocal newsFacade;
    
    private List<News> newsList; //> news/index
    
    private News selectedNews; // > news/detail + news/edit
    
    private List<News> searchNews; // > news/search
    
    private List<News> detailOlderNews; //> news/search
    
    private String selectedNewsID; // > news/edit
    
    private Part uploadPart; // > news/create + news/edit
    private PartUploader pu; // no getter/setter
    
    private String message;
    
    

    /**
     * Creates a new instance of NewsMb
     */
    public NewsMb() {
        System.out.println("Created a new mb for News.");
    }
    
    
    public void createNews(Account username, String createTitle, Part createUpload, String createContent) {
        try {
            News createNews = new News();
            createNews.setUsername(username);
            createNews.setNewsTitle(createTitle);
            createNews.setNewsContent(createContent);
            createNews.setDateCreate(new Date());
            //if file is image
            if(createUpload.getContentType().contains("image")) {
                System.out.println("File is image.");
                //uploadfile
                this.pu = new PartUploader(createUpload);
                if(pu.save()) { //if save file success
                    createNews.setNewsThumbnail(pu.getPath());
                    //insert news
                    newsFacade.insert(createNews);
                }   
            } else { 
                //if not then use noimage.png
                createNews.setNewsThumbnail("/uploadImage/news/noimage.png");
                newsFacade.insert(createNews);
            }
            redirect("news/index.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(pu != null && pu.getSuccess()) { //if file is already uploaded
                //delete file
                pu.rollback();
            }
            this.message = "An error has occured while inserting.";
        }
        
    }
    
    public void updateNews() {
        System.out.println("Begin to update news.");
        try {
            if(this.uploadPart.getContentType().contains("image")) { //if have file upload is image
                System.out.println("File is image.");
                //uploadfile
                this.pu = new PartUploader(this.getUploadPart());
                if(pu.save()) { //if save file success
                    //update database
                    selectedNews.setNewsThumbnail(pu.getPath());
                    newsFacade.edit(selectedNews);
                }
            } else { //if not then dont change thumbnail
                newsFacade.edit(selectedNews);
            }
            
            redirect("news/detail.xhtml?id="+selectedNews.getNewsID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(pu != null && pu.getSuccess()) { //if file is already uploaded
                //delete file
                pu.rollback();
            }
            this.message = "An error has occured while updating.";
        }
        
    }
    
    public void quickSearchNews(String searchString) {
        this.searchNews = newsFacade.quickSearch(searchString);
        System.out.println("callagain");
    }
    
    public void searchNews(String searchTitle, String searchContent, String searchAuthor, Date searchFrom, Date searchTo) throws IOException{
        if(searchTo != null) searchTo = this.addMidnight(searchTo);
        this.searchNews = newsFacade.search(searchTitle, searchContent, searchAuthor, searchFrom, searchTo);
    }
    
    public void getDetail(int id) {
        System.out.println("Getting detail of newsId: " + id);
        this.selectedNews = newsFacade.find(id);
        List<News> allList = newsFacade.findAll();
        List<News> olderNews = new ArrayList();
        
        for(int i = 1; i <= 5; i++) {
            if(newsFacade.find(id - i) != null){
                olderNews.add(newsFacade.find(id - i));
            }
        }
        this.detailOlderNews = olderNews;
    }
    
    public void findAllNews() {
        List<News> result = newsFacade.findAll();
        Collections.reverse(result);
        partializeNews(result);
        this.newsList = result;
    }
    
    public String getSimpleDate(int id) {
        News news = newsFacade.find(id);
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date date = news.getDateCreate();
        return parser.format(date);
    }
    
    public String convertToSimpleDate(Date date) {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return parser.format(date);
    }
    
    public Date addMidnight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        
        return cal.getTime();
    }
    
    public void partializeNews(List<News> list) {
        for(News item : list) {
            if(item.getNewsContent().length() >= 300) {
                String partial = item.getNewsContent().substring(0, 299);
                item.setNewsContent(partial);
            }
        }
    }
    public void redirect(String url) throws IOException {
        HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String context = origRequest.getContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(context + "/" + url);
    }
    

    /**
     * @return the newsList
     */
    public List<News> getNewsList() {
        return newsList;
    }

    /**
     * @param newsList the newsList to set
     */
    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    /**
     * @return the selectedNews
     */

    public News getSelectedNews() {
        return this.selectedNews;
    }

    /**
     * @param selectedNews the selectedNews to set
     */
    public void setSelectedNews(News selectedNews) {
        this.selectedNews = selectedNews;
    }

    /**
     * @return the detailOlderNews
     */
    public List<News> getDetailOlderNews() {
        return detailOlderNews;
    }

    /**
     * @param detailOlderNews the detailOlderNews to set
     */
    public void setDetailOlderNews(List<News> detailOlderNews) {
        this.detailOlderNews = detailOlderNews;
    }

    /**
     * @return the searchNews
     */
    public List<News> getSearchNews() {
        return searchNews;
    }

    /**
     * @param searchNews the searchNews to set
     */
    public void setSearchNews(List<News> searchNews) {
        this.searchNews = searchNews;
    }

    /**
     * @return the selectedNewsID
     */
    public String getSelectedNewsID() {
        return selectedNewsID;
    }

    /**
     * @param selectedNewsID the selectedNewsID to set
     */
    public void setSelectedNewsID(String selectedNewsID) {
        this.selectedNewsID = selectedNewsID;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
