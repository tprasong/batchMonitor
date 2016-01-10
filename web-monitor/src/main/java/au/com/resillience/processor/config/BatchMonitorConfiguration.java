package au.com.resillience.processor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "au.com.resillience.processor, au.com.temp")
public class BatchMonitorConfiguration {

}
