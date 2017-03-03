package qeqs.homefinances.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qeqs.homefinances.domain.Type;
import qeqs.homefinances.domain.Finance;
import qeqs.homefinances.service.TypeService;

@Component
@ManagedBean
public class TypeController {

    @Autowired
    TypeService typeService;
    
    Type selectedType;
    Finance selectedFinance;

    public Type getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(Type selectedType) {
        this.selectedType = selectedType;
    }       

    public Finance getSelectedFinance() {
        return selectedFinance;
    }

    public void setSelectedFinance(Finance selectedFinance) {
        this.selectedFinance = selectedFinance;
    }
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(typeService.getAll(), true);
    }   
    public String create(){
        try{
        typeService.save(selectedType);
        JsfUtil.addSuccessMessage("Type created");
        return "createType";
        }
        catch(Exception e){
            JsfUtil.addErrorMessage(e, "Error");
            return null;
        }
    }
    public String prepareCreate(){
        selectedType = new Type();
        return "faces/createType";
    }
    
    public List<Type> getTypes(){
        return typeService.getAll();
    }

    public Type getType(java.lang.Integer id) {
        return typeService.get(id);
    }

    @FacesConverter(forClass = Type.class)
    public static class TypeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TypeController controller = (TypeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "typeController");
            return controller.getType(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Type) {
                Type o = (Type) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Type.class.getName());
            }
        }

    }
}

