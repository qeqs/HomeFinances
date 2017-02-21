package qeqs.session;

import org.junit.Assert;
import org.junit.Test;

public class FinanceDaoTest {

    @Test
    public void testGetAll() {
        FinanceSession financeSession = new FinanceSession();
        Assert.assertNotNull(financeSession.getAll());
    }
}
