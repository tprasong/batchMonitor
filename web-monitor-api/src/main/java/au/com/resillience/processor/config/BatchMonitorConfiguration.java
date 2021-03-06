package au.com.resillience.processor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "au.com.resillience.processor, au.com.temp")
@ImportResource({"classpath*:conf/spring-config.xml","classpath:spring-config.xml"})
public class BatchMonitorConfiguration {
	
}
