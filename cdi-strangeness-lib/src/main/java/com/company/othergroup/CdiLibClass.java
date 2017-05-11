package com.company.othergroup;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

/**
 * very simple injectable (CDI) bean
 */
@Named
@Singleton
public class CdiLibClass {

    private String name = "the name";

    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext jmsContext;

    public CdiLibClass() {
        //empty constructor for CDI
    }

    public String getName() {
        return name;
    }

    public JMSContext getJmsContext() {
        return jmsContext;
    }
}
