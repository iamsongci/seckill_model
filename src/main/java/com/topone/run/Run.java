package com.topone.run;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/spring-*.xml" });
		context.start();
		System.out.println("服务开启！");
		System.in.read();
	}

}
	