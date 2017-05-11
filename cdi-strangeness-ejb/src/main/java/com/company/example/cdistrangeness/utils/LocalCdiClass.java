package com.company.example.cdistrangeness.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Created by will on 11/05/17.
 */
@Named
@ApplicationScoped
public class LocalCdiClass {

    private String name = "bean name";

    public LocalCdiClass() {
        //empty constructor for CDI
    }

    public String getName() {
        return name;
    }
}
