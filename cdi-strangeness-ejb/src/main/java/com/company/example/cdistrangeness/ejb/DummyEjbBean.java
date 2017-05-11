package com.company.example.cdistrangeness.ejb;

import com.company.example.cdistrangeness.utils.LocalCdiClass;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;

/**
 * Created by will on 11/05/17.
 */
@Stateless
public class DummyEjbBean {

/*  FIXME if i uncomment this field, test will fail with
Caused by: javax.enterprise.inject.UnsatisfiedResolutionException: Api type [com.company.othergroup.CdiLibClass] is not found with the qualifiers
Qualifiers: [@javax.enterprise.inject.Default()]
for injection into Field Injection Point, field name :  cdiLibClass, Bean Owner : [DummyEjbBean, WebBeansType:ENTERPRISE, Name:null, API Types:[com.company.example.cdistrangeness.ejb.DummyEjbBean,java.lang.Object], Qualifiers:[javax.enterprise.inject.Default,javax.enterprise.inject.Any]]
	at org.apache.webbeans.util.InjectionExceptionUtil.throwUnsatisfiedResolutionException(InjectionExceptionUtil.java:65)
	at org.apache.webbeans.container.InjectionResolver.checkInjectionPoint(InjectionResolver.java:234)
	at org.apache.webbeans.container.BeanManagerImpl.validate(BeanManagerImpl.java:1209)
	at org.apache.webbeans.util.WebBeansUtil.validate(WebBeansUtil.java:1709)
	at org.apache.webbeans.config.BeansDeployer.validate(BeansDeployer.java:913)
	at org.apache.webbeans.config.BeansDeployer.validateInjectionPoints(BeansDeployer.java:824)
	at org.apache.webbeans.config.BeansDeployer.deploy(BeansDeployer.java:307)
	... 24 more
	question is: is it invalid to inject a bean defined within a third tiers jar or am i missing something?
 */
//    @Inject
//    private CdiLibClass cdiLibClass;

    @Inject
    private JMSContext jmsContext;

    @Inject
    private LocalCdiClass localCdiClass;

    /**
     * public no arg constructor, needed by ejb spec
     */
    public DummyEjbBean() {
        //empty constructor, obviously
    }

//    public void useInjectedCdiLibClass() {
//        System.out.println(cdiLibClass.getName());
//    }

    public JMSContext getJmsContext() {
        return jmsContext;
    }

    public String getLocalCdiClassBeanName() {
        return localCdiClass.getName();
    }

}
