/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qeqs.session;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import qeqs.DataConfig;
import qeqs.mappers.FinanceMapper;

/**
 *
 * @author kvakin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class FinanceSessionTest {
    
    
    AnnotationConfigApplicationContext ctx;

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
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(DataConfig.class);
        ctx.refresh();
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
        ctx.getBean(FinanceMapper.class).selectAll();
    }

}
