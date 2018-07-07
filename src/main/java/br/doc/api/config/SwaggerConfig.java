package br.doc.api.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * To access: http://localhost:8080/swagger-ui.html
 * @author fabiana
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.doc.api"))
				.paths(regex("/rest.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Swagger Api Example using Spring.",
				"Swagger Api Example using Spring",
				"1.0",
				"Terms of Service",
				new Contact ("Fabiana Araujo",
						"https://www.youtube.com/user/biafreire2611",
						"fabiana2611@hotmail.com"),
				"Apache Licence Version 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0");
		
		return apiInfo;
	}
}
