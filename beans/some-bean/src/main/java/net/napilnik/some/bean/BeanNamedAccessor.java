/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.some.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import net.napilnik.cluster.api.ApiNamed;

/**
 *
 * @author malyshev
 */
@RequestScoped
public class BeanNamedAccessor {

    @Inject
    @Any
    private ApiNamed namedBean;

    public String getBeanName() {
        return namedBean.getMyName();
    }
}
