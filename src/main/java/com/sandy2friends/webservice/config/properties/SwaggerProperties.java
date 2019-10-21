package com.sandy2friends.webservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Swagger properties for custom config
 */
@Data
@ConfigurationProperties(prefix = "rest.swagger", ignoreUnknownFields = false)
public class SwaggerProperties {

    private String title = "Application API";

    private String description = "API documentation";

    private String version = "1.0";

    private String termsOfServiceUrl;

    private String contactName = "Sandeep Kamath";

    private String contactUrl = "www.sandy2friends.com";

    private String contactEmail = "sandeepkamathkr@gmail.com";

    private String license = "Owner";

    private String licenseUrl = "www.sandy2friends.com/";

    private String defaultIncludePattern = "/.*";

}
