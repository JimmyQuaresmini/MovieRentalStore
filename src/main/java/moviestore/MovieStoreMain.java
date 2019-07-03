package moviestore;

import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Jimmy
 */

@SpringBootApplication
public class MovieStoreMain {
    public static void main(String[] args) {
        //SpringApplication.run(MovieStoreMain.class, args);
        SpringApplication app = new SpringApplication(MovieStoreMain.class);
        Properties props = new Properties();
        props.setProperty("spring.resources.static-locations", "classpath:/static/");
        app.setDefaultProperties(props);
        app.run(args);
    }
    
    @Bean
    WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler(
                    "/img/**",
                    "/css/**",
                    "/js/**")
                    .addResourceLocations(
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
                
            }
        };
    }
}
