package com.company.othergroup;

import org.apache.openejb.resource.activemq.jms2.TomEEManagedConnectionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by will on 11/05/17.
 */
public class DirectTest {

    private static EJBContainer container;

    @EJB
    private InjectionTestEjb injectionTestEjb;

    @Test
    public void testInjection() {
        Assert.assertNotNull(injectionTestEjb.callCdiLibClassMethod());
    }

    @Before
    public void inject() throws NamingException {
        container.getContext().bind("inject", this);
    }

    @BeforeClass
    public static void init() {
        Properties p = new Properties();
        p.put("ConnectionFactory", "new://Resource?type=" + javax.jms.ConnectionFactory.class.getName() + "&class-name=" + TomEEManagedConnectionFactory.class.getName());
        container = EJBContainer.createEJBContainer(p);
    }

    @AfterClass
    public static void shutdown() {
        container.close();
    }



}
