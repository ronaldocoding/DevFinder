package br.com.devfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication//(exclude= {UserDetailsServiceAutoConfiguration.class})
public class DevFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevFinderApplication.class, args);
	}

}
