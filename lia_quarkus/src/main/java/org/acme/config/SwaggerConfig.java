package org.acme.config;


import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "Quarkus API", description = "This is a test project in quarkus", version = "1.0.0")
)

public class SwaggerConfig extends Application {
}
