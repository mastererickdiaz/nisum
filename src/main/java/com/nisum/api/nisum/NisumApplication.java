package com.nisum.api.nisum;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EntityScan({ "com.nisum.api.nisum.entity" })
public class NisumApplication {

	public static void main(String[] args) {
		SpringApplication.run(NisumApplication.class, args);
	}

	@PostConstruct
  public void init() {
    // Setting Spring Boot SetTimeZone
    TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
  }

  @Bean
  public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
      @Value("${application-version}") String appVersion) {

    return new OpenAPI().info(new Info().title("API Cliente").version(appVersion).description(appDesciption)
        .termsOfService("http://swagger.io/terms/")
        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
  }

}
