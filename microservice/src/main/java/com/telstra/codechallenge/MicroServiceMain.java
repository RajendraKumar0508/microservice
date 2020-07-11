package com.telstra.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
@EnableCaching
public class MicroServiceMain  {

  public static void main(String[] args) {
	
   // SpringApplication.run(MicroServiceMain.class, args);
  }

  @Bean
  //public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
 
}
