/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.dao.ProjectTypeDAO;
import model.dao.service.ProjectTypeDAOService;
import model.entities.ProjectType;

/**
 *
 * @author cong0_000
 */
@FacesConverter
public class TypeIdConverter implements Converter {

    private final ProjectTypeDAOService TYPE_SERVICE = ProjectTypeDAO.getInstance();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            ProjectType projectType = TYPE_SERVICE.getTypeByName(value);
            return projectType;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage("Cann't convert %s to Project Type!", value), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof ProjectType)){
            return null;
        }
        ProjectType projectType = (ProjectType) value;
        String typeName = projectType.getTypeName();
        return typeName;
    }

}
