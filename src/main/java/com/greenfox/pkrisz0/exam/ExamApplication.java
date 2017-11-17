package com.greenfox.pkrisz0.exam;

import com.greenfox.pkrisz0.exam.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamApplication {

	@Autowired
	CarRepo carRepo;

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}
}
