/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.napilnik.libs.cluster.tests.integration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import net.napilnik.cluster.api.ApiNamed;
import net.napilnik.cluster.impl.deflt.BeanNamedDefault;
import net.napilnik.cluster.impl.optional.BeanNamedOptional;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jboss.weld.junit5.WeldSetup;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author malyshev
 */
@ExtendWith(WeldJunit5Extension.class)
public class BeansWithAlternativesIT {

    @WeldSetup
    public WeldInitiator weldWithOptional = WeldInitiator.from(BeanNamedDefault.class, BeanNamedOptional.class).activate(RequestScoped.class, ApplicationScoped.class).build();

    @Test
    public void testOptionalBean() {
        ApiNamed bean = weldWithOptional.select(ApiNamed.class).get();
        assertTrue((bean instanceof BeanNamedOptional));
    }
}
