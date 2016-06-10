package jpa.springboot;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;


@SpringBootApplication
@EnableJpaAuditing
@EntityScan({"jpa.springboot.domain"})
@EnableJpaRepositories(basePackages = {"jpa.springboot.repository"}, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
public class JpaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPracticeApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public ServletRegistrationBean h2ConsoleServletRegistration() {
		ServletRegistrationBean servletRegistrationBean =
				new ServletRegistrationBean(new WebServlet());
		servletRegistrationBean.addUrlMappings("/h2-console/*");
		return servletRegistrationBean;
	}
}
