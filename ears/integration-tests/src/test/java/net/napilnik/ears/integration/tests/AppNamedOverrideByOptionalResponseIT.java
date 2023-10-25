package net.napilnik.ears.integration.tests;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
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
public class AppNamedOverrideByOptionalResponseIT {

    @Deployment(testable = false, name = "app-named")
    public static Archive<?> createAppNamedDeployment() {
        return ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File("../app-named/app-named-ear/target/app-named-ear-1.0-SNAPSHOT.ear"));
    }

    @Deployment(testable = false, name = "app-optional", managed = false)
    public static Archive<?> createAppOptionalDeployment() {
        return ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File("../app-optional/app-optional-ear/target/app-optional-ear-1.0-SNAPSHOT.ear"));
    }

    @ContainerResource
    ManagementClient managementClient;

    @ArquillianResource
    Deployer deployer;

    @Test
    @RunAsClient
    public void testBeanNamedOverride() throws Exception {

        URI baseUrl = managementClient.getWebUri();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(new URI(baseUrl + "/app-named/resources/rest"))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        assertTrue(response.body().contains("I am BeanNamedDefault"));

        deployer.deploy("app-optional");

        response = client.send(request, BodyHandlers.ofString());
        assertTrue(response.body().contains("I am BeanNamedDefault"));

        deployer.undeploy("app-optional");

    }
}
