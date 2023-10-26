/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.cluster.impl.deflt;

import jakarta.annotation.Priority;
import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Named;
import net.napilnik.cluster.api.ApiNamed;
import net.napilnik.cluster.api.Overridable;

/**
 *
 * @author malyshev
 */
//@ApplicationScoped
@Singleton
@Overridable
@Default
@Priority(0)
@Named("beannamed")
public class BeanNamedDefault implements ApiNamed {

    private static final String NAME = "I am BeanNamedDefault";

    public BeanNamedDefault() {

    }

    /**
     * This is for tests
     *
     * @return NAME value
     */
    public static String getNameConstant() {
        return NAME;
    }

    @Override
    public String getMyName() {
        return NAME;
    }

}
