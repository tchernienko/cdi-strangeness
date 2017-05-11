package com.company.othergroup;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * ejb only to test the CdiLibClass itself
 */
@Stateless
public class InjectionTestEjb {

    /**
     * here, the CdiLibClass is a "jar local" bean
     * which means it is defined inside the jar containing this ejb
     */
    @Inject
    private CdiLibClass cdiLibClass;

    public String callCdiLibClassMethod() {
        return cdiLibClass.getName();
    }

}
