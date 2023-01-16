package com.example.meraki;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {


	public static final String TAG_1 = "shows hello SMART-WIFI API";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).directModelSubstitute(LocalDateTime.class, String.class)
				.directModelSubstitute(LocalDate.class, String.class)
				.directModelSubstitute(LocalTime.class, String.class)
				.directModelSubstitute(ZonedDateTime.class, String.class).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.meraki.controllers"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndpointsInfo());

	}

	private ApiInfo apiEndpointsInfo() {
		return new ApiInfoBuilder().title("SMART-WIFI API").description("SMART-WIFI API").version("1.0-SNAPSHOT").build();
	}
}
