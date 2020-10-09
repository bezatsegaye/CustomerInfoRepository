package miu.edu.start.job.applicationprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import miu.edu.start.job.applicationprocessor.domain.Company;


@EnableAutoConfiguration
@ComponentScan
public class ApplicationProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationProcessorApplication.class, args);
		
		
		 
	}
	 @Bean
	    public Company personService() {
	        return new Company();
	    }
	 
}
