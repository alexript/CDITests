/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.cditests;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

/**
 *
 * @author malyshev
 */
@ApplicationScoped
@Default
public class AlwaysEnabledBean implements SomeBean {

    public AlwaysEnabledBean() {

    }

    @Override
    public String speak() {
        return this.getClass().getName();
    }

}
