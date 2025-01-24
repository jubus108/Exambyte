package de.propra.exambyte;

import org.springframework.boot.SpringApplication;

public class TestExamByteApplication {

	public static void main(String[] args) {
		SpringApplication.from(ExamByteApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
