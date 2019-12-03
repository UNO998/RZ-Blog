package com.lhs.rzBlog;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RzBlogApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RzBlogApplication.class, args);
	}
	
	 @Autowired
	 private ApplicationContext appContext;

	@Override
    public void run(String... args) throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}
