/**
 * <h1>Swagger Configuration</h1>
 * Class to handle swagger-ui config
 * in this project.
 *
 * @author Syarif Hidayat
 * @version 1.0
 * @since 2019-08-20
 * */


package com.mitrais.cdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * This method will be used to handle Token input in swagger
     * authorization process
     *
     * @return SecurityConfiguration
     */
	@Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(null, null, null, null, "", ApiKeyVehicle.HEADER,"Authorization","");
    }

    /**
     * This method will be used to set API url and controller package
     * that will be included in Swagger UI.
     *
     * @return Docket object
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.mitrais.cdc.blogmicroservices.controller"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaData())
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    /**
     * This method will be used to write
     * all API related information.
     *
     * @return
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Mitrais - CDC Java Boot Camp",
                "Spring Boot REST API for  Blog Microservices",
                "1.0",
                "Terms of service",
                new Contact("Mitrais", "www.mitrais.com", "cdc@mitrais.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }

    /**
     * This method will be used to handle Token input in swagger
     * authorization process
     *
     */
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    } 
}