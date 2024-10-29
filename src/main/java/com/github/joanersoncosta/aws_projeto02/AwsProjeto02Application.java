package com.github.joanersoncosta.aws_projeto02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@SpringBootApplication
public class AwsProjeto02Application {

	public static void main(String[] args) {
		SpringApplication.run(AwsProjeto02Application.class, args);
	}

	@GetMapping("/home")
	public String getHome(){
		return "Home Projeto 02";
	}
}