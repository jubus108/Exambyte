package de.hhu.propra.exambyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication() // exclude = {DataSourceAutoConfiguration .class }
public class ExamByteApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExamByteApplication.class, args);
	}

}
