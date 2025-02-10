package com.todolist.list;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.todolist.list.controller", "com.todolist.list.security","com.todolist.list.config","com.todolist.list.service"})

public class ListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListApplication.class, args);
	}

}
