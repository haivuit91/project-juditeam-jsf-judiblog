/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.dao.ProjectDAO;
import model.dao.ProjectTypeDAO;
import model.dao.ProjectUserDAO;
import model.dao.UserDAO;
import model.dao.service.ProjectDAOService;
import model.dao.service.ProjectTypeDAOService;
import model.dao.service.ProjectUserDAOService;
import model.dao.service.UserDAOService;
import model.entities.Project;
import model.entities.ProjectType;

/**
 *
 * @author windows 8.1
 */
@ManagedBean
@RequestScoped
public class ProjectBean {

    private final ProjectDAOService PROJECT_SERVICE = ProjectDAO.getInstance();
    private final ProjectTypeDAOService TYPE_SERVICE = ProjectTypeDAO.getInstance();
    private final ProjectUserDAOService PU_SERVICE = ProjectUserDAO.getInstance();
    private final UserDAOService USER_SERVICE = UserDAO.getInstance();

    /**
     * Creates a new instance of projectBean
     */
    public ProjectBean() {
    }

    private Project project = new Project();
    private ProjectType projectType;
    private List<ProjectType> types;
    private String typeName;

    public void createProject(){
        String msg = "";
        String projectName = getProject().getProjectName();
        String description = getProject().getDescription();
        Date startDate = getProject().getStartDate();
        java.sql.Date date = new java.sql.Date(startDate.getTime());
        int duration = getProject().getDuration();
        ProjectType type = this.projectType;
        Project p = new Project(1, projectName, description, date, duration, type, 1);
        if(PROJECT_SERVICE.createProject(p)){
            msg += "Post project Successfully";
        }else{
            msg += "Post project Failed";
        }
        FacesMessage message = new FacesMessage(msg, "Message!");
        FacesContext.getCurrentInstance().addMessage("Message!", message);
    }
    
    
    /**
     * @return the projectType
     */
    public ProjectType getProjectType() {
        return projectType;
    }

    /**
     * @param projectType the projectType to set
     */
    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    /**
     * @return the types
     */
    public List<ProjectType> getTypes() {
        types = TYPE_SERVICE.getTypes();
        return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes(List<ProjectType> types) {
        this.types = types;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }
}
