//Esta classe permite consultar a API através do Swagger, para maior facilidade 
//De visualização do back end

package org.mateus.blogPessoal.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage
				("org.mateus.blogPessoal.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Blog Pessoal")
				.description("API Projeto Blog Pessoal")
				.version("1.0")
				.contact(contact())
				.build();
	}
	
	private Contact contact(){
		return new Contact("Mateus Ribeiro",
				"https://github.com/MateusBCC020",
				"Programador full stack Angular e Spring");
	}
}
