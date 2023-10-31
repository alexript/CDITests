/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.ears.app.named;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import net.napilnik.some.bean.BeanNamedAccessor;

/**
 *
 * @author malyshev
 */
@RequestScoped
@Named(value = "beanName")
public class BeanNamesProvider {

    @Inject
    @Any
    private BeanNamedAccessor accessor;

    public BeanNamesProvider() {
        
    }

    public String getName() {
        return accessor.getBeanName();
    }

}
