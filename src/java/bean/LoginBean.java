/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.dao.UserDAO;
import model.dao.service.UserDAOService;
import model.entities.User;

/**
 *
 * @author Khoa
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String userName;
    private String pwd;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;

    UserDAOService USER_SERVICE = UserDAO.getInstance();

    public LoginBean() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public String login() {
        if (!USER_SERVICE.checkLogin(userName, pwd)) {
//            User user = USER_SERVICE.getUserByUserName(userName);
//            httpServletRequest.getSession().setAttribute(util.Constants.CURRENT_USER, user);
            return "./registation.jsf";
        } else {
//            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login", null);
//            facesContext.addMessage(null, facesMessage);
//            httpServletRequest.getSession().setAttribute("error", "Login error");
            return "./home.jsf";
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
