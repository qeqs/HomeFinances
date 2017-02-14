/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qeqs.session;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import qeqs.entities.Finance;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import qeqs.DataConfig;

/**
 *
 * @author kvakin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class FinanceSessionTest {

    public FinanceSessionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    @Autowired
    FinanceSession instance;

    /**
     * Test of getMapper method, of class FinanceSession.
     */
    @Test
    public void testGetMapper() {
        System.out.println("getAll");
        List<Finance> expResult = null;
        List<Finance> result = instance.getAll();
        assertEquals(expResult, result);
    }

}
