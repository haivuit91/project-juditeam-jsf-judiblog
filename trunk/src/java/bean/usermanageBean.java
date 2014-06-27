/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.dao.UserDAO;
import model.dao.service.UserDAOService;
import model.entities.User;

/**
 *
 * @author HAI VU
 */
@ManagedBean(name = "userManage")
@RequestScoped
public class usermanageBean implements Serializable {

    UserDAOService USER_SERVICE = UserDAO.getInstance();

    public List<User> getAllUser() {
        List<User> userList = USER_SERVICE.getAllUser();
        return userList;
    }

}
