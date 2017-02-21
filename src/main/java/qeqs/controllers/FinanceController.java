package qeqs.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qeqs.entities.Finance;
import qeqs.logic.Calculation;
import qeqs.session.FinanceSession;

@ManagedBean("financeController")
@Controller
@Scope("request")
public class FinanceController {
       @Autowired
       Calculation calculation;
       @Autowired
       FinanceSession financeSession;
       
       @RequestMapping("faces/index.xhtml")
       public List<Finance> getFinances(){
           return financeSession.getAll();
       }       
       @RequestMapping("faces/index.xhtml")
       public float getSaldo(){
           return calculation.saldo(getFinances());
       }
       @RequestMapping("faces/index.xhtml")
       public float getAvgIncome(){
           return calculation.avgIncome(getFinances());
       }
       @RequestMapping("faces/index.xhtml")
       public float getAvgOutgo(){
           return calculation.avgOutgo(getFinances());
       }
       
}
