/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.service.ProjectDAOService;
import model.entities.Project;
import model.entities.ProjectType;
import model.entities.Role;
import model.entities.User;

/**
 *
 * @author Admin
 */
public class ProjectDAO implements ProjectDAOService {

    private static ProjectDAO projectDAO;

    public static ProjectDAO getInstance() {
        if (projectDAO == null) {
            projectDAO = new ProjectDAO();
        }
        return projectDAO;
    }

    @Override
    public List<Project> getProjects() {
        List<Project> projectList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tblProject";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setDuration(rs.getInt("duration"));
                int typeID = rs.getInt("typeID");
                ProjectType type = ProjectTypeDAO.getInstance().getTypeByID(typeID);
                project.setType(type);
                project.setIsActive(rs.getBoolean("isActive"));
                project.setUserList(ProjectUserDAO.getInstance().getUserByProject(rs.getInt("projectID")));
                project.setUserListNotJoin(ProjectUserDAO.getInstance().getUserNotJoin(rs.getInt("projectID")));
                projectList.add(project);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    @Override
    public Project getProjectByID(int projectID) {
        Project project = new Project();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tblProject where projectID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projectID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setDuration(rs.getInt("duration"));
                int typeID = rs.getInt("typeID");
                ProjectType type = ProjectTypeDAO.getInstance().getTypeByID(typeID);
                project.setType(type);
                project.setIsActive(rs.getBoolean("isActive"));
                project.setUserList(ProjectUserDAO.getInstance().getUserByProject(rs.getInt("projectID")));
                project.setUserListNotJoin(ProjectUserDAO.getInstance().getUserNotJoin(rs.getInt("projectID")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> getProjectByName(String projectName) {
        List<Project> projectList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tblProject where projectName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, projectName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setDuration(rs.getInt("duration"));
                int typeID = rs.getInt("typeID");
                ProjectType type = ProjectTypeDAO.getInstance().getTypeByID(typeID);
                project.setType(type);
                project.setIsActive(rs.getBoolean("isActive"));
                project.setUserList(ProjectUserDAO.getInstance().getUserByProject(rs.getInt("projectID")));
                project.setUserListNotJoin(ProjectUserDAO.getInstance().getUserNotJoin(rs.getInt("projectID")));
                projectList.add(project);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    @Override
    public boolean createProject(Project project) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tblProject values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, project.getProjectName());
            pstmt.setString(2, project.getDescription());
            pstmt.setDate(3, (Date) project.getStartDate());
            pstmt.setInt(4, project.getDuration());
            pstmt.setInt(5, project.getType().getTypeID());
            pstmt.setBoolean(6, project.isIsActive());

            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateProject(Project project) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tblProject set projectName = ?, description = ?, startDate = ?,"
                    + "duration = ?, typeID = ?, isActive = ? where projectID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, project.getProjectName());
            pstmt.setString(2, project.getDescription());
            pstmt.setDate(3, (Date) project.getStartDate());
            pstmt.setInt(4, project.getDuration());
            pstmt.setInt(5, project.getType().getTypeID());
            pstmt.setBoolean(6, project.isIsActive());
            pstmt.setInt(7, project.getProjectID());
            System.out.println("Statement:" + pstmt);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean deleteProject(int projectID) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete tblProjectUserDetails where projectID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projectID);
            pstmt.executeUpdate();
                        
            sql = "delete tblProject where projectID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projectID);
            pstmt.executeUpdate();
            
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean activeProjectType(Project project) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tblProject set isActive = 'true' where projectID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, project.getProjectID());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean inactiveProjectType(Project project) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tblProject set isActive = 'false' where projectID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, project.getProjectID());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public List<Project> getProjectByType(int typeID) {
        List<Project> projectList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tblProject where typeID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, typeID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setDuration(rs.getInt("duration"));
                project.setIsActive(rs.getBoolean("isActive"));                
                project.setUserList(ProjectUserDAO.getInstance().getUserByProject(rs.getInt("projectID")));
                projectList.add(project);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }
     @Override
    public List<Project> findProject(String key, String value) {
         List<Project> projectList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tblProject where " + key + " like '" + "%" + value + "%" + "'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
              Project project = new Project();
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setDuration(rs.getInt("duration"));
                project.setIsActive(rs.getBoolean("isActive"));                
                project.setUserList(ProjectUserDAO.getInstance().getUserByProject(rs.getInt("projectID")));
                projectList.add(project);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }
    
}
