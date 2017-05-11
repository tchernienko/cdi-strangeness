package com.company.example.utils;

import org.apache.openejb.resource.activemq.jms2.TomEEManagedConnectionFactory;

import javax.ejb.embeddable.EJBContainer;
import java.util.Properties;

/**
 * Created by will on 11/05/17.
 */
public class EjbTestSupport {


    private static EJBContainer container;

    public static EJBContainer getContainer() {
        return container;
    }

    //    @BeforeClass
    public static void init() {
        Properties p = new Properties();
        p.put("ConnectionFactory", "new://Resource?type=" + javax.jms.ConnectionFactory.class.getName() + "&class-name=" + TomEEManagedConnectionFactory.class.getName());
        container = EJBContainer.createEJBContainer(p);
    }

//    @AfterClass
    public static void shutdown() {
        container.close();
    }


}
