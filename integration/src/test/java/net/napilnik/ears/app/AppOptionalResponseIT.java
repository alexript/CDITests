package net.napilnik.ears.app;

import java.io.File;
import org.jboss.arquillian.container.test.api.Deployer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.as.arquillian.api.ContainerResource;
import org.jboss.as.arquillian.container.ManagementClient;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author malyshev
 */
@ExtendWith(ArquillianExtension.class)
public class AppOptionalResponseIT {

    @Deployment(testable = false, name = "app-optional")
    public static Archive<?> createAppOptionalDeployment() {
        return ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File("../ear/app-optional-ear/target/app-optional-ear-1.0-SNAPSHOT.ear"));
    }

    @ContainerResource
    ManagementClient managementClient;

    @ArquillianResource
    Deployer deployer;

    @Test
    @RunAsClient
    public void testBeanNamedOptional() throws Exception {
        assertTrue(true);
    }

}
