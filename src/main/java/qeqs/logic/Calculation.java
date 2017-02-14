package qeqs.logic;

import java.util.List;
import org.springframework.stereotype.Component;
import qeqs.entities.Finance;

@Component
public class Calculation {

    public float saldo(List<Finance> finances) {
        float res = 0;
        for (Finance finance : finances) {
            res += finance.getValue();
        }
        return res;
    }

    public float avgIncome(List<Finance> finances) {
        float res = 0;
        float count = 0;
        for (Finance finance : finances) {
            if (finance.getValue() > 0) {
                count++;
                res += finance.getValue();
            }
        }
        return res/count;
    }
    public float avgOutgo(List<Finance> finances) {
        float res = 0;
        float count = 0;
        for (Finance finance : finances) {
            if (finance.getValue() < 0) {
                count++;
                res += finance.getValue();
            }
        }
        return res/count;
    }
}
