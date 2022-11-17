package com.machinevc.coreapi;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
@EnableWebMvc
public class CoreApiApplication implements CommandLineRunner, WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CoreApiApplication.class, args);
	}

	private Environment env;

	private void logBannerAndVersion() {
		//Log ASCII art service name + the application version
		log.info(
				"\n\n" +
						"█▀▀ █▀█ █▀█ █▀▀   ▄▀█ █▀█ █\n" +
						"█▄▄ █▄█ █▀▄ ██▄   █▀█ █▀▀ █" +
						" - v" + env.getProperty("app.version") + "\n");
	}

	//This run after the main execution
	@Override
	public void run(String... args) {
		logBannerAndVersion();
		log.info("Please visit the API exposed on http://localhost:8080/swagger-ui/index.html#/");
	}


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}
