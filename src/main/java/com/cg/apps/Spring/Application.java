package com.cg.apps.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.Spring.Customer.ui.CustomerUI;
import com.cg.apps.Spring.Items.ui.ItemUI;



@SpringBootApplication
public class Application {

	
		public static void main(String[] args) {
			ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
			CustomerUI ui = context.getBean(CustomerUI.class);
			ItemUI itemui=context.getBean(ItemUI.class);
		
			ui.start();
			itemui.start();
	}

}
