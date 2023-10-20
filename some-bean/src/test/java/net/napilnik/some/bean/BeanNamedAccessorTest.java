/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package net.napilnik.some.bean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import net.napilnik.cluster.impl.deflt.BeanNamedDefault;
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
public class BeanNamedAccessorTest {

    @WeldSetup
    public WeldInitiator weld = WeldInitiator.from(BeanNamedAccessor.class, BeanNamedDefault.class)
            .activate(RequestScoped.class, ApplicationScoped.class).build();

    @Test
    public void testGetBeanName() {
        String result = weld.select(BeanNamedAccessor.class).get().getBeanName();
        assertNotNull(result);
        assertEquals(BeanNamedDefault.getNameConstant(), result);
    }

}
