/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.mb;

import aptech.entity.Support;
import aptech.entity.SupportConversation;
import aptech.sb.SupportConversationFacadeLocal;
import aptech.sb.SupportFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aptech.util.DateConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author NguyenDucHuy
 */
@ManagedBean
@ViewScoped
public class EmpSupportMb {
    @EJB
    private SupportConversationFacadeLocal supportConversationFacade;
    @EJB
    private SupportFacadeLocal supportFacade;
    @ManagedProperty(value="#{loginMb}")
    private LoginMb loginMb;
    
    private List<Support> unresolved;
    private List<Support> resolved;
    
    private Support supportDetail;
    private List<SupportConversation> conversation;

    /**
     * @return the loginMb
     */
    public LoginMb getLoginMb() {
        return loginMb;
    }

    /**
     * @param loginMb the loginMb to set
     */
    public void setLoginMb(LoginMb loginMb) {
        this.loginMb = loginMb;
    }

    /**
     * @return the unresolved
     */
    public List<Support> getUnresolved() {
        return unresolved;
    }

    /**
     * @param unresolved the unresolved to set
     */
    public void setUnresolved(List<Support> unresolved) {
        this.unresolved = unresolved;
    }

    /**
     * @return the resolved
     */
    public List<Support> getResolved() {
        return resolved;
    }

    /**
     * @param resolved the resolved to set
     */
    public void setResolved(List<Support> resolved) {
        this.resolved = resolved;
    }

    /**
     * @return the searchUnresolvedInput
     */
    public SearchInput getSearchUnresolvedInput() {
        return searchUnresolvedInput;
    }

    /**
     * @param searchUnresolvedInput the searchUnresolvedInput to set
     */
    public void setSearchUnresolvedInput(SearchInput searchUnresolvedInput) {
        this.searchUnresolvedInput = searchUnresolvedInput;
    }

    /**
     * @return the searchResolvedInput
     */
    public SearchInput getSearchResolvedInput() {
        return searchResolvedInput;
    }

    /**
     * @param searchResolvedInput the searchResolvedInput to set
     */
    public void setSearchResolvedInput(SearchInput searchResolvedInput) {
        this.searchResolvedInput = searchResolvedInput;
    }

    /**
     * @return the supportDetail
     */
    public Support getSupportDetail() {
        return supportDetail;
    }

    /**
     * @param supportDetail the supportDetail to set
     */
    public void setSupportDetail(Support supportDetail) {
        this.supportDetail = supportDetail;
    }

    /**
     * @return the conversation
     */
    public List<SupportConversation> getConversation() {
        return conversation;
    }

    /**
     * @param conversation the conversation to set
     */
    public void setConversation(List<SupportConversation> conversation) {
        this.conversation = conversation;
    }
    
    public class SearchInput {
        private String searchString;
        private Date searchFrom;
        private Date searchTo;
        public SearchInput(){
            
        }

        /**
         * @return the searchString
         */
        public String getSearchString() {
            return searchString;
        }

        /**
         * @param searchString the searchString to set
         */
        public void setSearchString(String searchString) {
            this.searchString = searchString;
        }

        /**
         * @return the searchFrom
         */
        public Date getSearchFrom() {
            return searchFrom;
        }

        /**
         * @param searchFrom the searchFrom to set
         */
        public void setSearchFrom(Date searchFrom) {
            this.searchFrom = searchFrom;
        }

        /**
         * @return the searchTo
         */
        public Date getSearchTo() {
            return searchTo;
        }

        /**
         * @param searchTo the searchTo to set
         */
        public void setSearchTo(Date searchTo) {
            this.searchTo = searchTo;
        }
    }
    private SearchInput searchUnresolvedInput;
    private SearchInput searchResolvedInput;
    /**
     * Creates a new instance of EmpSupportMb
     */
    public EmpSupportMb() {
        System.out.println("Created new supportMb");
        searchResolvedInput = new SearchInput();
        searchUnresolvedInput = new SearchInput();
    }
    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(!request.getRequestURI().contains("emp/supportSearch.xhtml")) {
            System.out.println("Not search, DONT DO POSTCONSTRUCT!");
            return;
        }
        resolved = new ArrayList();
        unresolved = new ArrayList();
        System.out.println("Post construct supportMb");
        List<Support> listAll = supportFacade.findAll();
        Collections.reverse(listAll);
        for(Support support : listAll) {
            if(support.getIsResolved() && support.getUsername().getUsername().equals(loginMb.getCurAccount().getUsername())) {
                resolved.add(support);
            } else if (support.getIsResolved() == false && support.getUsername().getUsername().equals(loginMb.getCurAccount().getUsername())) {
                unresolved.add(support);
            }
        }
    }
    
    public void sendSupportReply(String content) {
        supportConversationFacade.sendReply(content, loginMb.getCurAccount().getUsername(), supportDetail.getSupportID());
        try {
            redirect("emp/supportDetail.xhtml?id="+supportDetail.getSupportID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void findSupportDetail(String idString) throws IOException {
        Integer id = Integer.valueOf(idString);
        supportDetail = supportFacade.find(id);
        if(!supportDetail.getUsername().getUsername().equals(loginMb.getCurAccount().getUsername())) {
            redirect("emp/index.xhtml");
        }
        else {
            conversation = supportConversationFacade.findBySupportID(supportDetail);
            Collections.reverse(conversation);
            System.out.println("Found: " + conversation.size() + " replies");
        }
    }
    
    public void createSupport(String title, String content) {
        supportFacade.insert(title, content, loginMb.getCurAccount().getUsername());
        try {
            redirect("emp/supportSearch.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void searchUnresolved() {
        Boolean isResolved = false;
        if(searchUnresolvedInput.searchTo != null)
            searchUnresolvedInput.searchTo = new DateConverter().addMidNight(searchUnresolvedInput.searchTo);
        setUnresolved(supportFacade.search(getSearchUnresolvedInput().searchString, getSearchUnresolvedInput().searchFrom, getSearchUnresolvedInput().searchTo, getLoginMb().getCurAccount(), isResolved));
        Collections.reverse(unresolved);
    }
    public void searchResolved() {
        Boolean isResolved = true;
        if(searchResolvedInput.searchTo != null)
            searchResolvedInput.searchTo = new DateConverter().addMidNight(searchResolvedInput.searchTo);
        setResolved(supportFacade.search(getSearchResolvedInput().searchString, getSearchResolvedInput().searchFrom, getSearchResolvedInput().searchTo, getLoginMb().getCurAccount(), isResolved));
        Collections.reverse(resolved);
    }
    
    public String getSimpleDateWithTime(Date date) {
        return new DateConverter().getSimpleDateWithTime(date);
    }
    
    public void redirect(String url) throws IOException {
        HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String context = origRequest.getContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(context + "/" + url);
    }
}
