package main;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter {

    /**
     * this sets the cors configuration for the rest API
     * For debuggin it is set to all origins, will be set to only the webserver if it is up and running
     * @param registry the current corsregistry where to add it to
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET").allowedOrigins("*");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}