/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Date;
import model.dao.RoleDAO;
import model.dao.UserDAO;
import model.entities.User;

/**
 *
 * @author windows 8.1
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UserDAO.getInstance().checkLogin("admin", "admin"));
        User user = new User(1, "haivv", "haivv", "Vũ Văn Hải", new Date(91, 5, 12), 1, "176334521", "Thanh Hóa", "haivv.itedu@gmail.com", "0906444222", null, RoleDAO.getInstance().getRoleByID(4), null, 1);
        System.out.println(UserDAO.getInstance().createUser(user));
    }
}
