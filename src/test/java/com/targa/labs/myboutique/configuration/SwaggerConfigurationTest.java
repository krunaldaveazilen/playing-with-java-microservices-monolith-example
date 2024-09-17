package com.targa.labs.myboutique.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SwaggerConfigurationTest {

    @Test
    public void testProductApi() {
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
        Docket docket = swaggerConfiguration.productApi();
        assertNotNull(docket);
    }
}
