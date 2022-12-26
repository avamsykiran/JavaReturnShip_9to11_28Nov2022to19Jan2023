package com.cts.sdid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.sdid.ui.HomeUI;

public class SpringDIDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		//HomeUI ui = new HomeUI();
		
		HomeUI ui = (HomeUI) context.getBean("homeUI");
		ui.run();
	}

}
