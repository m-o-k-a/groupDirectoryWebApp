package mybootapp.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import mybootapp.web.User;
import mybootapp.SpringConfiguration;
import mybootapp.model.Group;
import mybootapp.model.Person;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = {"mybootapp.repo"}
        )

@EntityScan(basePackages = {"mybootapp.repo", "mybootapp.service", "mybootapp.model", "mybootapp.web",
							"../mybootapp.repo", "../mybootapp.service", "../mybootapp.model", "../mybootapp.web",
							"../repo", "../service", "../model", "../web"}, basePackageClasses = SpringConfiguration.class)
public class Starter extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Starter.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("--- addResourceHandlers");
		registry.addResourceHandler("/webjars/**")//
				.addResourceLocations("/webjars/");
	}
}
