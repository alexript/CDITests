/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package net.napilnik.cditests;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author malyshev
 */
@ExtendWith(WeldJunit5Extension.class)
public class ServiceBeanTest {

    @Inject
    @Named("someBeanName")
    private SomeBean testBeanByName;

    @Inject
    private SomeBean testBeanInject;

    @WeldSetup
    public WeldInitiator weld = WeldInitiator
            .from(ServiceBean.class, AlwaysEnabledBean.class)
            .activate(RequestScoped.class, ApplicationScoped.class)
            .build();

    @Test
    public void testSpeak() {
        String result = weld.select(ServiceBean.class).get().speak();
        assertNotNull(result);
    }

    @Test
    public void testInject() {
        assertNotNull(testBeanInject);
    }

    @Test
    public void testBeanByName() {
        assertNotNull(testBeanByName);
    }

}
