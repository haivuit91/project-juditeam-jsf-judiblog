/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.entities.Role;

/**
 *
 * @author Khoa
 */
@ManagedBean
@SessionScoped
public class loginBean {

    private int userID;
    private String userName;
    private String pwd;
    private String fullName;
    private Date birthday;
    private int gender;
    private String idCard;
    private String address;
    private String email;
    private String phone;
    private String pathImage;
    private Role role;
    private String idActive;
    private int active;
    
    
    public loginBean() {
       
    }
    
}
