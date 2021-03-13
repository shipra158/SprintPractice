package com.cg.apps.Spring.Customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.Spring.Customer.ui.CustomerUI;



@SpringBootApplication
public class Application {

	
		public static void main(String[] args) {
			ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
			CustomerUI ui = context.getBean(CustomerUI.class);
			ui.start();
	}

}
