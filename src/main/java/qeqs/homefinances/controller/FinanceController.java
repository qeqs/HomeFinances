package qeqs.homefinances.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import qeqs.homefinances.domain.Finance;
import qeqs.homefinances.logic.Calculation;
import qeqs.homefinances.service.FinanceService;

@Component
@ManagedBean
public class FinanceController {

    @Autowired
    Calculation calculation;
    @Autowired
    FinanceService financeService;
    
    

    @RequestMapping("faces/index.xhtml")
    public List<Finance> getFinances() {
        return financeService.getAll();
    }

    @RequestMapping("faces/index.xhtml")
    public float getSaldo() {
        return calculation.saldo(getFinances());
    }

    @RequestMapping("faces/index.xhtml")
    public float getAvgIncome() {
        return calculation.avgIncome(getFinances());
    }

    @RequestMapping("faces/index.xhtml")
    public float getAvgOutgo() {
        return calculation.avgOutgo(getFinances());
    }
    
    
    

}
