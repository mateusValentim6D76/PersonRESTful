package br.com.erudio.restwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RestWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootApplication.class, args);
		
		 
//      Map<String, PasswordEncoder> encoders = new HashMap<>();
//      encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//      DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
//      passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder());

//      String result = passwordEncoder.encode("admin123");
//      System.out.println("My hash " +result);
      
	}

}
