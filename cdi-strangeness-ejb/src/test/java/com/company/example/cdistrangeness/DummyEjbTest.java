package com.company.example.cdistrangeness;

import com.company.example.cdistrangeness.ejb.DummyEjbBean;
import com.company.example.utils.EjbTestSupport;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.EJB;
import javax.naming.NamingException;

/**
 * Created by will on 11/05/17.
 */
public class DummyEjbTest {

    @EJB
    private DummyEjbBean dummyEjbBean;

    @Test
    public void testDummyEjb() {
        Assert.assertNotNull(dummyEjbBean);
    }

//    @Test
//    public void testDummyEjbMethod() {
//        dummyEjbBean.useInjectedCdiLibClass();
//    }

    @Test
    public void testDummyEjbDirectJmsContext() {
        Assert.assertNotNull(dummyEjbBean.getJmsContext());
    }

    @BeforeClass
    public static void init() {
        EjbTestSupport.init();
    }

    @Before
    public void inject() throws NamingException {
        EjbTestSupport.getContainer().getContext().bind("inject", this);
    }

    @AfterClass
    public static void shutdown() {
        EjbTestSupport.shutdown();
    }


}
