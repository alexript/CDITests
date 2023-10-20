/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.cluster.impl.deflt;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import net.napilnik.cluster.api.ApiNamed;

/**
 *
 * @author malyshev
 */
@ApplicationScoped
@Default
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
