package qeqs.homefinances.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
import qeqs.homefinances.logic.Calculation;
import qeqs.homefinances.service.FinanceService;
import qeqs.homefinances.service.TypeService;

@Component
@ManagedBean
public class FinanceController {

    @Autowired
    Calculation calculation;
    @Autowired
    FinanceService financeService;
    @Autowired
    TypeService typeService;

    Type selectedType;
    Finance selectedFinance;

    public String getGraphicData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Finance> list = financeService.getAll();
        list.sort(new Comparator<Finance>() {
            @Override
            public int compare(Finance o1, Finance o2) {
                return (int)(o1.getDate().getTime()-o2.getDate().getTime());
            }
        });
        Object[][] data = new Object[list.size() + 1][2];
        data[0][0] = "\"Date\"";
        data[0][1] = "\"Values\"";
        for (int i = 1; i < list.size() + 1; i++) {
            data[i][0] = "\'" + formatter.format(list.get(i - 1).getDate()) + "\'";
            data[i][1] = list.get(i - 1).getValue();
        }
        
        return Arrays.deepToString(data);
    }

    public Type getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(Type selectedType) {
        this.selectedType = selectedType;
    }

    public List<Finance> getFinances() {
        return financeService.getAll();
    }

    public Finance getSelectedFinance() {
        return selectedFinance;
    }

    public void setSelectedFinance(Finance selectedFinance) {
        this.selectedFinance = selectedFinance;
    }

    public List<Finance> getFinancesByType(Type type) {
        if (type == null) {
            return new ArrayList<>();
        }
        return type.getFinanceList();
    }

    public List<Finance> getFinancesIncomes() {
        List<Finance> temp = financeService.getAll();
        List<Finance> result = new ArrayList<>();
        for (Finance finance : temp) {
            if (finance.getValue() > 0) {
                result.add(finance);
            }
        }
        return result;
    }

    public List<Finance> getFinanceOutcomes() {
        List<Finance> temp = financeService.getAll();
        List<Finance> result = new ArrayList<>();
        for (Finance finance : temp) {
            if (finance.getValue() < 0) {
                result.add(finance);
            }
        }
        return result;
    }

    public String getSaldo() {
        return String.valueOf(calculation.saldo(financeService.getAll()));
    }

    public String getAvgIncome() {
        return String.valueOf(calculation.avgIncome(getFinances()));
    }

    public String getAvgOutgo() {
        return String.valueOf(calculation.avgOutgo(getFinances()));
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(typeService.getAll(), true);
    }

    public String create() {
        try {
            financeService.save(selectedFinance);
            JsfUtil.addSuccessMessage("Finance created");
            return "createFinance";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Error");
            return null;
        }
    }

    public String prepareCreate() {
        selectedFinance = new Finance();
        return "faces/createFinance";
    }

    public Finance getFinance(java.lang.Integer id) {
        return financeService.get(id);
    }

    @FacesConverter(forClass = Finance.class)
    public static class FinanceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FinanceController controller = (FinanceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "financeController");
            return controller.getFinance(getKey(value));
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
            if (object instanceof Finance) {
                Finance o = (Finance) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Finance.class.getName());
            }
        }

    }
}
