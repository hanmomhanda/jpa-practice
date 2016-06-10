package jpa.springboot;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * @author omwomw@sk.com
 *         created on 16. 5. 27.
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {
        "jpa.springboot.controller",
        "jpa.springboot.service",
        "jpa.springboot.support"
})
@EnableJpaRepositories(basePackages = {
        "jpa.springboot.repository"
})
@EntityScan(basePackages = {
        "jpa.springboot.domain"
})
public class TestJpaSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(TestJpaSpringBootApplication.class);

    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TestJpaSpringBootApplication.class);
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
