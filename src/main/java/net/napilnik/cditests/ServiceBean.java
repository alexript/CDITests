/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.cditests;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

/**
 *
 * @author malyshev
 */
@RequestScoped
public class ServiceBean {

    @Inject
    @Any
    private SomeBean bean;

    public String speak() {
        return bean.speak();
    }
}
