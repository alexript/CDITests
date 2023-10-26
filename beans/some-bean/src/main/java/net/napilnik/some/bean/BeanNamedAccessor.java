/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.some.bean;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import net.napilnik.cluster.api.ApiNamed;
import net.napilnik.cluster.api.Overridable;

/**
 *
 * @author malyshev
 */
@RequestScoped
public class BeanNamedAccessor {

    @Inject
    //@Resource
    //@EJB
    @Overridable
//    @Any
    private ApiNamed namedBean;

    public BeanNamedAccessor() {

    }

    public String getBeanName() {
        return namedBean.getMyName();
    }
}
