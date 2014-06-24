/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entities;

import java.util.List;

/**
 *
 * @author Admin
 */
public class ProjectType {
    private int typeID;
    private String typeName;
    private boolean isActive;
    private List<Project> projectList;

    public ProjectType() {
    }

    public ProjectType(int typeID, String typeName, boolean isActive) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.isActive = isActive;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
    
    
}
