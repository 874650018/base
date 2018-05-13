package com.weshare.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		/*DemoDao demoDao = context.getBean(DemoDao.class);
		Demo demo = new Demo();
		demo.setNumber(1);
		demo.setInsertTime(new Date());
		demo.setName("插入测试");
		demoDao.addDemo(demo);*/
	}
}
